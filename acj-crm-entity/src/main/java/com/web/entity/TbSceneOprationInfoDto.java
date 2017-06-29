package com.web.entity;
import java.util.HashMap;
import java.util.Map;

import com.absmybatis.dao.annotation.EntityPK;
import com.absmybatis.dao.annotation.EntityColumn;

	
/**
 * 类功能:自动代码生成 DTO 
 * <p>创建者:</p>
 * <p>创建时间:</p>
 * <p>修改者:</p>
 * <p>修改时间:</p>
 * <p>修改原因：</p>
 * <p>审核者:</p>
 * <p>审核时间:</p>
 * <p>审核意见：</p>
 *
 */
@EntityPK(Pk = "id", tableName = "tb_scene_opration_info")
public class TbSceneOprationInfoDto {//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = ""  )
	private java.lang.String id;//
	//场景
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "场景"  )
	private java.lang.String scene_id;//场景
	//开始日期
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "开始日期"  )
	private java.lang.String begain_date;//开始日期
	//结束日期
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "结束日期"  )
	private java.lang.String end_date;//结束日期
	//时间区间简称(如:1月,1季度等)
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "时间区间简称(如:1月,1季度等)"  )
	private java.lang.String time_intervar_simle_name;//时间区间简称(如:1月,1季度等)
	//预计资产规模
	@EntityColumn(dataType=8, typeName="DOUBLE", remarks = "预计资产规模"  )
	private java.lang.Double plan_asset_size;//预计资产规模
	//实际资产规模
	@EntityColumn(dataType=8, typeName="DOUBLE", remarks = "实际资产规模"  )
	private java.lang.Double reality_asset_size;//实际资产规模
	//预计保费
	@EntityColumn(dataType=8, typeName="DOUBLE", remarks = "预计保费"  )
	private java.lang.Double plan_premium;//预计保费
	//实际保费
	@EntityColumn(dataType=8, typeName="DOUBLE", remarks = "实际保费"  )
	private java.lang.Double reality_premium;//实际保费
	//用户数(对应预计业务规模发生额)
	@EntityColumn(dataType=4, typeName="INT", remarks = "用户数(对应预计业务规模发生额)"  )
	private java.lang.Long occur_cust_num;//用户数(对应预计业务规模发生额)
	//用户数(对应预计业务规模余额)
	@EntityColumn(dataType=4, typeName="INT", remarks = "用户数(对应预计业务规模余额)"  )
	private java.lang.Long balance_cust_num;//用户数(对应预计业务规模余额)
	//创建时间
	@EntityColumn(dataType=93, typeName="DATETIME", remarks = "创建时间"  )
	private java.sql.Timestamp gmt_created;//创建时间
	//修改时间
	@EntityColumn(dataType=93, typeName="DATETIME", remarks = "修改时间"  )
	private java.sql.Timestamp gmt_modified;//修改时间
	//创建人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "创建人"  )
	private java.lang.String creator;//创建人
	//修改人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "修改人"  )
	private java.lang.String modifier;//修改人
	//是否删除
	@EntityColumn(dataType=1, typeName="CHAR", remarks = "是否删除"  )
	private java.lang.String is_deleted;//是否删除


   /**
	* 获取 
	* @return
	*/
	public java.lang.String getId() {
		return id;
	}
	
   /**
	* 设置 
	* @param id
	*/
 	public void setId(java.lang.String id) {
		this.id = id;
	}
	 

   /**
	* 获取 场景
	* @return
	*/
	public java.lang.String getScene_id() {
		return scene_id;
	}
	
   /**
	* 设置 场景
	* @param scene_id
	*/
 	public void setScene_id(java.lang.String scene_id) {
		this.scene_id = scene_id;
	}
	 

   /**
	* 获取 开始日期
	* @return
	*/
	public java.lang.String getBegain_date() {
		return begain_date;
	}
	
   /**
	* 设置 开始日期
	* @param begain_date
	*/
 	public void setBegain_date(java.lang.String begain_date) {
		this.begain_date = begain_date;
	}
	 

   /**
	* 获取 结束日期
	* @return
	*/
	public java.lang.String getEnd_date() {
		return end_date;
	}
	
   /**
	* 设置 结束日期
	* @param end_date
	*/
 	public void setEnd_date(java.lang.String end_date) {
		this.end_date = end_date;
	}
	 

   /**
	* 获取 时间区间简称(如:1月,1季度等)
	* @return
	*/
	public java.lang.String getTime_intervar_simle_name() {
		return time_intervar_simle_name;
	}
	
   /**
	* 设置 时间区间简称(如:1月,1季度等)
	* @param time_intervar_simle_name
	*/
 	public void setTime_intervar_simle_name(java.lang.String time_intervar_simle_name) {
		this.time_intervar_simle_name = time_intervar_simle_name;
	}
	 

   /**
	* 获取 预计资产规模
	* @return
	*/
	public java.lang.Double getPlan_asset_size() {
		return plan_asset_size;
	}
	
   /**
	* 设置 预计资产规模
	* @param plan_asset_size
	*/
 	public void setPlan_asset_size(java.lang.Double plan_asset_size) {
		this.plan_asset_size = plan_asset_size;
	}
	 

   /**
	* 获取 实际资产规模
	* @return
	*/
	public java.lang.Double getReality_asset_size() {
		return reality_asset_size;
	}
	
   /**
	* 设置 实际资产规模
	* @param reality_asset_size
	*/
 	public void setReality_asset_size(java.lang.Double reality_asset_size) {
		this.reality_asset_size = reality_asset_size;
	}
	 

   /**
	* 获取 预计保费
	* @return
	*/
	public java.lang.Double getPlan_premium() {
		return plan_premium;
	}
	
   /**
	* 设置 预计保费
	* @param plan_premium
	*/
 	public void setPlan_premium(java.lang.Double plan_premium) {
		this.plan_premium = plan_premium;
	}
	 

   /**
	* 获取 实际保费
	* @return
	*/
	public java.lang.Double getReality_premium() {
		return reality_premium;
	}
	
   /**
	* 设置 实际保费
	* @param reality_premium
	*/
 	public void setReality_premium(java.lang.Double reality_premium) {
		this.reality_premium = reality_premium;
	}
	 

   /**
	* 获取 用户数(对应预计业务规模发生额)
	* @return
	*/
	public java.lang.Long getOccur_cust_num() {
		return occur_cust_num;
	}
	
   /**
	* 设置 用户数(对应预计业务规模发生额)
	* @param occur_cust_num
	*/
 	public void setOccur_cust_num(java.lang.Long occur_cust_num) {
		this.occur_cust_num = occur_cust_num;
	}
	 

   /**
	* 获取 用户数(对应预计业务规模余额)
	* @return
	*/
	public java.lang.Long getBalance_cust_num() {
		return balance_cust_num;
	}
	
   /**
	* 设置 用户数(对应预计业务规模余额)
	* @param balance_cust_num
	*/
 	public void setBalance_cust_num(java.lang.Long balance_cust_num) {
		this.balance_cust_num = balance_cust_num;
	}
	 

   /**
	* 获取 创建时间
	* @return
	*/
	public java.sql.Timestamp getGmt_created() {
		return gmt_created;
	}
	
   /**
	* 设置 创建时间
	* @param gmt_created
	*/
 	public void setGmt_created(java.sql.Timestamp gmt_created) {
		this.gmt_created = gmt_created;
	}
	 

   /**
	* 获取 修改时间
	* @return
	*/
	public java.sql.Timestamp getGmt_modified() {
		return gmt_modified;
	}
	
   /**
	* 设置 修改时间
	* @param gmt_modified
	*/
 	public void setGmt_modified(java.sql.Timestamp gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
	 

   /**
	* 获取 创建人
	* @return
	*/
	public java.lang.String getCreator() {
		return creator;
	}
	
   /**
	* 设置 创建人
	* @param creator
	*/
 	public void setCreator(java.lang.String creator) {
		this.creator = creator;
	}
	 

   /**
	* 获取 修改人
	* @return
	*/
	public java.lang.String getModifier() {
		return modifier;
	}
	
   /**
	* 设置 修改人
	* @param modifier
	*/
 	public void setModifier(java.lang.String modifier) {
		this.modifier = modifier;
	}
	 

   /**
	* 获取 是否删除
	* @return
	*/
	public java.lang.String getIs_deleted() {
		return is_deleted;
	}
	
   /**
	* 设置 是否删除
	* @param is_deleted
	*/
 	public void setIs_deleted(java.lang.String is_deleted) {
		this.is_deleted = is_deleted;
	}
	 


/**
 	 * 
 	 * 属性枚举类
 	 * 状态【0-正常,1-密码锁定,2-无效】
 	 * @author Administrator
 	 *
 	 */
 	public static  class PropertyEnum{
 		/*
 		 * 数据格式： 
 		 * <user_stat,<0,正常;1,密码锁定;2,无效>>
 		 */
 		private  static Map<String,Map<String,String>> propertyEnumMap = new HashMap<String,Map<String,String>>();
 		static{
 		}
		public static Map<String, Map<String, String>> getPropertyEnumMap() {
			return propertyEnumMap;
		}
 		
 	}
 	
}
