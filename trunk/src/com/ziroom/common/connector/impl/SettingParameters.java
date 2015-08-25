package com.ziroom.common.connector.impl;

import com.common.bean.ArgumentsBean;

/**
 *
 * @author 孙树林
 */
public class SettingParameters {

	/**
	 * 设置参数
	 * 
	 * @param argumentsBean
	 * @param param
	 * @param type
	 * @param isAnd
	 * @param sysbom
	 */
	public void setParameter(ArgumentsBean argumentsBean, String param,
			String type, boolean isAnd, String sysbom) {
		argumentsBean.setParamName(param);
		argumentsBean.setParamType(type);
		argumentsBean.setAnd(isAnd);
		argumentsBean.setSymbol(sysbom);
	}
	
	/**
	 * 设置参数
	 * 
	 * @param argumentsBean
	 * @param param
	 * @param type
	 * @param isAnd
	 * @param sysbom
	 */
	public void setParameter(ArgumentsBean argumentsBean, String param,
			String type, boolean isAnd, String sysbom, String parameters) {
		argumentsBean.setParamName(param);
		argumentsBean.setParamType(type);
		argumentsBean.setAnd(isAnd);
		argumentsBean.setSymbol(sysbom);
		argumentsBean.setParamters(parameters);
	}
}

