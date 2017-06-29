package com.absmybatis.dao.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import com.absmybatis.common.SelectParamHandle;


/**
 * 数据库持久化统一实现接口
 * 
 * 
 * 
 * @author shuzhiyun
 *
 */
@SuppressWarnings("rawtypes")
public interface DefaultDtoBaseMapper   {
	
	/**
	 * 1.1:查询一个对象
	 * @param obj = 查询参数与实体对象
	 * @return
	 */
	@SelectProvider(method ="selectObjectSql" ,type=SelectSqlProvider.class) 
	public  HashMap selectObject( @Param("entity") Object entity   );
	/**
	 * 1.2:查询一个对象  可以查询一个范围
	 * @param obj = 查询参数与实体对象
	 * @param obj selectParamHandle可以通过该实体,实现区间查询. 但是dto必须要继承AbsDto
	 * @return
	 */
	@SelectProvider(method ="selectObjectHaveIntervalQuerySql" ,type=SelectSqlProvider.class) 
	public  HashMap selectObjectHaveIntervalQuery( @Param("entity") Object entity   ,@Param("selectParamHandle")SelectParamHandle selectParamHandle);
	
	/**
	 * 2:查询一个对象列表
	 * @param obj = 查询参数与实体对象
	 * @return ArrayList<HashMap> 特殊的where条件
	 */
	@SelectProvider(method ="selectListSql" ,type=SelectSqlProvider.class) 
	public  ArrayList<HashMap> selectList( @Param("entity") Object entity ,
				@Param("selectParamHandle") SelectParamHandle selectParamHandle   );
	
	/**
	 * 3:分页查询一个对象列表
	 * @param entity
	 * @param selectParamHandle
	 * @return
	 */
	@SelectProvider(method ="selectListByPageSql" ,type=SelectSqlProvider.class) 
	public  ArrayList<HashMap> selectListByPage( @Param("entity") Object entity ,
			@Param("selectParamHandle") SelectParamHandle selectParamHandle   );
	
	/**
	 * 4.1:查询总数
	 * @param entity
	 * @param selectParamHandle
	 * @return
	 */
	@SelectProvider(method ="selectCountSql" ,type=SelectSqlProvider.class) 
	public  Integer selectCount( @Param("entity") Object entity  );
	/**
	 * 4.2:查询总数
	 * @param entity
	 * @param selectParamHandle
	 * @return
	 */
	@SelectProvider(method ="selectCountSelectParamSql" ,type=SelectSqlProvider.class) 
	public  Integer selectCountSelectParam( @Param("entity") Object entity ,  @Param("selectParamHandle") SelectParamHandle selectParamHandle   );
	
	/**
	 * 5:根据ID更新一个实体类,该类不会更新为空的字段 
	 * @param updateTarget = Entity
	 * @param updateParam = Entity or HashMap or String 
	 * @return update date size 
	 */
	@UpdateProvider(method ="updateEntityByIdSql" ,type=UpdateSqlProvider.class) 
	public int updateEntityById( @Param("entity") Object updateEntity );
	
	/**
	 * 5:根据ID更新一个实体类,该类也会将所为空的属性更新到库中
	 * @param updateTarget = Entity
	 * @param updateParam = Entity or HashMap or String 
	 * @return update date size 
	 */
	@UpdateProvider(method ="updateEntityByIdAllColumnSql" ,type=UpdateSqlProvider.class) 
	public int updateEntityByIdAllColumn( @Param("entity") Object updateEntity );
	
	/**
	 * 6:插入一个实体类
	 * @param insertEntity
	 * @param insertParamHandle
	 * @return
	 */
	@UpdateProvider(method ="insertEntitySql" ,type=InsertSqlProvider.class) 
	public int insertEntity( @Param("entity") Object insertEntity  );
	
	/**
	 * 7:根据条件删除
	 * @param deleteEntity
	 * @param deleteParamHandle
	 * @return
	 */
	@DeleteProvider(method ="deleteEntitySql" ,type=DeleteSqlProvider.class) 
	public int deleteEntity( @Param("entity") Object deleteEntity  );

}
