﻿package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.absmybatis.common.SelectParamHandle;
import com.absmybatis.util.DateUtil;
import com.web.common.controller.BaseController;
import com.web.common.util.PropertyValueChangeUtil;
import com.web.common.util.web.BeanRefUtil;
import com.web.common.util.web.CharacterConversionUtil;
import com.web.common.util.web.JsonDateFormatUtil;
import com.web.common.util.web.PagingObject;
import com.web.common.util.web.PangingUtils;
import com.web.common.util.web.TimestampMorpher;
import com.web.entity.TbSceneTraceInfoDto;
import com.web.mapper.AllEntityMapperFactory;
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
public class TbSceneTraceInfoController extends BaseController  {

	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@RequestMapping("/search_tbSceneTraceInfo_getListData.do")
	public void getListData(HttpServletRequest request ,HttpServletResponse response) {
		try {
			String searchContentStr = CharacterConversionUtil.change(
				request.getParameter("searchContentStr")) ;
            String[] formats={"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd"}; 
            JSONUtils.getMorpherRegistry().registerMorpher(new TimestampMorpher(formats));  
			JSONObject jSONObject = JSONObject.fromObject(searchContentStr);
			TbSceneTraceInfoDto dto = (TbSceneTraceInfoDto) jSONObject.toBean(jSONObject, TbSceneTraceInfoDto.class);  
			if(dto==null){
	        	dto = new TbSceneTraceInfoDto();
	        }
	        PagingObject init_pg = PangingUtils.getPagingObjectFormRequest(request);
	        List<TbSceneTraceInfoDto>  rows =  AllEntityMapperFactory.getAllEntityMapper()
					.selectListByPage(dto,new SelectParamHandle(init_pg.getCurrent_page(),init_pg.getPage_size(),"id")) ;
	        Integer total = AllEntityMapperFactory.getAllEntityMapper()
					.selectCount(dto ) ;
	        List<Map> mapRows = new ArrayList<Map>();
	        for (TbSceneTraceInfoDto d : rows) {
				BeanRefUtil beanRefUtil = new BeanRefUtil();
				Map map = beanRefUtil.transBean2Map(d);
				// 2.自定义按钮设置在此处
				map.put("edit","<a href='javascript:return void(0);' onClick=\"tbSceneTraceInfo_list.updateFormSubmit('"+ map.get("id")+ "');return false;\"><i class='icon-edit'></i></a>");
				map.put("detail","<a href='javascript:return void(0);'onClick=\"tbSceneTraceInfo_list.detailFormSubmit('"+ map.get("id")+ "');return false;\"><i class='icon-search'></i></a>");
				//下面的方法是将对象中的枚举值改为枚举描述。如stat为0时表示无效。则将map中的stat的值从0改为0-无效，方便前端显示，但是该方法需要完善Dto的PropertyEnum方法
				PropertyValueChangeUtil.enumValue2Desc(map,TbSceneTraceInfoDto.PropertyEnum.getPropertyEnumMap());
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
			ex.printStackTrace();
		}
	}
	 
	 
	 /***
	 * 点击添加按钮时
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked",  "static-access" })
	@RequestMapping("/add_TbSceneTraceInfo.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void addData(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String json ="";
		String addContentStr = CharacterConversionUtil.change(
				request.getParameter("addContentStr"));
        JSONObject jSONObject = JSONObject.fromObject(addContentStr);
        TbSceneTraceInfoDto dto = (TbSceneTraceInfoDto) jSONObject.toBean(jSONObject, TbSceneTraceInfoDto.class);  
        if(dto==null){
        	json = "{\"error\":" + true + ",\"message\":\"" + "保存失败!\"}";
			outJSOND(response,  json) ; 
			return ;
        }		
        dto.setCreator(obtainLoginUserId(request));
		dto.setGmt_created(DateUtil.date2javaSqlTimestamp(new Date()));
		dto.setGmt_modified(DateUtil.date2javaSqlTimestamp(new Date()));
		dto.setModifier(obtainLoginUserId(request));
		dto.setIs_deleted("N");
		try {
			int flag  = AllEntityMapperFactory.getAllEntityMapper()
						.insertEntity(dto);
			if(flag ==1){
				json = "{\"error\":" + false + ",\"message\":\"" + "保存成功!\"}";
			}else{
				json = "{\"error\":" + true + ",\"message\":\"" + "保存失败!\"}";
			}
			outJSOND(response,  json) ; 
		} catch (Exception ex) {
			logger.error("保存出现异常",ex);
			json = "{\"error\":" + true + ",\"message\":\"" + "保存失败!\"}";
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
	@RequestMapping("/detail_TbSceneTraceInfo.do")
	public void queryDetail(HttpServletRequest request ,HttpServletResponse response) throws IOException {
       	String pkid =request.getParameter("pkid"); 
		String json ="";
		TbSceneTraceInfoDto dto = new TbSceneTraceInfoDto();
		dto.setId(pkid) ; 
		dto=(TbSceneTraceInfoDto)AllEntityMapperFactory.getAllEntityMapper()
				.selectObject(dto);
		Map map = new BeanRefUtil().transBean2Map(dto);
		PropertyValueChangeUtil.enumValue2Desc(new BeanRefUtil().transBean2Map(dto), TbSceneTraceInfoDto.PropertyEnum.getPropertyEnumMap());
		PropertyValueChangeUtil.dateValue2Desc(map );
		JSONObject jsonObj = JSONObject.fromObject(map );  
		json = "{\"error\":" + true + ",\"message\":" + jsonObj.toString() + "}";
		outJSOND(response,  json) ; 
	}
	/***
	 * 点击编辑后，显示修改初始化页面时的查询
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/editDetail_TbSceneTraceInfo.do")
	public void queryEditDetail(HttpServletRequest request ,HttpServletResponse response) throws IOException {
       	String pkid =request.getParameter("pkid"); 
		String json ="";
		TbSceneTraceInfoDto dto = new TbSceneTraceInfoDto();
		dto.setId(pkid) ; 
		dto=(TbSceneTraceInfoDto)AllEntityMapperFactory.getAllEntityMapper()
				.selectObject(dto);
		JSONObject jsonObj = JSONObject.fromObject(dto );  
		json = "{\"error\":" + true + ",\"message\":" + jsonObj.toString() + "}";
		outJSOND(response,  json) ; 
	}
	
	/***
	 * 
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	@RequestMapping("/edit_TbSceneTraceInfo.do")
	public void editData(HttpServletRequest request ,HttpServletResponse response ) throws IOException {
		String json ="";
		String editContentStr = CharacterConversionUtil.change(
			request.getParameter("editContentStr"));
        JSONObject jSONObject = JSONObject.fromObject(editContentStr);
        TbSceneTraceInfoDto dto = (TbSceneTraceInfoDto) jSONObject.toBean(jSONObject, TbSceneTraceInfoDto.class);  
        if(dto==null){
        	json = "{\"error\":" + true + ",\"message\":\"" + "更新失败!\"}";
			outJSOND(response,  json) ; 
			return ;
        }		
		try {
			dto.setGmt_modified(DateUtil.date2javaSqlTimestamp(new Date()));
			dto.setModifier(obtainLoginUserId(request));
			int flag  = AllEntityMapperFactory.getAllEntityMapper()
						.updateEntityById(dto);
			if(flag ==1){
				json = "{\"error\":" + false + ",\"message\":\"" + "更新成功!\"}";
			}else{
				json = "{\"error\":" + true + ",\"message\":\"" + "更新失败!\"}";
			}
			outJSOND(response,  json) ; 
		} catch (Exception ex) {
			logger.error("更新出现异常",ex);
			json = "{\"error\":" + true + ",\"message\":\"" + "更新失败!\"}";
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
	@RequestMapping("/del_TbSceneTraceInfo.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void del(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String pkid  =request.getParameter("pkid");        
		String json ="";
		TbSceneTraceInfoDto dto = new TbSceneTraceInfoDto();
		dto.setId(pkid);  
		int flag = 0;
		try {
			if(pkid == null ){
				outJSOND(response,  "{\"error\":" + false + ",\"message\":\"" + "主键为空!\"}") ; 
				return ; 
			}
			flag = AllEntityMapperFactory.getAllEntityMapper().deleteEntity(dto);
		} catch (Exception e) {
			logger.error("删除数据出现异常",e);
			json = "{\"error\":" + true + ",\"message\":\"" + "删除数据出现异常!\"}";
		}
		if(flag ==0){
			json = "{\"error\":" + true + ",\"message\":\"" + "删除失败!\"}";
		}else{
			json = "{\"error\":" + false + ",\"message\":\"" + "删除成功!\"}";
		}
			
		outJSOND(response,  json) ; 
	}	
	
	
}
