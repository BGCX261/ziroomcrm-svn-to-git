package com.common.exception;

/**
 * 异常处理类，所有的异常都通过GeneralException抛出
 * 
 * @author 孙树林
 * 
 */
public class GeneralException extends Exception {

	private static final long serialVersionUID = 5568151140160272224L;

	public GeneralException() {
		super();
	}

	public GeneralException(String message, Throwable cause) {
		super(message, cause);
	}

	public GeneralException(String message) {
		super(message);
	}

	public GeneralException(Throwable cause) {
		super(cause);
	}
}
