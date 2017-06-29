package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.common.ChainMap;
import com.web.common.controller.BaseController;
import com.web.common.util.web.JsonDateFormatUtil;
import com.web.entity.TbCustInfoDto;
import com.web.entity.TbProductInfoDto;
import com.web.entity.TbSceneInfoDto;
import com.web.entity.TbSysrUserDto;
import com.web.mapper.AllEntityMapperFactory;
@Controller
public class SelectController  extends BaseController{

	 /***
	 * 该方法用来获取页面上的select标签页面
	 * 最好将该方法移动到TbSceneInfoContrller中
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/obtainTbSceneInfo.do")
	public void obtainTbSceneInfoForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		TbSceneInfoDto  prd = new TbSceneInfoDto();
		List<TbSceneInfoDto> prdList =(ArrayList<TbSceneInfoDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
        result.add(new ChainMap<String,String>()
    			.chainPut("text","请选择")
    			.chainPut("id", ""));
    	if(prdList!=null && prdList.size()>0){
	        for(TbSceneInfoDto temp: prdList){
	        	result.add(new ChainMap<String,String>()
	        			.chainPut("text",temp.getProject_name() )
	        			.chainPut("id", temp.getId())
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
	
	 /***
	 * 该方法用来获取页面上的select标签页面
	 * 最好将该方法移动到TbSysrUserProjectManagerContrller中
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/obtainTbSysrUserProjectManager.do")
	public void obtainTbSysrUserProjectManagerForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		TbSysrUserDto  prd = new TbSysrUserDto();
		//TODO 添加角色
		List<TbSysrUserDto> prdList =(ArrayList<TbSysrUserDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
        result.add(new ChainMap<String,String>()
    			.chainPut("text","请选择")
    			.chainPut("id", ""));
    	if(prdList!=null && prdList.size()>0){
	        for(TbSysrUserDto temp: prdList){
	        	result.add(new ChainMap<String,String>()
	        			.chainPut("text",temp.getUser_name() )
	        			.chainPut("id", temp.getSysr_user_id())
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
	 /***
	 * 该方法用来获取页面上的select标签页面
	 * 最好将该方法移动到TbSysrUserProductManagerContrller中
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/obtainTbSysrUserProductManager.do")
	public void obtainTbSysrUserProductManagerForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		TbSysrUserDto  prd = new TbSysrUserDto();
		//TODO 添加角色
		List<TbSysrUserDto> prdList =(ArrayList<TbSysrUserDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
        result.add(new ChainMap<String,String>()
    			.chainPut("text","请选择")
    			.chainPut("id", ""));
    	if(prdList!=null && prdList.size()>0){
	        for(TbSysrUserDto temp: prdList){
	        	result.add(new ChainMap<String,String>()
	        			.chainPut("text",temp.getUser_name() )
	        			.chainPut("id", temp.getSysr_user_id())
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
	 /***
	 * 该方法用来获取页面上的select标签页面
	 * 最好将该方法移动到TbSysrUserRiskControllerContrller中
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/obtainTbSysrUserRiskController.do")
	public void obtainTbSysrUserRiskControllerForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		TbSysrUserDto  prd = new TbSysrUserDto();
		//TODO 添加角色
		List<TbSysrUserDto> prdList =(ArrayList<TbSysrUserDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
        result.add(new ChainMap<String,String>()
    			.chainPut("text","请选择")
    			.chainPut("id", ""));
    	if(prdList!=null && prdList.size()>0){
	        for(TbSysrUserDto temp: prdList){
	        	result.add(new ChainMap<String,String>()
	        			.chainPut("text",temp.getUser_name() )
	        			.chainPut("id", temp.getSysr_user_id())
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
	 /***
	 * 该方法用来获取页面上的select标签页面
	 * 最好将该方法移动到TbSysrUserLowWorkerContrller中
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/obtainTbSysrUserLowWorker.do")
	public void obtainTbSysrUserLowWorkerForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		TbSysrUserDto  prd = new TbSysrUserDto();
		//TODO 添加角色
		List<TbSysrUserDto> prdList =(ArrayList<TbSysrUserDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
        result.add(new ChainMap<String,String>()
    			.chainPut("text","请选择")
    			.chainPut("id", ""));
    	if(prdList!=null && prdList.size()>0){
	        for(TbSysrUserDto temp: prdList){
	        	result.add(new ChainMap<String,String>()
	        			.chainPut("text",temp.getUser_name() )
	        			.chainPut("id", temp.getSysr_user_id())
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
	 /***
	 * 该方法用来获取页面上的select标签页面
	 * 最好将该方法移动到TbSysrUserOperaterContrller中
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/obtainTbSysrUserOperater.do")
	public void obtainTbSysrUserOperaterForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		TbSysrUserDto  prd = new TbSysrUserDto();
		//TODO 添加角色
		List<TbSysrUserDto> prdList =(ArrayList<TbSysrUserDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
        result.add(new ChainMap<String,String>()
    			.chainPut("text","请选择")
    			.chainPut("id", ""));
    	if(prdList!=null && prdList.size()>0){
	        for(TbSysrUserDto temp: prdList){
	        	result.add(new ChainMap<String,String>()
	        			.chainPut("text",temp.getUser_name() )
	        			.chainPut("id", temp.getSysr_user_id())
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
	 /***
	 * 该方法用来获取页面上的select标签页面
	 * 最好将该方法移动到TbSysrUserItManagerContrller中
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/obtainTbSysrUserItManager.do")
	public void obtainTbSysrUserItManagerForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		TbSysrUserDto  prd = new TbSysrUserDto();
		//TODO 添加角色
		List<TbSysrUserDto> prdList =(ArrayList<TbSysrUserDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
        result.add(new ChainMap<String,String>()
    			.chainPut("text","请选择")
    			.chainPut("id", ""));
    	if(prdList!=null && prdList.size()>0){
	        for(TbSysrUserDto temp: prdList){
	        	result.add(new ChainMap<String,String>()
	        			.chainPut("text",temp.getUser_name() )
	        			.chainPut("id", temp.getSysr_user_id())
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
	 /***
	 * 该方法用来获取页面上的select标签页面
	 * 最好将该方法移动到TbSysrUserBAContrller中
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/obtainTbSysrUserBA.do")
	public void obtainTbSysrUserBAForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		TbSysrUserDto  prd = new TbSysrUserDto();
		//TODO 添加角色
		List<TbSysrUserDto> prdList =(ArrayList<TbSysrUserDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
        result.add(new ChainMap<String,String>()
    			.chainPut("text","请选择")
    			.chainPut("id", ""));
    	if(prdList!=null && prdList.size()>0){
	        for(TbSysrUserDto temp: prdList){
	        	result.add(new ChainMap<String,String>()
	        			.chainPut("text",temp.getUser_name() )
	        			.chainPut("id", temp.getSysr_user_id())
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
	 /***
	 * 该方法用来获取页面上的select标签页面
	 * 最好将该方法移动到TbSysrUserDataManagerContrller中
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/obtainTbSysrUserDataManager.do")
	public void obtainTbSysrUserDataManagerForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		TbSysrUserDto  prd = new TbSysrUserDto();
		//TODO 添加角色
		List<TbSysrUserDto> prdList =(ArrayList<TbSysrUserDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
        result.add(new ChainMap<String,String>()
    			.chainPut("text","请选择")
    			.chainPut("id", ""));
    	if(prdList!=null && prdList.size()>0){
	        for(TbSysrUserDto temp: prdList){
	        	result.add(new ChainMap<String,String>()
	        			.chainPut("text",temp.getUser_name() )
	        			.chainPut("id", temp.getSysr_user_id())
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

	 /***
	 * 该方法用来获取页面上的select标签页面
	 * 最好将该方法移动到TbCustInfoContrller中
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/obtainTbCustInfo.do")
	public void obtainTbCustInfoForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		TbCustInfoDto  prd = new TbCustInfoDto();
		List<TbCustInfoDto> prdList =(ArrayList<TbCustInfoDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
        result.add(new ChainMap<String,String>()
   			.chainPut("text","请选择")
   			.chainPut("id", ""));
        if(prdList!=null && prdList.size()>0){
	         for(TbCustInfoDto temp: prdList){
	        	 result.add(new ChainMap<String,String>()
	        			.chainPut("text",temp.getCust_name() )
	        			.chainPut("id", temp.getId())
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
	 /***
	 * 该方法用来获取页面上的select标签页面
	 * 最好将该方法移动到TbProductInfoContrller中
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/obtainTbProductInfo.do")
	public void obtainTbProductInfoForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		TbProductInfoDto  prd = new TbProductInfoDto();
		List<TbProductInfoDto> prdList =(ArrayList<TbProductInfoDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
       ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
       result.add(new ChainMap<String,String>()
   			.chainPut("text","请选择")
   			.chainPut("id", ""));
   	if(prdList!=null && prdList.size()>0){
	        for(TbProductInfoDto temp: prdList){
	        	result.add(new ChainMap<String,String>()
	        			.chainPut("text",temp.getProduct_name() )
	        			.chainPut("id", temp.getId())
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
	 /***
		 * 该方法用来获取页面上的select标签页面
		 * 最好将该方法移动到TbSysrUserBDContrller中
		 * @return
		 * @throws IOException 
		 * @throws Exception
		 */
		@SuppressWarnings({ "unchecked" })
		@RequestMapping("/obtainTbSysrUserBD.do")
		public void obtainTbSysrUserBDForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
			TbSysrUserDto  prd = new TbSysrUserDto();
			//TODO prd设置角色
			List<TbSysrUserDto> prdList =(ArrayList<TbSysrUserDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
	        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
	        result.add(new ChainMap<String,String>()
       			.chainPut("text","请选择")
       			.chainPut("id", ""));
       	if(prdList!=null && prdList.size()>0){
		        for(TbSysrUserDto temp: prdList){
		        	result.add(new ChainMap<String,String>()
		        			.chainPut("text",temp.getUser_name() )
		        			.chainPut("id", temp.getSysr_user_id())
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
		 /***
		 * 该方法用来获取页面上的select标签页面
		 * 最好将该方法移动到TbSysrUserProductContrller中
		 * @return
		 * @throws IOException 
		 * @throws Exception
		 */
		@SuppressWarnings({ "unchecked" })
		@RequestMapping("/obtainTbSysrUserProduct.do")
		public void obtainTbSysrUserProductForSelectTab(HttpServletRequest request ,HttpServletResponse response) throws IOException {
			TbSysrUserDto  prd = new TbSysrUserDto();
			List<TbSysrUserDto> prdList =(ArrayList<TbSysrUserDto>)AllEntityMapperFactory.getAllEntityMapper().selectList(prd);
	        ArrayList<ChainMap<String,String>> result =  new ArrayList<ChainMap<String,String>>();
	        result.add(new ChainMap<String,String>()
       			.chainPut("text","请选择")
       			.chainPut("id", ""));
       	if(prdList!=null && prdList.size()>0){
		        for(TbSysrUserDto temp: prdList){
		        	result.add(new ChainMap<String,String>()
		        			.chainPut("text",temp.getUser_name() )
		        			.chainPut("id", temp.getSysr_user_id())
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
