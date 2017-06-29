package com.web.controller.authority;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.absmybatis.common.SelectParamHandle;
import com.web.common.controller.BaseController;
import com.web.common.exception.BusinessException;
import com.web.common.util.ConstantValue;
import com.web.common.util.PropertyValueChangeUtil;
import com.web.common.util.web.BeanRefUtil;
import com.web.common.util.web.CharacterConversionUtil;
import com.web.common.util.web.DatabaseUtil;
import com.web.common.util.web.JsonDateFormatUtil;
import com.web.common.util.web.MD5Util;
import com.web.common.util.web.PagingObject;
import com.web.common.util.web.PangingUtils;
import com.web.common.util.web.TimestampMorpher;
import com.web.entity.TbSysrRelationUserRoleDto;
import com.web.entity.TbSysrRoleDto;
import com.web.entity.TbSysrUserDto;
import com.web.facade.basequery.BaseQueryServiceUtil;
import com.web.mapper.tbSysrRole.TbSysrRoleMapper;
 /**
 * 类功能:自动代码生成模板查询   controller 模板
 */
 
@Controller 
public class TbSysrUserController extends BaseController  {
	
	
	@Autowired
	private TbSysrRoleMapper tbSysrRoleMapper ; 
	
	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@RequestMapping("/search_tbSysrUser_getListData.do")
	public void getListData(HttpServletRequest request ,HttpServletResponse response) {
		try {
			String searchContentStr = CharacterConversionUtil.change(
					request.getParameter("searchContentStr")) ;
             String[] formats={"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd"}; 
             JSONUtils.getMorpherRegistry().registerMorpher(new TimestampMorpher(formats));  
			JSONObject jSONObject = JSONObject.fromObject(searchContentStr);
			TbSysrUserDto dto = (TbSysrUserDto) jSONObject.toBean(jSONObject, TbSysrUserDto.class);  
			if(dto==null){
				dto = new TbSysrUserDto();
			}
			dto.setNetno(obtainLoginUserNetno(request));
	        PagingObject init_pg = PangingUtils.getPagingObjectFormRequest(request);
	        //TODO
	        dto.setUser_code(BeanRefUtil.setLikeConditon(dto.getUser_code()));//登录名称模糊查询
	        dto.setUser_name(BeanRefUtil.setLikeConditon(dto.getUser_name()));//用户名模糊查询
	        dto.setEmail(BeanRefUtil.setLikeConditon(dto.getEmail()));//邮箱模糊查询
	        dto.setMobile(BeanRefUtil.setLikeConditon(dto.getMobile()));//手机号码模糊查询
	        List<TbSysrUserDto>  rows = new BaseQueryServiceUtil<TbSysrUserDto>()
					.selectListByPage(dto,new SelectParamHandle(init_pg.getCurrent_page(),init_pg.getPage_size(),"sysr_user_id")) ;
	        dto.setUser_code(BeanRefUtil.setLikeConditon(dto.getUser_code()));//登录名称模糊查询
	        dto.setUser_name(BeanRefUtil.setLikeConditon(dto.getUser_name()));//用户名模糊查询
	        dto.setEmail(BeanRefUtil.setLikeConditon(dto.getEmail()));//邮箱模糊查询
	        dto.setMobile(BeanRefUtil.setLikeConditon(dto.getMobile()));//手机号码模糊查询
	        Integer total = new BaseQueryServiceUtil<TbSysrUserDto>()
					.selectCount(dto ) ;
	        List<Map> mapRows = new ArrayList<Map>();
	        for (TbSysrUserDto d : rows) {
				Map map = new BeanRefUtil().transBean2Map(d);
				// 2.自定义按钮设置在此处
				map.put("edit","<a href='javascript:return void(0);' onClick=\"tbSysrUser_list.updateFormSubmit('"+ map.get("sysr_user_id")+ "');return false;\"><i class='icon-edit'></i></a>");
				map.put("detail","<a href='javascript:return void(0);'onClick=\"tbSysrUser_list.detailFormSubmit('"+ map.get("sysr_user_id")+ "');return false;\"><i class='icon-search'></i></a>");
				map.put("resetpass","<a href='javascript:return void(0);'onClick=\" tbSysrUser_list.resetPassFormSubmit('"+ map.get("sysr_user_id")+ "');return false;\"><i class='icon-setting'></i></a>");
				map.put("allot","<a href='javascript:return void(0);'onClick=\"tbSysrUser_list.allotFormSubmit('"+ map.get("sysr_user_id")+ "','"+map.get("user_code")+"','"+map.get("user_name")+"');return false;\"><i class='icon-setting'></i></a>");
				PropertyValueChangeUtil.enumValue2Desc(map, TbSysrUserDto.PropertyEnum.getPropertyEnumMap());
				PropertyValueChangeUtil.dateValue2Desc(map );
				mapRows.add(map);
			}	
	        JsonConfig config = new JsonConfig();
	        JsonDateFormatUtil.formatDateForJsonConfig_type(config);
			JSONArray json_rows = JSONArray.fromObject(mapRows, config);
	        String json = "{\"total\":\""
					+ total
					+ "\",\"rows\":" + json_rows.toString() + "}";
	        outJSOND(response,  json) ;  
		} catch (BusinessException ex) {
			logger.error(ex.getErrorMessage(),ex );
			String json = "{\"error\":" + true + ",\"message\":\"" +ex.getErrorMessage()+ "\"}";
			outJSOND(response,  json) ;  
		} catch (Exception e) {
			logger.error("查询员工信息出错",e );
			String json = "{\"error\":" + true + ",\"message\":\"" + "查询员工信息出错!\"}";
			outJSOND(response,  json) ;  
		}
	}
	 
	 
	 /***
	 * 
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({  "static-access" })
	@RequestMapping("/add_TbSysrUser.do")
	public void addData(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String json ="";
		String addContentStr = CharacterConversionUtil.change(
				request.getParameter("addContentStr"));
        JSONObject jSONObject = JSONObject.fromObject(addContentStr);
        TbSysrUserDto dto = (TbSysrUserDto) jSONObject.toBean(jSONObject, TbSysrUserDto.class);  
        if(StringUtils.isEmpty(dto.getUser_code())
        		||StringUtils.isEmpty(dto.getPassword())){
        	json = "{\"error\":" + true + ",\"message\":\"" + "添加信息不全，用户登录名与密码都不能为空!\"}";
			outJSOND(response,  json) ;
			return; 
        }
        if(!validateUsercode(dto.getUser_code(), obtainLoginUserNetno(request)  , response )){
        	return; 
		}
        if(!validateUsername(dto.getUser_name(), obtainLoginUserNetno(request)  , response )){
        	return; 
		}
        dto.setSysr_user_id(DatabaseUtil.getPkId(3, 1));
		dto.setNetno(obtainLoginUserNetno(request));
		dto.setCreatetime(obtainCreateTimeStr()); //创建时间
		dto.setCreate_user_id(obtainLoginUserId(request));
		dto.setUpdatetime(obtainCreateTimeStr());
		dto.setUpdate_user_id(obtainLoginUserId(request));
		dto.setInit_pass_update(TbSysrUserDto.INIT_PASS_UPDATEEnum.INIT_PASS_UPDATE_0.getValue());
		dto.setLogin_count(new Long(0));
		dto.setPass_error_num(new Long(0));
		try {
			int flag =0;
			try {
				flag = new BaseQueryServiceUtil<TbSysrUserDto>().insertEntity(dto);
			} catch (Exception e) {
				logger.error("保存出现异常",e);
				json = "{\"error\":" + true + ",\"message\":\"" + ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
			}
			if(flag ==1){
				json = "{\"error\":" + false + ",\"message\":\"" + "保存成功!\"}";
			}else{
				json = "{\"error\":" + true + ",\"message\":\"" + ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
			}
			outJSOND(response,  json) ; 
		} catch (Exception ex) {
			logger.error("保存出现异常",ex);
			json = "{\"error\":" + true + ",\"message\":\"" + ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
			outJSOND(response,  json) ; 
		}
	}

	
	private boolean validateUsername(String user_name,
			String netno, HttpServletResponse response) {
		String json = ""; 
		TbSysrUserDto temp =new TbSysrUserDto();
	    temp.setUser_name(user_name);
	    temp.setNetno(netno);
	    int size = new BaseQueryServiceUtil<TbSysrUserDto>().selectCount(temp);
	    if(size !=0){
        	json = "{\"error\":" + true + ",\"message\":\"" + "该姓名与其他员工姓名重复,为防止后期数据混淆,请使用其他名称以便区分!如"+user_name+"+数字\"}";
			outJSOND(response,  json) ;
			return false;
	    } 
		return true; 
	}


	/**
	 * 判断登录名的唯一性
	 * @param usercode
	 * @param response
	 * @param id 
	 * @return
	 */
	private boolean validateUsercode(String usercode,  String netno ,HttpServletResponse response){
		String json = ""; 
		//判断用户名是否存在
        TbSysrUserDto temp =new TbSysrUserDto();
        temp.setUser_code(usercode);
		int size = new BaseQueryServiceUtil<TbSysrUserDto>().selectCount(temp);
		if(size !=0){
        	json = "{\"error\":" + true + ",\"message\":\"" + "该登录名已经存在，请换一个登录名重新輸入!\"}";
			outJSOND(response,  json) ;
			return false;
	    } 
		return true; 
	}
	/***
	 * 点击详细功能的时候，获取
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({  "static-access", "rawtypes" })
	@RequestMapping("/detail_TbSysrUser.do")
	public void queryDetail(HttpServletRequest request ,HttpServletResponse response) throws IOException {
       	String pkid =request.getParameter("pkid"); 
		String json ="";
		TbSysrUserDto dto = new TbSysrUserDto();
		dto.setSysr_user_id(pkid) ; 
		dto.setNetno(super.obtainLoginUserNetno(request));
		dto=(TbSysrUserDto)new BaseQueryServiceUtil<TbSysrUserDto>()
				.selectObject(dto);
		Map map = new BeanRefUtil().transBean2Map(dto);
		PropertyValueChangeUtil.enumValue2Desc(map, TbSysrUserDto.PropertyEnum.getPropertyEnumMap());
		PropertyValueChangeUtil.dateValue2Desc(map );
		JSONObject jsonObj = JSONObject.fromObject(map);  
		json = "{\"error\":" + false + ",\"message\":" + jsonObj.toString() + "}";
		outJSOND(response,  json) ; 
	}
	/***
	 * 点击编辑后，显示修改初始化页面时的查询
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@RequestMapping("/editDetail_TbSysrUser.do")
	public void queryEditDetail(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String pkid =request.getParameter("pkid"); 
		String json ="";
		TbSysrUserDto dto = new TbSysrUserDto();
		dto.setSysr_user_id(pkid) ; 
		dto.setNetno(super.obtainLoginUserNetno(request));
		dto=(TbSysrUserDto)new BaseQueryServiceUtil<TbSysrUserDto>()
				.selectObject(dto);
		JSONObject jsonObj = JSONObject.fromObject(dto);  
		json = "{\"error\":" + false + ",\"message\":" + jsonObj.toString() + "}";
		outJSOND(response,  json) ; 
	} 
	
	
	/***
	 * 
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "static-access" })
	@RequestMapping("/edit_TbSysrUser.do")
	public void editData(HttpServletRequest request ,HttpServletResponse response ) throws IOException {
		String json ="";
		String editContentStr = CharacterConversionUtil.change(
				request.getParameter("editContentStr"));
        JSONObject jSONObject = JSONObject.fromObject(editContentStr);
        TbSysrUserDto dto = (TbSysrUserDto) jSONObject.toBean(jSONObject, TbSysrUserDto.class);  
		dto.setUpdatetime(obtainCreateTimeStr());
		dto.setUpdate_user_id(obtainLoginUserId(request));
		TbSysrUserDto odto = obtainUserInfo(request) ; 
	    if(odto.getUser_code().equals(dto.getUser_code())){//表示用户修改了用户名,此时需要验证性的用户名是否唯一
	    	if(!validateUsercode(dto.getUser_code(), obtainLoginUserNetno(request) ,response )){
	        	return ; 
			}
	    }	
		try {
			int flag =0;
			try {
				flag =new BaseQueryServiceUtil<TbSysrUserDto>()
						.updateEntityById(dto);
			} catch (Exception e) {
				logger.error("更新出现异常",e);
				json = "{\"error\":" + true + ",\"message\":\"" + ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
			}
			if(flag ==1){
				json = "{\"error\":" + false + ",\"message\":\"" + "更新成功!\"}";
			}else{
				json = "{\"error\":" + true + ",\"message\":\"" + ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
			}
			outJSOND(response,  json) ; 
		} catch (Exception ex) {
			logger.error("更新出现异常",ex);
			json = "{\"error\":" + true + ",\"message\":\"" + ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
			outJSOND(response,  json) ; 
		}
	}
	
	/***
	 * 点击删除按钮时
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@RequestMapping("/del_TbSysrUser.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void del(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String pkid  =request.getParameter("pkid");        
		String json ="";
		TbSysrUserDto dto = new TbSysrUserDto();
		dto.setSysr_user_id(pkid);  
		int flag = 0;
		try {
			if(pkid == null ){
				outJSOND(response,  "{\"error\":" + true + ",\"message\":\"" + "主键为空!\"}") ; 
				return ; 
			}
			TbSysrUserDto loginInfoUser = obtainUserInfo(request) ; 
			
			if(loginInfoUser.getSysr_user_id().equals(pkid)){
				outJSOND(response,  "{\"error\":" + true + ",\"message\":\"" + "您不能删除您自己的账户!\"}") ; 
				return ; 
			}
			flag = new BaseQueryServiceUtil<TbSysrUserDto>().deleteEntity(dto);
		} catch (Exception e) {
			logger.error("删除数据出现异常",e);
			json = "{\"error\":" + true + ",\"message\":\"" + ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
		}
		if(flag ==0){
			json = "{\"error\":" + true + ",\"message\":\"" + ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
		}else{
			json = "{\"error\":" + false + ",\"message\":\"" + "删除成功!\"}";
		}
		outJSOND(response,  json) ; 
	}	
	/***
	 * 点击重置登录密码按钮时
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@RequestMapping("/resetTbSysUserPass.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void resetTbSysUserPass(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String pkid  =request.getParameter("pkid");        
		String json ="";
		int flag = 0;
		try {
			if(pkid == null ){
				outJSOND(response,  "{\"error\":" + true + ",\"message\":\"" + "主键为空!\"}") ; 
				return ; 
			}
			TbSysrUserDto dto = new TbSysrUserDto();
			dto.setSysr_user_id(pkid); 
			dto = (TbSysrUserDto)new BaseQueryServiceUtil<TbSysrUserDto>().selectObject(dto);
			dto.setPassword(MD5Util.string2MD5("111111"));//初始密码为111111
			flag = new BaseQueryServiceUtil<TbSysrUserDto>().updateEntityById(dto);
			//
		} catch (Exception e) {
			logger.error("", e);
			json = "{\"error\":" + true + ",\"message\":\"" + ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
		}
		if(flag ==0){
			json = "{\"error\":" + true + ",\"message\":\"" + "重置密码失败!\"}";
		}else{
			json = "{\"error\":" + false + ",\"message\":\"" + "重置密码成功!初始密码为：111111\"}";
		}
			
		outJSOND(response,  json) ; 
	}	
	
	
	/**
	 * 根据ID获取已经配置的角色
	 * @param request
	 * @param response
	 */
	@SuppressWarnings({  "rawtypes", "static-access", "unchecked" })
	@RequestMapping("/searchTUserRoleRela.do")
	public void searchTUserRoleRelaByUserId(HttpServletRequest request ,HttpServletResponse response) {
		try {
			String pkid = request.getParameter("pkid");  
			if(StringUtils.isEmpty(pkid)){
				String json = "{\"error\":" + true + ",\"message\":\"" + "获取角色失败,用户未选择\"}";
				outJSOND(response,  json) ;  
				return ; 
			}
	        PagingObject init_pg = PangingUtils.getPagingObjectFormRequest(request);
	        java.util.HashMap param = new java.util.HashMap();
	        param.put("netno", super.obtainLoginUserNetno(request)) ;
	        param.put("sysr_user_id", pkid) ;
	        param.put("maxSize", init_pg.getCurrent_page()*init_pg.getPage_size()) ;
	        param.put("minSize", (init_pg.getCurrent_page()-1)*init_pg.getPage_size()) ;
	        List<TbSysrRoleDto>  rows = tbSysrRoleMapper.selectConfigTRoleByUserId(param);
	        param.remove("maxSize");
	        param.remove("minSize");
	        Integer total = tbSysrRoleMapper.selectCountConfigTRoleByUserId(param) ;
	        List<Map> mapRows = new ArrayList<Map>();
	        for (TbSysrRoleDto dto : rows) {
				// 2.自定义按钮设置在此处
	        	Map map  = new BeanRefUtil().transBean2Map(dto);
				map.put("edit","<a href='javascript:return void(0);' onClick=\"tbSysrRelationUserRole_list.updateFormSubmit('"+ map.get("object_id")+ "');return false;\"><i class='icon-edit'></i></a>");
				map.put("detail","<a href='javascript:return void(0);'onClick=\"tbSysrRelationUserRole_list.detailFormSubmit('"+ map.get("object_id")+ "');return false;\"><i class='icon-search'></i></a>");
				//下面的方法是将对象中的枚举值改为枚举描述。如stat为0时表示无效。则将map中的stat的值从0改为0-无效，方便前端显示，但是该方法需要完善Dto的PropertyEnum方法
				PropertyValueChangeUtil.enumValue2Desc(map,TbSysrRelationUserRoleDto.PropertyEnum.getPropertyEnumMap());
				PropertyValueChangeUtil.dateValue2Desc(map );
				mapRows.add(map);
			}	
	        JsonConfig config = new JsonConfig();
	        JsonDateFormatUtil.formatDateForJsonConfig_type(config);
			JSONArray json_rows = JSONArray.fromObject(mapRows, config);
	        String json = "{\"total\":\""
					+ total
					+ "\",\"rows\":" + json_rows.toString() + "}";
	        outJSOND(response,  json) ;  
		} catch (Exception ex) {
			logger.error("操作错误" ,ex);
		}
	}
	
	/**
	 * 根据客户id获取还为配置的角色列表
	 * @param request
	 * @param response
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@RequestMapping("/selectTRoleByUserId.do")
	public void selectTRoleByUserId(HttpServletRequest request ,HttpServletResponse response) {
		String role_name  =BeanRefUtil.setLikeConditon(request.getParameter("role_name")); 
		String role_group  =request.getParameter("role_group"); 
		String sysr_user_id  =request.getParameter("role_user_id"); 
		PagingObject init_pg = PangingUtils.getPagingObjectFormRequest(request);
		java.util.HashMap param = new java.util.HashMap();
		param.put("netno", super.obtainLoginUserNetno(request)) ;
        param.put("sysr_user_id", sysr_user_id) ;
		param.put("role_name", role_name) ;
		param.put("role_group", role_group) ;
        param.put("maxSize", init_pg.getCurrent_page()*init_pg.getPage_size()) ;
        param.put("minSize", (init_pg.getCurrent_page()-1)*init_pg.getPage_size()) ;
		List<TbSysrRoleDto>  rows = tbSysrRoleMapper.selectNoConfigTRoleByUserId(param);
		param.remove("maxSize") ;
		param.remove("minSize") ;
		Integer total =  tbSysrRoleMapper.selectCountNoConfigTRoleByUserId(param);
		List<Map> mapRows = new ArrayList<Map>();
		for (TbSysrRoleDto dto : rows) {
			if(ConstantValue.ROLE_ADMIN.equals(dto.getSysr_role_id())){
				continue;
			}
			Map d  = new BeanRefUtil().transBean2Map(dto);
			// 2.自定义按钮设置在此处
			d.put("edit","<a href='javascript:return void(0);' onClick=\"tRole_list.updateFormSubmit('"+ d.get("sysr_role_id")+ "');return false;\"><i class='icon-edit'></i></a>");
			d.put("detail","<a href='javascript:return void(0);'onClick=\"tRole_list.detailFormSubmit('"+ d.get("sysr_role_id")+ "');return false;\"><i class='icon-search'></i></a>");
			d.put("resource_config","<a href='javascript:return void(0);' onClick=\"tRole_list.allotResourceFormSubmit('"+ d.get("sysr_role_id")+ "','"+d.get("role_name")+"','"+d.get("role_group")+"');return false;\"><i class='icon-edit'></i></a>");
			d.put("user_config","<a href='javascript:return void(0);' onClick=\"tRole_list.allotResourceFormSubmit('"+ d.get("sysr_role_id")+ "','"+d.get("role_name")+"','"+d.get("role_group")+"');return false;\"><i class='icon-edit'></i></a>");
			PropertyValueChangeUtil.enumValue2Desc(d,TbSysrRoleDto.PropertyEnum.getPropertyEnumMap());
			PropertyValueChangeUtil.dateValue2Desc(d );
			mapRows.add(d);
		}

		// 3.组合输出列表查询所需数据
		// JsonConfig 用于解析转换的设置
		JsonConfig config = new JsonConfig();
		JsonDateFormatUtil.formatDateForJsonConfig_type(config);
		JSONArray json_rows = JSONArray.fromObject(mapRows, config);
        String json = "{\"total\":\""
				+ total
				+ "\",\"rows\":" + json_rows.toString() + "}";
		outJSOND(response, json);
	}
	
	/**
	 * 移除角色按钮
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delTRoleResRela.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void delTRoleResRela(HttpServletRequest request ,HttpServletResponse response) {
		String sysr_user_id = request.getParameter("pkid") ; 
		String[] sys_role_ides = request.getParameter("sys_role_ides").split(",");
		if(StringUtils.isEmpty(sysr_user_id)){
			return ;//"{\"error\":" + true + ",\"message\":\"" + "重置密码失败!\"}";
		}
		TbSysrRelationUserRoleDto dto  = null; 
		for(String sys_role_id:sys_role_ides){
			dto = new TbSysrRelationUserRoleDto();
			dto.setSysr_role_id(sys_role_id);
			dto.setSysr_user_id(sysr_user_id);
			new BaseQueryServiceUtil<TbSysrRelationUserRoleDto>().deleteEntity(dto) ; 
		}
	}
	
	
	/**
	 * 添加角色
	 */
	@RequestMapping("/addTUserRoleRela.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void addTUserRoleRela(HttpServletRequest request ,HttpServletResponse response) {
		String sysr_user_id = request.getParameter("pkid") ; 
		String[] sys_role_ides = request.getParameter("sys_role_ides").split(",");
		TbSysrRelationUserRoleDto dto  = null; 
		for(String sys_role_id:sys_role_ides){
			dto = new TbSysrRelationUserRoleDto();
			dto.setObject_id(DatabaseUtil.getPkId(3, 1));
			dto.setSysr_role_id(sys_role_id);
			dto.setSysr_user_id(sysr_user_id);
			dto.setCreatetime(obtainCreateTimeStr());
			dto.setCreate_user_id(obtainLoginUserId(request));
			dto.setUpdate_user_id(obtainLoginUserId(request));
			dto.setUpdatetime(obtainCreateTimeStr());
			new BaseQueryServiceUtil<TbSysrRelationUserRoleDto>().insertEntity(dto) ; 
		}
	}
}