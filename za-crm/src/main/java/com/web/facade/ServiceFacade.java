package com.web.facade;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.web.common.exception.BusinessException;
import com.web.common.service.IService;

/**
 * 服务汇总者
 * 
 * 如果集成了dubbo服务，则可以使用dubbo服务
 * @author Administrator
 *
 */
@Service
public class ServiceFacade implements  ApplicationContextAware {
	
	private static Logger logger = Logger.getLogger(ServiceFacade.class);
	private static Map<String,IService>   servicePool = new  HashMap<String,IService>();
	
	/**
	 * 调用服务
	 * @param request
	 * @return
	 */
	public static  AbsResponse invokeService(AbsRequest request){
		if(servicePool.get(request.getServiceCode())!=null){
			try{
				return servicePool.get(request.getServiceCode()).execute(request) ; 
			}catch(BusinessException e){
				logger.error(e.getErrorCode()==null?AbsResponse.SYSTEMERROR:e.getErrorCode(),
						e );
				throw e ; 
			}catch(Exception e){
				logger.error("调用服务错误",e);
				throw new BusinessException(AbsResponse.SYSTEMERROR,"系统错误")  ; 
			}
		}else {
			BusinessException e = new BusinessException(AbsResponse.SYSTEMERROR,"服务不存在："+request.getServiceCode())  ; 
			logger.error("服务不存在",e);
			throw e ; 
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		Map<String,IService> mapTemp = arg0.getBeansOfType(IService.class) ;
		if(mapTemp==null || mapTemp.isEmpty())
			return ; 
		Set keys = mapTemp.keySet() ; 
		for(Object key : keys ){
			IService service = mapTemp.get(key) ; 
			servicePool.put(service.serviceCode() , service ); 
		}
	} 
}