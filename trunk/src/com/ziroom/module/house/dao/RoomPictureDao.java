package com.ziroom.module.house.dao;

import java.util.List;

import com.ziroom.module.house.vo.RoomPictureVo;

/**
 * 房屋图片数据房屋接口
 * 
 * @author 孙树林
 */
public interface RoomPictureDao {

	/**
	 * 查询房间图片
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<RoomPictureVo> searchRoomPicture(Integer sysRoomId) throws Exception;

	/**
	 * 查询公共区域图片
	 * 
	 * @param sysRoomId
	 * @return
	 * @throws Exception
	 */
	public List<RoomPictureVo> searchPubRegionPicture(Integer sysHouseId) throws Exception;

	/**
	 * 查找图片
	 * @return
	 * @throws Exception
	 */
	public void findRoomPictureVo(RoomPictureVo roomPictureVo) throws Exception;
}
