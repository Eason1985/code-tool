
package com.web.common.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.absmybatis.util.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.web.common.exception.BusinessException;
import com.web.common.util.web.StringUtil;
import com.web.entity.TbSysrUserDto;
import com.web.facade.basequery.BaseQueryServiceUtil;
import com.web.mapper.AllEntityMapperFactory;
import com.web.mapper.metadbIdgenerator.MetadbIdgeneratorMapperApp;


/**
 * @author wzg
 * @version  2015年9月24日
 * @desc  控制器基础类
 */
public  class BaseController  extends MultiActionController{
	
	public static String SESSION_SET_KEY_USER = "$_USER";
	
	public static String SESSION_SET_KEY_OLINEUSERLIST = "$_OLINEUSERLIST";
	
	public static String SESSION_SET_KEY_OLINEUSERID = "$_OLINEUSERID";
	public static final String CONST_CAS_ASSERTION = "_const_cas_assertion_";
	@Autowired
	protected   MetadbIdgeneratorMapperApp metadbIdgeneratorMapperApp;
	/**
	 * @param obj
	 * @return
	 * 
	 */
	protected String Bean2Json(Object obj)
	{
		    SerializeConfig ser = new SerializeConfig();
		    ser.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd"));
		    String Json = JSON.toJSONString(obj, ser, new SerializerFeature[] { SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty });  
		    return Json;
	}
	
	/**
	 * 输出JSOND数据   
	 * **/
	 public void outJSOND(HttpServletResponse response, String content)  {
		response.setContentType( "text/plain;charset=UTF-8" );
		try {
			PrintWriter _writer  = response.getWriter();
			_writer.print(content);
			_writer.flush();
			_writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	 }
	 
//	 /**
//	 * 输出JSOND数据   
//	 * **/
//	 public void outJSOND(HttpServletResponse response, Object content) throws IOException {
//		JsonConfig config = new JsonConfig();
//		JsonDateFormatUtil.formatDateForJsonConfig_type(config);
//		JSONArray json_rows = JSONArray.fromObject(content, config);
//		outJSOND(response,json_rows.toString());
//	 }
	 /**
	 * 输出JSOND数据   
	 * 
	 **/
	 public void outJSOND(HttpServletResponse response, HashMap resultHashMap) throws IOException {
		JsonConfig config = new JsonConfig();
		JSONObject json_rows = JSONObject.fromObject(resultHashMap, config);
		outJSOND(response,json_rows.toString());
	 } 
		 
	 /**
	 * 输出JSOND数据   
	 * **/
	 public void outJSONParam(HttpServletResponse response, boolean result,String message) throws IOException {
		response.setContentType( "text/plain;charset=UTF-8" );
		PrintWriter _writer = response.getWriter();
		_writer.print("{\"status\":"+result+",\"message\":\""+message+"\"}");
		_writer.flush();
		_writer.close();
	 }
	 
	 public String obtainLoginUserId(HttpServletRequest request){
		 if(org.springframework.util.StringUtils.isEmpty(obtainUserInfo(request).getSysr_user_id())){
	 		 throw new BusinessException("00000002","用户为空");
	 	 }
		 return obtainUserInfo(request).getSysr_user_id() ; 
	 }
	 
	 public String obtainLoginUserNetno(HttpServletRequest request){
	 	 if(org.springframework.util.StringUtils.isEmpty(obtainUserInfo(request).getNetno())){
	 		 throw new BusinessException("00000003","网点号不能为空");
	 	 }
		 return  obtainUserInfo(request).getNetno(); 
	 }
	 public Timestamp obtainCreateTime( ){
		 Timestamp nowdate = new Timestamp(System.currentTimeMillis());
		 return nowdate ; 
	 }
	 
	 public String obtainCreateTimeStr(){
		 return DateUtil.getFormatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
	 }
	 public TbSysrUserDto obtainUserInfo(HttpServletRequest request){
		 String isApp = request.getParameter("from") ; 
		 if("app".equals(isApp)){
			 TbSysrUserDto  tbSysrUserDto =   (TbSysrUserDto)request.getSession().getAttribute(BaseController.SESSION_SET_KEY_USER) ;  
			 if(tbSysrUserDto == null ){
				 String user_cd =  request.getParameter("user_cd") ; 
				 if(user_cd == null || user_cd.length() ==0 ){
					 throw new BusinessException("99999998","请输入用户名"); 
				 }
				 String token =  request.getParameter("token") ; 
				 tbSysrUserDto = new TbSysrUserDto(); 
				 tbSysrUserDto.setUser_code(user_cd);
				 tbSysrUserDto =  (TbSysrUserDto)new BaseQueryServiceUtil<TbSysrUserDto>()
						 .selectObject(tbSysrUserDto) ; 
				 if(tbSysrUserDto ==null || tbSysrUserDto.getToken_value()==null 
						 || !tbSysrUserDto.getToken_value().equals(token)){
					 throw new BusinessException("00000001","请先登录"); 
				 }
				 request.getSession().setAttribute(BaseController.SESSION_SET_KEY_USER,tbSysrUserDto) ;  
			 }
			 return tbSysrUserDto ; 
		 }else{
			 TbSysrUserDto  tbSysrUserDto =  (TbSysrUserDto)request.getSession().getAttribute(BaseController.SESSION_SET_KEY_USER) ;  
			 if(tbSysrUserDto ==null){
				 throw new BusinessException("00000001","请先登录"); 
			 }
			 return(TbSysrUserDto)request.getSession().getAttribute(BaseController.SESSION_SET_KEY_USER) ; 
		 }
		 
	 }
	 
	 
	  
	 
	 
	 /**
	  * 
	  * @Description: 根据用户号查询用户名称
	  * @param @param custId
	  * @param @return   
	  * @return String  
	  * @throws
	  * @author witt.wang
	  * @date 2016年6月29日
	  */
	 protected String getUserName(String userId){
		 String userName = "";
		 if(StringUtil.isEmpty(userId)){
			 return userName;
		 }else{
			 TbSysrUserDto userDto = new TbSysrUserDto();
			 userDto.setSysr_user_id(userId); 
			 userDto=(TbSysrUserDto)AllEntityMapperFactory.getAllEntityMapper()
					.selectObject(userDto);	
			 if(userDto==null){
					return userName;
			 }else{
				 return userDto.getUser_name();
			 }
		 }		 
	 }
}
