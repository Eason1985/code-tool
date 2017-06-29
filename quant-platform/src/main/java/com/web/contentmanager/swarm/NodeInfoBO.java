package com.web.contentmanager.swarm;

public class NodeInfoBO {

	private String nodeId ; 
	
	private String ip ; 
	
	private String hostName ;

	public String getNodeId() {
		return nodeId;
	}

	public NodeInfoBO(String nodeId, String ip, String hostName) {
		super();
		this.nodeId = nodeId;
		this.ip = ip;
		this.hostName = hostName;
	}



	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	} 
	
	
}
