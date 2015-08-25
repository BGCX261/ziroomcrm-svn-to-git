package com.ziroom.module.house.service;

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
 * 房屋数据查询及用户权限过滤处理
 * 
 * @author 孙树林
 */
public class HouseConditionInterfaceImpl extends SettingParameters implements ConditionInterface {

	/**
	 * 房屋查询处理
	 * 
	 * @param searchBean
	 */
	public void handlerCondition(SearchBean searchBean) {
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
				// 房源编号条件
				param = "houseCode";
				type = DataType.s.getValue();
				sysbom = Symbol.eq.getValue();
				break;
			case 1:
				// 拓展部条件
			case 2:
				// 业务组
			case 3:
				// 主管
				param = "(select distinct t_user.dept_path from t_user where t_user.staffid=this_.steward_code) like '%"
						+ value + "%'";
				sysbom = Symbol.sql.getValue();
				break;
			case 4:
				// 管家
				param = "stewardCode";
				type = DataType.s.getValue();
				sysbom = Symbol.eq.getValue();
				break;
			case 5:
				// 发布
				param = "(is_show='" + value + "' or (select count(t_room.room_id) from t_room where t_room.room_type!='KITCHEN' and t_room.flag !='N' and t_room.sys_house_id=this_.sys_house_id and t_room.is_show='" + value + "') > 0)";
				sysbom = Symbol.sql.getValue();
				break;
			case 6:
				// 优先
				param = "(select count(t_room.room_id) from t_room where t_room.room_type!='KITCHEN' and t_room.flag !='N' and t_room.sys_house_id=this_.sys_house_id and t_room.is_promotions='" + value + "') > 0";
				sysbom = Symbol.sql.getValue();
				break;
			case 7:
				// 推荐
				param = "(select count(t_room.room_id) from t_room where t_room.room_type!='KITCHEN' and t_room.flag !='N' and t_room.sys_house_id=this_.sys_house_id and t_room.is_top='" + value + "') > 0";
				sysbom = Symbol.sql.getValue();
				break;
			}
			setParameter(argumentsBean, param, type, true, sysbom);
		}
	}

	/**
	 * 登录用户房屋数据数据过滤
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
			filter.setFilterName("steward");
			filter
					.addParmater(new Parmater("stewardCode", userVo
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
