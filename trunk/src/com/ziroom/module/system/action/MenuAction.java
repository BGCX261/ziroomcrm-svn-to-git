package com.ziroom.module.system.action;

import java.util.List;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.system.service.MenuService;
import com.ziroom.module.system.vo.MenuVo;

/**
 * 
 * 系统菜单
 * 
 * @author 孙树林
 * 
 */
public class MenuAction extends ZiroomAction {

	private static final long serialVersionUID = -7166896443380588798L;

	private MenuVo vo = new MenuVo();

	private MenuService menuService;

	/**
	 * 登录用户一级菜单
	 * 
	 * @return
	 */
	public String searchTopMenu() {
		List<MenuVo> menues = menuService.getFirstMenu();
		vo.setMenus(menues);
		return "success";
	}

	/**
	 * 登录用户二级、三级菜单
	 * 
	 * @return
	 */
	public String searchLeftMenu() {
		vo.setMenuCode(menuCode);
		List<MenuVo> menues = menuService.getSecondAndThreeMenu(vo);
		vo.setMenus(menues);
		return "success";
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public MenuVo getVo() {
		return vo;
	}

	public void setVo(MenuVo vo) {
		this.vo = vo;
	}
}