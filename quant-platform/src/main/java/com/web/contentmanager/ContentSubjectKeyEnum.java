package com.web.contentmanager;


/**
 * 
 * 内容主题管理集
 * 
 * 具体内容 key值 
 * redis中的信息key 
 * 
 * @author shuzhiyun
 *
 */
public enum ContentSubjectKeyEnum   {
	
	/**
	 * 客户docker信息   ip为客户端的ip值：clientIp
	 */
	CLIENT_DOCKER_DYNAMIC_PROXY_ADDRESS("dynamicProxyAddr_{ip}","客户docker代理信息,数据格式为： docerip:port","REDIS") ,
	/**
	 * 客户最后一次访问docker时间   ip为客户端的ip值：clientIp
	 */
	CLIENT_LAST_VISIT_DOCKER_TIME("lastVisitDockerTime_{ip}","最后一次访问docker时间,数据格式为： yyyyMMddHH24mmss","REDIS") ,
	/**
	 * docker容器池list的信息
	 */
	DOCKER_CONTAINER_POOL_SET("dockerContainerPoolSet","docker容器池Set的信息,元素数据格式为： clientIp,dockerId","REDIS") ,
	//该路径是需要挂载到docker容器 路径
	CLIENT_FILE_PTAH("clientFileTotalPtah","客户文件总路径配置，数据格式为: /**/**","SYSPROPERTY") ,
	//代理notebook的地址，一般是nginx地址。如果没有ngxin，那么就是notebook地址
	PROXY_NOTEBOOK_ADDRESS("proxyNotebookAddress","代理notebook的地址,格式为： //http://域名:80","SYSPROPERTY") ,
	
	SWARM_CLUSTER_NAME("clusterName", "docke容器集群名称", "SYSPROPERTY"),

	SWARM_ADDRESS("swarmAddress", "docke容器集群地址,格式：http://ip:端口", "SYSPROPERTY"),

	DOCKER_IMAGE_NAME("dockerImageName", "docker镜像名", "SYSPROPERTY"),
	;
	
	//数据主题
	private String subjectKey ;
	//描述
	private String describe ; 
	//数据载体，表示数据从哪儿获取
	private String dataCarrier ;
	
	ContentSubjectKeyEnum(String subject , String describe ,  String dataCarrier ){
		this.subjectKey = subject ; 
		this.describe = describe ; 
		this.dataCarrier = dataCarrier  ; 
	}

	
	public String getDescribe() {
		return describe;
	}


	public void setDescribe(String describe) {
		this.describe = describe;
	}


	public String getSubjectKey() {
		return subjectKey;
	}

	public void setSubjectKey(String subjectKey) {
		this.subjectKey = subjectKey;
	}

	public String getDataCarrier() {
		return dataCarrier;
	}

	public void setDataCarrier(String dataCarrier) {
		this.dataCarrier = dataCarrier;
	}

}
