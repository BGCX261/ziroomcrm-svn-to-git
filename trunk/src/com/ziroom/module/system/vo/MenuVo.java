package com.ziroom.module.system.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单值对象
 * 
 * @author 孙树林
 * 
 */
public class MenuVo {

	private Integer id;
	private String menuName;
	private String menuCode;
	private String url;
	
	// 父菜单
	private MenuVo menuVo;
	// 节点
	private List<MenuVo> menus = new ArrayList<MenuVo>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MenuVo getMenuVo() {
		return menuVo;
	}

	public void setMenuVo(MenuVo menuVo) {
		this.menuVo = menuVo;
	}

	public List<MenuVo> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuVo> menus) {
		this.menus = menus;
	}
}
