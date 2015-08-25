package com.ziroom.module.system.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ziroom.common.init.InitBean;
import com.ziroom.common.manager.SessionManager;
import com.ziroom.module.system.vo.MenuVo;
import com.ziroom.module.system.vo.UserVo;

/**
 * 
 * 系统功能菜单业务处理类
 * 
 * @author 孙树林
 * 
 */
public class MenuService {

	/**
	 * 获得登录用户使用系统的一级菜单
	 * 
	 * @return
	 */
	public List<MenuVo> getFirstMenu() {
		List<MenuVo> menuVoes = new ArrayList<MenuVo>();
		// 获得系统一级菜单
		menuVoes = handlerMenu(null, 10000000000L);
		return menuVoes;
	}

	/**
	 * 获得登录用户一、二级菜单
	 * 
	 * @param menuVo
	 * @return
	 */
	public List<MenuVo> getSecondAndThreeMenu(MenuVo menuVo) {
		List<MenuVo> menuVoes = new ArrayList<MenuVo>();
		String code = menuVo.getMenuCode();
		if (code != null) {
			// 获得系统二级菜单
			menuVoes = handlerMenu(code, 100000000L);
			// 处理二级下三级菜单
			for (MenuVo vo : menuVoes) {
				List<MenuVo> _menuVoes = handlerMenu(vo.getMenuCode(), 1000000L);
				vo.setMenus(_menuVoes);
			}
		}

		return menuVoes;
	}

	/**
	 * 获得菜单
	 * 
	 * @param c
	 *            父菜单编号
	 * @param level
	 *            菜单等级
	 * @return
	 */
	private List<MenuVo> handlerMenu(String c, Long level) {

		// 登录用户权限
		UserVo userVo = SessionManager.getSessionUser();

		List<MenuVo> menuVoes = new ArrayList<MenuVo>();
		Map<String, MenuVo> maps = InitBean.getMenu();
		Iterator<String> codes = maps.keySet().iterator();
		while (codes.hasNext()) {
			String code = codes.next();
			Long x = Long.parseLong(code);
			if (c != null) {
				x = Long.parseLong(code) - Long.parseLong(c);
			}
			if (x % level == 0 && x / level >= 10 && x / level <= 99) {
				// TODO 登录用户菜单权限
				menuVoes.add(maps.get(code));
			}
		}
		return menuVoes;
	}
}
