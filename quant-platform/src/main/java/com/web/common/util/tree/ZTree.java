package com.web.common.util.tree;

import java.util.List;

public class ZTree {
	
	public ZTree(String id_,String pid,String name,String code_,boolean checked,String resource_addr)
	{
		this.id_ = id_;
		this.name = name;
		this.pid = pid;
		this.code_ = code_;
		this.checked = checked;
		this.resource_addr = resource_addr;
	}
	
	public ZTree(String id_, String name, String pid, String code_,
			boolean open) {
		super();
		this.id_ = id_;
		this.name = name;
		this.pid = pid;
		this.code_ = code_;
		this.open = open;
	}

	private String id_;//树id
	private String name;//显示的内容
	private String pid; //父级id
	private String code_;//编码
	private String resource_addr ; 
	private boolean open = true ;//是否是叶子节点
	private boolean checked;//选中状态 
	private List<ZTree> children;//子数据集合
	
	 
	public String getResource_addr() {
		return resource_addr;
	}
	public void setResource_addr(String resource_addr) {
		this.resource_addr = resource_addr;
	}
	public void setLeaf(boolean open) {
		this.open = open;
	}
	public String getId_() {
		return id_;
	}
	public void setId(String id_) {
		this.id_ = id_;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public List<ZTree> getChildren() {
		return children;
	}
	public void setChildren(List<ZTree> children) {
		this.children = children;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode_() {
		return code_;
	}
	public void setCode(String code_) {
		this.code_ = code_;
	}
	public boolean getChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public boolean getOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	
	
}
