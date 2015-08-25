package net.ziroom.crm.system.action;

import net.ziroom.common.action.ZiroomAction;
import net.ziroom.crm.system.service.MenuService;
import net.ziroom.crm.system.vo.MenuVo;

/**
 * 
 * 菜单请求Action
 * 
 * @author 孙树林
 */
public class MenuAction extends ZiroomAction {

	private static final long serialVersionUID = -2584450012097112202L;

	private MenuVo menuVo = new MenuVo();

	private MenuService menuService;

	/**
	 * 系统菜单请求业务处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		menuService.searchSystemMenu(menuVo);
		return SUCCESS;
	}
	
	/**
	 * 系统菜单请求业务处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String searchSystemMenu() throws Exception {
		menuService.searchSystemMenu(menuVo);
		return SUCCESS;
	}

	public MenuVo getMenuVo() {
		return menuVo;
	}

	public void setMenuVo(MenuVo menuVo) {
		this.menuVo = menuVo;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
}
