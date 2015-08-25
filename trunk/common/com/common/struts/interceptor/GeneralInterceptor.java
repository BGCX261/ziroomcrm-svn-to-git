package com.common.struts.interceptor;

import org.apache.struts2.ServletActionContext;

import com.common.exception.GeneralException;
import com.common.manager.GeneralManager;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * struts2拦截器类，用来处理日志，异常等内容
 * 
 * @author 孙树林
 * 
 */
public class GeneralInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -3802649958215518533L;

	/** 异常处理 */
	private final String RESULT_ERROR_PAGE = "errorPage";

	/**
	 * 程序拦截器，用来处理日志
	 * 
	 * @param actionInvocation
	 * @return
	 * @throws Exception
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		GeneralManager generalManager = new GeneralManager(ServletActionContext.getRequest());
		// 管理类保存线程中，是在整个请求中保存唯一管理类
		GeneralManager.setCurrentManager(generalManager);
		// 开始请求处理
		generalManager.preProcess();
		try {
			return actionInvocation.invoke();
		} catch (Exception e) {
			GeneralException exception = new GeneralException(e);
			ValueStack stack = actionInvocation.getStack();
			stack.set("ex", exception);
			generalManager.processException(exception);
			e.printStackTrace();
			return RESULT_ERROR_PAGE;
		} finally {
			// 请求处理结束
			generalManager.postProcess();
		}
	}

}
