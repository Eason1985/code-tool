package com.acjkj.excelutil;

import java.util.LinkedHashMap;
import java.util.List;

public interface ExcelDataHandle {
	
	
	/**
	 * 
	 * @param params 参数
	 * @param current_page 当前页面
	 * @param page_size  每页大小  从第一页开始。
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List  obtainExcelData(  int current_page );
	
	
	/**
	 * 表头
	 * @return
	 */
	public LinkedHashMap<String,String>  obtainExcelHeaderData( );
	
	/**
	 * 是否分页
	 * @return
	 */
	public   boolean  isPaging() ;
	
	
	
}
