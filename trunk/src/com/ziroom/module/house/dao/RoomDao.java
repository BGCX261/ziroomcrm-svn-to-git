package com.ziroom.module.house.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.ziroom.module.house.vo.RoomVo;

/**
 * 
 * 房间数据房屋接口
 * 
 * @author 孙树林
 * 
 */
public interface RoomDao {

	/**
	 * 批量处理房间的资产系统房屋ID更新房间
	 * 
	 * @param roomVo
	 * @param i
	 * @return
	 */
	public int updateRoomBySysHouseId(RoomVo roomVo, int i) throws Exception;

	/**
	 * 根据房间ID查找房间信息
	 * 
	 * @param id
	 * @return
	 */
	public void findRoomByRoomId(RoomVo roomVo) throws Exception;

	/**
	 * 更新房间
	 * 
	 * @param roomVo
	 */
	public void updateRoom(RoomVo roomVo) throws Exception;

	/**
	 * 统计优先展示房间数
	 * 
	 * @param roomVo
	 * @return
	 */
	public int totalPriorRoomNum(RoomVo roomVo) throws Exception;

	/**
	 * 统计推荐房间数
	 * 
	 * @param roomVo
	 * @return
	 */
	public int totalTopRoomNum(RoomVo roomVo) throws Exception;

	/**
	 * 其它房间租住信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> searchOtherRoom(Integer sysRoomId, Integer sysHouseId) throws Exception;

	/**
	 * jdbc
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception;

	/**
	 * 根据房屋查询房间
	 * 
	 * @param sysHouseId
	 * @return
	 * @throws Exception
	 */
	public List<RoomVo> findRoomBySysHouseId(Integer sysHouseId) throws Exception;
}
