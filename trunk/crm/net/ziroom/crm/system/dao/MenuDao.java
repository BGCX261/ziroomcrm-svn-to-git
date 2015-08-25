package net.ziroom.crm.system.dao;

import net.ziroom.crm.system.vo.MenuVo;

/**
 * 系统菜单数据访问接口
 * 
 * @author 孙树林
 */
public interface MenuDao {

	/**
	 * 查询系统菜单
	 * 
	 * @param menuVo
	 * @throws Exception
	 */
	public void searchSystemMenu(MenuVo menuVo) throws Exception;
}
