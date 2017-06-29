package com.web.mapper.tbSysrRelationUserRole;

import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.absmybatis.common.SelectParamHandle;
import com.absmybatis.dao.mapper.SelectSqlProvider;
import com.absmybatis.exception.BaseDtoException;

public class TbSysrRelationUserRoleSqlPrivider {
	
	public String selectListByPageSql(Map<String ,Object> parames) throws BaseDtoException {
		SelectParamHandle scb = (SelectParamHandle) parames.get("selectParamHandle") ; 
		if(scb.getPage()==null||scb.getPageSize()==null){
			throw new BaseDtoException ("分页辅助类中的分页信息不明");
		}
		String sql = "select f.sysr_role_id sysr_role_id ,  r.role_name role_name ,r.role_group role_group ,to_char(r.createtime,'yyyyMMdd HHmmss') create_time,r.create_user_id create_user_id " 
					+" from  tb_sysr_relation_user_role f left join tb_sysr_role r on f.sysr_role_id =r.sysr_role_id "
					 + " where f.sysr_user_id = #{sysr_user_id} and r.netno = #{netno} order by f.object_id" ; 
		 sql =  "SELECT * FROM ( SELECT t.* ,rownum rn FROM ("+ 
					sql
					+") t where  ROWNUM <= " +scb.getPage()*scb.getPageSize() +
			") where rn > " +((scb.getPage()-1)*scb.getPageSize()) ;
		return sql ; 
	}
	
}
