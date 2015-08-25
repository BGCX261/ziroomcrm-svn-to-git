package com.ziroom.module.cms.dao;

import java.util.List;

import com.ziroom.module.cms.vo.SowingVo;

/**
 * 首页轮播图数据访问接口
 * 
 * @author 孙树林
 */
public interface SowingDao {

	/**
	 * 查询数据
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public List<SowingVo> search(SowingVo vo) throws Exception;

	/**
	 * 保存数据
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void saveSowing(SowingVo vo) throws Exception;

	/**
	 * 更新数据
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void updateSowing(SowingVo vo) throws Exception;

	/**
	 * 删除数据
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void deleteSowing(SowingVo vo) throws Exception;

	/**
	 * 查找数据
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void findSowing(SowingVo vo) throws Exception;

	/**
	 * 首页轮播图最大值
	 * 
	 * @throws Exception
	 */
	public int getMaxSortNum() throws Exception;

	/**
	 * 排序号查找
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void findSowingBySortNum(SowingVo vo) throws Exception;

	/**
	 * 根据排序号更新
	 * 
	 * @param sortNum
	 * @throws Exception
	 */
	public void updateSortNum(int sortNum) throws Exception;
	
	/**
	 * 查询所有已发布的信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SowingVo> searchAll() throws Exception;
}
