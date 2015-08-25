package com.ziroom.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.common.bean.SearchBean;
import com.common.util.ResourceManager;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ziroom action 基类
 * 
 * @author 孙树林
 * 
 */
public class ZiroomAction extends ActionSupport {

	private static final long serialVersionUID = -2442417820338113634L;

	public static final String ERROR = "error";
	/** 处理放回界面的消息内容 */
	protected String msg;
	/** 系统菜单编号 */
	protected String menuCode;
	
	/**
	 * response out
	 * 
	 * @param str
	 * @throws IOException
	 */
	protected void out(String str) throws IOException {
		HttpServletResponse response = getResponse();
		response.setContentType("text/xml");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(str);
		out.close();
	}

	/**
	 * 输出json字符串
	 * 
	 * @param str
	 * @throws Exception
	 */
	protected void json(Object o) throws Exception {
		HttpServletResponse response = getResponse();
		response.setContentType("text/xml");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/html; charset=utf-8");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(o));
		out.close();
	}

	/**
	 * 设置每页显示记录数
	 */
	public void setPageBeanSize(SearchBean searchBean, String key) {
		searchBean.getPageBean().setPageSize(ResourceManager.getInt(key));
	}

	/**
	 * 设置actionmessage信息
	 * 
	 */
	public void addMessage(String msg) {
		this.msg = msg;
	}

	/**
	 * request
	 * 
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * response
	 * 
	 * @return
	 */
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * servletContext
	 * 
	 * @return
	 */
	protected ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
}