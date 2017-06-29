package com.web.facade.basequery;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.absmybatis.common.SelectParamHandle;
import com.absmybatis.exception.BaseDtoException;
import com.web.common.exception.BusinessException;
import com.web.facade.ServiceFacade;

/**
 * 该方法是提供给controller使用的查询单个表的工具类
 * 
 * 
 * @author YAO
 *
 * @param <T>
 */
public class BaseQueryServiceUtil<T> {
	
	private static Logger logger = Logger.getLogger(BaseQueryServiceUtil.class);  
	
	public static final String BASEOBJECTOP_BASEQUERY = "BASEQUERY";
	public static final String BASEOBJECTOP_BASESUBMIT = "BASESUBMIT";
	
//	通用查询
	public static final String BASEOBJECTOP_CURRENCYQUERY = "CURRENCYQUERY";
	/**
	 * 查询单个表中的一条数据。当返回多条数据的时候，会报错。
	 * @param entity
	 * @return
	 * @throws BaseDtoException
	 */
	@SuppressWarnings("unchecked")
	public   T selectObject(T   entity   ) throws BaseDtoException  {
		BaseObjectOPRequest baseQueryRequest = new BaseObjectOPRequest(BaseObjectOPRequest.QUERYTYPE_SELECTOBJECT_1,entity);
		baseQueryRequest.setServiceCode(BASEOBJECTOP_BASEQUERY);
 		BaseObjectOPResponse response = null ;
		try {
			response = (BaseObjectOPResponse)ServiceFacade.invokeService(baseQueryRequest);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("查询出错");
		} 
		return (T)response.getSelectObject() ; 
	}

	/**
	 * 2:查询单个表中的多条数据  返回一个List  如果要排序，在必须使用该方法。
	 * @param entity；  selectParamHandle:order by 
	 * @return ArrayList<T> 
	 */
 	@SuppressWarnings({ "unchecked" })
	public  ArrayList<T> selectList(T  entity ,
				 SelectParamHandle selectParamHandle   )throws BaseDtoException {
 		BaseObjectOPRequest baseQueryRequest = new BaseObjectOPRequest(BaseObjectOPRequest.QUERYTYPE_SELECTLIST_2,entity,selectParamHandle);
 		baseQueryRequest.setServiceCode(BASEOBJECTOP_BASEQUERY);
 		BaseObjectOPResponse response = (BaseObjectOPResponse)ServiceFacade.invokeService(baseQueryRequest) ; 
		return  response.getSelectList() ; 
	}
	/**
	 *  2:查询单个表中的多条数据  返回一个List 不指定排序
	 * 
	 * 默认获取逻辑我未删除的数据
	 * @param entity
	 * @return
	 * @throws BaseDtoException
	 */
	public  ArrayList<T> selectList(T entity )throws BaseDtoException {
		return selectList(entity,null) ; 
	}
	
	/**
	 * 3:分页查询
	 * @param entity ; selectParamHandle order by and page info
	 * @param selectParamHandle
	 * @return
	 */
	@SuppressWarnings({   "unchecked" })
	public ArrayList<T> selectListByPage(T entity ,
			 SelectParamHandle selectParamHandle   )throws BaseDtoException {
		BaseObjectOPRequest baseQueryRequest = new BaseObjectOPRequest(BaseObjectOPRequest.QUERYTYPE_SELECTLISTBYPAGE_3,entity,selectParamHandle);
		baseQueryRequest.setServiceCode(BASEOBJECTOP_BASEQUERY);
 		BaseObjectOPResponse response = (BaseObjectOPResponse)ServiceFacade.invokeService(baseQueryRequest) ; 
		return  response.getSelectList() ; 
	}
	
	/**
	 * 4:查询总数
	 * @param entity 
	 * @param selectParamHandle
	 * @return
	 */
	public  Integer selectCount(T entity )throws BaseDtoException{
		BaseObjectOPRequest baseQueryRequest = new BaseObjectOPRequest(BaseObjectOPRequest.QUERYTYPE_SELECTCOUNT_4,entity);
		baseQueryRequest.setServiceCode(BASEOBJECTOP_BASEQUERY);
 		BaseObjectOPResponse response = (BaseObjectOPResponse)ServiceFacade.invokeService(baseQueryRequest) ; 
		return  response.getDataExeNumber() ; 
	}
	/**
	 * 4:查询总数
	 * @param entity 
	 * @param selectParamHandle
	 * @return
	 */
	public  Integer selectCount(T entity , SelectParamHandle selectParamHandle )throws BaseDtoException{
		BaseObjectOPRequest baseQueryRequest = new BaseObjectOPRequest(BaseObjectOPRequest.QUERYTYPE_SELECTCOUNT_HAVE_HANDLE_5,entity);
		baseQueryRequest.setServiceCode(BASEOBJECTOP_BASEQUERY);
		baseQueryRequest.setHandle(selectParamHandle);
 		BaseObjectOPResponse response = (BaseObjectOPResponse)ServiceFacade.invokeService(baseQueryRequest) ; 
		return  response.getDataExeNumber() ; 
	}
	/**
	 * 4:插入实体类
	 * @param entity 
	 * @param selectParamHandle
	 * @return
	 */
	public  Integer insertEntity(T entity )throws BaseDtoException{
		BaseObjectOPRequest baseQueryRequest = new BaseObjectOPRequest(BaseObjectOPRequest.SUBMITTYPE_INSERT_1,entity);
		baseQueryRequest.setServiceCode(BASEOBJECTOP_BASESUBMIT);
 		BaseObjectOPResponse response = (BaseObjectOPResponse)ServiceFacade.invokeService(baseQueryRequest) ; 
		return  response.getDataExeNumber() ; 
	}
	
	/**
	 * 5:根据ID修改
	 * @param entity 
	 * @param selectParamHandle
	 * @return
	 */
	public  Integer updateEntityById(T entity )throws BaseDtoException{
		BaseObjectOPRequest baseQueryRequest = new BaseObjectOPRequest(BaseObjectOPRequest.SUBMITTYPE_UPDATEBYID_2,entity);
		baseQueryRequest.setServiceCode(BASEOBJECTOP_BASESUBMIT);
 		BaseObjectOPResponse response = (BaseObjectOPResponse)ServiceFacade.invokeService(baseQueryRequest) ; 
		return  response.getDataExeNumber() ; 
	}
	
	/**
	 * 5:根据ID修改
	 * @param entity 
	 * @param selectParamHandle
	 * @return
	 */
	public  Integer deleteEntity(T entity )throws BaseDtoException{
		BaseObjectOPRequest baseQueryRequest = new BaseObjectOPRequest(BaseObjectOPRequest.SUBMITTYPE_DELETEBYID_3,entity);
		baseQueryRequest.setServiceCode(BASEOBJECTOP_BASESUBMIT);
 		BaseObjectOPResponse response = (BaseObjectOPResponse)ServiceFacade.invokeService(baseQueryRequest) ; 
		return  response.getDataExeNumber() ; 
	}
	
	

	
	/**
	 * request = hashMap 
	 * 
	 * 直接查询一个复杂的查询
	 * 
	 * @param selectParam 可以是String ,可以是Hashmap, 可以是其他类型
	 * 		  currencyquery_type 
	 * 通用查询种类
	 * @return
	 * @throws BaseDtoException
	 */
	public Object selectCurrencyBean(Object   selectParam ,CurrencyEnum currencyEnum) throws BaseDtoException  {
		BaseObjectOPRequest baseQueryRequest = new BaseObjectOPRequest(BaseObjectOPRequest.CURRENCY_SELECTOBJECT_1,selectParam);
		baseQueryRequest.setServiceCode(BASEOBJECTOP_CURRENCYQUERY);
		baseQueryRequest.setCurrencyquery_type(currencyEnum.getValue());
 		BaseObjectOPResponse response = null ;
		try {
			response = (BaseObjectOPResponse)ServiceFacade.invokeService(baseQueryRequest);
		} catch (BaseDtoException e) {
			logger.error("error",e);;
			throw new BusinessException("查询出错");
		} catch (Exception e) {
			logger.error("error",e);;
			throw new BusinessException("查询出错");
		} 
		return response.getSelectObject() ; 
	}

	/**
	 * 2:查询单个表中的多条数据  返回一个List  如果要排序，在必须使用该方法。
	 * @param entity；  selectParamHandle:order by 
	 * @return ArrayList<T> 
	 */
 	@SuppressWarnings({ "unchecked" })
	public  ArrayList<Object> selectCurrencyList(Object   selectParam ,CurrencyEnum currencyEnum)throws BaseDtoException {
 		BaseObjectOPRequest baseQueryRequest = new BaseObjectOPRequest(BaseObjectOPRequest.CURRENCY_SELECTLIST_2,selectParam);
 		baseQueryRequest.setServiceCode(BASEOBJECTOP_CURRENCYQUERY);
		baseQueryRequest.setCurrencyquery_type(currencyEnum.getValue());
		BaseObjectOPResponse response = (BaseObjectOPResponse)ServiceFacade.invokeService(baseQueryRequest) ; 
		return  (ArrayList<Object>)response.getSelectList() ; 
	}
	
	
}
