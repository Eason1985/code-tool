/**  
* @Title: ConstantsValue.java
* @Package com.web.common.util
* @Description: TODO(用一句话描述该文件做什么)
* @author witt.wang
* @date 2016年5月11日 上午11:59:40
* @version V1.0  
*/
package com.web.common.util;

/**   
 *  定值类
 * 项目名称：acj-crm   
 * 类名称：ConstantsValue   
 * 类描述：   
 * 创建人：witt.wang
 * 创建时间：2016年5月11日 上午11:59:40   
 * 修改人：thinkpd   
 * 修改时间：2016年5月11日 上午11:59:40   
 * 修改备注：   
 * @version    
 *    
 */
public class ConstantValue {
	//维修厂员工角色-洗车
	public static String ROLE_WASH = "015";
	//维修厂员工角色-美容
	public static String ROLE_SPA = "016";
	//维修厂员工角色-保养
	public static String ROLE_ROUTINE = "017";
	//维修厂员工角色-机修
	public static String ROLE_REPAIR = "014";
	//维修厂员工角色-油漆
	public static String ROLE_PAINTINE = "011";
	//维修厂员工角色-超级管理员
	public static String ROLE_ADMIN = "000";
	
	//维修厂员工角色-老板
	public static String ROLE_LAOBAN = "003";
	
	//维修厂员工角色-接待
	public static String ROLE_JIEDAI = "004";
		
	//维修厂员工角色-仓管
	public static String ROLE_CANGGUAN = "005";

	//维修厂员工角色-其他
	public static String ROLE_QITA = "019";
		
	//工单类型   维修 
	public static String ORDER_TYPE_REPAIR = "0";
	//工单类型   救援 
	public static String ORDER_TYPE_RESUCE = "1";
	//工单类型   洗车-保养-美容 
	public static String ORDER_TYPE_WASH = "2";
	
	//工单类型详细   维修 
	public static String ORDER_TYPE_DETAIL_REPAIR = "001";
	//工单类型详细   救援 
	public static String ORDER_TYPE_DETAIL_RESUCE = "002";
	//工单类型详细   洗车 
	public static String ORDER_TYPE_DETAIL_WASH = "003";
	//工单类型详细   美容 
	public static String ORDER_TYPE_DETAIL_SPA = "004";
	//工单类型详细  保养 
	public static String ORDER_TYPE_DETAIL_ROUTINE = "005";
	//工单类型详细   代办 
	public static String ORDER_TYPE_DETAIL_AGENT = "006";
	
	public static String SYSTEM_ERROR_CODE = "99999999";
	public static String SYSTEM_EROR_MESSAGE = "系统异常 ! 请联系ACJ服务人员。";
	
	//潜在项目分析维度 时间
	public static String LATENT_ANALYSIS_ONE = "1";
	//潜在项目分析维度 项目种类
	public static String LATENT_ANALYSIS_TWO = "2";
	//潜在项目分析维度 意向程度
	public static String LATENT_ANALYSIS_THREE = "3";
}
