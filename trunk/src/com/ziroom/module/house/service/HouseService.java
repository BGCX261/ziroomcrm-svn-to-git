package com.ziroom.module.house.service;

import java.util.ArrayList;
import java.util.List;

import com.ziroom.common.connector.ConditionInterface;
import com.ziroom.module.house.dao.ConfigDao;
import com.ziroom.module.house.dao.HouseDao;
import com.ziroom.module.house.dao.RoomDao;
import com.ziroom.module.house.dao.RoomPictureDao;
import com.ziroom.module.house.vo.ConfigVo;
import com.ziroom.module.house.vo.HouseVo;
import com.ziroom.module.house.vo.RoomPictureVo;
import com.ziroom.module.house.vo.RoomVo;

/**
 * 房源业务处理类，包括房屋发布，房屋查询业务处理
 * 
 * @author 孙树林
 * 
 */
public class HouseService {

	private HouseDao houseDao;

	private RoomDao roomDao;

	private RoomPictureDao roomPictureDao;

	private ConfigDao configDao;

	private ConditionInterface houseConditionInterface;

	/**
	 * 查询房源
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<HouseVo> searchHouse(HouseVo vo) throws Exception {
		List<HouseVo> houseVoes = new ArrayList<HouseVo>();
		houseConditionInterface.handlerCondition(vo);
		houseVoes = houseDao.searchHouse(vo, houseConditionInterface.handlerFilter());
		return houseVoes;
	}

	/**
	 * 查找房屋信息
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void findHouse(HouseVo vo) throws Exception {
		houseDao.findHouseById(vo);
	}

	/**
	 * 房屋发布
	 * 
	 * @param houseId
	 * @return
	 * @throws Exception
	 */
	public boolean pubHouse(HouseVo vo) throws Exception {
		boolean isPub = false;
		// 房屋查找
		houseDao.findHouseById(vo);
		if (vo != null) {
			RoomVo roomVo = new RoomVo();
			roomVo.setSysHouseId(vo.getSysHouseId());
			int k = 1;
			if (vo.getIsShow().equals("Y")) {
				// 取消房屋发布，并且所有的房间也取消发布
				vo.setIsShow("N");
				vo.setIsTop("N");
				vo.setIsPromotions("N");
				vo.setCheckInTime(null);
				// 对该房屋下的房间都取消发布
				roomVo.setIsShow("N");
				roomVo.setIsTop("N");
				roomVo.setIsPromotions("N");
				roomVo.setCheckInTime(null);
				k = 1;
			} else {
				// 如果房屋发布，房间中除了已经出租房间外都设为发布状态
				vo.setIsShow("Y");
				// 该房屋下房间进行发布（已出租或已预订的除外）
				roomVo.setIsShow("Y");
				if (vo.getCheckInTime() != null) {
					// 如果填写入住时间，记录房屋可入住时间
					vo.setCheckInTime(vo.getCheckInTime());
					roomVo.setCheckInTime(vo.getCheckInTime());
				}
				k = 2;
			}
			roomDao.updateRoomBySysHouseId(roomVo, k);
			houseDao.updateHouse(vo);
			isPub = true;
		}
		return isPub;
	}

	/**
	 * 查找房屋的详细信息，包括小区，房间，房间图片，公共区域，配置物品等
	 * 
	 * @param houseVo
	 * @throws Exception
	 */
	public void findHouseDetail(HouseVo houseVo) throws Exception {
		// 房屋信息
		houseDao.findHouseById(houseVo);
		// 房屋首页房间信息
		List<RoomVo> roomVoes = roomDao.findRoomBySysHouseId(houseVo.getSysHouseId());
		// 房间图片，物品等信息
		for (RoomVo roomVo : roomVoes) {
			if (roomVo.getRoomType().equals("KITCHEN")) {
				// 如果是房间
				List<ConfigVo> configVoes = configDao.searchPubHouseConfig(roomVo.getSysHouseId());
				roomVo.setConfigVoes(configVoes);

				List<RoomPictureVo> roomPictures = roomPictureDao.searchPubRegionPicture(roomVo.getSysHouseId());
				roomVo.setRoomPictures(roomPictures);
			} else {
				// 如果是公共区域
				List<ConfigVo> configVoes = configDao.searchRoomConfig(roomVo.getSysRoomId());
				roomVo.setConfigVoes(configVoes);

				List<RoomPictureVo> roomPictures = roomPictureDao.searchRoomPicture(roomVo.getSysRoomId());
				roomVo.setRoomPictures(roomPictures);
			}
		}
		/* TODO 小区信息 */

		houseVo.setRooms(roomVoes);
	}

	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public void setHouseConditionInterface(ConditionInterface houseConditionInterface) {
		this.houseConditionInterface = houseConditionInterface;
	}

	public void setRoomPictureDao(RoomPictureDao roomPictureDao) {
		this.roomPictureDao = roomPictureDao;
	}

	public void setConfigDao(ConfigDao configDao) {
		this.configDao = configDao;
	}

}
