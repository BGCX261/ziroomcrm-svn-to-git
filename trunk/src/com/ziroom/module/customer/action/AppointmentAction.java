package com.ziroom.module.customer.action;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.customer.service.AppointmentService;
import com.ziroom.module.customer.vo.AppointmentVo;

/**
 * 带看单请求处理类
 * 
 * @author 孙树林
 */
public class AppointmentAction extends ZiroomAction {

	private static final long serialVersionUID = -4902428016200994880L;

	private AppointmentVo appointmentVo = new AppointmentVo();

	private AppointmentService appointmentService;

	/**
	 * 查询待看单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String searchAppointment() throws Exception {
		appointmentService.searchAppointment(appointmentVo);
		return SUCCESS;
	}

	/**
	 * 查找待看单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findAppointment() throws Exception {
		appointmentService.findAppointment(appointmentVo);
		return SUCCESS;
	}

	/**
	 * 更新客户资料
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveAppointment() throws Exception {
		appointmentService.saveAppointment(appointmentVo);
		return SUCCESS;
	}

	public AppointmentVo getAppointmentVo() {
		return appointmentVo;
	}

	public void setAppointmentVo(AppointmentVo appointmentVo) {
		this.appointmentVo = appointmentVo;
	}

	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
}
