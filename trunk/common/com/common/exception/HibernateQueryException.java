package com.common.exception;

/**
 * hibernate query 异常类
 * 
 * @author Administrator
 * 
 */
public class HibernateQueryException extends RuntimeException {

	private static final long serialVersionUID = 4471086811902983662L;

	public HibernateQueryException() {
		super();
	}

	public HibernateQueryException(String message, Throwable cause) {
		super(message, cause);
	}

	public HibernateQueryException(String message) {
		super(message);
	}

	public HibernateQueryException(Throwable cause) {
		super(cause);
	}

}
