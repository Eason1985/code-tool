package com.absmybatis.exception;

/**
 * 数据持久层异常
 * @author shuzhiyun
 *
 */
public class BaseDtoException extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String exceptionCode  ; 
	String message ; 
	
	
	public BaseDtoException() {
		super();
	}
	public BaseDtoException(String exceptionCode ,String message ) {
		super();
		this.exceptionCode = exceptionCode; 
		this.message = message ; 
	}
	public BaseDtoException(String exceptionCode ,String message, Throwable cause ) {
		super();
		super.initCause(cause);
		this.exceptionCode = exceptionCode; 
		this.message = message ; 
	}
	 
	public BaseDtoException(String message, Throwable cause) {
		super(message);
		super.initCause(cause);
	}
	
	public BaseDtoException(String message) {
		super(message);
	}

	public BaseDtoException(Throwable cause) {
		super.initCause(cause);
	}
	
}
