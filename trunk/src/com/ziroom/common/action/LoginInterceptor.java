package com.ziroom.common.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.ziroom.common.manager.SessionManager;

/**
 * 登录验证拦截器
 * 
 * @author 孙树林
 */
public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -6422047906118037163L;

	/**
	 * 判断用户是否登录系统
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		if(!SessionManager.isLogin()) {
			// 如果用户没有登录系统
			return "return";
		} else {
			return actionInvocation.invoke();
		}
	}

}

