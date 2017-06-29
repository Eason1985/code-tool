package com.web.common.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


public class StringFormatByParamMean {

	
	/**
	 * 
	 * @param oriStr:需要格式化的字符串  如字符串： 姓名:{name}，年龄:{age}
	 * @param Map 
	 *      key:name value:张三
	 *      key:age  value:Inteber:12  
	 * @return 姓名_jason,年龄:12
	 */
	@SuppressWarnings("rawtypes")
	public static String format(String oriStr , Map objes){
		if(StringUtils.isEmpty(oriStr) || objes == null  )
			return oriStr ; 
		StringBuffer sb = new StringBuffer(oriStr);
		while(true){
			int i = sb.indexOf("{");
			int j = sb.indexOf("}");
			if( i >= 0 ){
				sb =new StringBuffer( sb.substring(0,i) )
						.append( (StringUtils.isBlank(sb.substring(i+1,j)) || objes.get(sb.substring(i+1,j)) ==null) ? "" 
								: objes.get(sb.substring(i+1,j)).toString()) 
						.append( sb.substring(j+1) );
			}
			else break ; 
		}
		return sb.toString() ; 
	
	}
	
	/**
	 * 
	 * @param oriStr 需要格式化的字符串  如字符串： 姓名:{name}，年龄:{age}
	 * @param objes 张三  ,12
	 * @return 姓名_jason,年龄:12
	 */
	public static String format(String oriStr , String... objes){
		if(StringUtils.isEmpty(oriStr) || objes == null || objes.length == 0 )
			return oriStr ; 
		int next = 0;
		int length = objes.length ; 
		StringBuffer sb = new StringBuffer(oriStr);
		while(true){
			int i = sb.indexOf("{");
			int j = sb.indexOf("}");
			if( i >= 0 && next < length  ){
				sb =new StringBuffer( sb.substring(0,i) )
						.append(objes[next]==null ? "" : objes[next].toString())
						.append(sb.substring(j+1) );
				next ++ ; 
			}
			else break ; 
		}
		return sb.toString() ; 
	}

	
	
	
	public static void main(String[] args) {
		String test = "{}ddddd:{};age:{},port:{}";
		Map<String,Object>  param = new HashMap<String,Object>();
		param.put("ip", "192.168.0.12") ; 
		param.put("port", 12) ; 
		
		System.out.println(StringFormatByParamMean.format(test, param));
		System.out.println(StringFormatByParamMean.format(test, "1211",null,"12ddd"));
		
	}
}
