package com.ziroom.module.customer.dao;

import java.util.List;

import com.common.hibernate.Filter;
import com.ziroom.module.customer.vo.UserAppointmentVo;

/**
 * 客户数据访问接口
 * 
 * @author 孙树林
 */
public interface UserAppointmentDao {

	/**
	 * 查询用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<UserAppointmentVo> searchUserAppointment(UserAppointmentVo userAppointmentVo, List<Filter> filters, String staffid)
			throws Exception;

	/**
	 * 查找用户
	 * 
	 * @param userAppointmentVo
	 * @throws Exception
	 */
	public void findUserAppointment(UserAppointmentVo userAppointmentVo) throws Exception;

	/**
	 * 保存用户
	 * 
	 * @param userAppointmentVo
	 * @throws Exception
	 */
	public void saveUserAppointment(UserAppointmentVo userAppointmentVo) throws Exception;
}
