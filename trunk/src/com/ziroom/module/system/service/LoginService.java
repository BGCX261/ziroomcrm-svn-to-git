package com.ziroom.module.system.service;

import com.ziroom.common.manager.SessionManager;
import com.ziroom.module.system.dao.UserDao;
import com.ziroom.module.system.vo.UserVo;

/**
 * 用户登录业务处理类
 * 
 * @author 孙树林
 */
public class LoginService {

	private UserDao userDao;

	/**
	 * 用户登录业务处理方法
	 * 
	 * @param vo
	 * @return
	 */
	public boolean isLogin(UserVo vo) {
		boolean isLogin = false;
		UserVo userVo = userDao.searchUser(vo.getStaffid(), vo.getStaffPass());
		if (userVo != null) {
			isLogin = true;
			// 将用户信息保存至session中
			SessionManager.setSessionUser(userVo);
			// TODO 用户权限，角色处理
		}
		return isLogin;
	}
	
	/**
	 * 退出
	 */
	public void loginOut() {
		SessionManager.remove();
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
