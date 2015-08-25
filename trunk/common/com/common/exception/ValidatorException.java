package com.common.exception;

/**
 * struts验证异常处理类
 * 
 * @author 孙树林
 * 
 */
public class ValidatorException extends Exception {

	private static final long serialVersionUID = 1246430664697608801L;

	public ValidatorException() {
		super();
	}

	public ValidatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidatorException(String message) {
		super(message);
	}

	public ValidatorException(Throwable cause) {
		super(cause);
	}
}
