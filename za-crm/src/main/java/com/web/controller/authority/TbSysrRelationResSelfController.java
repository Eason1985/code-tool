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
import org.springframework.web.bind.annotation.RequestMapping;

import com.absmybatis.common.SelectParamHandle;
import com.web.common.ChainMap;
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
import com.web.entity.TbSysrRelationResSelfDto;
import com.web.entity.TbSysrResourceDto;
import com.web.mapper.AllEntityMapperFactory;
import com.web.mapper.tbSysrRelationResSelf.TbSysrRelationResSelfMapper;
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
public class TbSysrRelationResSelfController extends BaseController  {
	@Autowired
	TbSysrRelationResSelfMapper tbSysrRelationResSelfMapper;
	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@RequestMapping("/search_tbSysrRelationResSelf_getListData.do")
	public void getListData(HttpServletRequest request ,HttpServletResponse response) {
		try {
			String searchContentStr = CharacterConversionUtil.change(
					request.getParameter("searchContentStr")) ;
             String[] formats={"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd"}; 
             JSONUtils.getMorpherRegistry().registerMorpher(new TimestampMorpher(formats));  
			JSONObject jSONObject = JSONObject.fromObject(searchContentStr);
			TbSysrRelationResSelfDto dto = (TbSysrRelationResSelfDto) jSONObject.toBean(jSONObject, TbSysrRelationResSelfDto.class);  
			if(dto==null){
	        	dto = new TbSysrRelationResSelfDto();
	        }
	        PagingObject init_pg = PangingUtils.getPagingObjectFormRequest(request);
	        List<TbSysrRelationResSelfDto>  rows =  AllEntityMapperFactory.getAllEntityMapper()
					.selectListByPage(dto,new SelectParamHandle(init_pg.getCurrent_page(),init_pg.getPage_size(),"relation_res_self_id")) ;
	        Integer total = AllEntityMapperFactory.getAllEntityMapper()
					.selectCount(dto ) ;
	        List<Map> mapRows = new ArrayList<Map>();
	        for (TbSysrRelationResSelfDto d : rows) {
				BeanRefUtil beanRefUtil = new BeanRefUtil();
				Map map = beanRefUtil.transBean2Map(d);
				// 2.自定义按钮设置在此处
				map.put("edit","<a href='javascript:return void(0);' onClick=\"tbSysrRelationResSelf_list.updateFormSubmit('"+ map.get("relation_res_self_id")+ "');return false;\"><i class='icon-edit'></i></a>");
				map.put("detail","<a href='javascript:return void(0);'onClick=\"tbSysrRelationResSelf_list.detailFormSubmit('"+ map.get("relation_res_self_id")+ "');return false;\"><i class='icon-search'></i></a>");
				//下面的方法是将对象中的枚举值改为枚举描述。如stat为0时表示无效。则将map中的stat的值从0改为0-无效，方便前端显示，但是该方法需要完善Dto的PropertyEnum方法
				PropertyValueChangeUtil.enumValue2Desc(map,TbSysrRelationResSelfDto.PropertyEnum.getPropertyEnumMap());
				PropertyValueChangeUtil.dateValue2Desc(map );
				//设置资源名称
				Map parent_res_idMap = tbSysrRelationResSelfMapper.queryResourceName((String) map.get("parent_res_id"));
				Map child_res_idMap = tbSysrRelationResSelfMapper.queryResourceName((String) map.get("child_res_id")); 
				map.put("parent_res_id", parent_res_idMap==null?"":parent_res_idMap.get("RESOURCE_NAME"));
				map.put("child_res_id", child_res_idMap == null?"":child_res_idMap.get("RESOURCE_NAME"));
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
	@RequestMapping("/add_TbSysrRelationResSelf.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void addData(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String json ="";
		String addContentStr = CharacterConversionUtil.change(
				request.getParameter("addContentStr"));
        JSONObject jSONObject = JSONObject.fromObject(addContentStr);
        TbSysrRelationResSelfDto dto = (TbSysrRelationResSelfDto) jSONObject.toBean(jSONObject, TbSysrRelationResSelfDto.class);  
        if(dto==null){
        	   dto = new TbSysrRelationResSelfDto();
        }		
		try {
				dto.setRelation_res_self_id(DatabaseUtil.getPkId(3, 1)); //资源自关联ID
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
	@RequestMapping("/detail_TbSysrRelationResSelf.do")
	public void queryDetail(HttpServletRequest request ,HttpServletResponse response) throws IOException {
       	String pkid =request.getParameter("pkid"); 
		String json ="";
		TbSysrRelationResSelfDto dto = new TbSysrRelationResSelfDto();
		dto.setRelation_res_self_id(pkid) ; 
		dto=(TbSysrRelationResSelfDto)AllEntityMapperFactory.getAllEntityMapper()
				.selectObject(dto);
		Map parent_res_idMap = tbSysrRelationResSelfMapper.queryResourceName(dto.getParent_res_id());
		Map child_res_idMap = tbSysrRelationResSelfMapper.queryResourceName(dto.getChild_res_id()); 
		dto.setParent_res_id((String) (parent_res_idMap==null?"":parent_res_idMap.get("RESOURCE_NAME")));
		dto.setChild_res_id((String) (child_res_idMap == null?"":child_res_idMap.get("RESOURCE_NAME")));
		Map map = new BeanRefUtil().transBean2Map(dto);
		PropertyValueChangeUtil.enumValue2Desc(new BeanRefUtil().transBean2Map(dto), TbSysrRelationResSelfDto.PropertyEnum.getPropertyEnumMap());
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
	@RequestMapping("/editDetail_TbSysrRelationResSelf.do")
	public void queryEditDetail(HttpServletRequest request ,HttpServletResponse response) throws IOException {
       	String pkid =request.getParameter("pkid"); 
		String json ="";
		TbSysrRelationResSelfDto dto = new TbSysrRelationResSelfDto();
		dto.setRelation_res_self_id(pkid) ; 
		dto=(TbSysrRelationResSelfDto)AllEntityMapperFactory.getAllEntityMapper()
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
	@RequestMapping("/edit_TbSysrRelationResSelf.do")
	public void editData(HttpServletRequest request ,HttpServletResponse response ) throws IOException {
		String json ="";
		String editContentStr = CharacterConversionUtil.change(
				request.getParameter("editContentStr"));
        JSONObject jSONObject = JSONObject.fromObject(editContentStr);
        TbSysrRelationResSelfDto dto = (TbSysrRelationResSelfDto) jSONObject.toBean(jSONObject, TbSysrRelationResSelfDto.class);  
        if(dto==null){
        	   dto = new TbSysrRelationResSelfDto();
        }		
		try {
			dto.setNetno(obtainLoginUserNetno(request));
			dto.setUpdate_user_id(obtainLoginUserId(request));
			dto.setUpdatetime(obtainCreateTimeStr()); //修改时间
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
	@RequestMapping("/del_TbSysrRelationResSelf.do")
	@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public void del(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String pkid  =request.getParameter("pkid");        
		String json ="";
		TbSysrRelationResSelfDto dto = new TbSysrRelationResSelfDto();
		dto.setRelation_res_self_id(pkid);  
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
	
		 /***
		 * 该方法用来获取页面上的select标签页面
		 * 最好将该方法移动到TbSysrResourceDtoContrller中
		 * @return
		 * @throws IOException 
		 * @throws Exception
		 */
		@SuppressWarnings({ "unchecked" })
		@RequestMapping("/obtainTbSysrResourceDto.do")
		public void obtainTbSysrResourceDtoForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
			TbSysrResourceDto  prd = new TbSysrResourceDto();
			List<TbSysrResourceDto> prdList =(ArrayList<TbSysrResourceDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
	        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
	        result.add(new ChainMap<String,String>()
        			.chainPut("text","请选择")
        			.chainPut("id", ""));
        	if(prdList!=null && prdList.size()>0){
		        for(TbSysrResourceDto temp: prdList){
		        	result.add(new ChainMap<String,String>()
		        			.chainPut("text",temp.getResource_name() )
		        			.chainPut("id", temp.getResource_id())
		        		);
		        }
	        }
	        JsonConfig config = new JsonConfig();
	        JsonDateFormatUtil.formatDateForJsonConfig_type(config);
			JSONArray json_rows = JSONArray.fromObject(result, config);
			String json = "{\"total\":\""
					+ result.size()
					+ "\",\"rows\":" + json_rows.toString() + "}";
			outJSOND(response, json) ; 
		}
	
	
	
}
