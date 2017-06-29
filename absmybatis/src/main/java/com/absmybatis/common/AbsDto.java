package com.absmybatis.common;

import java.util.HashMap;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/***
 * DTO抽象类
 * @author shuzhiyun
 *
 */
public abstract class AbsDto implements IDto{
	
	 /**
	  * 当有特殊查询(范围查询,in查询,纯sql查询时使用)
	  */
	 
	//该属性是给区间查询 时框架使用, 该值为区间查询的值,该方法由框架使用
	private  HashMap<String,Object> _intervalQueryValues ; 
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);  
	}

	public HashMap<String, Object> get_intervalQueryValues() {
		return _intervalQueryValues;
	}

	public void set_intervalQueryValues(HashMap<String, Object> _intervalQueryValues) {
		this._intervalQueryValues = _intervalQueryValues;
	}
	
	
}
