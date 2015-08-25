package com.ziroom.module.customer.service;

import java.util.ArrayList;
import java.util.List;

import com.common.bean.SearchBean;
import com.common.hibernate.Filter;
import com.common.hibernate.Parmater;
import com.ziroom.common.connector.ConditionInterface;
import com.ziroom.common.connector.impl.SettingParameters;
import com.ziroom.common.manager.JobManager;
import com.ziroom.common.manager.SessionManager;
import com.ziroom.module.system.vo.UserVo;

/**
 * 
 * @author 孙树林
 */
public class UserAppointmentConditionInterface extends SettingParameters implements ConditionInterface {

	public void handlerCondition(SearchBean searchBean) {

	}

	public List<Filter> handlerFilter() {
		// 获得登录用户信息
		UserVo userVo = SessionManager.getSessionUser();
		String setidJobcode = userVo.getSetidJobcode();
		// 查询权限过滤器
		List<Filter> filters = new ArrayList<Filter>();
		Filter filter = new Filter();
		if (setidJobcode != null && !setidJobcode.equals("") && setidJobcode.equals(JobManager.JOB_ZY)) {
			filter.setFilterName("appointmentFirst");
			filter.addParmater(new Parmater("staffid", userVo.getStaffid()));
		} else {
			filter.setFilterName("manager");
			filter.addParmater(new Parmater("deptCode", "%" + userVo.getDeptCode() + "%"));
		}
		filters.add(filter);
		return filters;
	}

}
