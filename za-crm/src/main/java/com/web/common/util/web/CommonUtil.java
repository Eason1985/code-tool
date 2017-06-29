package com.web.common.util.web;

public class CommonUtil {
	
	public static boolean isNullOrEmpty(String str){
		return (null == str || "".equals(str));
	}
	
	public static String formatNullStr(String str){
		if(null == str){
			return "";
		}else{
			return str;
		}
	}
	
	/**
	 * 把null值转成0
	 * @Description: 
	 * @param 
	 * @return Double  
	 * @throws
	 * @author witt.wang
	 * @date 2016年4月11日
	 */
	public static Double toDouble(Object obj){
		Double priceValue = (Double) (obj==null?0:obj);
		return priceValue;
	}

	/**
	 * @Description: 把object转换成sring
	 * @param @param object
	 * @param @return   
	 * @return Object  
	 * @throws
	 * @author witt.wang
	 * @date 2016年7月25日
	 */
	public static String formatNullStr(Object str){
		if(null == str){
			return "";
		}else{
			return String.valueOf(str);
		}
	}
	
	/**
	 * 
	 * @Description: 格式化数字 去掉科学计数法
	 * @param @param num
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author witt.wang
	 * @date 2016年8月8日
	 */
	public static String formatDouble(Double num){
		
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance();   
		nf.setGroupingUsed(false);  
		return nf.format(num);   
	}
}


