package com.web.common.util.web;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringUtil {
	
	/**
	 * 转换为String字符串
	 * @param value
	 * @return
	 */
	public static String parseObjectToString(Object value)
	{
		if(value != null) return value.toString();
		return "";
	}
	
	public static boolean isEmpty(Object obj)
	{
		if(obj == null || obj.toString().trim().length() <= 0 ) return true;
		return false;
	}
	/**
	 * 把一个参数变成固定程度，长度不足用0补充. 如果原长度超过要求长度，将原长度直接返回.
	 * 
	 * @param value
	 *            原参数值
	 * @param len
	 *            参数需要的长度.
	 * @return String
	 */
	public static String fillZero(final String value, int len) {
		if (StringUtil.isEmpty(value) || len <= 0) {
			throw new IllegalArgumentException("参数不正确");
		}
		StringBuffer zero = new StringBuffer();
		StringBuffer sb = new StringBuffer(len);
		int paramLen = value.trim().length();
		if (paramLen < len) {
			for (int i = 0; i < len - paramLen; i++) {
				zero.append("0");
			}
		}
		return sb.append(zero).append(value).toString();
	}
	
	
	/**
	 * 保留两位精度
	 * @param money
	 * @return
	 */
	public static String bigDeclimalToString(BigDecimal money){
		DecimalFormat df1 = new DecimalFormat("#0.00");//两位精度
		if(money == null){
			BigDecimal zero = new BigDecimal( "0.00" ) ;
			return df1.format(zero);
		}
		return df1.format(money);
	}
	
	
	/**
	 * 获取subject字符串
	 * @param taCode 
	 * @param existsSize 数据库中该TA已存在多少科目
	 * @return taCode + 后缀
	 * @throws Exception 长度过长，没有符合的命名后缀
	 */
	public static String buildSubjectStr (String taCode , int existsSize) throws Exception {
		char[] charSet = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'} ;
		if( charSet.length <= existsSize ){
			throw new Exception( "长度太长，没有符合的命名后缀" ) ;
		}
		StringBuffer subjectStr = new StringBuffer( taCode ) ;
		subjectStr.append( charSet[existsSize] ) ;
		return subjectStr.toString() ;
	}
	
	
	/**
	 * @param money ：123456.78
	 * @return +-123,,456.78
	 */
	public static String switchMoneyFormat( BigDecimal money ){
		if( money == null ){
			money = new BigDecimal("0.00");
		}
		money = new BigDecimal( bigDeclimalToString(money) );
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		String temStr = nf.format( money ) ;
		return  temStr.indexOf('.') < 0 ? temStr+".00"  : temStr ;
		
	}
	
	
	public static String mathTime(String start,String end) throws Exception{
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   java.util.Date now = df.parse(end);
		   java.util.Date date=df.parse(start);
		   long l=now.getTime()-date.getTime();
		   long day=l/(24*60*60*1000);
		   long hour=(l/(60*60*1000)-day*24);
		   long min=((l/(60*1000))-day*24*60-hour*60);
		   long s=(l/1000-day*24*60*60-hour*60*60-min*60);
		   System.out.println(""+day+"天"+hour+"小时"+min+"分"+s+"秒");
		return ""+day+"天"+hour+"小时"+min+"分"+s+"秒";
		
	}
	
}
