package com.web.facade.basequery;

import java.util.ArrayList;

import com.web.facade.AbsResponse;
@SuppressWarnings("rawtypes")
public class BaseObjectOPResponse  extends AbsResponse {
	
	private Object selectObject ; 
	
	private ArrayList<Object>  selectList ; 
	
	/**
	 * 数据执行数目
	 */
	private  Integer dataExeNumber;

	
	
	public Object getSelectObject() {
		return selectObject;
	}

	public void setSelectObject(Object selectObject) {
		this.selectObject = selectObject;
	}

	public ArrayList getSelectList() {
		return selectList;
	}

	 

	public Integer getDataExeNumber() {
		return dataExeNumber;
	}

	public void setDataExeNumber(Integer dataExeNumber) {
		this.dataExeNumber = dataExeNumber;
	}

	public void setSelectList(ArrayList<Object> selectList) {
		this.selectList = selectList;
	}

 
	
	
}
