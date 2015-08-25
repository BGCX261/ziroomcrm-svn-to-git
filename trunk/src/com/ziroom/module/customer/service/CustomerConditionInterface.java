package com.ziroom.module.customer.service;

import java.util.ArrayList;
import java.util.List;

import com.common.bean.ArgumentsBean;
import com.common.bean.SearchBean;
import com.common.hibernate.Filter;
import com.ziroom.common.connector.ConditionInterface;
import com.ziroom.common.connector.impl.SettingParameters;
import com.ziroom.common.manager.JobManager;
import com.ziroom.common.manager.SessionManager;
import com.ziroom.module.system.vo.UserVo;

/**
 *
 * @author 孙树林
 */
public class CustomerConditionInterface extends SettingParameters implements ConditionInterface {

	public void handlerCondition(SearchBean searchBean) {
		
		// 处理简单查询条件
		List<ArgumentsBean> argumentsBeans = searchBean.getArgumentsBeans();
		for (int i = 0; i < argumentsBeans.size(); i++) {
			ArgumentsBean argumentsBean = argumentsBeans.get(i);
			String value = null;
			String param = null;
			if (argumentsBean == null && argumentsBean.getValues() == null && argumentsBean.getValues().get(0) == null
					&& argumentsBean.getValues().size() == 0 && argumentsBean.getValues().get(0).equals("")) {
				continue;
			} else {
				value = argumentsBean.getValues().get(0);
			}
			if (value == null || "".equals(value)) {
				continue;
			}
			switch (i) {
			case 0:
				// 姓名
				param = "t.custName='" + value + "'";
				break;
			case 1:
				// 证件号
				param = "t.certNum='" + value + "'";
				break;
			case 2:
				// 手机号
				param = "t.phone='" + value + "'";
				break;
			case 3:
				// 管家名称
				param = "u.staffid='" + value + "'";
				break;
			case 4:
				// 区域
				param = "h.counties='" + value + "'";
				break;
			case 5:
				// 商圈
				param = "h.shopping='" + value + "'";
				break;
			}
			argumentsBean.setParamName(param);
		}

	}

	public List<Filter> handlerFilter() {
		// 获得登录用户信息
		UserVo userVo = SessionManager.getSessionUser();
		String setidJobcode = userVo.getSetidJobcode();
		// 查询权限过滤器
		List<Filter> filters = new ArrayList<Filter>();
		Filter filter = new Filter();
		if (setidJobcode != null && !setidJobcode.equals("") && setidJobcode.equals(JobManager.JOB_ZY)) {
			filter.setFilterName("u.staffid='" + userVo.getStaffid() + "'");
		} else {
			filter.setFilterName("u.deptPath  like '%" + userVo.getDeptCode() + "%'");
		}
		filters.add(filter);
		filters.add(filter);
		return filters;
	}

}

