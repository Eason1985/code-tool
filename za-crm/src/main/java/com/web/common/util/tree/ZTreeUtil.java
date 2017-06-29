package com.web.common.util.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZTreeUtil {
	
	
	
	
	 /**
	  * 转换为树集合
	  * @param data
	  * @return
	  */
	 public static ZTree  convertTResSelfRelaToZTree(List<Map> data)
	 {
		 List<ZTree> ZTreeList = new ArrayList<ZTree>();
		 for(Map map:data){
			 ZTree ZTree = new ZTree(map.get("CHILD_RES_ID").toString()
					 	,map.get("PARENT_RES_ID").toString()
					 	,map.get("RES_NAME").toString()
					 	,map.get("RES_CODE").toString()
					 	,map.get("CHECKED").toString().equals("true")?true:false
					 	,map.get("RESOURCE_ADDR")==null?"":map.get("RESOURCE_ADDR").toString());
			 ZTreeList.add(ZTree);
		 }
		 if(ZTreeList.size()==0) return new ZTree("","","","",false,"") ; 
		 return  getZTreeStructure(ZTreeList) ;
	 }
	 
	 /**
	  * 转换为树集合
	  * @param data
	  * @return
	  */
	 public static ZTree  convertTResSelfRelaToZTree1(List<Map> data)
	 {
		 List<ZTree> ZTreeList = new ArrayList<ZTree>();
		 for(Map map:data){
			 ZTree ZTree = new ZTree(map.get("CHILD_RES_ID").toString()
						 ,map.get("RES_NAME").toString()
						 ,map.get("PARENT_RES_ID").toString()
					 	,map.get("RES_CODE").toString()
					 	,map.get("ISLEAF").toString().equals("true")?true:false);
			 ZTreeList.add(ZTree);
		 }
		 if(ZTreeList.size()==0) return new ZTree("","","","",false,"") ; 
		 return  getZTreeStructure(ZTreeList) ;
	 }
	 
	 
	/**
	 * 以根节点为基点，向下组装树结构
	 * @return
	 */
	private  static void assemblyZTree(ZTree rootZTree,List<ZTree> ZTreeList)
	{
		//获取子节点
		List<ZTree> children = new ArrayList<ZTree>();
		for(int i = 0;i<ZTreeList.size();i++)
		{
			ZTree ZTree = ZTreeList.get(i);
			if(ZTree.getPid().equals(rootZTree.getId_()))
			{
				children.add(ZTree);
			}
		}
		//只让子节点有选中状态，主要为了配合前台树控件的半选效果。
		if(children.size() > 0)
		{
			rootZTree.setChecked(false);
		}
		rootZTree.setChildren(children);
		if(children.size()>0){
//			rootZTree.setIsLeaf(false);
		}
		//递归获取节点
		for(int i = 0;i<children.size();i++)
		{
			ZTree childZTree = children.get(i);
			assemblyZTree(childZTree,ZTreeList);
		}
	}
	
	/**
	 * 获取组装好的树结构
	 * @param ZTreeList
	 * @return
	 */
	public static ZTree getZTreeStructure(List<ZTree> ZTreeList)
	{
		//获取根节点,默认为第一个
		ZTree rootZTree = ZTreeList.get(0);
		assemblyZTree(rootZTree,ZTreeList);
		return rootZTree;
	}
	
	
	
	
	public static void main(String[] args) {
//		ZTree ZTree = new ZTree("1","0","一级");
//		ZTree ZTree2 = new ZTree("101","1","二级-1");
//		ZTree ZTree3 = new ZTree("10101","101","三级");
//		ZTree ZTree21 = new ZTree("102","1","二级-2");
//		List<ZTree> ZTreeList2 = new ArrayList<ZTree>();
//		ZTreeList2.add(ZTree);
//		ZTreeList2.add(ZTree2);
//		ZTreeList2.add(ZTree3);
//		ZTreeList2.add(ZTree21);
//		
//		
//		ZTree tvo = getZTreeStructure(ZTreeList2);
//		
//		
//		
//		
//		
////		List<ZTree> ZTreeList2 = new ArrayList<ZTree>();
////		
////		ZTreeList1.add(ZTree3);
////		ZTree2.setChildren(ZTreeList1);
////		ZTreeList2.add(ZTree2);
////		ZTreeList2.add(ZTree21);
////		ZTree.setChildren(ZTreeList2);
//		
//		
//	
//		JSONObject jsonObject = new JSONObject();
//		System.out.println(jsonObject.fromObject(tvo).toString());
		
	}
}
