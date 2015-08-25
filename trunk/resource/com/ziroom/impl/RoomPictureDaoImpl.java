package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.RoomPicture;
import com.ziroom.module.house.dao.RoomPictureDao;
import com.ziroom.module.house.vo.RoomPictureVo;

/**
 * 房屋图片数据房屋接口
 * 
 * @author 孙树林
 */
public class RoomPictureDaoImpl extends HibernateQBCQuery implements RoomPictureDao {

	/**
	 * 查询公共区域图片
	 * 
	 * @param sysRoomId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RoomPictureVo> searchPubRegionPicture(Integer sysHouseId) throws Exception {
		List<RoomPicture> roomPictures = new ArrayList<RoomPicture>();
		Query query = this
				.getSession()
				.createQuery(
						"from RoomPicture as rp where rp.sysHouseId=:sysHouseId and rp.sysRoomId not in(select r.sysRoomId from Room as r where r.roomType!='KITCHEN' and r.sysHouseId=:sysHouseId)");
		query.setInteger("sysHouseId", sysHouseId);
		roomPictures = query.list();
		return copy(roomPictures);
	}

	/**
	 * 查询房间图片
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RoomPictureVo> searchRoomPicture(Integer sysRoomId) throws Exception {
		List<RoomPicture> roomPictures = new ArrayList<RoomPicture>();
		Query query = this.getSession().createQuery("from RoomPicture where sysRoomId=:sysRoomId");
		query.setInteger("sysRoomId", sysRoomId);
		roomPictures = query.list();
		return copy(roomPictures);
	}

	/**
	 * 查找图片
	 * 
	 * @return
	 * @throws Exception
	 */
	public void findRoomPictureVo(RoomPictureVo roomPictureVo) throws Exception {
		RoomPicture roomPicture = (RoomPicture) this.loadEntity(RoomPicture.class, roomPictureVo.getHpimageid());
		BeanUtils.copyPropertiesNotNull(roomPicture, roomPictureVo);
	}

	/**
	 * 赋值
	 * 
	 * @param roomPictures
	 * @return
	 * @throws Exception
	 */
	private List<RoomPictureVo> copy(List<RoomPicture> roomPictures) throws Exception {
		List<RoomPictureVo> roomPictureVoes = new ArrayList<RoomPictureVo>();
		for (RoomPicture roomPicture : roomPictures) {
			RoomPictureVo roomPictureVo = new RoomPictureVo();
			BeanUtils.copyPropertiesNotNull(roomPicture, roomPictureVo);
			roomPictureVoes.add(roomPictureVo);
		}
		return roomPictureVoes;
	}
}
