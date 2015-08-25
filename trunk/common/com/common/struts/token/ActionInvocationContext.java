package com.common.struts.token;

import java.io.Serializable;

import com.opensymphony.xwork2.ActionInvocation;

/**
 * @author 孙树林
 * 
 */
public class ActionInvocationContext implements Serializable {

	private static final long serialVersionUID = -1198992358960202204L;

	private ActionInvocation invocation;
	private String token;

	public ActionInvocationContext(ActionInvocation invocation, String token) {
		this.invocation = invocation;
		this.token = token;
	}

	/**
	 * @return the invocation
	 */
	public ActionInvocation getInvocation() {
		return invocation;
	}

	/**
	 * @param invocation
	 *            the invocation to set
	 */
	public void setInvocation(ActionInvocation invocation) {
		this.invocation = invocation;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
}
