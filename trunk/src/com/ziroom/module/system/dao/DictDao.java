package com.ziroom.module.system.dao;

import java.util.List;

import com.ziroom.module.system.vo.DictVo;

/**
 * 房源数据字典数据房屋接口
 * 
 * @author 孙树林
 */
public interface DictDao {

	/**
	 * 读取所有字典数据
	 * 
	 * @return
	 */
	public List<DictVo> searchAllDict();

	/**
	 * 读取所有区域
	 * 
	 * @return
	 */
	public List<DictVo> searchAllDistrict();

	/**
	 * 读取所有的商圈
	 * 
	 * @return
	 */
	public List<DictVo> searchAllBusiness();

	/**
	 * 读取区域与商圈关系
	 * 
	 * @return
	 */
	public List<DictVo> searchAllDistrictBusiness();

	/**
	 * 读取所有的地铁线
	 * 
	 * @return
	 */
	public List<DictVo> searchAllSubway();

	/**
	 * 读取所有的地点站点
	 * 
	 * @return
	 */
	public List<DictVo> searchAllSubwayStation();
}
