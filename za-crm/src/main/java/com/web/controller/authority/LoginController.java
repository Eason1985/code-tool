package com.web.controller.authority;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.absmybatis.exception.BaseDtoException;
import com.absmybatis.util.DateUtil;
import com.web.common.controller.BaseController;
import com.web.common.exception.BusinessException;
import com.web.common.util.ConstantValue;
import com.web.common.util.TokenProcessor;
import com.web.common.util.tree.Tree;
import com.web.common.util.tree.TreeUtil;
import com.web.entity.TbSysrRelationUserRoleDto;
import com.web.entity.TbSysrRoleDto;
import com.web.entity.TbSysrUserDto;
import com.web.entity.TbrEmployeeMessageDto;
import com.web.facade.basequery.BaseQueryServiceUtil;
import com.web.mapper.AllEntityMapperFactory;
import com.web.mapper.tbSysrRelationRoleResource.TbSysrRelationRoleResourceMapper;
@Controller 
public class LoginController extends BaseController  {
	
	public static final java.lang.Long maxPassErrorNum = 5L ; 
	private static Logger logger = Logger.getLogger(LoginController.class);  
	@Autowired
	private TbSysrRelationRoleResourceMapper tbSysrRelationRoleResourceMapper ;
	
	
	
	/**
	 * result :
	 * {"status":false,"message":"用户名或密码有误!"}
	 * @param request
	 * @param response
	 * @param mode
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/login.do")
	public void loginSubmit(HttpServletRequest request ,
			HttpServletResponse response , Model mode) throws IOException{
		String user_cd = request.getParameter("user_cd");
		String password = request.getParameter("password");
		String from = request.getParameter("from");//如果是来自app. 
		if(StringUtils.isEmpty(user_cd)){
			String json = "{\"status\":" + false + ",\"message\":\"" + "登录名为空!\"}";
		    outJSOND(response, json); 
		    return ;
		}
		if(StringUtils.isEmpty(password)){
			String json = "{\"status\":" + false + ",\"message\":\"" + "密码为空!\"}";
		    outJSOND(response, json); 
		    return ;
		}
		TbSysrUserDto  user = new TbSysrUserDto();
		user.setUser_code(user_cd);
		user=(TbSysrUserDto) new BaseQueryServiceUtil<TbSysrUserDto>().selectObject(user);
		if(user == null ){
			String json = "{\"status\":" + false + ",\"message\":\"" + "用户不存在!\"}";
	        outJSOND(response,  json) ;  
	        return ;
		}
		TbSysrRelationUserRoleDto tbSysrRelationUserRoleDto=new TbSysrRelationUserRoleDto();
	    tbSysrRelationUserRoleDto.setSysr_user_id(user.getSysr_user_id());
	    int roleSize = new BaseQueryServiceUtil<TbSysrRelationUserRoleDto>().selectCount(tbSysrRelationUserRoleDto);
	    if(roleSize == 0  ){
			String json = "{\"status\":" + false + ",\"message\":\"" + "用户没有分配角色，无权登录!\"}";
			outJSOND(response,  json) ;  
	        return ;
		}
		if(TbSysrUserDto.USER_STATEEnum.USER_STATE_0.getValue().equals(user.getUser_state())){
			//判断密码是否正确
			if(user.getPassword().equals(password)){
				HashMap result = new HashMap();
				user.setPass_error_num(0L);
				user.setLast_login_time(DateUtil.date2javaSqlTimestamp(new Date()));
				if(from != null && "app".equals(from)){//表示来源于app的登录请求
					String token_value = TokenProcessor.getInstance().generateToken(user.getUser_code());
					result.put("token", token_value) ; 
					user.setToken_value(token_value);
					user.setToken_update_time(obtainCreateTimeStr());
				}
				result.put("name",user.getUser_name() );
		    	result.put("photo", "") ; 
				fillRoleInfo(result ,user );
		    	fillMessageInfo(result, user );
				updateUser(user);
				request.getSession().setAttribute(SESSION_SET_KEY_USER, user);
		    	result.put("status", true) ; 
		    	result.put("message", "登录成功!") ;
		    	outJSOND(response,  result) ; 
		    	
				//登錄控制  TODO 防止重复登录
//			    HttpSession session = request.getSession();
//			    ServletContext application = session.getServletContext();
//			    List onlineUserList = (List)application.getAttribute(BaseController.SESSION_SET_KEY_OLINEUSERLIST);
//			    if(null == onlineUserList){
//			    	onlineUserList = new ArrayList();
//			    	onlineUserList.add(user.getSysr_user_id());
//			    	application.setAttribute(BaseController.SESSION_SET_KEY_OLINEUSERLIST, onlineUserList);
//			    }else{
//			    	if(onlineUserList.contains(user.getSysr_user_id())){
//			    		 json = "{\"status\":" + false + ",\"message\":\"该用户正在使用中，请勿重复登录！\"}";
//					     outJSOND(response,  json) ;  
//					     return ; 
//			    	}else{
//			    		onlineUserList.add(user.getSysr_user_id());
//			    	}
//			    }
//			    session.setAttribute(BaseController.SESSION_SET_KEY_OLINEUSERID,user.getSysr_user_id());
				 
			}else{
				user.setPass_error_num(user.getPass_error_num()+1L);
				//判断密码错误次数
				if(maxPassErrorNum.compareTo(user.getPass_error_num())<=0){
					user.setUser_state(TbSysrUserDto.USER_STATEEnum.USER_STATE_1.getValue());
					updateUser(user);
					String json = "{\"status\":" + false + ",\"message\":\"" + "密码输错"+maxPassErrorNum+"次,已锁定,请与管理员联系!\"}";
			        outJSOND(response,  json) ;  
				}else{
					updateUser(user);
					String json = "{\"status\":" + false + ",\"message\":\"" + "密码错误"+user.getPass_error_num()+"次!还剩"+(maxPassErrorNum-user.getPass_error_num())+"次!\"}";
					outJSOND(response,  json) ;  
				}
			}
		}else if(TbSysrUserDto.USER_STATEEnum.USER_STATE_1.getValue().equals(user.getUser_state())){
			String json = "{\"status\":" + false + ",\"message\":\"" + "密码已输错"+maxPassErrorNum+"次,已锁定,请与管理员联系!\"}";
		    outJSOND(response,  json) ;  
		}else if(TbSysrUserDto.USER_STATEEnum.USER_STATE_2.getValue().equals(user.getUser_state())){
			String json = "{\"status\":" + false + ",\"message\":\"" + "用户已经失效,请与管理员联系!\"}";
		    outJSOND(response,  json) ;
		}
	} 
	
	/* 
	 * 该用户的消息数目
	 * @param result
	 * @param user
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void fillMessageInfo(HashMap result, TbSysrUserDto user) {
		TbrEmployeeMessageDto tbrEmployeeMessageDto = new TbrEmployeeMessageDto();
		tbrEmployeeMessageDto.setNetno(user.getNetno() );
		tbrEmployeeMessageDto.setSysr_user_id(user.getSysr_user_id() ); 
		tbrEmployeeMessageDto.setMessage_state(TbrEmployeeMessageDto.MESSAGE_STATEEnum.MESSAGE_STATE_0.getValue());
		int messaeSize = new BaseQueryServiceUtil<TbrEmployeeMessageDto>().selectCount(tbrEmployeeMessageDto )  ; 
		result.put("messagesize", messaeSize) ;
	}
	/* 
	 * 该用户角色的消息数目
	 * @param result
	 * @param user
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void fillRoleInfo(HashMap result, TbSysrUserDto user) {
		TbSysrRelationUserRoleDto userRole = new TbSysrRelationUserRoleDto();
		userRole.setSysr_user_id(user.getSysr_user_id());
		List<TbSysrRelationUserRoleDto> userRoles = new BaseQueryServiceUtil<TbSysrRelationUserRoleDto>().selectList(userRole) ;
		if(userRoles== null || userRoles.size() == 0 ){
			result.put("rolecode", "" ) ; 
			result.put("rolename",""  ) ;
		}else {
			int i = 0 ; 
			StringBuffer rolecode = new StringBuffer(""); 
			StringBuffer rolename =  new StringBuffer(""); 
			for(TbSysrRelationUserRoleDto userRoleTemp : userRoles){
				TbSysrRoleDto  rbSysrRoleDto =new  TbSysrRoleDto() ;
				rbSysrRoleDto.setSysr_role_id(userRoleTemp.getSysr_role_id() );
				rbSysrRoleDto = new BaseQueryServiceUtil<TbSysrRoleDto>().selectObject(rbSysrRoleDto) ;
				if(i == 0 ){
					rolecode.append(rbSysrRoleDto.getSysr_role_id() ) ;
					rolename.append(rbSysrRoleDto.getRole_name() ) ; 
					i++ ;
				}else{
					rolecode.append(","+ rbSysrRoleDto.getSysr_role_id()) ;
					rolename.append(","+ rbSysrRoleDto.getRole_name()) ; 
				}
			}
			result.put("rolecode", rolecode.toString() ) ; 
			result.put("rolename", rolename.toString()  ) ;
		}
    	
	}

	public void updateUser(TbSysrUserDto updateDto){
		new BaseQueryServiceUtil<TbSysrUserDto>().updateEntityById(updateDto) ;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/index.do")
	public String index(HttpServletRequest request ,
			HttpServletResponse response , RedirectAttributes attr) throws IOException{
		TbSysrUserDto user = null ;
		
		try {
			user = obtainUserInfo(request);
		} catch (BusinessException e) {
			logger.error("获取用户信息错误" ,e );
			attr.addAttribute("errorInfo", "长时间没有登录，请重新登录");
			return  "redirect:/login.jsp";
		}
		
		HashMap map = new HashMap();
		String sysr_user_id = user.getSysr_user_id();
		map.put("sysr_user_id", sysr_user_id);
		map.put("netno", user.getNetno());
		List<Map> mapes = tbSysrRelationRoleResourceMapper.select_tResSelfRelaListByUserId(map);
		Tree tree  =  TreeUtil.convertTResSelfRelaToTree(mapes);
		request.setAttribute("menuTree", tree); 
	    TbSysrRelationUserRoleDto userRole = new TbSysrRelationUserRoleDto();
	    userRole.setSysr_user_id(sysr_user_id);
	    List<TbSysrRelationUserRoleDto> roleList = AllEntityMapperFactory.getAllEntityMapper().selectList(userRole);
	    String redirectStr = "";
	    if(roleList != null){
	    	for(int i=0;i<roleList.size();i++){
	    		TbSysrRelationUserRoleDto roleDto = roleList.get(i);
	    		String roleId = roleDto.getSysr_role_id();
	    		if(ConstantValue.ROLE_CANGGUAN.equals(roleId)){
	    			redirectStr=  "/indexCangGuan";
	    	    }else if(ConstantValue.ROLE_JIEDAI.equals(roleId)){
	    	    	redirectStr=  "/indexJieDai";
	    	    }else if(ConstantValue.ROLE_ADMIN.equals(roleId) || ConstantValue.ROLE_LAOBAN.equals(roleId)){
	    	    	redirectStr=  "/index";
	    	    }else{
	    	    	redirectStr= "/indexOther";
	    	    }
	    	}
	    }else{
	    	redirectStr=  "/index";
	    }
		return redirectStr;
	    
		
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request ,
			HttpServletResponse response , Model mode) throws IOException{
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		session.removeAttribute(BaseController.SESSION_SET_KEY_USER);
		List onlineUserList = (List)application.getAttribute(BaseController.SESSION_SET_KEY_OLINEUSERLIST);
		String sysr_user_id = (String) session.getAttribute(BaseController.SESSION_SET_KEY_OLINEUSERID);
		if( onlineUserList != null ){
			onlineUserList.remove(sysr_user_id);
		}
		session.removeAttribute(BaseController.SESSION_SET_KEY_OLINEUSERID);
		session.removeAttribute("error");
		return  "redirect:/login.jsp";
	}
	
	
	
	/**
	 * 密码修改
	 * @param request
	 * @param response
	 * @param mode
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "static-access" })
	@RequestMapping("/updatePassword.do")
	public void updatePassword(HttpServletRequest request ,
			HttpServletResponse response , Model mode) throws IOException{
		String searchContentStr = request.getParameter("searchContentStr") ;
        if(searchContentStr != null ){
        	searchContentStr = new String(request.getParameter("searchContentStr").getBytes("ISO8859-1"),"UTF-8");
        }
		JSONObject jSONObject = JSONObject.fromObject(searchContentStr);
		HashMap dto = (HashMap) jSONObject.toBean(jSONObject, HashMap.class);  
		TbSysrUserDto tbSysrUserDto = obtainUserInfo(request) ;
		if(!tbSysrUserDto.getPassword().equals(dto.get("oldpassword"))){
			String json = "{\"error\":" + true + ",\"message\":\"" +"原密码输入错误"+"\"}";
			outJSOND(response, json);
			return ;
		}
		if(dto.get("password") == null ){
			String json = "{\"error\":" + true + ",\"message\":\"" +"新密码没有输入"+"\"}";
			outJSOND(response, json);
		} 
		tbSysrUserDto.setPassword(dto.get("password").toString() );
		try {
			new BaseQueryServiceUtil<TbSysrUserDto>().updateEntityById(tbSysrUserDto) ;
		} catch (BaseDtoException e) {
			logger.error(e.getMessage(),e);
			String json = "{\"error\":" + true + ",\"message\":\"" +"保存密码失败!"+"\"}";
			outJSOND(response, json);
			return ; 
		} 
		String json = "{\"error\":" + false + ",\"message\":\"" +"密码修改成功,下次登录请使用新密码登录,请牢记新密码,谢谢!"+"\"}";
		outJSOND(response, json);
	}
	
	
}
