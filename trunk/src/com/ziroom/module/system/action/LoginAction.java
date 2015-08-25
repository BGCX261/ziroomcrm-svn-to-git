package com.ziroom.module.system.action;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.system.service.LoginService;
import com.ziroom.module.system.vo.UserVo;

/**
 * 用户登录请求处理类
 * 
 * @author 孙树林
 */
public class LoginAction extends ZiroomAction {

	private static final long serialVersionUID = -5147805173766241314L;

	private LoginService loginService;

	private UserVo vo;

	/**
	 * 用户登录请求
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		if (loginService.isLogin(vo)) {
			return SUCCESS;
		} else {
			return "login";
		}
	}

	/**
	 * 退出
	 * 
	 * @return
	 * @throws Exception
	 */
	public String loginOut() throws Exception {
		return "return";
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public UserVo getVo() {
		return vo;
	}

	public void setVo(UserVo vo) {
		this.vo = vo;
	}
}
