package com.common.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询bean
 * 
 * @author 孙树林
 * 
 */
public class SearchBean {
	
	/** 复合查询关联属性 */
	private String property;
	/** 是否分页标识 ;默认分页 */
	private boolean isPage = true;
	/** 分页Bean */
	private PageBean pageBean = new PageBean();
	/** 查询条件Beans */
	private List<ArgumentsBean> argumentsBeans = new ArrayList<ArgumentsBean>();
	/** 复合查询条件 */
	private List<SearchBean> searchBeans = new ArrayList<SearchBean>();
	/** 排序bean */
	private List<OrderBean> orderBeans = new ArrayList<OrderBean>();

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public List<ArgumentsBean> getArgumentsBeans() {
		return argumentsBeans;
	}

	public void setArgumentsBeans(List<ArgumentsBean> argumentsBeans) {
		this.argumentsBeans = argumentsBeans;
	}

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}

	public List<SearchBean> getSearchBeans() {
		return searchBeans;
	}

	public void setSearchBeans(List<SearchBean> searchBeans) {
		this.searchBeans = searchBeans;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public List<OrderBean> getOrderBeans() {
		return orderBeans;
	}

	public void setOrderBeans(List<OrderBean> orderBeans) {
		this.orderBeans = orderBeans;
	}
}
