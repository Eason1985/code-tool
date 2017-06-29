package com.web.mapper.tbSysrRelationResSelf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface TbSysrRelationResSelfMapper {
	
	/**
	 * 根据页面ID查询页面名称
	 * @param role_name
	 * @param role_group
	 * @param role_user_id
	 */
	 @Select("select RESOURCE_NAME from tb_sysr_resource  where RESOURCE_ID = #{resourceId} ")
	public Map<String,Object> queryResourceName(String resourceId) ;  

}
