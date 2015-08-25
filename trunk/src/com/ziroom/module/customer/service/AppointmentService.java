package com.ziroom.module.customer.service;

import java.util.List;

import com.ziroom.common.connector.ConditionInterface;
import com.ziroom.module.customer.dao.AppointmentDao;
import com.ziroom.module.customer.vo.AppointmentVo;

/**
 * 待看单业务处理类
 * 
 * @author 孙树林
 */
public class AppointmentService {

	private AppointmentDao appointmentDao;

	private ConditionInterface appointmentConditionInterface;

	/**
	 * 查询待看单
	 * 
	 * @param appointmentVo
	 * @throws Exception
	 */
	public void searchAppointment(AppointmentVo appointmentVo) throws Exception {
		appointmentConditionInterface.handlerCondition(appointmentVo);
		List<AppointmentVo> appointmentVoes = appointmentDao.searchAppointment(appointmentVo,
				appointmentConditionInterface.handlerFilter());
		appointmentVo.setAppointmentVoes(appointmentVoes);
	}

	/**
	 * 查找待看单
	 * 
	 * @param appointmentVo
	 * @throws Exception
	 */
	public void findAppointment(AppointmentVo appointmentVo) throws Exception {
		appointmentDao.findAppointment(appointmentVo);
	}

	/**
	 * 保存信息
	 * 
	 * @param appointmentVo
	 * @throws Exception
	 */
	public void saveAppointment(AppointmentVo appointmentVo) throws Exception {
		appointmentDao.saveAppointment(appointmentVo);
	}

	public void setAppointmentDao(AppointmentDao appointmentDao) {
		this.appointmentDao = appointmentDao;
	}

	public void setAppointmentConditionInterface(ConditionInterface appointmentConditionInterface) {
		this.appointmentConditionInterface = appointmentConditionInterface;
	}
}
