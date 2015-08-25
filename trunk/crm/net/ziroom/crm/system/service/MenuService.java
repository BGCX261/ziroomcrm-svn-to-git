package net.ziroom.crm.system.service;

import net.ziroom.crm.system.dao.MenuDao;
import net.ziroom.crm.system.vo.MenuVo;

/**
 * 菜单业务处理类
 * 
 * @author 孙树林
 */
public class MenuService {

	private MenuDao menuDao;

	/**
	 * 查询系统一，二级菜单
	 * 
	 * @throws Exception
	 */
	public void searchSystemMenu(MenuVo menuVo) throws Exception {
		// 查询菜单
		menuDao.searchSystemMenu(menuVo);
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
}
