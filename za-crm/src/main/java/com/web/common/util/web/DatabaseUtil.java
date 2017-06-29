package com.web.common.util.web;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.web.mapper.AllEntityMapperFactory;



/** 
 * 
*    
* 项目名称：acj-crm   
* 类名称：DatabaseUtil   
* 类描述：   
* 创建人：witt.wang
* 创建时间：2016年7月25日 下午2:06:30   
* 修改人：Administrator   
* 修改时间：2016年7月25日 下午2:06:30   
* 修改备注：   
* @version    
*
 */
@Service
public class DatabaseUtil {
	
	private static Integer pyl = 0 ; 
	private static final DecimalFormat dataf=new DecimalFormat("000");
	private static final DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
	
	private static final Logger LOGGER = Logger
			.getLogger(DatabaseUtil.class);
	
	/**
	 * 
	 * @param randomNum 随机数位数
	 * @param i  偏移量: 附在随机数后面的一个数字。
	 * @return
	 */
	public static String getPkId(int randomNum , int i ){
		String time=format.format(new Date()); 
		String btno = "";
		synchronized (DatabaseUtil.class) {
			btno =  dataf.format(pyl);
			pyl++ ; 
			if(pyl>100){
				pyl = 0 ;
			}
		}
		return time+rand(randomNum)+btno+i;
	}
	
	/**
	 * 返回特定格式数据
	 * @param 格式化要求格式
	 * @param i  
	 * @return
	 */
	public static String getPkId(String format,int i){
		DecimalFormat dataf=new DecimalFormat(format);
        String btno = dataf.format(i);
		return btno;
	}
	
	/**
	 * 
	 * @Description: 获取随机数
	 * @param @param n
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author witt.wang
	 * @date 2016年6月12日
	 */
	public static int rand(int n){
        int ans = 0;
        while(Math.log10(ans)+1<n)
            ans = (int)(Math.random()*Math.pow(10, n));
        return ans;
    }
	
	/**
	 * 
	 * @Description: 判断对象是否存在
	 * @param @param    
	 * @return   
	 * @throws
	 * @author witt.wang
	 * @date 2016年6月12日
	 */
	public static boolean isExsit(Object obj){
		List resultObj = AllEntityMapperFactory.getAllEntityMapper().selectList(obj);
		return resultObj.size() == 0;
	}
	 
	  
	 
	/**
	 * 
	 * @Description: TODO
	 * @param @param args   
	 * @return void  
	 * @throws
	 * @author witt.wang
	 * @date 2016年7月25日
	 */
	
	public static void main(String[] args) {
		System.err.println(getPkId(3,1));
	}
	 
	/**
	 * @Description: 
	 * @param @param randomNum
	 * @param @param format2
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author witt.wang
	 * @date 2016年9月12日
	 */
	public static String getPkId(int randomNum, String i) {
		String time=format.format(new Date()); 
		String btno = "";
		synchronized (DatabaseUtil.class) {
			btno =  dataf.format(pyl);
			pyl++ ; 
			if(pyl>100){
				pyl = 0 ;
			}
		}
		return time+rand(randomNum)+btno+i;
	}
}
