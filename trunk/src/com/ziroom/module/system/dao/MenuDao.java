package com.ziroom.module.system.dao;

import java.util.List;

import com.ziroom.module.system.vo.MenuVo;

/**
 * 
 * 系统功能菜单数据访问接口
 * 
 * @author 孙树林
 * 
 */
public interface MenuDao {

	/**
	 * 读取系统功能菜单列表
	 * 
	 * @return
	 */
	public List<MenuVo> loadMenu();
}
