package com.web.contentmanager.swarm.assitobj;

import java.io.Serializable;
import java.util.Map;

public class TaskSpec  implements Serializable {

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String 			     Image ; // (必填) - 镜像 
	private Map<String,String>   Labels ; // (可选) - 实例标签
	private String[]  			 Command ; //(可选) - 启动命令
	private String[]  			 Env ; //  (可选) - 环境变量
	private String   			 User ;  //(可选) - 用户
	private Mount[]  			 Mounts ;//  (可选) - 目录挂载
	private Resources			 LimitResources;//   (可选) - 资源限制
	private String[] 			 Constraints;// (可选) - 调度约束条件
	private String   			 NetworkMode ;//   (可选) - 网络模式
	
	
	public TaskSpec(String image) {
		super();
		Image = image;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public Map getLabels() {
		return Labels;
	}
	public void setLabels(Map labels) {
		Labels = labels;
	}
	public String[] getCommand() {
		return Command;
	}
	public void setCommand(String[] command) {
		Command = command;
	}
	public String[] getEnv() {
		return Env;
	}
	public void setEnv(String[] env) {
		Env = env;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public Mount[] getMounts() {
		return Mounts;
	}
	public void setMounts(Mount[] mounts) {
		Mounts = mounts;
	}
	public Resources getLimitResources() {
		return LimitResources;
	}
	public void setLimitResources(Resources limitResources) {
		LimitResources = limitResources;
	}
	public String[] getConstraints() {
		return Constraints;
	}
	public void setConstraints(String[] constraints) {
		Constraints = constraints;
	}
	public String getNetworkMode() {
		return NetworkMode;
	}
	public void setNetworkMode(String networkMode) {
		NetworkMode = networkMode;
	}
	
	

}
