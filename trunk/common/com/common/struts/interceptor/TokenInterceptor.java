package com.common.struts.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import com.common.struts.token.InvocationStore;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 重复提交拦截器，处理当请求连接重复提交处理方式
 * 
 * @author 孙树林
 * 
 */
public class TokenInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1279677633785844688L;

	/**
	 * 重复提交拦截器处理方法
	 * 
	 * @param invocation
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ac = invocation.getInvocationContext();

		HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		String tokenName = TokenHelper.getTokenName();
		String token = TokenHelper.getToken(tokenName);

		// 清除参数列表中的令牌环
		if (tokenName != null && token != null) {
			Map params = ac.getParameters();
			params.remove(tokenName);
			params.remove(TokenHelper.TOKEN_NAME_FIELD);
		}

		if ((tokenName != null) && (token != null)) {
			ActionInvocation actionInvocation = InvocationStore.loadInvocation(tokenName, token);
			if (actionInvocation != null) {
				ValueStack stack = actionInvocation.getStack();
				Map context = stack.getContext();
				request.setAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY, stack);
				ActionContext savedContext = actionInvocation.getInvocationContext();
				savedContext.getContextMap().put(ServletActionContext.HTTP_REQUEST, request);
				savedContext.getContextMap().put(ServletActionContext.HTTP_RESPONSE, response);
				Result result = actionInvocation.getResult();
				if ((result != null) && (actionInvocation.getProxy().getExecuteResult())) {
					synchronized (context) {
						result.execute(actionInvocation);
					}
				}
				invocation.getProxy().setExecuteResult(false);

				return actionInvocation.getResultCode();
			} else {
				InvocationStore.putInvocation(invocation, token, tokenName);
			}
		}
		return invocation.invoke();
	}

}
