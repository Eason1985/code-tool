package com.web.mapper.tbSysrRelationUserRole;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.absmybatis.common.SelectParamHandle;
public interface TbSysrRelationUserRoleMapper {

	@SelectProvider(method ="selectListByPageSql" ,type=TbSysrRelationUserRoleSqlPrivider.class) 
	public List<Map<String,Object>> searchTUserRoleRelaByUserId(@Param("sysr_user_id") String sysr_user_id ,@Param("selectParamHandle") SelectParamHandle selectParamHandle );
	
	@Select("select count(1) from tb_sysr_relation_user_role f    where f.sysr_user_id = #{sysr_user_id}")
	public Integer searchTUserRoleRelaCountByUserId(@Param("sysr_user_id") String sysr_user_id  );
	
}
