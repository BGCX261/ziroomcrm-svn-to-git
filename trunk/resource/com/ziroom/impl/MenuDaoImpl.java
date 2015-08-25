package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Menu;
import com.ziroom.module.system.dao.MenuDao;
import com.ziroom.module.system.vo.MenuVo;

/**
 * 系统功能菜单数据访问接口实现类
 * 
 * @author 孙树林
 * 
 */
public class MenuDaoImpl extends HibernateQBCQuery implements MenuDao {

	/**
	 * 读取系统功能菜单列表
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MenuVo> loadMenu() {
		List<MenuVo> menuVoes = new ArrayList<MenuVo>();
		List<Menu> menus = criteriaOfSimple(null, Menu.class, false);
		for (Menu menu : menus) {
			MenuVo menuVo = new MenuVo();
			BeanUtils.copyPropertiesNotNull(menu, menuVo);
			menuVoes.add(menuVo);
		}
		return menuVoes;
	}

}