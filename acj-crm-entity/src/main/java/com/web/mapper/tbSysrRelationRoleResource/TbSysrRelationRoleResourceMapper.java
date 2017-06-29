package com.web.mapper.tbSysrRelationRoleResource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TbSysrRelationRoleResourceMapper {
	
	/**
	 * 根据角色查询资源列表
	 * @param roleId
	 * @return
	 */
	public List<Map> select_tResSelfRelaList(HashMap hashMap ) ;   

	public List<Map> select_tResSelfRelaListByUserId(HashMap hashMap ) ;   

}
