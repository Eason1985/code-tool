package com.web.mapper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.absmybatis.dao.BaseDtoMapperSuport;
import com.absmybatis.dao.mapper.DefaultDtoBaseMapper;
/**
 * 所有实体类的Mapper工厂。可以通过该工厂操作所有单表的增删改查！ 
 * @author Administrator
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class AllEntityMapperFactory  implements ApplicationContextAware {
	private static ApplicationContext arg0  = null; 
	
	private static BaseDtoMapperSuport allEntityMapper = null;
	
	/**
	 * 获取所有表的Mapper。可以通过该表实现对单表的增删改查（含单表查询分页）。
	 * @return
	 */
	public static BaseDtoMapperSuport getAllEntityMapper(){
		if(allEntityMapper == null){
			synchronized (AllEntityMapperFactory.class) {
				if(allEntityMapper == null){
					allEntityMapper = new BaseDtoMapperSuport();
					BaseDtoMapperSuport.setDefaultDaoBaseMapper(arg0.getBean(DefaultDtoBaseMapper.class)) ; 
				}
			}
		}
		return allEntityMapper ;
	}
	
	
	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.arg0 = arg0 ; 
	} 
}
