package com.ziroom.module.customer.dao;

import java.util.List;

import com.common.hibernate.Filter;
import com.ziroom.module.customer.vo.AppointmentVo;

/**
 * 带看单数据访问接口
 * 
 * @author 孙树林
 */
public interface AppointmentDao {

	/**
	 * 待看单查询数据访问
	 * 
	 * @param appointmentVo
	 * @return
	 * @throws Exception
	 */
	public List<AppointmentVo> searchAppointment(AppointmentVo appointmentVo, List<Filter> filters) throws Exception;

	/**
	 * 待看单查找数据访问
	 * 
	 * @param appointmentVo
	 * @return
	 * @throws Exception
	 */
	public void findAppointment(AppointmentVo appointmentVo) throws Exception;

	/**
	 * 保存
	 * 
	 * @param appointmentVo
	 * @throws Exception
	 */
	public void saveAppointment(AppointmentVo appointmentVo) throws Exception;
}
