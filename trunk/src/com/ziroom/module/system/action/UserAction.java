package com.ziroom.module.system.action;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.system.service.UserService;
import com.ziroom.module.system.vo.UserVo;

/**
 * 用户请求处理方法
 * 
 * @author 孙树林
 */
public class UserAction extends ZiroomAction {

	private static final long serialVersionUID = 4676923865443155031L;

	private UserVo userVo = new UserVo();

	private UserService userService;

	/**
	 * 查询部门下的人员
	 * 
	 * @throws Exception
	 */
	public void searchUserByDeptCode() throws Exception {
		userVo.setUserVoes(userService.searchUserByDeptAndJob(userVo.getDeptCode(), userVo.getSetidJobcode()));
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}
}
