package net.ziroom.crm.system.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单值对象
 * 
 * @author 孙树林
 */
public class MenuVo {

	private Integer id;
	private String menuName;
	private String menuCode;
	private String url;
	private List<MenuVo> nodes = new ArrayList<MenuVo>();

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

	public List<MenuVo> getNodes() {
		return nodes;
	}

	public void setNodes(List<MenuVo> nodes) {
		this.nodes = nodes;
	}
}
