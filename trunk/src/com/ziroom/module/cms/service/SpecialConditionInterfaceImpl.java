package com.ziroom.module.cms.service;

import java.util.List;

import com.common.bean.ArgumentsBean;
import com.common.bean.SearchBean;
import com.common.enums.DataType;
import com.common.enums.Symbol;
import com.common.hibernate.Filter;
import com.ziroom.common.connector.ConditionInterface;
import com.ziroom.common.connector.impl.SettingParameters;

/**
 * 首页轮播图查询条件处理
 * 
 * @author 孙树林
 */
public class SpecialConditionInterfaceImpl extends SettingParameters implements ConditionInterface {

	/**
	 * 查询处理
	 * 
	 * @param searchBean
	 */
	public void handlerCondition(SearchBean searchBean) {
		List<ArgumentsBean> argumentsBeans = searchBean.getArgumentsBeans();
		for (int i = 0; i < argumentsBeans.size(); i++) {
			ArgumentsBean argumentsBean = argumentsBeans.get(i);
			String param = null;
			String type = null;
			String sysbom = null;
			if (argumentsBean == null && argumentsBean.getValues() == null && argumentsBean.getValues().get(0) == null
					&& argumentsBean.getValues().size() == 0 && argumentsBean.getValues().get(0).equals("")) {
				continue;
			}
			switch (i) {
			// 业务组
			case 0:
				// 主管
				param = "specialType";
				type = DataType.s.getValue();
				sysbom = Symbol.eq.getValue();
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
		return null;
	}

}
