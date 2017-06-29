package com.web.facade.basequery;

import com.absmybatis.common.SelectParamHandle;
import com.web.facade.AbsRequest;
public class BaseObjectOPRequest  extends AbsRequest   {

	public static final int QUERYTYPE_SELECTOBJECT_1  = 1 ; //查询单个表
	public static final int QUERYTYPE_SELECTLIST_2  = 2 ; //查询单个表数据列表
	public static final int QUERYTYPE_SELECTLISTBYPAGE_3  = 3 ;  //查询单个表的分页数据
	public static final int QUERYTYPE_SELECTCOUNT_4  = 4 ; //总数
	public static final int QUERYTYPE_SELECTCOUNT_HAVE_HANDLE_5  = 5 ; //总数
	
	public static final int SUBMITTYPE_INSERT_1  = 1 ; //插入表
	public static final int SUBMITTYPE_UPDATEBYID_2  = 2 ; //通过主键修改表
	public static final int SUBMITTYPE_DELETEBYID_3  = 3 ;  //删除
	

	public static final int CURRENCY_SELECTOBJECT_1  =1 ; //通用查询
	public static final int CURRENCY_SELECTLIST_2  = 2 ; //通用查询列表
	

	private String currencyquery_type ; 
	

	private Integer queryType  ; 
	/**
	 * 
	 */
	private Object object ;

	/**
	 * 当 queryType 的值等于 QUERYTYPE_SELECTLISTBYPAGE_3 时，必填
	 */
	private SelectParamHandle handle ; 
	
	
	//	BASEQUERY
	private String serviceCode ;
	
	
	public BaseObjectOPRequest(Integer queryType,Object object ) {
		super();
		this.queryType = queryType;
		this.object = object;
	}

	
	public BaseObjectOPRequest(Integer queryType, Object object,
			SelectParamHandle handle) {
		super();
		this.queryType = queryType;
		this.object = object;
		this.handle = handle;
	}
	
	public Integer getQueryType() {
		return queryType;
	}

	public SelectParamHandle getHandle() {
		return handle;
	}

	public void setHandle(SelectParamHandle handle) {
		this.handle = handle;
	}

	public void setQueryType(Integer queryType) {
		this.queryType = queryType;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	} 
	
	
	public String getCurrencyquery_type() {
		return currencyquery_type;
	}


	public void setCurrencyquery_type(String currencyquery_type) {
		this.currencyquery_type = currencyquery_type;
	}


	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	@Override
	protected String getServiceCode() {
		return serviceCode;
	}

	
}
