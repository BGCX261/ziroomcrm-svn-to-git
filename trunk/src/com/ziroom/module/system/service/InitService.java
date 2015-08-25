package com.ziroom.module.system.service;

import java.util.List;

import com.ziroom.module.system.dao.DictDao;
import com.ziroom.module.system.dao.MenuDao;
import com.ziroom.module.system.vo.DictVo;
import com.ziroom.module.system.vo.MenuVo;

/**
 * 初始化service，用来初始化通用的数据
 * 
 * @author 孙树林
 * 
 */
public class InitService {

	private MenuDao menuDao;

	private DictDao dictDao;

	/**
	 * 菜单数据初始化
	 */
	public List<MenuVo> loadMenuAll() {
		List<MenuVo> menuVoes = menuDao.loadMenu();
		return menuVoes;
	}

	/**
	 * 数据字典初始化
	 * 
	 * @return
	 */
	public List<DictVo> loadDictAll() {
		List<DictVo> dictVoes = dictDao.searchAllDict();
		dictVoes.addAll(dictDao.searchAllBusiness());
		dictVoes.addAll(dictDao.searchAllDistrict());
		dictVoes.addAll(dictDao.searchAllDistrictBusiness());
		dictVoes.addAll(dictDao.searchAllSubway());
		dictVoes.addAll(dictDao.searchAllSubwayStation());
		return dictVoes;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}
}
