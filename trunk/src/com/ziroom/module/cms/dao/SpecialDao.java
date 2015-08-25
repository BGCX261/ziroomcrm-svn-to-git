package com.ziroom.module.cms.dao;

import java.util.List;

import com.ziroom.module.cms.vo.SpecialVo;

/**
 * 专题页数据房屋接口
 * 
 * @author 孙树林
 */
public interface SpecialDao {

	/**
	 * 专题页查询
	 * 
	 * @param specialVo
	 * @return
	 * @throws Exception
	 */
	public List<SpecialVo> searchSpecial(SpecialVo specialVo) throws Exception;

	/**
	 * 保存专题页信息
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void saveSpecial(SpecialVo specialVo) throws Exception;

	/**
	 * 更新专题页信息
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void updateSpecial(SpecialVo specialVo) throws Exception;

	/**
	 * 查找专题页信息
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void findSpecial(SpecialVo specialVo) throws Exception;

	/**
	 * 删除专题页信息
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void deleteSpecial(SpecialVo specialVo) throws Exception;

	/**
	 * 按排序号更新
	 * 
	 * @param sortNum
	 * @throws Exception
	 */
	public void updateSortNum(int sortNum, String specialType) throws Exception;

	/**
	 * 排序号查找
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void findSpecialBySortNum(SpecialVo specialVo) throws Exception;

	/**
	 * 查找最大值
	 * 
	 * @return
	 * @throws Exception
	 */
	public int getMaxSortNum(String specialType) throws Exception;
	
	/**
	 * 专题信息列表
	 * 
	 * @param specialVo
	 * @return
	 * @throws Exception
	 */
	public List<SpecialVo> searchAll(String type) throws Exception;
}
