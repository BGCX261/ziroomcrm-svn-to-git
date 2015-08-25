package com.common.bean;

/**
 * 分页bean
 * 
 * @author 孙树林
 * 
 */
public class PageBean {

	/** 当前页 */
	private int currentPage = 1;
	/** 总页数 */
	private int totalPage;
	/** 每页显示记录数 */
	private int pageSize = 10;
	/** 总记录数 */
	private int totalSize;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
		if (totalSize % pageSize == 0) {
			this.totalPage = totalSize / pageSize;
		} else {
			this.totalPage = totalSize / pageSize + 1;
		}
	}

	public int getStart() {
		return (currentPage - 1) * pageSize;
	}
}
