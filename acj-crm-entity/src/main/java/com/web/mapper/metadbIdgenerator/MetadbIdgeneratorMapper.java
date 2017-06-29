package com.web.mapper.metadbIdgenerator;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.web.entity.MetadbIdgeneratorDto;

/**
 * 
 * @author szy
 *
 */
public interface MetadbIdgeneratorMapper {

	@Select ("select * from TB_SYSR_IDGENERATOR t where t.entityname = #{entityName} for update ")
	public MetadbIdgeneratorDto queryMetaDbIdgenerator(@Param("entityName") String entityName); 

}
