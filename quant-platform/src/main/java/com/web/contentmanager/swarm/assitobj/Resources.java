package com.web.contentmanager.swarm.assitobj;

import java.io.Serializable;

public class Resources  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int nanoCPUs ; //   (可选)CPU配额
	private int memoryMB ; //   (可选) 内存限制
	
	
	
	public Resources(int nanoCPUs, int memoryMB) {
		super();
		this.nanoCPUs = nanoCPUs;
		this.memoryMB = memoryMB;
	}
	public int getNanoCPUs() {
		return nanoCPUs;
	}
	public void setNanoCPUs(int nanoCPUs) {
		this.nanoCPUs = nanoCPUs;
	}
	public int getMemoryMB() {
		return memoryMB;
	}
	public void setMemoryMB(int memoryMB) {
		this.memoryMB = memoryMB;
	}
	

}
