package com.absmybatis.common;

import java.util.ArrayList;

import com.absmybatis.exception.BaseDtoException;

/**
 * 查询分页辅助类
 * 如果分页该类必须
 * @author shuzhiyun
 *
 */
public class SelectParamHandle {

	
	public  static final String SQL_GRAM_AND = " AND " ; 
	public static final String SQL_GRAM_ORDER_BY = " ORDER BY " ; 
			
	private   Integer page ; 
	private   Integer pageSize  = 100 ; 
	private   String orderParam ; //如果为空，默认ID排序
	
	
	public SelectParamHandle(){
		super();
	}
	/**
	 * 查询构造器  ： 
	 * @param page >=1 
	 * @param pageSize default 100 
	 * @param orderParam 排序，如果为空，表示使用主键排序
	 * @throws Exception 
	 */
	public SelectParamHandle(Integer page  , Integer pageSize ,String orderParam  ) throws BaseDtoException{
		if(page==null){
			throw new BaseDtoException("查询分页时，页码不能为空");
		}
		if(page<=0){
			throw new BaseDtoException("查询分页时，页码应该从第1页开始，而不是从第0页。");
		}
		 this.page = page ; 
		 this.pageSize = Math.abs(pageSize) ; 
		 this.orderParam = orderParam ;
	}
	
	/**
	 * 查询构造器  ：  根据主键排序
	 * @param page >=1 
	 * @param pageSize default 100 
	 * @throws Exception 
	 */
	public SelectParamHandle(Integer page  , Integer pageSize ) throws BaseDtoException{
		if(page==null){
			throw new BaseDtoException("查询分页时，页码不能为空");
		}
		if(page<=0){
			throw new BaseDtoException("查询分页时，页码应该从第1页开始，而不是从第0页。");
		}
		 this.page = page ; 
		 this.pageSize = Math.abs(pageSize) ; 
	}
	
	/**
	 * 查询构造器  ：  分页每页行数100条构造器   pageSize default 100 
	 * @param page >=1  
	 * 		  orderParam可以为空，如果为空，则默认ID主键排序
	 *                  不过不为空，则传入对象的属性
	 * @throws Exception 
	 */
	public SelectParamHandle(Integer page,String orderParam) throws BaseDtoException{
		if(page==null){
			throw new BaseDtoException("查询分页时，页码不能为空");
		}
		if(page<=0){
			throw new BaseDtoException("查询分页时，页码应该从第1页开始，而不是从第0页。");
		}
		 this.page = Math.abs(page);  
		 this.orderParam = orderParam ;
	} 
	
	/**
	 * 查询构造器  ：  
	 * 		分页每页行数100条构造器   pageSize default 100 
	 * 		根据主键排序
	 * @param page >=1  如果 orderParam 为空，默认ID主键排序
	 * @throws Exception 
	 */
	public SelectParamHandle(Integer page) throws BaseDtoException{
		if(page==null){
			throw new BaseDtoException("查询分页时，页码不能为空");
		}
		if(page<=0){
			throw new BaseDtoException("查询分页时，页码应该从第1页开始，而不是从第0页。");
		}
		 this.page = Math.abs(page);  
	} 
	
	/**
	 * 查询列表时，排序构造器  查询list时，分页查询 
	 * @param page >=1
	 * @throws Exception 
	 */
	public SelectParamHandle(String orderParam){
		 this.orderParam = orderParam; 
	} 
	
	
	/**
	 * 特殊查询器
	 * @return
	 */
	public ArrayList<IntervalQueryWare> intervalQueryHandle(){
		return null ; 
	} 
	
	public Integer getPage() {
		return page;
	}
	public Integer getPageSize() {
		return pageSize;
	}

	public String getOrderParam() {
		return orderParam;
	}

	public void setOrderParam(String orderParam) {
		this.orderParam = orderParam;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}