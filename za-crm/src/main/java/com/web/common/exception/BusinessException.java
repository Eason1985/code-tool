package com.web.common.exception;


public class BusinessException extends RuntimeException   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String functionCode ; 
	
	private String errorCode  ; 
	
	private String errorMessage ;
	
	/**
	 * 在exceptionMessage_zh_CN.properties中定义errorCode=errorMessage的信息
	 * 如：
	 * 0001=参数错误
	 * 
	 * 0002=参数[%1$s]错误    
	 * %n$s表示该errorMessage需要参数,n表示个数 : 如该errorMessage就需要1个参数
	 * 
	 * 0003=服务%1$s调用有误,原因:%2$s
	 * %n$s表示该errorMessage需要参数,n表示个数 : 如该errorMessage就需要2个参数.以此类推
	 * 
	 * 
	 * @param errorCode
	 * @param errorMessageParam
	 */
	public BusinessException(String errorCode ,String...  errorMessageParam) {
		this.errorCode = errorCode ; 
//		String message = ErrorCodeHandler.getMessageByKey(errorCode);
//		message = String.format(message,errorMessageParam) ;
//		this.errorMessage = message ; 
		this.errorMessage = errorMessageParam[0] ; 
	}
	
	
	
	public BusinessException(String errorCode , String errorMessage, Throwable cause) {
		super(errorMessage);
		super.initCause(cause);
		this.errorCode = errorCode ; 
		this.errorMessage = errorMessage ; 
	}

	public BusinessException( String errorMessage, Throwable cause) {
		super(errorMessage);
		super.initCause(cause);
		this.errorMessage = errorMessage ; 
	}
	
	
	public BusinessException(String errorCode , String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode ; 
		this.errorMessage = errorMessage ; 
	}
	
	public BusinessException(String message) {
		super(message);
		this.errorMessage = message ; 
	}

	public BusinessException(Throwable cause) {
		super.initCause(cause);
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	 
	
	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String toString(){
		return "调用错误："+(functionCode==null?"":("函数:" + functionCode)) 
				+(errorCode==null?"":(",错误代码:"+errorCode)) 
				+",错误信息:"+errorMessage ;
	}
	

	
}
