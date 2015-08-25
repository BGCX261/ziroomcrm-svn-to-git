package com.ziroom.common.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ziroom.module.system.vo.UserVo;

/**
 * session管理类，通常用来保存用户信息。
 * 
 * @author 孙树林
 */
public class SessionManager {

	/** 用户信息 */
	public static final String USER_KEY = "user";

	/**
	 * 判断用户是否已经登录
	 * 
	 * @return
	 */
	public static boolean isLogin() {
		boolean isLogin = false;
		if (getSessionUser() != null) {
			isLogin = true;
		} else {
			isLogin = false;
		}
		return isLogin;
	}

	/**
	 * 获得用户信息
	 * 
	 * @return
	 */
	public static UserVo getSessionUser() {
		Object o = getAttr(USER_KEY);
		if (o != null) {
			return (UserVo) o;
		}
		return null;
	}

	/**
	 * 设置用户信息
	 * 
	 * @return
	 */
	public static void setSessionUser(UserVo vo) {
		setAttr(USER_KEY, vo);
	}

	/**
	 * 删除用户信息
	 * 
	 * @return
	 */
	public static void deleteSessionUser(UserVo vo) {
		removeAttr(USER_KEY);
	}

	/**
	 * 保存session属性
	 * 
	 * @param key
	 * @param value
	 */
	public static void setAttr(String key, Object value) {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute(key, value);
	}

	/**
	 * 获得属性
	 * 
	 * @param key
	 * @return
	 */
	public static Object getAttr(String key) {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getSession().getAttribute(key);
	}

	/**
	 * 删除属性
	 * 
	 * @param key
	 */
	public static void removeAttr(String key) {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute(key);
	}

	/**
	 * 销毁用户session
	 * 
	 * @param sessionKey
	 */
	public static void remove() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
	}
}
