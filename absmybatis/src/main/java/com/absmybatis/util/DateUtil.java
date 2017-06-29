package com.absmybatis.util ;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.absmybatis.exception.BaseDtoException;


public class DateUtil {

	/**
	 * 
	 * @param "yyyyMMdd"
	 * @return
	 */
	public  static java.util.Date getDate(String date_yyyyMMdd){
		return getDate(date_yyyyMMdd, "yyyyMMdd") ; 
	}
	
	
	
	/**
	 * 根据字符串获取时间
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public  static java.util.Date getDate(String date,String dateFormat){
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		try {
			java.util.Date date1 = format.parse(date);
			return date1 ; 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	/**
	 * 获取间隔日期
	 * 获取前后日期 i为正数 向后推迟i天，负数时向前提前i天
	 * @param i
	 * @return
	 */
	public  static Date getIntervalDate(int i){ // //
		 Date dat = null;
		 Calendar cd = Calendar.getInstance();
		 cd.add(Calendar.DATE, i);
		 dat = cd.getTime();
		 SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Timestamp date = Timestamp.valueOf(dformat.format(dat));
		 return date;
	 }
	/**
	 * 获取当日开始时间
	 * @return yyyyMMdd 00:00:00
	 */
	public static String getBeginDate(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(date);
		String beginDate = today+" 00:00:00";
		return beginDate;
	}
	
	/**
	 * 获取当日结束时间
	 * @return yyyyMMdd 23:59:59
	 */
	public static String getEndDate(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(date);
		String endDate   = today+" 23:59:59";
		return endDate;
	}
	
	/**
	 * 将Date变换成string string格式为："yyyy-MM-dd HH:mm:ss"
	 * @param date
	 * @return
	 */
	public static String getFormatDate(Date date){
		return getFormatDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	/*
	 * 将date类型转化为formatValue格式的字符串
	 * @date ：要转化的时间
	 * @formatValue :时间转化的目标格式，不能为空
	 * */
	public static String getFormatDate(Date date,String formatValue){
		if(formatValue==null)
		{
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(formatValue);
		return format.format(date);
	}
	public static String getDefaultFormatDate(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(date);
	}
	
	//return java.util.Date 
	/**
	 *  java.util.Date是在除了SQL语句的情况下面使用的。
		java.sql.Date是针对SQL语句使用的，它只包含日期而没有时间部分
 		
 		java.util.Date 是 java.sql.Date 的父类，前者是常用的表示时间的类，我们通常格式化或者得到当前时间都是用他，
	 * @param sqlDate
	 * @return
	 */
	public static java.util.Date date2javaUtilDate(java.sql.Date sqlDate ){
		java.util.Date date = new java.util.Date(sqlDate.getTime());
		return date ; 
	}
	/**
	 * java.util.Date 2 java.sql.Timestamp 
	 * @param utilDate
	 * @return
	 */
	public static java.util.Date    date2javaUtilDate(java.sql.Timestamp timestamp){
		return new java.util.Date(timestamp.getTime());
	}
	//=======return java.sql.Date 
	/**
	 *  java.util.Date是在除了SQL语句的情况下面使用的。
		java.sql.Date是针对SQL语句使用的，它只包含日期而没有时间部分
 		
 		java.util.Date 是 java.sql.Date 的父类，前者是常用的表示时间的类，我们通常格式化或者得到当前时间都是用他，
	 * @param sqlDate
	 * @return
	 */
	public static java.sql.Date date2javaSqlDate(java.util.Date utilDate ){
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
		return sqlDate ;
	}
	/**
	 * java.sql.Timestamp  2  java.sql.Date 
	 * @param sqlDate
	 * @return
	 */
	public static java.sql.Date    date2javaSqlDate(java.sql.Timestamp timestamp){
		return  new java.sql.Date(timestamp.getTime()) ;
	}
	/**
	 * java.sql.Timestamp  2  java.sql.Date 
	 * @param sqlDate
	 * @return
	 * @throws BaseDtoException 
	 * @throws SQLException 
	 */
	public static java.sql.Date    oracleSqlTIMESTAMP2javaSqlDate(oracle.sql.TIMESTAMP timestamp) throws BaseDtoException  {
		Timestamp tt = null;
		try {
			tt = timestamp.timestampValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BaseDtoException("日期转换错误");
		}  
		Date javaUtilDate = new Date(tt.getTime());  
		return date2javaSqlDate(javaUtilDate) ;
	}
	
	
	//==========return java.sql.Timestamp
	/**
	 * java.util.Date 2 java.sql.Timestamp 
	 * @param utilDate
	 * @return
	 */
	public static java.sql.Timestamp date2javaSqlTimestamp(java.util.Date utilDate ){
		java.sql.Timestamp t = new Timestamp(utilDate.getTime());
		return t ; 
	}
	/**
	 * java.sql.Date 2 java.sql.Timestamp 
	 * @param sqlDate
	 * @return
	 */
	public static java.sql.Timestamp date2javaSqlTimestamp(java.sql.Date sqlDate ){
		return date2javaSqlTimestamp(date2javaUtilDate(sqlDate));
	}
//	/**
//	 *oracle.sql.TIMESTAMP  2 java.sql.Timestamp 
//	 * @param utilDate
//	 * @return
//	 * @throws BaseDtoException 
//	 */
//	public static java.sql.Timestamp date2javaSqlTimestamp(oracle.sql.TIMESTAMP  timestamp) throws BaseDtoException{
//		try {
//			return timestamp.timestampValue();
//		} catch (SQLException e) {
//			throw new BaseDtoException("日期转换错误");
//		} 
//	} 
//	
//	//===========return oracle.sql.TIMESTAMP
//	/**
//	 * java.util.Date 2 oracle.sql.TIMESTAMP 
//	 * @param utilDate
//	 * @return
//	 */
//	public static oracle.sql.TIMESTAMP date2oracleSqlTIMESTAMP(java.util.Date utilDate ){
//		 return date2oracleSqlTIMESTAMP(date2javaSqlDate(utilDate)) ; 
//	} 
//	/**
//	 * java.sql.Date 2 oracle.sql.TIMESTAMP  
//	 * @param sqlDate
//	 * @return
//	 */
//	public static oracle.sql.TIMESTAMP date2oracleSqlTIMESTAMP(java.sql.Date sqlDate ){
//		return new oracle.sql.TIMESTAMP(sqlDate);
//	}
	
	
	
	/**
	 * 时间字符串转换  
	 * @param date (8位或者14位)例如：20140101或者20140101123456
	 * @return 2014-01-01或者2014-01-01 12:34 没有秒
	 */
	public static String dateStringChange( String date )
	{
		if( date == null ){
			return "";
		}
		else if( date.trim().length() == 8 )
		{
			return new StringBuilder( date ).insert(4, '-').insert( 7 , '-' ).toString();
		}
		else if( date.trim().length() >= 14 )
		{
			String temp = date.substring(0, 12);
			return new StringBuilder( temp ).insert( 4 , '-').insert( 7 , '-' ).insert( 10 , ' ' ).insert( 13 , ':' ).toString();
		}
//		else if( date.trim().length() == 14 )
//		{
//			return new StringBuilder( date ).insert( 4 , '-').insert( 7 , '-' ).insert( 10 , ' ' ).insert( 13 , ':' ).insert( 16 , ':' ).toString();
//		}
		else
		{
			return date;
		}
	}
	
	

	/**
	 * 获取上一个工作日
	 * @param pay_dt
	 * @return
	 * @throws BaseDtoException
	 */
	public static String obtainLastDate(String pay_dt) throws BaseDtoException  {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			java.util.Date date= formatter.parse(pay_dt);    
			Calendar cal = Calendar.getInstance() ; 
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			date = cal.getTime() ; 
			return formatter.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new BaseDtoException("获取上一个自然日出错,当前日期为:"+pay_dt );
		}
	}
	
	
	
	public static void main(String[] args) throws ParseException {
		
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String mDateTime = formatter.format(cal.getTime());
        System.out.println(java.sql.Date.valueOf(mDateTime)); 
        System.out.println(date2javaUtilDate(java.sql.Date.valueOf(mDateTime))); 
        
        System.out.println(cal.getTime()); 
        System.out.println(date2javaSqlDate( cal.getTime())); 
        
        System.out.println(dateStringChange("19000102122334"));

	}
 
}
