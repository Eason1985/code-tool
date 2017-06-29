package com.absmybatis.common;



/**
 * 区间查询器
 * 
 * 
 * @author shuzhiyun
 *
 */
public class IntervalQueryWare {
	
	/**
	 * 区间查询类型 : 区间查询  >
	 */
	public static final String INTERVAL_TYPE_GT = ">" ; 
	/**
	 * 区间查询类型 : 区间查询  >=
	 */
	public  static final String INTERVAL_TYPE_GE = ">=" ; 
	/**
	 * 区间查询类型 : 区间查询  <
	 */
	public  static final String INTERVAL_TYPE_LT = "<"  ; 
	/**
	 * 区间查询类型 : 区间查询  <=
	 */
	public  static final String INTERVAL_TYPE_LE = "<=" ; 
	/**
	 * 区间查询类型 : 区间查询  !=
	 */
	public  static final String INTERVAL_TYPE_NE = "!=" ; 
	/**
	 * 区间查询类型 : 区间查询  !=
	 */
	public  static final String INTERVAL_TYPE_LIKE = " like " ; 
	
	/**
	 *  property interval_type #{entity.specilQueryValues.p1 jdbcType=*****}
	 */
	private String property ; 
	
	/**
	 * 关系可以前端直接输入.其填写范围为: 
	 *  >
	 *  >=
	 *  <
	 *  <=
	 *  !=
	 *  like
	 */
	private String interval_type ; 
	
	/**
	 * 参数值
	 */
	private Object value ;


 


	public String getProperty() {
		return property;
	}



	public void setProperty(String property) {
		this.property = property;
	}



	public String getInterval_type() {
		return interval_type;
	}



	public void setInterval_type(String interval_type) {
		this.interval_type = interval_type;
	}



	public Object getValue() {
		return value;
	}



	public void setValue(Object value) {
		this.value = value;
	}
	
}
