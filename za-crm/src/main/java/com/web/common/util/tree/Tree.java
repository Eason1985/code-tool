package com.web.common.util.tree;

import java.util.List;

public class Tree {
	
	public Tree(String id,String pid,String text,String code,boolean checked,String resource_addr)
	{
		this.id = id;
		this.text = text;
		this.pid = pid;
		this.code = code;
		this.checked = checked;
		this.resource_addr = resource_addr;
	}
	
	public Tree(String id, String text, String pid, String code,
			boolean isLeaf) {
		super();
		this.id = id;
		this.text = text;
		this.pid = pid;
		this.code = code;
		this.isLeaf = isLeaf;
	}

	private String id;//树id
	private String text;//显示的内容
	private String pid; //父级id
	private String code;//编码
	private String resource_addr ; 
	private boolean isLeaf = true ;//是否是叶子节点
	private boolean checked;//选中状态 
	private List<Tree> children;//子数据集合
	
	 
	public String getResource_addr() {
		return resource_addr;
	}
	public void setResource_addr(String resource_addr) {
		this.resource_addr = resource_addr;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public List<Tree> getChildren() {
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean getChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public boolean getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	
	
}
