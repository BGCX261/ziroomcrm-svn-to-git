package com.common.bean;

/**
 * 排序bean
 * 
 * @author 孙树林
 */
public class OrderBean {

	/** 排序方式 */
	private String sort;
	/** 字段 */
	private String param;

	public OrderBean() {
		super();
	}

	public OrderBean(String sort, String param) {
		super();
		this.sort = sort;
		this.param = param;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
}
