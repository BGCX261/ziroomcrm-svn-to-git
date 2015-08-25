package com.common.struts.token;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;

/**
 * @author 孙树林
 * 
 */
public class InvocationStore {

	private static final String INVOCATION_MAP_KEY = "RTS.TOKEN.SESSION";

	/**
	 * 
	 * @param tokenName
	 * @param token
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	public static ActionInvocation loadInvocation(String tokenName, String token) {
		Map session = ActionContext.getContext().getSession();
		Map invocationMap = (Map) session.get(INVOCATION_MAP_KEY);
		if (invocationMap == null) {
			invocationMap = new HashMap();
			session.put(INVOCATION_MAP_KEY, invocationMap);
		}
		ActionInvocationContext context = (ActionInvocationContext) invocationMap.get(tokenName);
		if ((context == null) || !context.getToken().equals(token)) {
			return null;
		}
		return context.getInvocation();
	}
	
	@SuppressWarnings({"unchecked" })
	public static void putInvocation(ActionInvocation invocation, String token, String tokenName) {
		Map session = ActionContext.getContext().getSession();
		Map invocationMap = (Map) session.get(INVOCATION_MAP_KEY);
		if (invocationMap == null) {
			invocationMap = new HashMap();
			session.put(INVOCATION_MAP_KEY, invocationMap);
		}
		ActionInvocationContext context = new ActionInvocationContext(invocation, token);
		invocationMap.put(tokenName, context);
	}
}
