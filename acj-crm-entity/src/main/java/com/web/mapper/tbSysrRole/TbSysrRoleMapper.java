package com.web.mapper.tbSysrRole;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.web.entity.TbSysrRoleDto;


public interface TbSysrRoleMapper {

	
	/**
	 * 根据客户ID查询该客户还没有配置的角色
	 * @param role_name
	 * @param role_group
	 * @param role_user_id
	 */
	public List<TbSysrRoleDto> selectConfigTRoleByUserId(HashMap param) ; 
	
	public Integer selectCountConfigTRoleByUserId(HashMap param);
	
	/**
	 * 根据客户ID查询该客户还没有配置的角色
	 * @param role_name
	 * @param role_group
	 * @param role_user_id
	 */
	public List<TbSysrRoleDto> selectNoConfigTRoleByUserId(HashMap param) ; 

	public Integer selectCountNoConfigTRoleByUserId(java.util.HashMap param) ; 

	
	
}
