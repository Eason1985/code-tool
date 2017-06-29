package com.web.facade;

public class AbsResponse {
	
	public static final String SUCCESS = "00000000"; 
	
	public static final String NO_LOGIN_ERROR = "00000001"; 
	public static final String BUS_ERROR = "00000002"; 
	public static final String PARAMERROR = "99999999"; //参数错误
	public static final String SYSTEMERROR = "99999998"; //系统错误
	
	/**
	 * 	该值只表示服务运行正常。不能作为业务逻辑判断
	 */
	private String returnCode =  SUCCESS; 
	
	private String message = "成功";

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
	
	
	
}
