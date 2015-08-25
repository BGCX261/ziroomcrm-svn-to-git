package net.ziroom.common.action;

import com.common.bean.SearchBean;

/**
 * ziroom值对象基类
 * 
 * @author 孙树林
 * 
 */
public class ZiroomVo extends SearchBean {

	private String menuCode;
	
	private String xml;

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
}
