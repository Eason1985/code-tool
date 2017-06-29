package com.web.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.absmybatis.util.DateUtil;
import com.web.common.controller.BaseController;
import com.web.common.util.StringFormatByParamMean;
import com.web.common.util.web.ClientIpUtil;
import com.web.contentmanager.ContentSubjectKeyEnum;
import com.web.contentmanager.cache.RedisContentHandle;
import com.web.contentmanager.swarm.ContainerBO;
import com.web.contentmanager.swarm.SwarmBO;
import com.web.contentmanager.sysproperty.SysPropertyHandle;

/**
 * 
 * 点击开始研究按钮
 * @author shuzhiyun
 *
 */
@Controller
public class BeginResearchController  extends BaseController{
	
	private static Logger logger = Logger.getLogger(BeginResearchController.class);  
	
	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/begin_research.do")
	public String beginResearch(HttpServletRequest request ,HttpServletResponse response) {
		// 1:到redis中获取该用户docker信息
		String clientRealIp = ClientIpUtil.getIpAddress(request) ;
		logger.debug("clientRealIp = " + clientRealIp) ; 
		//调用Redis看是否含有该ip的
		String dynamicProxyAddr = RedisContentHandle.get( StringFormatByParamMean.format(ContentSubjectKeyEnum.CLIENT_DOCKER_DYNAMIC_PROXY_ADDRESS.getSubjectKey() , clientRealIp) );
		logger.debug("dynamicProxyAddr = " + dynamicProxyAddr) ; 
		String userId = "123abc" ; //TODO session 客户的userId
		Integer hostPort = 8888 ; //TODO 宿主机端口 与userId 获取绑定，一个userId一个
		Integer dockerPort = 8888 ; //TODO docker容器的开放端口，一般与hostPort一样。两个端口之间docker容器会作映射。
		
//		SwarmBO.removeDockerContainer(userId) ; 
		
		if(StringUtils.isEmpty( dynamicProxyAddr )){
			logger.debug("进入创建容器分支" ) ; 
			ContainerBO  containerBO = 	SwarmBO.queryDockerDetailContainer(userId);
			
			if(null == containerBO ){
				logger.debug("查找容器没有查询到，开始创建 " ) ; 
				 containerBO = SwarmBO.createDockerContainer(
							SysPropertyHandle.getProperty(ContentSubjectKeyEnum.CLIENT_FILE_PTAH)
							+ File.separator +userId,
							userId , 
							hostPort ,dockerPort ,
	   					    new String[]{"jupyter-notebook", "--ip=0.0.0.0", "--notebook-dir=/tmp" ,"--NotebookApp.token='"+userId+"'" , "--port="+dockerPort}
					);
			}
			logger.debug("容器为： "+ containerBO ) ; 
			//TODO 调用swarm获取docker 
			String containerIp = containerBO.getContainerInstanceInfoList().get(0).getNodeInfo().getIp() ; 
			Integer containerPort = containerBO.getPortes().get(0).getPublishedPort() ;
			if(StringUtils.isEmpty(containerIp) 
					||  containerPort ==null 
					|| StringUtils.isEmpty(containerBO.getServiceId()) 
					  ){
				logger.warn("该客户不能启动docker容器" ) ; 
				return "/login" ; 
			}
			logger.debug("添加redis 的 set" ) ; 
			RedisContentHandle.sadd(ContentSubjectKeyEnum.DOCKER_CONTAINER_POOL_SET,userId +","+clientRealIp + "," + containerBO.getServiceId());
			RedisContentHandle.set(StringFormatByParamMean.format(
					ContentSubjectKeyEnum.CLIENT_DOCKER_DYNAMIC_PROXY_ADDRESS.getSubjectKey() , clientRealIp) ,
						containerIp+":"+containerPort);
			logger.debug("redirectPath = "+RedisContentHandle.get(StringFormatByParamMean.format(
					ContentSubjectKeyEnum.CLIENT_DOCKER_DYNAMIC_PROXY_ADDRESS.getSubjectKey() , clientRealIp)));
		}
		RedisContentHandle.set(StringFormatByParamMean.format(
				ContentSubjectKeyEnum.CLIENT_LAST_VISIT_DOCKER_TIME.getSubjectKey() , clientRealIp) ,
				DateUtil.getDefaultFormatDate( new Date() ) );
		
		logger.debug("redirectPath = "+RedisContentHandle.get(StringFormatByParamMean.format(
				ContentSubjectKeyEnum.CLIENT_DOCKER_DYNAMIC_PROXY_ADDRESS.getSubjectKey() , clientRealIp)));
		
		String redirectPath =  "redirect:"+ SysPropertyHandle.getProperty(ContentSubjectKeyEnum.PROXY_NOTEBOOK_ADDRESS) ;
		logger.debug("redirectPath = "+redirectPath);
		//		return "redirect:http://"+ RedisContentHandle.get(StringFormatByParamMean.format(
//				ContentSubjectKeyEnum.CLIENT_DOCKER_DYNAMIC_PROXY_ADDRESS.getSubjectKey() , clientRealIp)) ;
		return redirectPath ; 
	}
}