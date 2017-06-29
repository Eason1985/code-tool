package com.web.common.util.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreeUtil {
	
	
	
	
	 /**
	  * 转换为树集合
	  * @param data
	  * @return
	  */
	 public static Tree  convertTResSelfRelaToTree(List<Map> data)
	 {
		 List<Tree> treeList = new ArrayList<Tree>();
		 for(Map map:data){
			 Tree tree = new Tree(map.get("CHILD_RES_ID").toString()
					 	,map.get("PARENT_RES_ID").toString()
					 	,map.get("RES_NAME").toString()
					 	,map.get("RES_CODE").toString()
					 	,map.get("CHECKED").toString().equals("true")?true:false
					 	,map.get("RESOURCE_ADDR")==null?"":map.get("RESOURCE_ADDR").toString());
			 treeList.add(tree);
		 }
		 if(treeList.size()==0) return new Tree("","","","",false,"") ; 
		 return  getTreeStructure(treeList) ;
	 }
	 
	 /**
	  * 转换为树集合
	  * @param data
	  * @return
	  */
	 public static Tree  convertTResSelfRelaToTree1(List<Map> data)
	 {
		 List<Tree> treeList = new ArrayList<Tree>();
		 for(Map map:data){
			 Tree tree = new Tree(map.get("CHILD_RES_ID").toString()
					 	,map.get("PARENT_RES_ID").toString()
					 	,map.get("RES_NAME").toString()
					 	,map.get("RES_CODE").toString()
					 	,map.get("ISLEAF").toString().equals("true")?true:false
					 	,map.get("RESOURCE_ADDR")==null?"":map.get("RESOURCE_ADDR").toString());
			 treeList.add(tree);
		 }
		 if(treeList.size()==0) return new Tree("","","","",false,"") ; 
		 return  getTreeStructure(treeList) ;
	 }
	 
	 
	/**
	 * 以根节点为基点，向下组装树结构
	 * @return
	 */
	private  static void assemblyTree(Tree rootTree,List<Tree> treeList)
	{
		//获取子节点
		List<Tree> children = new ArrayList<Tree>();
		for(int i = 0;i<treeList.size();i++)
		{
			Tree tree = treeList.get(i);
			if(tree.getPid().equals(rootTree.getId()))
			{
				children.add(tree);
			}
		}
		//只让子节点有选中状态，主要为了配合前台树控件的半选效果。
		if(children.size() > 0)
		{
			rootTree.setChecked(false);
		}
		rootTree.setChildren(children);
		if(children.size()>0){
			rootTree.setIsLeaf(false);
		}
		//递归获取节点
		for(int i = 0;i<children.size();i++)
		{
			Tree childTree = children.get(i);
			assemblyTree(childTree,treeList);
		}
	}
	
	/**
	 * 获取组装好的树结构
	 * @param treeList
	 * @return
	 */
	public static Tree getTreeStructure(List<Tree> treeList)
	{
		//获取根节点,默认为第一个
		Tree rootTree = treeList.get(0);
		assemblyTree(rootTree,treeList);
		return rootTree;
	}
	
	
	
	
	public static void main(String[] args) {
//		Tree tree = new Tree("1","0","一级");
//		Tree tree2 = new Tree("101","1","二级-1");
//		Tree tree3 = new Tree("10101","101","三级");
//		Tree tree21 = new Tree("102","1","二级-2");
//		List<Tree> treeList2 = new ArrayList<Tree>();
//		treeList2.add(tree);
//		treeList2.add(tree2);
//		treeList2.add(tree3);
//		treeList2.add(tree21);
//		
//		
//		Tree tvo = getTreeStructure(treeList2);
//		
//		
//		
//		
//		
////		List<Tree> treeList2 = new ArrayList<Tree>();
////		
////		treeList1.add(tree3);
////		tree2.setChildren(treeList1);
////		treeList2.add(tree2);
////		treeList2.add(tree21);
////		tree.setChildren(treeList2);
//		
//		
//	
//		JSONObject jsonObject = new JSONObject();
//		System.out.println(jsonObject.fromObject(tvo).toString());
		
	}
}
