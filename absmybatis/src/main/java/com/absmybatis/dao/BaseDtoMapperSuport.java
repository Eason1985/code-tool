package com.absmybatis.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.exceptions.TooManyResultsException;

import com.absmybatis.common.SelectParamHandle;
import com.absmybatis.dao.mapper.DefaultDtoBaseMapper;
import com.absmybatis.exception.BaseDtoException;
import com.absmybatis.util.BeanMapUtil;


/**
 * 实体表操作引擎
 * @author shuzhiyun
 * 
 * 
 * 特殊单表查询: 
 * 
 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:参数值
 *  如： 想模糊查询张姓学生： 
 * Student st  = new Student();
 * st.setName("$like$:张%") ; 
 * 
 * 支持区间查询(大于,大于等于,小于,小于等于.   )，
 * 如果含有区间查询,就必须使用区间查询器工具. 
 * 
 * 支持纯sql查询，如果含有范围查询,就必须使用特殊查询器工具. 
 * 
 *
 * @param <T>
 */
public class BaseDtoMapperSuport<T> implements IBaseDtoMapper<T>   {
	
	private static DefaultDtoBaseMapper defaultDaoBaseMapper  ; 
	
	/**
	 * 1.1:查询一个对象
	 * 
	 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ; 
	 * 但是该方法只会返回一个对象，请确保模糊查询的结果只含有一个对象。
	 * 
	 * @param obj = entity and entity property value 
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public   T selectObject(T   entity   ) throws BaseDtoException  {
		HashMap map = null ;
		try {
			map = defaultDaoBaseMapper.selectObject(entity );
		} catch (TooManyResultsException e) {
			e.printStackTrace();
			throw new BaseDtoException("10001","查询时查询出多条数据",e);
		} 
		return (T) BeanMapUtil.Map2Bean(entity.getClass(), map) ;
	}

	/**
	 * 1.2:查询一个对象
	 * 
	 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ; 
	 * 但是该方法只会返回一个对象，请确保模糊查询的结果只含有一个对象。
	 * 
	 * @param obj selectParamHandle可以通过该实体,实现区间查询. 但是dto必须要继承AbsDto
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public T selectObject(T entity,  SelectParamHandle selectParamHandle  )
			throws BaseDtoException {
		HashMap map = null ;
		try {
			map = defaultDaoBaseMapper.selectObjectHaveIntervalQuery(entity ,selectParamHandle );
		} catch (TooManyResultsException e) {
			e.printStackTrace();
			throw new BaseDtoException("10001","查询时查询出多条数据",e);
		} 
		return (T) BeanMapUtil.Map2Bean(entity.getClass(), map) ;
	}

	
	/**
	 * 2:查询一个List
	 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ; 
	 * @param entity；  selectParamHandle:order by 
	 * @return ArrayList<T> 
	 */
 	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  ArrayList<T> selectList(T  entity ,
				 SelectParamHandle selectParamHandle   )throws BaseDtoException {
		ArrayList<HashMap> listes = defaultDaoBaseMapper.selectList(entity, selectParamHandle) ; 
		ArrayList<T> tes = new ArrayList<T> (); 
		for( HashMap map : listes){
			tes.add( (T) BeanMapUtil.Map2Bean(entity.getClass(), map) );
		}
		return tes ;
	}
	/**
	 * 查询列表
	 * 
	 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ; 
	 * 
	 * @param entity
	 * @return
	 * @throws BaseDtoException
	 */
	public  ArrayList<T> selectList(T entity )throws BaseDtoException {
		return selectList(entity,null) ; 
	}
	
	/**
	 * 3:分页查询
	 * 
	 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ; 
	 * 
	 * @param entity ; selectParamHandle order by and page info
	 * @param selectParamHandle
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<T> selectListByPage(T entity ,
			 SelectParamHandle selectParamHandle   )throws BaseDtoException {
		ArrayList<HashMap> listes = defaultDaoBaseMapper.selectListByPage(entity, selectParamHandle) ; 
		ArrayList<T> tes = new ArrayList<T> (); 
		for(HashMap map : listes){
			tes.add( (T) BeanMapUtil.Map2Bean(entity.getClass(), map) );
		}
		return tes ;
	}
	
	/**
	 * 4:查询总数
	 * 
	 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ; 
	 * 
	 * 
	 * @param entity 
	 * @param selectParamHandle
	 * @return
	 */
	public  Integer selectCount(T entity )throws BaseDtoException{
		return defaultDaoBaseMapper.selectCount(entity ) ; 
	}
	/**
	 * 4.2:查询总数
	 * 
	 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 *  
	 * 
	 * 
	 * @param entity 
	 * @param selectParamHandle
	 * @return
	 */
	public  Integer selectCount(T entity , SelectParamHandle selectParamHandle)throws BaseDtoException{
		return defaultDaoBaseMapper.selectCountSelectParam(entity ,selectParamHandle) ; 
	}
	/**
	 * 5:更新一个实体类
	 *  禁止更新ID
	 * @param updateTarget = Entity
	 * @param updateParam = Entity or HashMap or JavaBean or String 
	 * @return update date size 
	 */
	public int updateEntityById( T updateEntity)throws BaseDtoException{
		return defaultDaoBaseMapper.updateEntityById(updateEntity) ; 
	}
	
	/**
	 * 5.2:更新一个实体类  全字段更新 ,即使属性为空也会更新
	 *  禁止更新ID
	 * @param updateTarget = Entity
	 * @param updateParam = Entity or HashMap or JavaBean or String 
	 * @return update date size 
	 */
	public int updateEntityByIdAllColumn( T updateEntity)throws BaseDtoException{
		return defaultDaoBaseMapper.updateEntityByIdAllColumn(updateEntity) ; 
	}
	
	/**
	 * 6:插入一个实体类
	 * @param insertEntity
	 * @param insertParamHandle
	 * @return
	 */
	public int insertEntity( T insertEntity  )throws BaseDtoException{
		return defaultDaoBaseMapper.insertEntity(insertEntity ) ;  
	}
	/**
	 * 6:删除一个实体类
	 * @param insertEntity
	 * @param insertParamHandle
	 * @return
	 */
	public int deleteEntity( T deleteEntity  )throws BaseDtoException{
		return defaultDaoBaseMapper.deleteEntity(deleteEntity ) ;  
	}

	
	
	
	@SuppressWarnings("unused")
	private   DefaultDtoBaseMapper getDefaultDaoBaseMapper() {
		return BaseDtoMapperSuport.defaultDaoBaseMapper;
	}

	public static  void setDefaultDaoBaseMapper(DefaultDtoBaseMapper defaultDaoBaseMapper) {
		BaseDtoMapperSuport.defaultDaoBaseMapper = defaultDaoBaseMapper;
	}

}
