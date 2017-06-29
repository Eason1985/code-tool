package com.acjkj.importcarmodedataUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBean {

	private String id ; 
	private String name ; 
	private String p_id ;
	private List<ExcelBean> subExcelBean  = new ArrayList<ExcelBean>();
	
	public static  int nextRow = 0 ;
	
	public static  XSSFWorkbook xssfWorkbook   = null ; 
	
	/**
	 * 
	 * @param excelPath
	 * @param p_id
	 * @param baseCol ��
	 * @param baseRow ��
	 * @return
	 * @throws Exception
	 */
	public void fillSubExcelBean(String excelPath ,String p_id,int baseCol) throws Exception{
		File file = new File(excelPath);
		if(xssfWorkbook == null ){
			InputStream tempFlie = new FileInputStream(file);
			xssfWorkbook = new XSSFWorkbook(tempFlie);
		}
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0) ;
		boolean isFirstCellAndCellAdd1AllCanNotNull = true ; 
		boolean isChangeLine = false; 
		for( ;nextRow<xssfSheet.getLastRowNum();){
			System.out.println(nextRow);
			XSSFRow xssfRow = xssfSheet.getRow(nextRow);
			Object cellObj = xssfRow.getCell(baseCol);
			Object celladd1Obj = xssfRow.getCell(baseCol+1); 
			Object celladd2Obj = xssfRow.getCell(baseCol+2) ; 
			
			if((cellObj!=null && cellObj.toString().trim().length()!=0)
					&&(celladd1Obj !=null && celladd1Obj.toString().trim().length()!=0)){ 
				//String cell = cellObj.toString() ;
				String celladd1 = celladd1Obj.toString() ;
				if(isFirstCellAndCellAdd1AllCanNotNull){
					ExcelBean bean =new ExcelBean() ; 
					bean.setP_id(p_id);
					bean.setName(celladd1);
					bean.setId(p_id+nextRow+"");
					if(celladd2Obj !=null){
						bean.fillSubExcelBean("C:\\Users\\zou\\Desktop\\���ͺ����.xlsx",p_id+nextRow, baseCol+1) ; 
						this.getSubExcelBean().add(bean);
					}else{
						isChangeLine = true ; 
						nextRow++;
						this.getSubExcelBean().add(bean);
					}
					isFirstCellAndCellAdd1AllCanNotNull = false ; 
				}else{
					break;
				}
			}else if((cellObj==null ||cellObj.toString().trim().length() ==0 ) && celladd1Obj !=null  && celladd1Obj.toString().trim().length()!=0){
				String celladd1 = celladd1Obj.toString() ;
				ExcelBean bean =new ExcelBean() ; 
				bean.setP_id(p_id);
				bean.setName(celladd1 );
				bean.setId(p_id+nextRow+"");
				if(celladd2Obj !=null){
					bean.fillSubExcelBean("C:\\Users\\zou\\Desktop\\���ͺ����.xlsx",p_id+nextRow, baseCol+1) ; 
					this.getSubExcelBean().add(bean);
				}else{
					isChangeLine = true ; 
					nextRow++;
					this.getSubExcelBean().add(bean);
				}
			}else if((cellObj!=null && cellObj.toString().trim().length()!=0)
					&&(celladd1Obj ==null || celladd1Obj.toString().trim().length()==0)){
				if(!isChangeLine){
					nextRow++;
				}
				break ; 
			}else{
				throw new Exception();
			}
		}
		
	}
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public List<ExcelBean> getSubExcelBean() {
		return subExcelBean;
	}
	
}
