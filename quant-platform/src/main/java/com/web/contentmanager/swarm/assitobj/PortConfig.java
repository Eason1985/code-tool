package com.web.contentmanager.swarm.assitobj;

import java.io.Serializable;

public class PortConfig  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String Protocol ; // - `tcp`/`udp`
	private Integer TargetPort ; // - 容器内部端口
	private Integer PublishedPort ; // - 主机映射端口
	
	//
	private String PublishMode ; // host 
	
	
	public PortConfig(String protocol, int targetPort ,int publishedPort ) {
		super();
		Protocol = protocol;
		TargetPort = targetPort;
		PublishedPort = publishedPort; 
	}
	
	
	public String getProtocol() {
		return Protocol;
	}
	public void setProtocol(String protocol) {
		Protocol = protocol;
	}
	public int getTargetPort() {
		return TargetPort;
	}
	public void setTargetPort(Integer targetPort) {
		TargetPort = targetPort;
	}
	public Integer getPublishedPort() {
		return PublishedPort;
	}
	public void setPublishedPort(Integer publishedPort) {
		PublishedPort = publishedPort;
	}
	public String getPublishMode() {
		return PublishMode;
	}
	public void setPublishMode(String publishMode) {
		PublishMode = publishMode;
	}
	

}
