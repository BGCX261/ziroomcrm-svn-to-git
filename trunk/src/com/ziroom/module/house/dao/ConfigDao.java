package com.ziroom.module.house.dao;

import java.util.List;

import com.ziroom.module.house.vo.ConfigVo;

/**
 * 房间物品配置数据访问接口
 * 
 * @author 孙树林
 */
public interface ConfigDao {
	
	/**
	 * 房屋公共区域配置物品
	 * 
	 * @param sysRoomId
	 * @return
	 * @throws Exception
	 */
	public List<ConfigVo> searchPubHouseConfig(Integer sysHouseId) throws Exception;

	/**
	 * 房间配置物品
	 * 
	 * @param sysRoomId
	 * @return
	 * @throws Exception
	 */
	public List<ConfigVo> searchRoomConfig(Integer sysRoomId) throws Exception;

	/**
	 * 根据房间sysRoomId，物品类型查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<String> searchRoomConfig(Integer sysRoomId, String itemType) throws Exception;

	/**
	 * 根据房间sysHouseId，物品类型查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<String> searchPubHouseConfig(Integer sysHouseId, String itemType) throws Exception;
}
