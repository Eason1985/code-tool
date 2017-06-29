package com.web.entity;

import com.absmybatis.dao.annotation.EntityColumn;
import com.absmybatis.dao.annotation.EntityPK;
/**
 * 类功能:自动代码生成模板 DTO模板
 * <p>创建者:</p>
 * <p>创建时间:</p>
 * <p>修改者:</p>
 * <p>修改时间:</p>
 * <p>修改原因：</p>
 * <p>审核者:</p>
 * <p>审核时间:</p>
 * <p>审核意见：</p>
 * 
 * 规约开启方式 用于规约符合我们要求的对象
 * 1. 设置   AddParentClass = true
 * 2. 类       extends BaseDtoImpl
 * 
 * 规约关闭方式  用于规约不受我们控制的对象
 * 1. 设置   AddParentClass = false
 * 2. 类        implements IBaseDto
 */
@SuppressWarnings("serial")
@EntityPK(Pk = "objid", tableName = "RUNPARAMS")
public class RunparamsDto {//
	//
	@EntityColumn(dataType=1, typeName="CHAR", remarks = ""  )
	private java.lang.String canmodify;//
	//
	@EntityColumn(dataType=1, typeName="CHAR", remarks = ""  )
	private java.lang.String canshow;//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR2", remarks = ""  )
	private java.lang.String childclass;//
	//
	@EntityColumn(dataType=93, typeName="DATE", remarks = ""  )
	private java.sql.Timestamp createtimestamp;//
	//
	@EntityColumn(dataType=1, typeName="CHAR", remarks = ""  )
	private java.lang.String cryptflag;//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR2", remarks = ""  )
	private java.lang.String describe;//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR2", remarks = ""  )
	private java.lang.String entityname;//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR2", remarks = ""  )
	private java.lang.String item;//
	//
	@EntityColumn(dataType=3, typeName="NUMBER", remarks = ""  )
	private java.lang.String lastobjid;//
	//
	@EntityColumn(dataType=3, typeName="NUMBER", remarks = ""  )
	private java.lang.String objid;//
	//
	@EntityColumn(dataType=3, typeName="NUMBER", remarks = ""  )
	private java.lang.Long orderid;//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR2", remarks = ""  )
	private java.lang.String parentclass;//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR2", remarks = ""  )
	private java.lang.String sysname;//
	//
	@EntityColumn(dataType=93, typeName="DATE", remarks = ""  )
	private java.sql.Timestamp updatetimestamp;//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR2", remarks = ""  )
	private java.lang.String value;//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR2", remarks = ""  )
	private java.lang.String valuebound;//
	//
	@EntityColumn(dataType=12, typeName="VARCHAR2", remarks = ""  )
	private java.lang.String valuetype;//
	//
	@EntityColumn(dataType=3, typeName="NUMBER", remarks = ""  )
	private java.lang.Long version;//


   /**
	* 获取 
	* @return
	*/
	public java.lang.String getCanmodify() {
		return canmodify;
	}
	
   /**
	* 设置 
	* @param canmodify
	*/
 	public void setCanmodify(java.lang.String canmodify) {
		this.canmodify = canmodify;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getCanshow() {
		return canshow;
	}
	
   /**
	* 设置 
	* @param canshow
	*/
 	public void setCanshow(java.lang.String canshow) {
		this.canshow = canshow;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getChildclass() {
		return childclass;
	}
	
   /**
	* 设置 
	* @param childclass
	*/
 	public void setChildclass(java.lang.String childclass) {
		this.childclass = childclass;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.sql.Timestamp getCreatetimestamp() {
		return createtimestamp;
	}
	
   /**
	* 设置 
	* @param createtimestamp
	*/
 	public void setCreatetimestamp(java.sql.Timestamp createtimestamp) {
		this.createtimestamp = createtimestamp;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getCryptflag() {
		return cryptflag;
	}
	
   /**
	* 设置 
	* @param cryptflag
	*/
 	public void setCryptflag(java.lang.String cryptflag) {
		this.cryptflag = cryptflag;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getDescribe() {
		return describe;
	}
	
   /**
	* 设置 
	* @param describe
	*/
 	public void setDescribe(java.lang.String describe) {
		this.describe = describe;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getEntityname() {
		return entityname;
	}
	
   /**
	* 设置 
	* @param entityname
	*/
 	public void setEntityname(java.lang.String entityname) {
		this.entityname = entityname;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getItem() {
		return item;
	}
	
   /**
	* 设置 
	* @param item
	*/
 	public void setItem(java.lang.String item) {
		this.item = item;
	}
	 

   public java.lang.String getLastobjid() {
	return lastobjid;
}

public void setLastobjid(java.lang.String lastobjid) {
	this.lastobjid = lastobjid;
}

public java.lang.String getObjid() {
	return objid;
}

public void setObjid(java.lang.String objid) {
	this.objid = objid;
}

/**
	* 获取 
	* @return
	*/
	public java.lang.Long getOrderid() {
		return orderid;
	}
	
   /**
	* 设置 
	* @param orderid
	*/
 	public void setOrderid(java.lang.Long orderid) {
		this.orderid = orderid;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getParentclass() {
		return parentclass;
	}
	
   /**
	* 设置 
	* @param parentclass
	*/
 	public void setParentclass(java.lang.String parentclass) {
		this.parentclass = parentclass;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getSysname() {
		return sysname;
	}
	
   /**
	* 设置 
	* @param sysname
	*/
 	public void setSysname(java.lang.String sysname) {
		this.sysname = sysname;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.sql.Timestamp getUpdatetimestamp() {
		return updatetimestamp;
	}
	
   /**
	* 设置 
	* @param updatetimestamp
	*/
 	public void setUpdatetimestamp(java.sql.Timestamp updatetimestamp) {
		this.updatetimestamp = updatetimestamp;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getValue() {
		return value;
	}
	
   /**
	* 设置 
	* @param value
	*/
 	public void setValue(java.lang.String value) {
		this.value = value;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getValuebound() {
		return valuebound;
	}
	
   /**
	* 设置 
	* @param valuebound
	*/
 	public void setValuebound(java.lang.String valuebound) {
		this.valuebound = valuebound;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.String getValuetype() {
		return valuetype;
	}
	
   /**
	* 设置 
	* @param valuetype
	*/
 	public void setValuetype(java.lang.String valuetype) {
		this.valuetype = valuetype;
	}
	 

   /**
	* 获取 
	* @return
	*/
	public java.lang.Long getVersion() {
		return version;
	}
	
   /**
	* 设置 
	* @param version
	*/
 	public void setVersion(java.lang.Long version) {
		this.version = version;
	}
	 
}
