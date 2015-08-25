package com.ziroom.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Menu entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Menu {

	// Fields

	private Integer id;
	private String menuName;
	private String menuCode;
	private String url;

	private Menu menu;
	private Set<Menu> menus = new HashSet<Menu>();

	// Constructors

	/** default constructor */
	public Menu() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuCode() {
		return this.menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

}