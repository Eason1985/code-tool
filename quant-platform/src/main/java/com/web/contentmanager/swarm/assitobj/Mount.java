package com.web.contentmanager.swarm.assitobj;

import java.io.Serializable;

public class Mount  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String Source ; //  - 主机目录
	private String Target ; //  - 容器目录
	private boolean ReadOnly; // - 是否只读
	
	
	public Mount(String source, String target, boolean readOnly) {
		super();
		Source = source;
		Target = target;
		ReadOnly = readOnly;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getTarget() {
		return Target;
	}
	public void setTarget(String target) {
		Target = target;
	}
	public boolean isReadOnly() {
		return ReadOnly;
	}
	public void setReadOnly(boolean readOnly) {
		ReadOnly = readOnly;
	}
	
	

}
