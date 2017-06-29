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

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.absmybatis.common.SelectParamHandle;
import com.web.common.controller.BaseController;
import com.web.common.util.ConstantValue;
import com.web.common.util.PropertyValueChangeUtil;
import com.web.common.util.web.BeanRefUtil;
import com.web.common.util.web.CharacterConversionUtil;
import com.web.common.util.web.DatabaseUtil;
import com.web.common.util.web.JsonDateFormatUtil;
import com.web.common.util.web.PagingObject;
import com.web.common.util.web.PangingUtils;
import com.web.common.util.web.TimestampMorpher;
import com.web.entity.TbSysrGroupDto;
import com.web.entity.TbSysrUserDto;
import com.web.facade.basequery.BaseQueryServiceUtil;
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
public class TbSysrGroupController extends BaseController  {
	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@RequestMapping("/search_tbSysrGroup_getListData.do")
	public void getListData(HttpServletRequest request ,HttpServletResponse response) {
		try {
			String searchContentStr = CharacterConversionUtil.change(
					request.getParameter("searchContentStr")) ;
             String[] formats={"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd"}; 
             JSONUtils.getMorpherRegistry().registerMorpher(new TimestampMorpher(formats));  
			JSONObject jSONObject = JSONObject.fromObject(searchContentStr);
			TbSysrGroupDto dto = (TbSysrGroupDto) jSONObject.toBean(jSONObject, TbSysrGroupDto.class);  
			if(dto==null){
	        	dto = new TbSysrGroupDto();
	        }
	        PagingObject init_pg = PangingUtils.getPagingObjectFormRequest(request);
	        List<TbSysrGroupDto>  rows =  AllEntityMapperFactory.getAllEntityMapper()
					.selectListByPage(dto,new SelectParamHandle(init_pg.getCurrent_page(),init_pg.getPage_size(),"group_id")) ;
	        Integer total =new BaseQueryServiceUtil().selectCount(dto ) ;
	        List<Map> mapRows = new ArrayList<Map>();
	        for (TbSysrGroupDto d : rows) {
				BeanRefUtil beanRefUtil = new BeanRefUtil();
				Map map = beanRefUtil.transBean2Map(d);
				// 2.自定义按钮设置在此处
				map.put("edit","<a href='javascript:return void(0);' onClick=\"tbSysrGroup_list.updateFormSubmit('"+ map.get("group_id")+ "');return false;\"><i class='icon-edit'></i></a>");
				map.put("detail","<a href='javascript:return void(0);'onClick=\"tbSysrGroup_list.detailFormSubmit('"+ map.get("group_id")+ "');return false;\"><i class='icon-search'></i></a>");
				PropertyValueChangeUtil.enumValue2Desc(map, TbSysrGroupDto.PropertyEnum.getPropertyEnumMap());
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
	@SuppressWarnings({ "unchecked",  "static-access", "rawtypes" })
	@RequestMapping("/add_TbSysrGroup.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void addData(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String json ="";
		String addContentStr = CharacterConversionUtil.change(
				request.getParameter("addContentStr"));
        JSONObject jSONObject = JSONObject.fromObject(addContentStr);
        TbSysrGroupDto dto = (TbSysrGroupDto) jSONObject.toBean(jSONObject, TbSysrGroupDto.class);  
        if(dto==null){
        	   dto = new TbSysrGroupDto();
        }		
		try {
				dto.setGroup_id(DatabaseUtil.getPkId(3, 1));
				dto.setNetno(obtainLoginUserNetno(request));
				dto.setCreate_user_id(obtainLoginUserId(request));
				dto.setCreate_user_id(obtainLoginUserId(request));
				dto.setCreatetime(obtainCreateTimeStr()); //创建时间
				dto.setUpdatetime(obtainCreateTimeStr()); //修改时间
				//dto.setgroup_name(""); //组名
				//dto.setnetno(""); //网点号
				//dto.setcreatetime(""); //创建时间
				//dto.setupdatetime(""); //修改时间
				//dto.setcreate_user_id(""); //创建人
				//dto.setupdate_user_id(""); //更新人
			int flag = new BaseQueryServiceUtil().insertEntity(dto);
			if(flag ==1){
				json = "{\"error\":" + false + ",\"message\":\"" + "保存成功!\"}";
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
	 * 
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "static-access", "rawtypes" })
	@RequestMapping("/detail_TbSysrGroup.do")
	public void queryEditDetail(HttpServletRequest request ,HttpServletResponse response) throws IOException {
       	String pkid =request.getParameter("pkid"); 
		String json ="";
		TbSysrGroupDto dto = new TbSysrGroupDto();
		dto.setGroup_id(pkid) ; 
		dto=(TbSysrGroupDto)AllEntityMapperFactory.getAllEntityMapper()
				.selectObject(dto);
		Map map = new BeanRefUtil().transBean2Map(dto);
		PropertyValueChangeUtil.enumValue2Desc(new BeanRefUtil().transBean2Map(dto), TbSysrUserDto.PropertyEnum.getPropertyEnumMap());
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
	@RequestMapping("/editDetail_TbSysrGroup.do")
	public void queryDetail(HttpServletRequest request ,HttpServletResponse response) throws IOException {
       	String pkid =request.getParameter("pkid"); 
		String json ="";
		TbSysrGroupDto dto = new TbSysrGroupDto();
		dto.setGroup_id(pkid) ; 
		dto=(TbSysrGroupDto)AllEntityMapperFactory.getAllEntityMapper()
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
	@RequestMapping("/edit_TbSysrGroup.do")
	public void editData(HttpServletRequest request ,HttpServletResponse response ) throws IOException {
		String json ="";
		String editContentStr = CharacterConversionUtil.change(
				request.getParameter("editContentStr"));
        JSONObject jSONObject = JSONObject.fromObject(editContentStr);
        TbSysrGroupDto dto = (TbSysrGroupDto) jSONObject.toBean(jSONObject, TbSysrGroupDto.class);  
        if(dto==null){
        	   dto = new TbSysrGroupDto();
        }		
		try {
				dto.setNetno(obtainLoginUserNetno(request));
				dto.setCreate_user_id(obtainLoginUserId(request));
				dto.setCreate_user_id(obtainLoginUserId(request));
				dto.setCreatetime(obtainCreateTimeStr()); //创建时间
				dto.setUpdatetime(obtainCreateTimeStr()); //修改时间
				//dto.setgroup_id(""); //组ID
				//dto.setgroup_name(""); //组名
			int flag   = AllEntityMapperFactory.getAllEntityMapper()
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
	@RequestMapping("/del_TbSysrGroup.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void del(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String pkid  =request.getParameter("pkid");        
		String json ="";
		TbSysrGroupDto dto = new TbSysrGroupDto();
		dto.setGroup_id(pkid);  
		int flag = 0;
		try {
			if(pkid == null ){
				outJSOND(response,  "{\"error\":" + true + ",\"message\":\"" + "主键为空!\"}") ; 
				return ; 
			}
			flag = AllEntityMapperFactory.getAllEntityMapper().deleteEntity(dto);
		} catch (Exception e) {
			logger.error("", e);
			json = "{\"error\":" + true + ",\"message\":\"" + ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
		}
		if(flag ==0){
			json = "{\"error\":" + true + ",\"message\":\"" + ConstantValue.SYSTEM_EROR_MESSAGE+"\"}";
		}else{
			json = "{\"error\":" + false + ",\"message\":\"" + "删除成功!\"}";
		}
			
		outJSOND(response,  json) ; 
	}	
	
}
