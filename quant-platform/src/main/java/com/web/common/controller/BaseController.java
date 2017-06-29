
package com.web.common.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.absmybatis.util.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;


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
	 
	/**
	 * 输出JSOND数据   
	 * 
	 **/
	 @SuppressWarnings("rawtypes")
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
	 
	  
	 public Timestamp obtainCreateTime( ){
		 Timestamp nowdate = new Timestamp(System.currentTimeMillis());
		 return nowdate ; 
	 }
	 
	 public String obtainCreateTimeStr(){
		 return DateUtil.getFormatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
	 }
	  
}
