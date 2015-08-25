package com.ziroom.module.house.dao;

import java.util.List;

import com.common.bean.SearchBean;
import com.common.hibernate.Filter;
import com.ziroom.module.cms.vo.SpecialVo;
import com.ziroom.module.house.vo.HouseVo;

/**
 * 房源数据房屋接口
 * 
 * @author 孙树林
 * 
 */
public interface HouseDao {

	/**
	 * 数据查询
	 * 
	 * @param searchBean
	 * @param filter
	 * @return
	 */
	public List<HouseVo> searchHouse(SearchBean searchBean, List<Filter> filter)
			throws Exception;

	/**
	 * 房屋查找
	 * 
	 * @param houseId
	 * @return
	 */
	public void findHouseById(HouseVo vo) throws Exception;

	/**
	 * 更新房屋
	 * 
	 * @param houseVo
	 */
	public void updateHouse(HouseVo houseVo) throws Exception;

	/**
	 * 统计房屋的房间数量
	 * 
	 * @param sysHouseId
	 * @return
	 */
	public int totalHouseRoomNum(Integer sysHouseId) throws Exception;

	/**
	 * 统计房屋发布的房间数量
	 * 
	 * @param sysHouseId
	 * @return
	 */
	public int totalHousePubRoomNum(Integer sysHouseId) throws Exception;

	/**
	 * 更新房屋信息通过sys_house_id更新
	 * 
	 * @param houseVo
	 */
	public void updateHouseBySysHouseId(HouseVo houseVo) throws Exception;

	/**
	 * 房屋syshouseid查找房屋
	 * 
	 * @param houseVo
	 */
	public void findHouseBySysHouseId(HouseVo houseVo) throws Exception;

	/**
	 * 房屋优先展示房间数量
	 * 
	 * @param sysHouseId
	 * @return
	 * @throws Exception
	 */
	public int totalHousePriorNum(Integer sysHouseId) throws Exception;
	
	/**
	 * 房屋推荐房间数量
	 * 
	 * @param sysHouseId
	 * @return
	 * @throws Exception
	 */
	public int totalHouseTopNum(Integer sysHouseId) throws Exception;
	
	/**
	 * 房屋编号查询房屋信息
	 * 
	 * @param houseCode
	 * @return
	 * @throws Exception
	 */
	public HouseVo findHouseByHouseCode(SpecialVo specialVo) throws Exception;
	
	/**
	 * 查询房屋
	 * 
	 * @param specialVo
	 * @return
	 * @throws Exception
	 */
	public List<HouseVo> findHouse(SpecialVo specialVo) throws Exception;
}
