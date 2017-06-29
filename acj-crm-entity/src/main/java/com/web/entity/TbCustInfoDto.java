package com.web.entity;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.absmybatis.dao.annotation.EntityColumn;
import com.absmybatis.dao.annotation.EntityPK;
import com.web.common.ChainMap;
import com.web.common.ForeignKeyProperty;
	
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
@EntityPK(Pk = "id", tableName = "tb_cust_info")
public class TbCustInfoDto {//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = ""  )
	private java.lang.String id;//
	//客户名称
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "客户名称"  )
	private java.lang.String cust_name;//客户名称
	//BD对接人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "BD对接人"  )
	private java.lang.String bd_on_access;//BD对接人
	//地点
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "地点"  )
	private java.lang.String address;//地点
	//产品对接人
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "产品对接人"  )
	private java.lang.String product_on_access;//产品对接人
	//状态
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "状态"  )
	private java.lang.String status;//状态
	//商务条件
	@EntityColumn(dataType=-1, typeName="TEXT", remarks = "商务条件"  )
	private java.lang.String business_condition;//商务条件
	//备注
	@EntityColumn(dataType=12, typeName="VARCHAR", remarks = "备注"  )
	private java.lang.String memo;//备注
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
	* 获取 客户名称
	* @return
	*/
	public java.lang.String getCust_name() {
		return cust_name;
	}
	
   /**
	* 设置 客户名称
	* @param cust_name
	*/
 	public void setCust_name(java.lang.String cust_name) {
		this.cust_name = cust_name;
	}
	 

   /**
	* 获取 BD对接人
	* @return
	*/
	public java.lang.String getBd_on_access() {
		return bd_on_access;
	}
	
   /**
	* 设置 BD对接人
	* @param bd_on_access
	*/
 	public void setBd_on_access(java.lang.String bd_on_access) {
		this.bd_on_access = bd_on_access;
	}
	 

   /**
	* 获取 地点
	* @return
	*/
	public java.lang.String getAddress() {
		return address;
	}
	
   /**
	* 设置 地点
	* @param address
	*/
 	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	 

   /**
	* 获取 产品对接人
	* @return
	*/
	public java.lang.String getProduct_on_access() {
		return product_on_access;
	}
	
   /**
	* 设置 产品对接人
	* @param product_on_access
	*/
 	public void setProduct_on_access(java.lang.String product_on_access) {
		this.product_on_access = product_on_access;
	}
	 

   /**
	* 获取 状态
	* @return
	*/
	public java.lang.String getStatus() {
		return status;
	}
	
   /**
	* 设置 状态
	* @param status
	*/
 	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	 

   /**
	* 获取 商务条件
	* @return
	*/
	public java.lang.String getBusiness_condition() {
		return business_condition;
	}
	
   /**
	* 设置 商务条件
	* @param business_condition
	*/
 	public void setBusiness_condition(java.lang.String business_condition) {
		this.business_condition = business_condition;
	}
	 

   /**
	* 获取 备注
	* @return
	*/
	public java.lang.String getMemo() {
		return memo;
	}
	
   /**
	* 设置 备注
	* @param memo
	*/
 	public void setMemo(java.lang.String memo) {
		this.memo = memo;
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
 	 * 外键的key-value
 	 * @author shuzhiyun
 	 *
 	 */
 	public static class ForeignKeyPropertyEnum{
 		//所有外键的解决
 		private  static final List<ForeignKeyProperty> foreignKeyPropertyEnumList = new ArrayList<ForeignKeyProperty>();
 		static{
 			 foreignKeyPropertyEnumList.add(new ForeignKeyProperty("bd_on_access",TbSysrUserDto.class,"sysr_user_id","user_name") );
			 foreignKeyPropertyEnumList.add(new ForeignKeyProperty("product_on_access",TbSysrUserDto.class,"sysr_user_id","user_name") );
			 foreignKeyPropertyEnumList.add(new ForeignKeyProperty("creator",TbSysrUserDto.class,"sysr_user_id","user_name") );
			 foreignKeyPropertyEnumList.add(new ForeignKeyProperty("modifier",TbSysrUserDto.class,"sysr_user_id","user_name") );
 		}
 		
 		public static List<ForeignKeyProperty>  getForeignKeyPropertyEnumList() {
			return foreignKeyPropertyEnumList;
		}
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
			propertyEnumMap.put("STATUS", new ChainMap<String,String>()
					.chainPut("0", "0-接触")
					.chainPut("1", "1-搁置")
					.chainPut("2", "2-合作")
					.chainPut("3", "3-中断合作")
			) ; 
 		}
		public static Map<String, Map<String, String>> getPropertyEnumMap() {
			return propertyEnumMap;
		}
 		
 	}
 	
	public static  enum STATUSEnum{
	
		/**
 		 *  0-接触
 		 */
 			STATUS_0("0"),
		/**
 		 *  1-搁置
 		 */
 			STATUS_1("1"),
		/**
 		 *  2-合作
 		 */
 			STATUS_2("2"),
		/**
 		 *  3-中断合作
 		 */
 			STATUS_3("3")
 			;
 		 
 		private String value;

	    public String getValue() {
	        return value;
	    }
	    
	    STATUSEnum(String value) {
	        this.value = value;
	    }
	    
	    public final static Map<STATUSEnum, String> map ;
	    static{
	    	map = new EnumMap<STATUSEnum, String>(STATUSEnum.class);
		 	map.put(STATUSEnum.STATUS_0 , "0-接触");
		 	map.put(STATUSEnum.STATUS_1 , "1-搁置");
		 	map.put(STATUSEnum.STATUS_2 , "2-合作");
		 	map.put(STATUSEnum.STATUS_3 , "3-中断合作");
	    }
	    /**
	     * 跟据value返回枚举对应的key
	     * 
	     * @param value
	     * @return NotifyErrorCode
	     */
	    public static STATUSEnum getEnum(String value) {
	    	STATUSEnum tmpKey = null;
	        for (STATUSEnum tmpEnum : STATUSEnum.values()) {
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
	        return STATUSEnum.map.get(
	        		STATUSEnum.getEnum(value));
	    }
	    
 	}	
}
