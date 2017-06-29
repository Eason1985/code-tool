package com.web.contentmanager.sysproperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemPropertyContent {
	private static SystemPropertyContent instance;
    public static SystemPropertyContent getInstance() {
        return instance;
    }
    public SystemPropertyContent() {
        instance = this;
    }
    
    
    // 客户文件总路径配置，数据格式为: /**/**
    @Value("#{configProperties['clientFileTotalPtah']}")
    private String clientFileTotalPtah ; 
    
    @Value("#{configProperties['proxyNotebookAddress']}")
    private String proxyNotebookAddress ; 
    
    //客户文件总路径配置，数据格式为: 
    @Value("#{configProperties['clusterName']}")
    private String clusterName ; 
    
    
    @Value("#{configProperties['swarmAddress']}")
    private String swarmAddress ; 
    
    @Value("#{configProperties['dockerImageName']}")
    private String dockerImageName ;
    
    
    
	public String getProxyNotebookAddress() {
		return proxyNotebookAddress;
	}
	public void setProxyNotebookAddress(String proxyNotebookAddress) {
		this.proxyNotebookAddress = proxyNotebookAddress;
	}
	public String getSwarmAddress() {
		return swarmAddress;
	}
	public void setSwarmAddress(String swarmAddress) {
		this.swarmAddress = swarmAddress;
	}
	public String getClientFileTotalPtah() {
		return clientFileTotalPtah;
	}
	public void setClientFileTotalPtah(String clientFileTotalPtah) {
		this.clientFileTotalPtah = clientFileTotalPtah;
	}
	public String getClusterName() {
		return clusterName;
	}
	
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
	
	public String getDockerImageName() {
		return dockerImageName;
	}
	
	
	public void setDockerImageName(String dockerImageName) {
		this.dockerImageName = dockerImageName;
	}
    
	
    
    
}
