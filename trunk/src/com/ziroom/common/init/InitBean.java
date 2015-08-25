package com.ziroom.common.init;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.common.log.GeneralLog;
import com.common.util.ResourceManager;
import com.ziroom.common.manager.DictManager;
import com.ziroom.module.system.service.InitService;
import com.ziroom.module.system.vo.MenuVo;

/**
 * 初始化Bean
 * 
 * @author 孙树林
 * 
 */
public class InitBean {

	/** 系统菜单 */
	@SuppressWarnings("unchecked")
	public static TreeMap<String, MenuVo> loadMenuData = new TreeMap<String, MenuVo>();

	private InitService initService;

	/**
	 * 初始化
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {
		initMenu();
		initResource();
		initDict();
		initLog();
	}

	/**
	 * 
	 * 初始化系统菜单
	 * 
	 * 备注：系统菜单分6级，没两位表示一级，其中前六位表示系统功能菜单；后六位表示系统操作功能按钮等。
	 */
	private void initMenu() {
		List<MenuVo> menuVoes = initService.loadMenuAll();
		for (MenuVo menuVo : menuVoes) {
			loadMenuData.put(menuVo.getMenuCode(), menuVo);
		}
	}

	/**
	 * 初始化resource资源文件
	 * 
	 * @throws IOException
	 */
	public void initResource() throws IOException {
		ResourceManager.init("resources.properties");
	}

	/**
	 * 初始化数据字典数据
	 * 
	 * @throws Exception
	 */
	public void initDict() throws Exception {
		DictManager.init(initService.loadDictAll());
	}

	/**
	 * 初始化日志
	 * 
	 * @throws Exception
	 */
	public void initLog() throws Exception {
		GeneralLog.getInstance();
	}

	/**
	 * 系统菜单
	 * 
	 * @return
	 */
	public static Map<String, MenuVo> getMenu() {
		return loadMenuData;
	}

	public void setInitService(InitService initService) {
		this.initService = initService;
	}

}
