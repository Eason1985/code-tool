package com.web.controller.authority;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.web.common.util.tree.Tree;
import com.web.common.util.tree.TreeUtil;
import com.web.common.util.web.BeanRefUtil;
import com.web.common.util.web.CharacterConversionUtil;
import com.web.common.util.web.DatabaseUtil;
import com.web.common.util.web.JsonDateFormatUtil;
import com.web.common.util.web.PagingObject;
import com.web.common.util.web.PangingUtils;
import com.web.common.util.web.TimestampMorpher;
import com.web.entity.TbSysrRelationRoleResourceDto;
import com.web.entity.TbSysrRoleDto;
import com.web.mapper.AllEntityMapperFactory;
import com.web.mapper.tbSysrRelationRoleResource.TbSysrRelationRoleResourceMapper;
 /**
 * 类功能:自动代码生成模板查询   controller 模板
 * <p>创建者:</p>
 * <p>创建时间:</p>
 * <p>修改者:</p>
 * <p>修改时间:</p>
 * <p>修改原因：</p>
 * <p>审核者:</p>
 * <p>审核时间:</p>
 * <p>审核意见：</p>
 */
 
@Controller 
public class TbSysrRoleController extends BaseController  {
	@Autowired
	private TbSysrRelationRoleResourceMapper tbSysrRelationRoleResourceMapper;
	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@RequestMapping("/search_tbSysrRole_getListData.do")
	public void getListData(HttpServletRequest request ,HttpServletResponse response) {
		try {
			String searchContentStr = CharacterConversionUtil.change(
					request.getParameter("searchContentStr")) ;
             String[] formats={"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd"}; 
             JSONUtils.getMorpherRegistry().registerMorpher(new TimestampMorpher(formats));  
			JSONObject jSONObject = JSONObject.fromObject(searchContentStr);
			TbSysrRoleDto dto = (TbSysrRoleDto) jSONObject.toBean(jSONObject, TbSysrRoleDto.class);  
			if(dto==null){
	        	dto = new TbSysrRoleDto();
	        }
			dto.setRole_name(BeanRefUtil.setLikeConditon(dto.getRole_name()));//角色名模糊查詢
			dto.setRole_group(BeanRefUtil.setLikeConditon(dto.getRole_group()));//角色組模糊查詢
//			dto.setNetno(obtainLoginUserNetno(request));
	        PagingObject init_pg = PangingUtils.getPagingObjectFormRequest(request);
	        List<TbSysrRoleDto>  rows =  AllEntityMapperFactory.getAllEntityMapper()
					.selectListByPage(dto,new SelectParamHandle(init_pg.getCurrent_page(),init_pg.getPage_size(),"sysr_role_id")) ;
	        dto.setRole_name(BeanRefUtil.setLikeConditon(dto.getRole_name()));//角色名模糊查詢
			dto.setRole_group(BeanRefUtil.setLikeConditon(dto.getRole_group()));//角色組模糊查詢
	        Integer total = AllEntityMapperFactory.getAllEntityMapper()
					.selectCount(dto ) ;
	        List<Map> mapRows = new ArrayList<Map>();
	        for (TbSysrRoleDto d : rows) {
				BeanRefUtil beanRefUtil = new BeanRefUtil();
				Map map = beanRefUtil.transBean2Map(d);
				// 2.自定义按钮设置在此处
				map.put("edit","<a href='javascript:return void(0);' onClick=\"tbSysrRole_list.updateFormSubmit('"+ map.get("sysr_role_id")+ "');return false;\"><i class='icon-edit'></i></a>");
				map.put("detail","<a href='javascript:return void(0);'onClick=\"tbSysrRole_list.detailFormSubmit('"+ map.get("sysr_role_id")+ "');return false;\"><i class='icon-search'></i></a>");
				map.put("resource_config","<a href='javascript:return void(0);' onClick=\"tbSysrRole_list.allotResourceFormSubmit('"+ map.get("sysr_role_id")+ "','"+map.get("role_name")+"','"+map.get("role_group")+"');return false;\"><i class='icon-resource'></i></a>");
				map.put("user_config","<a href='javascript:return void(0);' onClick=\"tbSysrRole_list.allotUserFormSubmit('"+ map.get("sysr_role_id")+ "','"+map.get("role_name")+"','"+map.get("role_group")+"');return false;\"><i class='icon-user'></i></a>");
            	PropertyValueChangeUtil.enumValue2Desc(map,TbSysrRoleDto.PropertyEnum.getPropertyEnumMap());
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
			logger.error("", ex);
		}
	}
	 
	 
	 /***
	 * 点击添加按钮时
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked",  "static-access" })
	@RequestMapping("/add_TbSysrRole.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void addData(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String json ="";
		String addContentStr = CharacterConversionUtil.change(
				request.getParameter("addContentStr"));
        JSONObject jSONObject = JSONObject.fromObject(addContentStr);
        TbSysrRoleDto dto = (TbSysrRoleDto) jSONObject.toBean(jSONObject, TbSysrRoleDto.class);  
        if(dto==null){
        	   dto = new TbSysrRoleDto();
        }		
		try {
			dto.setSysr_role_id(DatabaseUtil.getPkId(3, 1));
			dto.setNetno(obtainLoginUserNetno(request));
			dto.setCreatetime(obtainCreateTimeStr()); //创建时间
			dto.setCreate_user_id(obtainLoginUserId(request));
			dto.setUpdatetime(obtainCreateTimeStr());
			dto.setUpdate_user_id(obtainLoginUserId(request));
			int flag  = AllEntityMapperFactory.getAllEntityMapper()
						.insertEntity(dto);
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


	/***
	 * 
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "static-access", "rawtypes" })
	@RequestMapping("/detail_TbSysrRole.do")
	public void queryDetail(HttpServletRequest request ,HttpServletResponse response) throws IOException {
       	String pkid =request.getParameter("pkid"); 
		String json ="";
		TbSysrRoleDto dto = new TbSysrRoleDto();
		dto.setSysr_role_id(pkid) ; 
		dto.setNetno(obtainLoginUserNetno(request));
		dto=(TbSysrRoleDto)AllEntityMapperFactory.getAllEntityMapper()
				.selectObject(dto);
		Map map = new BeanRefUtil().transBean2Map(dto);
		PropertyValueChangeUtil.enumValue2Desc(new BeanRefUtil().transBean2Map(dto), TbSysrRoleDto.PropertyEnum.getPropertyEnumMap());
		PropertyValueChangeUtil.dateValue2Desc(map );
		JSONObject jsonObj = JSONObject.fromObject(map );  
		json = "{\"error\":" + false + ",\"message\":" + jsonObj.toString() + "}";
		outJSOND(response,  json) ; 
	}
	/***
	 * 点击编辑后，显示修改初始化页面时的查询
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/editDetail_TbSysrRole.do")
	public void queryEditDetail(HttpServletRequest request ,HttpServletResponse response) throws IOException {
       	String pkid =request.getParameter("pkid"); 
		String json ="";
		TbSysrRoleDto dto = new TbSysrRoleDto();
		dto.setSysr_role_id(pkid) ; 
		dto.setNetno(obtainLoginUserNetno(request));
		dto=(TbSysrRoleDto)AllEntityMapperFactory.getAllEntityMapper()
				.selectObject(dto);
		JSONObject jsonObj = JSONObject.fromObject(dto );  
		json = "{\"error\":" + false + ",\"message\":" + jsonObj.toString() + "}";
		outJSOND(response,  json) ; 
	}
	
	/***
	 * 
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	@RequestMapping("/edit_TbSysrRole.do")
	public void editData(HttpServletRequest request ,HttpServletResponse response ) throws IOException {
		String json ="";
		String editContentStr = CharacterConversionUtil.change(
				request.getParameter("editContentStr"));
        JSONObject jSONObject = JSONObject.fromObject(editContentStr);
        TbSysrRoleDto dto = (TbSysrRoleDto) jSONObject.toBean(jSONObject, TbSysrRoleDto.class);  
        if(dto==null){
        	json = "{\"error\":" + true + ",\"message\":\"" +ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
        	outJSOND(response,  json) ; 
        	return ;
        }		
		try {
			dto.setUpdatetime(obtainCreateTimeStr());
			dto.setUpdate_user_id(obtainLoginUserId(request));
			int flag  = AllEntityMapperFactory.getAllEntityMapper()
						.updateEntityById(dto);
			if(flag ==1){
				json = "{\"error\":" + false + ",\"message\":\"" + "更新成功!\"}";
			}else{
				json = "{\"error\":" + true + ",\"message\":\"" + ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
			}
			outJSOND(response,  json) ; 
		} catch (Exception ex) {
			logger.error("", ex);
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
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/del_TbSysrRole.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void del(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String pkid  =request.getParameter("pkid");        
		String json ="";
		int flag = 0;
		try {
			if(pkid == null ){
				outJSOND(response,  "{\"error\":" + true + ",\"message\":\"" + "主键为空!\"}") ; 
				return ; 
			}
			TbSysrRoleDto dto = new TbSysrRoleDto();
			dto.setSysr_role_id(pkid);  
			flag = AllEntityMapperFactory.getAllEntityMapper().deleteEntity(dto);
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
	
	
	/**
	 * 根据角色ID获取
	 * @param request
	 * @param response
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/searchTResSelfRela.do")
	public void searchTResSelfRela(HttpServletRequest request ,HttpServletResponse response) {
		try {
			String pkid = request.getParameter("pkid"); 
			if(StringUtils.isEmpty(pkid)){
				String json = "{\"error\":" + true + ",\"message\":\"" + "未选择角色!\"}";
				outJSOND(response, json);
				return ;
			}
			HashMap  map = new HashMap(); 
			map.put("netno",obtainLoginUserNetno(request)) ; 
			map.put("sysr_role_id", pkid); 
			List<Map> list = tbSysrRelationRoleResourceMapper.select_tResSelfRelaList(map);
			Tree tree  =  TreeUtil.convertTResSelfRelaToTree(list);
			JsonConfig config = new JsonConfig();
	        JsonDateFormatUtil.formatDateForJsonConfig_type(config);
	        JSONArray  json_rows = JSONArray.fromObject(tree, config);
			outJSOND(response, json_rows.toString());
		} catch (BusinessException e ){
			logger.error("", e);
			 String json = "{\"error\":" + true + ",\"message\":\"" + e.getErrorCode()==null?"":(e.getErrorCode()+"-")+e.getErrorMessage()+"!\"}";
			 outJSOND(response, json);
		 }
	}	 	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/configResourceToRole.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void configResourceToRole(HttpServletRequest request ,HttpServletResponse response) {
		try {
		String pkid = request.getParameter("pkid")  ; 
		String res_id = request.getParameter("res_id")  ; 
		if(StringUtils.isEmpty(pkid)||StringUtils.isEmpty(res_id)){
			String json = "{\"error\":" + true + ",\"message\":\"" + "未选择角色!\"}";
			outJSOND(response, json);
		}
		if(StringUtils.isEmpty(pkid)||StringUtils.isEmpty(res_id)){
			String json = "{\"error\":" + true + ",\"message\":\"" + "未选择角色!\"}";
			outJSOND(response, json);
		}
		 //通过角色id将原有的关联关系删除
		 TbSysrRelationRoleResourceDto delRoleResRela = new TbSysrRelationRoleResourceDto();
		 delRoleResRela.setSysr_role_id(pkid);
		 AllEntityMapperFactory.getAllEntityMapper().deleteEntity(delRoleResRela);
		 //保存新数据 _id = tRoleResRelaDto.getRes_id();
		 if(res_id != null && res_id.trim().length() > 0)
			{
				String[] resIdArray = res_id.split(",");
				int i = 0;
				for(String rid : resIdArray)
				{	
					delRoleResRela = new TbSysrRelationRoleResourceDto();
					delRoleResRela.setObject_id(DatabaseUtil.getPkId(3, i));
					delRoleResRela.setSysr_role_id(pkid);
					delRoleResRela.setResource_id(rid);
					delRoleResRela.setCreatetime(obtainCreateTimeStr()); //创建时间
					delRoleResRela.setCreate_user_id(obtainLoginUserId(request));
					delRoleResRela.setUpdatetime(obtainCreateTimeStr());
					delRoleResRela.setUpdate_user_id(obtainLoginUserId(request));
					AllEntityMapperFactory.getAllEntityMapper().insertEntity(delRoleResRela);
					i++;
				}
			}
			String json = "{\"error\":" + false + ",\"message\":\"" + "执行成功!\"}";
		 	outJSOND(response, json);
		 } catch (BusinessException e ){
			 logger.error("", e);
			 String json = "{\"error\":" + true + ",\"message\":\"" + e.getErrorCode()==null?"":(e.getErrorCode()+"-")+e.getErrorMessage()+"!\"}";
			 outJSOND(response, json);
		 }
	}
	
	
	
}
