package com.ziroom.module.customer.service;

import java.util.ArrayList;
import java.util.List;

import com.common.bean.ArgumentsBean;
import com.common.bean.SearchBean;
import com.common.enums.DataType;
import com.common.enums.Symbol;
import com.common.hibernate.Filter;
import com.common.hibernate.Parmater;
import com.ziroom.common.connector.ConditionInterface;
import com.ziroom.common.connector.impl.SettingParameters;
import com.ziroom.common.manager.JobManager;
import com.ziroom.common.manager.SessionManager;
import com.ziroom.module.system.vo.UserVo;

/**
 * 带看单查询
 * 
 * @author 孙树林
 */
public class AppointmentConditionInterface extends SettingParameters implements ConditionInterface {

	/**
	 * 带看单查询条件处理
	 */
	public void handlerCondition(SearchBean searchBean) {
		// 处理简单查询条件
		List<ArgumentsBean> argumentsBeans = searchBean.getArgumentsBeans();
		for (int i = 0; i < argumentsBeans.size(); i++) {
			ArgumentsBean argumentsBean = argumentsBeans.get(i);
			String value = null;
			String param = null;
			String type = null;
			String sysbom = null;
			if (argumentsBean == null && argumentsBean.getValues() == null
					&& argumentsBean.getValues().get(0) == null
					&& argumentsBean.getValues().size() == 0
					&& argumentsBean.getValues().get(0).equals("")) {
				continue;
			} else {
				value = argumentsBean.getValues().get(0);
			}
			switch (i) {
			case 0:
				// 带看单号
				param = "id";
				type = DataType.it.getValue();
				sysbom = Symbol.eq.getValue();
				setParameter(argumentsBean, param, type, true, sysbom);
				break;
			case 1:
				// 房间编号查询
				param = "(select concat(t_house.house_code,'-',t_room.room_code) from t_house,t_room where t_house.sys_house_id=t_room.sys_house_id and t_room.room_id=this_.room_id) ='" + value + "'";
				sysbom = Symbol.sql.getValue();
				setParameter(argumentsBean, param, type, true, sysbom);
				break;
			case 2:
				// 提交日期
				param = "printtime";
				type = DataType.dt.getValue();
				sysbom = Symbol.eq.getValue();
				setParameter(argumentsBean, param, type, true, sysbom);
				break;
			case 3:
				// 是否带看
				param = "release";
				type = DataType.s.getValue();
				sysbom = Symbol.eq.getValue();
				setParameter(argumentsBean, param, type, true, sysbom);
				break;
			case 4:
				// 管家
				param = "staffid";
				type = DataType.s.getValue();
				sysbom = Symbol.eq.getValue();
				setParameter(argumentsBean, param, type, true, sysbom);
				break;
			case 5:
				// 主管
				param = "(select count(t_user.dept_path) from t_user where t_user.staffid=this_.staffid and t_user.dept_path like '%"
					+ value + "%') > 0";
				sysbom = Symbol.sql.getValue();
				setParameter(argumentsBean, param, type, true, sysbom);
				break;
			case 6:
				// 优先
//				param = "(select count(t_room.room_id) from t_room where t_room.room_type!='KITCHEN' and t_room.flag !='N' and t_room.sys_house_id=this_.sys_house_id and t_room.is_promotions='" + value + "') > 0";
//				sysbom = Symbol.sql.getValue();
//				break;
			case 7:
				// 推荐
//				param = "(select count(t_room.room_id) from t_room where t_room.room_type!='KITCHEN' and t_room.flag !='N' and t_room.sys_house_id=this_.sys_house_id and t_room.is_top='" + value + "') > 0";
//				sysbom = Symbol.sql.getValue();
				break;
			}
		}
		// 查理复合查询条件
		List<SearchBean> sbs = searchBean.getSearchBeans();
		if(sbs != null && sbs.size() > 0) {
			SearchBean sb =sbs.get(0);
			List<ArgumentsBean> arguments = sb.getArgumentsBeans();
			ArgumentsBean argumentsBean = arguments.get(0);
			String value = argumentsBean.getValues().get(0);
			if(value != null && !value.equals("")) {
				sb.setProperty("userAppointment");
				argumentsBean.setParamName("userMobile");
				argumentsBean.setParamType(DataType.s.getValue());
				argumentsBean.setSymbol(Symbol.eq.getValue());
			}
		}
	}

	/**
	 * 登录数据过滤
	 * 
	 * @return
	 */
	public List<Filter> handlerFilter() {
		// 获得登录用户信息
		UserVo userVo = SessionManager.getSessionUser();
		String setidJobcode = userVo.getSetidJobcode();
		// 查询权限过滤器
		List<Filter> filters = new ArrayList<Filter>();
		Filter filter = new Filter();
		if (setidJobcode != null && !setidJobcode.equals("")
				&& setidJobcode.equals(JobManager.JOB_ZY)) {
			filter.setFilterName("appointmentFirst");
			filter
					.addParmater(new Parmater("staffid", userVo
							.getStaffid()));
		} else {
			filter.setFilterName("manager");
			filter.addParmater(new Parmater("deptCode", "%"
					+ userVo.getDeptCode() + "%"));
		}
		filters.add(filter);
		return filters;
	}

}
