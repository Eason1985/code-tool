package com.acjkj.importcarmodedataUtil;

import java.util.List;


public class Main {
	public static void main(String[] args) throws Exception {
		ExcelBean bean = new ExcelBean();
		bean.setP_id("1");
		bean.setName("��Ʒ��");
		bean.fillSubExcelBean("C:\\Users\\zou\\Desktop\\���ͺ����.xlsx", "1", 0) ; 
		List<ExcelBean> cc = bean.getSubExcelBean();
		System.out.print("111111111111");
		
	}
}
