package com.ziroom.common.action;

import com.common.bean.SearchBean;

/**
 * ziroom值对象基类
 * 
 * @author 孙树林
 * 
 */
public class ZiroomVo extends SearchBean {

	private String menuCode;

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
}
