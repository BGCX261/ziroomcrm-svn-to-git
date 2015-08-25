package net.ziroom.crm.dao.system;

import java.util.Iterator;
import java.util.List;

import net.ziroom.crm.entity.system.Menu;
import net.ziroom.crm.system.dao.MenuDao;
import net.ziroom.crm.system.vo.MenuVo;

import org.hibernate.Query;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;

/**
 * 系统菜单数据访问接口实现类
 * 
 * @author 孙树林
 */
public class MenuDaoImpl extends HibernateQBCQuery implements MenuDao {

	/**
	 * 查询系统菜单
	 * 
	 * @param menuVo
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void searchSystemMenu(MenuVo menuVo) throws Exception {
		String hql = "from Menu m where m.menu is null";
		Query query = this.createQuery(hql);
		List<Menu> menus = query.list();
		for (Menu menu : menus) {
			// 一级菜单
			MenuVo vo = new MenuVo();
			BeanUtils.copyPropertiesNotNull(menu, vo);
			// 二级菜单
			Iterator<Menu> m = menu.getMenus().iterator();
			while (m.hasNext()) {
				MenuVo node = new MenuVo();
				BeanUtils.copyPropertiesNotNull(m.next(), node);
				vo.getNodes().add(node);
			}
			menuVo.getNodes().add(vo);
		}
	}
}