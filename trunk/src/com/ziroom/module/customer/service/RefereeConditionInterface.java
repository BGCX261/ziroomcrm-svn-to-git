package com.ziroom.module.customer.service;

import java.util.List;

import com.common.bean.ArgumentsBean;
import com.common.bean.SearchBean;
import com.common.hibernate.Filter;
import com.ziroom.common.connector.ConditionInterface;
import com.ziroom.common.connector.impl.SettingParameters;

/**
 * 带看单查询
 * 
 * @author 孙树林
 */
public class RefereeConditionInterface extends SettingParameters implements ConditionInterface {

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
				param = "r.custName like '%" + value + "%'";
				break;
			case 1:
				// 证件号
				param = "r.certNo='" + value + "'";
				break;
			case 2:
				// 手机号
				param = "r.telphone='" + value + "'";
				break;
			}
			argumentsBean.setParamName(param);
		}
	}

	/**
	 * 登录数据过滤
	 * 
	 * @return
	 */
	public List<Filter> handlerFilter() {
		
		return null;
	}

}
