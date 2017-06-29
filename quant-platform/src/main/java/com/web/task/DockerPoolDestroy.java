package com.web.task;

import java.util.Date;
import java.util.Set;

import me.chanjar.weixin.common.util.StringUtils;

import com.absmybatis.util.DateUtil;
import com.web.common.util.StringFormatByParamMean;
import com.web.contentmanager.ContentSubjectKeyEnum;
import com.web.contentmanager.cache.RedisContentHandle;
import com.web.contentmanager.swarm.SwarmBO;

/**
 * 
 * docker池 销毁器 
 * @author shuzhiyun
 *
 */
public class DockerPoolDestroy {

	
	public void destory(){
		String[] clientIpAndDockerIdes ; 
		boolean remPoolMember = false ; 
		Set<String> dockerSet = RedisContentHandle.smembers(ContentSubjectKeyEnum.DOCKER_CONTAINER_POOL_SET);
		if(dockerSet !=null && dockerSet.size() != 0 ){
			for(String clientIpAndDockerId: dockerSet ){
				remPoolMember = false  ; 
				clientIpAndDockerIdes = clientIpAndDockerId.split(","); 
				if(clientIpAndDockerIdes.length == 3 ){
					String time = RedisContentHandle.get(StringFormatByParamMean.format(ContentSubjectKeyEnum.CLIENT_LAST_VISIT_DOCKER_TIME.getSubjectKey() ,clientIpAndDockerIdes[1])) ;
					String dynamicProxyAddr = RedisContentHandle.get(StringFormatByParamMean.format(ContentSubjectKeyEnum.CLIENT_DOCKER_DYNAMIC_PROXY_ADDRESS.getSubjectKey() ,clientIpAndDockerIdes[1])) ;
					if(StringUtils.isEmpty(time) ){
						RedisContentHandle.del(StringFormatByParamMean.format(ContentSubjectKeyEnum.CLIENT_DOCKER_DYNAMIC_PROXY_ADDRESS.getSubjectKey() ,clientIpAndDockerIdes[0]));
						remPoolMember = SwarmBO.removeDockerContainer(clientIpAndDockerIdes[1]);
					}else if(StringUtils.isEmpty(dynamicProxyAddr) ){
						RedisContentHandle.del(StringFormatByParamMean.format(ContentSubjectKeyEnum.CLIENT_LAST_VISIT_DOCKER_TIME.getSubjectKey() ,clientIpAndDockerIdes[0]));
						remPoolMember = SwarmBO.removeDockerContainer(clientIpAndDockerIdes[1]);
					}else{
						long seconds = (DateUtil.getDate(time, "yyyyMMddHHmmss").getTime() - new Date().getTime())/1000;
						if(seconds > 30 ){
							remPoolMember = SwarmBO.removeDockerContainer(clientIpAndDockerIdes[1]); 
						}
					}
				}else{
					remPoolMember = true ; 
				}
				if(remPoolMember){
					RedisContentHandle.srem(ContentSubjectKeyEnum.DOCKER_CONTAINER_POOL_SET, clientIpAndDockerId);
				}
			}
		}
	}
	
	
	
	
	
}
