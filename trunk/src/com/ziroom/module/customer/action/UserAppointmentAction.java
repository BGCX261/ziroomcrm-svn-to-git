package com.ziroom.module.customer.action;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.customer.service.UserAppointmentService;
import com.ziroom.module.customer.vo.UserAppointmentVo;

/**
 * 用户请求处理类
 * 
 * @author 孙树林
 */
public class UserAppointmentAction extends ZiroomAction {

	private static final long serialVersionUID = 4072450994243376880L;

	private UserAppointmentVo userAppointmentVo = new UserAppointmentVo();

	private UserAppointmentService userAppointmentService;

	/**
	 * 查询客户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String searchUserAppointment() throws Exception {
		userAppointmentService.searchUserAppointment(userAppointmentVo);
		return SUCCESS;
	}

	/**
	 * 查找用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findUserAppointment() throws Exception {
		userAppointmentService.findUserAppointment(userAppointmentVo);
		return SUCCESS;
	}

	/**
	 * 编辑用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editUserAppointment() throws Exception {
		userAppointmentService.saveUserAppointment(userAppointmentVo);
		return SUCCESS;
	}

	public UserAppointmentVo getUserAppointmentVo() {
		return userAppointmentVo;
	}

	public void setUserAppointmentVo(UserAppointmentVo userAppointmentVo) {
		this.userAppointmentVo = userAppointmentVo;
	}

	public void setUserAppointmentService(UserAppointmentService userAppointmentService) {
		this.userAppointmentService = userAppointmentService;
	}
}
