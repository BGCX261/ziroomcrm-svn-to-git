package com.common.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询条件bean
 * 
 * @author 孙树林
 * 
 */
public class ArgumentsBean {

	/** 名称 */
	private String searchName;
	/** 参数名称 */
	private String paramName;
	/** 参数类型 */
	private String paramType;
	/** 参数值 */
	private List<String> values = new ArrayList<String>();
	/** 条件连接符 */
	private boolean isAnd = true;
	/** 条件符号 */
	private String symbol;
	/** 参数别名 */
	private String paramters;

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	public boolean isAnd() {
		return isAnd;
	}

	public void setAnd(boolean isAnd) {
		this.isAnd = isAnd;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getParamters() {
		return paramters;
	}

	public void setParamters(String paramters) {
		this.paramters = paramters;
	}
}
