package com.ziroom.module.customer.service;

import java.util.List;

import com.ziroom.common.connector.ConditionInterface;
import com.ziroom.common.manager.JobManager;
import com.ziroom.common.manager.SessionManager;
import com.ziroom.module.customer.dao.UserAppointmentDao;
import com.ziroom.module.customer.vo.UserAppointmentVo;
import com.ziroom.module.system.vo.UserVo;

/**
 * 用户业务处理类
 * 
 * @author 孙树林
 */
public class UserAppointmentService {

	public UserAppointmentDao userAppointmentDao;

	private ConditionInterface userAppointmentConditionInterface;

	/**
	 * 查询客户资料
	 * 
	 * @throws Exception
	 */
	public void searchUserAppointment(UserAppointmentVo userAppointmentVo) throws Exception {
		// 获得登录用户信息
		UserVo userVo = SessionManager.getSessionUser();
		String setidJobcode = userVo.getSetidJobcode();
		String staffid = null;
		if (setidJobcode != null && !setidJobcode.equals("") && setidJobcode.equals(JobManager.JOB_ZY)) {
			staffid = userVo.getStaffid();
		}
		userAppointmentConditionInterface.handlerCondition(userAppointmentVo);

		List<UserAppointmentVo> userAppointmentVoes = userAppointmentDao.searchUserAppointment(userAppointmentVo,
				userAppointmentConditionInterface.handlerFilter(), staffid);
		userAppointmentVo.setUserAppointmentVoes(userAppointmentVoes);
	}

	/**
	 * 查找
	 * 
	 * @param userAppointmentVo
	 * @throws Exception
	 */
	public void findUserAppointment(UserAppointmentVo userAppointmentVo) throws Exception {
		userAppointmentDao.findUserAppointment(userAppointmentVo);
	}

	/**
	 * 编辑
	 * 
	 * @param userAppointmentVo
	 * @throws Exception
	 */
	public void saveUserAppointment(UserAppointmentVo userAppointmentVo) throws Exception {
		userAppointmentDao.saveUserAppointment(userAppointmentVo);
	}

	public void setUserAppointmentDao(UserAppointmentDao userAppointmentDao) {
		this.userAppointmentDao = userAppointmentDao;
	}

	public void setUserAppointmentConditionInterface(ConditionInterface userAppointmentConditionInterface) {
		this.userAppointmentConditionInterface = userAppointmentConditionInterface;
	}
}
