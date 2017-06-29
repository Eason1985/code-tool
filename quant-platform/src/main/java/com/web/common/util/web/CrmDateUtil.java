package com.web.common.util.web;

import java.util.Date;

import com.absmybatis.util.DateUtil;

public class CrmDateUtil {
	
	
	/**
	 * 如果 
	 *  createtime = null  default = new Date() 
	 *  createtime = null  default = new Date() 
	 * @param createtime
	 * @param complate_time
	 * @return
	 */
	public static  Object obtainWorkOrderTime(String createtime, String complate_time) {
		if(complate_time == null ){
			complate_time = DateUtil.getFormatDate(new Date()) ; 
		}
		if(createtime == null ){
			createtime = DateUtil.getFormatDate(new Date()) ; 
		}
		Date createtimeDate1 =  DateUtil.getDate(createtime, "yyyy-MM-dd HH:mm:ss") ;
		Date complate_timeDate2 =  DateUtil.getDate(complate_time, "yyyy-MM-dd HH:mm:ss") ;
		int time = (int)(complate_timeDate2.getTime()-createtimeDate1.getTime())/(1000*60*60);//小时
		if(time < 24 ){
			return time+"小时";
		}else{
			int day = (int)time/24 ; 
			time = time-24*day ; 
			return time==0?day+"天":day+"天"+time+"小时";
		}
	}
}
