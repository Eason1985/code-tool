package com.web.entity;
import java.util.HashMap;
import java.util.Map;

import com.absmybatis.dao.annotation.EntityPK;
import com.absmybatis.dao.annotation.EntityColumn;

import com.web.common.ChainMap;	
import java.util.EnumMap;		
	
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
@EntityPK(Pk = "id", tableName = "tb_product_info")
public class TbProductInfoDto {//
	//id
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "id"  )
	private java.lang.String id;//id
	//产品名称
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "产品名称"  )
	private java.lang.String product_name;//产品名称
	//合作方部门id
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "合作方部门id"  )
	private java.lang.String partner_id;//合作方部门id
	//场景说明
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "场景说明"  )
	private java.lang.String scene_explain;//场景说明
	//渠道ID
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "渠道ID"  )
	private java.lang.String channel_id;//渠道ID
	//立项时间
	@EntityColumn(dataType=93, typeName="DATETIME", remarks = "立项时间"  )
	private java.sql.Timestamp project_time;//立项时间
	//业务类型
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "业务类型"  )
	private java.lang.String bis_type;//业务类型
	//项目管理人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "项目管理人"  )
	private java.lang.String project_manager;//项目管理人
	//产品经理
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "产品经理"  )
	private java.lang.String product_manager;//产品经理
	//商务条件说明
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "商务条件说明"  )
	private java.lang.String business_condition_explain;//商务条件说明
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
	* 获取 id
	* @return
	*/
	public java.lang.String getId() {
		return id;
	}
	
   /**
	* 设置 id
	* @param id
	*/
 	public void setId(java.lang.String id) {
		this.id = id;
	}
	 

   /**
	* 获取 产品名称
	* @return
	*/
	public java.lang.String getProduct_name() {
		return product_name;
	}
	
   /**
	* 设置 产品名称
	* @param product_name
	*/
 	public void setProduct_name(java.lang.String product_name) {
		this.product_name = product_name;
	}
	 

   /**
	* 获取 合作方部门id
	* @return
	*/
	public java.lang.String getPartner_id() {
		return partner_id;
	}
	
   /**
	* 设置 合作方部门id
	* @param partner_id
	*/
 	public void setPartner_id(java.lang.String partner_id) {
		this.partner_id = partner_id;
	}
	 

   /**
	* 获取 场景说明
	* @return
	*/
	public java.lang.String getScene_explain() {
		return scene_explain;
	}
	
   /**
	* 设置 场景说明
	* @param scene_explain
	*/
 	public void setScene_explain(java.lang.String scene_explain) {
		this.scene_explain = scene_explain;
	}
	 

   /**
	* 获取 渠道ID
	* @return
	*/
	public java.lang.String getChannel_id() {
		return channel_id;
	}
	
   /**
	* 设置 渠道ID
	* @param channel_id
	*/
 	public void setChannel_id(java.lang.String channel_id) {
		this.channel_id = channel_id;
	}
	 

   /**
	* 获取 立项时间
	* @return
	*/
	public java.sql.Timestamp getProject_time() {
		return project_time;
	}
	
   /**
	* 设置 立项时间
	* @param project_time
	*/
 	public void setProject_time(java.sql.Timestamp project_time) {
		this.project_time = project_time;
	}
	 

   /**
	* 获取 业务类型
	* @return
	*/
	public java.lang.String getBis_type() {
		return bis_type;
	}
	
   /**
	* 设置 业务类型
	* @param bis_type
	*/
 	public void setBis_type(java.lang.String bis_type) {
		this.bis_type = bis_type;
	}
	 

   /**
	* 获取 项目管理人
	* @return
	*/
	public java.lang.String getProject_manager() {
		return project_manager;
	}
	
   /**
	* 设置 项目管理人
	* @param project_manager
	*/
 	public void setProject_manager(java.lang.String project_manager) {
		this.project_manager = project_manager;
	}
	 

   /**
	* 获取 产品经理
	* @return
	*/
	public java.lang.String getProduct_manager() {
		return product_manager;
	}
	
   /**
	* 设置 产品经理
	* @param product_manager
	*/
 	public void setProduct_manager(java.lang.String product_manager) {
		this.product_manager = product_manager;
	}
	 

   /**
	* 获取 商务条件说明
	* @return
	*/
	public java.lang.String getBusiness_condition_explain() {
		return business_condition_explain;
	}
	
   /**
	* 设置 商务条件说明
	* @param business_condition_explain
	*/
 	public void setBusiness_condition_explain(java.lang.String business_condition_explain) {
		this.business_condition_explain = business_condition_explain;
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
			propertyEnumMap.put("BIS_TYPE", new ChainMap<String,String>()
					.chainPut("0", "0-对公业务")
					.chainPut("1", "1-交通金融")
					.chainPut("2", "2-投资产品业务")
					.chainPut("3", "3-消费金融")
			) ; 
 		}
		public static Map<String, Map<String, String>> getPropertyEnumMap() {
			return propertyEnumMap;
		}
 		
 	}
 	
	public static  enum BIS_TYPEEnum{
	
		/**
 		 *  0-对公业务
 		 */
 			BIS_TYPE_0("0"),
		/**
 		 *  1-交通金融
 		 */
 			BIS_TYPE_1("1"),
		/**
 		 *  2-投资产品业务
 		 */
 			BIS_TYPE_2("2"),
		/**
 		 *  3-消费金融
 		 */
 			BIS_TYPE_3("3")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    BIS_TYPEEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<BIS_TYPEEnum, String> map ;
	    static{
	    	map = new EnumMap<BIS_TYPEEnum, String>(BIS_TYPEEnum.class);
		 	map.put(BIS_TYPEEnum.BIS_TYPE_0 , "0-对公业务");
		 	map.put(BIS_TYPEEnum.BIS_TYPE_1 , "1-交通金融");
		 	map.put(BIS_TYPEEnum.BIS_TYPE_2 , "2-投资产品业务");
		 	map.put(BIS_TYPEEnum.BIS_TYPE_3 , "3-消费金融");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static BIS_TYPEEnum getEnum(String value) {
	    	BIS_TYPEEnum tmpKey = null;
	        for (BIS_TYPEEnum tmpEnum : BIS_TYPEEnum.values()) {
	            if (tmpEnum.value.equals(value)) {
	                tmpKey = tmpEnum;
	                break;
	            }
	        }
	        return tmpKey;
	    }
	    /**
	     * 返回NotifyErrorCode对应的描述.
	     * @param value int.
	     * @return String
	     */
	    public static String getEnumDesc(final String value) {
	        return BIS_TYPEEnum.map.get(
	        		BIS_TYPEEnum.getEnum(value));
	    }
	    
 	}	
}
