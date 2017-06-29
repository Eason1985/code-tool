package com.absmybatis.dao;

import java.util.ArrayList;

import com.absmybatis.common.SelectParamHandle;
import com.absmybatis.exception.BaseDtoException;

/**
 * 查询单表数据
 * @author jason.shu
 *
 * @param <T>
 */
public interface IBaseDtoMapper<T> {
	
	
	/**
	 * 1:查询一个对象
	 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ; 
	 * 但是该方法只会返回一个对象，请确保模糊查询的结果只含有一个对象。
	 * @param obj = entity and entity property value 
	 * @return
	 */
	public   T selectObject(T   entity   ) throws BaseDtoException  ;

	/**
	 * 2:查询一个对象
	 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ; 
	 * 但是该方法只会返回一个对象，请确保模糊查询的结果只含有一个对象。
	 * @param obj = entity and entity property value 
	 * @return
	 */
	public   T selectObject(T   entity  ,  SelectParamHandle selectParamHandle    ) throws BaseDtoException  ;

	/**
	 * 2:查询一个List
	 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ; 
	 * 
	 * @param entity；  selectParamHandle:order by 
	 * @return ArrayList<T> 
	 */
	public  ArrayList<T> selectList(T  entity ,
				 SelectParamHandle selectParamHandle   )throws BaseDtoException;
	/**
	 * 查询列表
	 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ;
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public  ArrayList<T> selectList(T entity )throws BaseDtoException ;
	
	/**
	 * 3:分页查询
	 * 支持模糊查询，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ; 
	 * 
	 * @param entity ; selectParamHandle order by and page info
	 * @param selectParamHandle
	 * @return
	 */
	public ArrayList<T> selectListByPage(T entity ,
			 SelectParamHandle selectParamHandle   )throws BaseDtoException ;
	
	/**
	 * 4.1:查询总数
	 * 支持模糊查询的条数，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ; 
	 * 
	 * @param entity 
	 * @param selectParamHandle
	 * @return
	 */
	public  Integer selectCount(T entity ) throws BaseDtoException ;
	/**
	 * 4.2:查询总数
	 * 支持模糊查询的条数，如果含有模糊查询,可以在参数值前添加：$like$:标识符
	 * 如： 想模糊查询张姓学生： 
	 * Student st  = new Student();
	 * st.setName("$like$:张%") ; 
	 * 
	 * @param entity 
	 * @param selectParamHandle
	 * @return
	 */
	public  Integer selectCount(T entity , SelectParamHandle selectParamHandle)throws BaseDtoException ; 
	/**
	 * 5:更新一个实体类 , 只更新非空值 . 这个方法理论上是不需要的. 
	 *  禁止更新ID
	 * @param updateTarget = Entity
	 * @param updateParam = Entity or HashMap or JavaBean or String 
	 * @return update date size 
	 */
	public int updateEntityById( T updateEntity) throws BaseDtoException ; 

	/**
	 * 5.2:更新一个实体类  全字段更新 ,即使属性为空也会更新
	 *  禁止更新ID
	 * @param updateTarget = Entity
	 * @param updateParam = Entity or HashMap or JavaBean or String 
	 * @return update date size 
	 */
	public int updateEntityByIdAllColumn( T updateEntity) throws BaseDtoException ; 
	
	
	/**
	 * 6:插入一个实体类
	 * @param insertEntity
	 * @param insertParamHandle
	 * @return
	 */
	public int insertEntity( T insertEntity  )throws BaseDtoException ; 
	/**
	 * 6:删除一个实体类
	 * @param insertEntity
	 * @param insertParamHandle
	 * @return
	 */
	public int deleteEntity( T deleteEntity  )throws BaseDtoException ; 

}
