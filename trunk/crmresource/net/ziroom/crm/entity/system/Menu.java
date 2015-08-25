package net.ziroom.crm.entity.system;

import java.util.HashSet;
import java.util.Set;

/**
 * 系统菜单实体模型
 * 
 * @author Administrator
 * 
 */
public class Menu {

	private Integer id;
	private Menu menu;
	private String menuName;
	private String menuCode;
	private String url;
	private Set<Menu> menus = new HashSet<Menu>(0);

	public Menu() {
	}

	public Menu(Menu menu, String menuName, String menuCode, String url, Set<Menu> menus) {
		this.menu = menu;
		this.menuName = menuName;
		this.menuCode = menuCode;
		this.url = url;
		this.menus = menus;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
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

	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

}