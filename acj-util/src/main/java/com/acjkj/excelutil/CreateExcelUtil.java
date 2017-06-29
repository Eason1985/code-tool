package com.acjkj.excelutil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateExcelUtil {
	
	
	/**
	 * fileName :excel文件名称  必填 不要含有输入.xls
	 * sheetName:sheet名称   不填写默认与fileNam一样. 
	 * excelHander:表头    必填
	 * excelDataHandle:表数据  其方法的返回值为HashMap<String,Object>   必填
	 * 
	 * 注意,表头HashMap<String,String>的key与excelDataHandle数据钩子的返回数据HashMap<String,Object>的key是一样的
	 * 如: 
	 *  学生名称, 学生年龄
	 *  exeelHandle 元素有两个,其中之一是: name:学生名称
	 *  excelDataHandle的返回值为: name:张三
	 *  key值必须一样才可以. 
	 *  
	 *  
	 *  页面上需要第一个按钮.触发该按钮后,定义后台的url, 然后本地地址等于该url即可. 
	 *  该url后台对应的controller方法需要调用本方法.
	 * location.href=url; 
	 * 
	 * @throws Exception 
    
	 */
	public static void createExcelForWebUpload(
			String netNo  ,
			String fileName ,//excel文件名称 
			String sheetName ,//sheet名称 
			ExcelDataHandle excelDataHandle ,  //excel data
			HttpServletResponse response
		) throws Exception{
		if(netNo == null ||fileName == null  
				|| excelDataHandle == null ){
			throw new RuntimeException("参数为空") ; 
		}
		OutputStream out = response.getOutputStream();//取得输出流
		response.reset();//清空输出流
		//下面是对中文文件名的处理
		response.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
		fileName = java.net.URLEncoder.encode(fileName,"UTF-8");
		response.setHeader("Content-Disposition","attachment;filename="+new String(fileName.getBytes("UTF-8"),"GBK")+".xls");
		response.setContentType("application/msexcel");//定义输出类型
		createExcel(netNo, fileName, sheetName, excelDataHandle, out);  
		try {
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * fileName :excel文件名称  必填 不要含有输入.xls
	 * sheetName:sheet名称   不填写默认与fileNam一样. 
	 * excelHander:表头    必填
	 * excelDataHandle:表数据  其方法的返回值为HashMap<String,Object>   必填
	 * 
	 * 注意,表头HashMap<String,String>的key与excelDataHandle数据钩子的返回数据HashMap<String,Object>的key是一样的
	 * 如: 
	 *  学生名称, 学生年龄
	 *  exeelHandle 元素有两个,其中之一是: name:学生名称
	 *  excelDataHandle的返回值为: name:张三
	 *  key值必须一样才可以. 
	 *  
	 * @return 文件路径
	 */
	public static void createExcelForCreateFile(
			String netNo  ,
			String fileName ,//excel文件名称 
			String sheetName ,//sheet名称 
			ExcelDataHandle excelDataHandle ,  //excel data
			String filePath  
		) throws FileNotFoundException{
		if(netNo == null ||fileName == null  
				|| excelDataHandle == null ){
			throw new RuntimeException("参数为空") ; 
		}
		File file = new File(filePath+"/"+fileName+".xls");
		FileOutputStream out  = new FileOutputStream (file);
		createExcel(netNo, fileName, sheetName, excelDataHandle, out);
		try {
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * fileName :excel文件名称  必填
	 * sheetName:sheet名称   不填写默认与fileNam一样. 
	 * excelHander:表头    必填
	 * excelDataHandle:表数据  其方法的返回值为HashMap<String,Object>   必填
	 * 
	 * 注意,表头HashMap<String,String>的key与excelDataHandle数据钩子的返回数据HashMap<String,Object>的key是一样的
	 * 如: 
	 *  学生名称, 学生年龄
	 *  exeelHandle 元素有两个,其中之一是: name:学生名称
	 *  excelDataHandle的返回值为: name:张三
	 *  key值必须一样才可以. 
	 *  
	 */
	public static void createExcel(
			String netNo  ,
			String fileName ,//excel文件名称 
			String sheetName ,//sheet名称 
			ExcelDataHandle excelDataHandle ,  //excel data
			OutputStream out
		){
		if(netNo == null ||fileName == null ||  excelDataHandle == null ){
			throw new RuntimeException("参数为空") ; 
		}
		// 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = hSSFWorkbook.createSheet(sheetName == null ?fileName:sheetName);  
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow(0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = hSSFWorkbook.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        ArrayList<String> cellKey = new ArrayList<String>(); 
        LinkedHashMap<String,String> header =  excelDataHandle.obtainExcelHeaderData() ; 
        int headerCell = 0 ; 
        for(Entry<String,String> entry:header.entrySet()){
        	String key = entry.getKey() ; 
        	cellKey.add(key) ; 
        	String headName = entry.getValue() ; 
        	HSSFCell cell = row.createCell(headerCell);  
            cell.setCellValue(headName);  
            cell.setCellStyle(style);  
            headerCell ++ ; 
        }
        // 第六步，将文件存到指定位置  
        try{  
        	circleExcuteData(sheet, cellKey ,excelDataHandle, out, hSSFWorkbook  );
        	hSSFWorkbook.write(out);  
        }catch (Exception e){  
            e.printStackTrace();  
        }
	}

	@SuppressWarnings("rawtypes")
	private static void circleExcuteData(HSSFSheet sheet,
			ArrayList<String> cellKey,
			ExcelDataHandle excelDataHandle,
			OutputStream out ,
			HSSFWorkbook hSSFWorkbook ) throws Exception {
		int rowNum = 0 ; 
		HSSFRow hSSFRow = null ; 
		for(int i = 0 ; ; i++){//开始分页
			if(!excelDataHandle.isPaging() && i >0){//不分页
				return ; 
			}
			List  dataes= excelDataHandle.obtainExcelData(i+1) ;
			if(dataes ==null || dataes.size() == 0){
				return ; 
			}
			if(i >0){
				hSSFWorkbook.write(out);
			}
			for (int j = 0; j < dataes.size(); j++)  
	        {  
				rowNum ++ ; 
				hSSFRow = sheet.createRow(rowNum);  
				for(int r = 0 ; r<cellKey.size() ; r ++ ){
					Map map = new HashMap() ; 
					Object obj = dataes.get(j) ; 
					if(!(obj instanceof HashMap)){
						map = BeanUtils.describe(obj);  
					}else{
						map = (HashMap)obj;
					}
					hSSFRow.createCell(r).setCellValue(map.get(cellKey.get(r))==null?"":map.get(cellKey.get(r)).toString());  
				}
	        }  
		}
	}
}
