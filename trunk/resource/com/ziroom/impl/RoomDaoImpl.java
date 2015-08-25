package com.ziroom.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Room;
import com.ziroom.module.house.dao.RoomDao;
import com.ziroom.module.house.vo.RoomVo;

/**
 * 房间数据房屋接口
 * 
 * @author 孙树林
 */
public class RoomDaoImpl extends HibernateQBCQuery implements RoomDao {

	/**
	 * 房间的资产系统房屋ID更新房间
	 */
	public int updateRoomBySysHouseId(RoomVo roomVo, int k) throws Exception {
		StringBuilder stringBuilder = null;
		Query query = null;
		if (k == 1) {
			stringBuilder = new StringBuilder(
					"update Room set isTop=:isTop, isShow=:isShow, isPromotions=:isPromotions, checkInTime=:checkInTime where sysHouseId=:sysHouseId and roomType !='KITCHEN'");
		} else if (k == 2) {
			stringBuilder = new StringBuilder(
					"update Room set isShow=:isShow, checkInTime=:checkInTime where sysHouseId=:sysHouseId and roomType !='KITCHEN' and roomStatus in('zxpzz','dzz','ytz')");
		}
		query = this.createQuery(stringBuilder.toString());
		if (k == 1) {
			query.setString("isTop", roomVo.getIsTop());
			query.setString("isPromotions", roomVo.getIsPromotions());
		}
		query.setString("isShow", roomVo.getIsShow());
		query.setDate("checkInTime", roomVo.getCheckInTime());
		query.setInteger("sysHouseId", roomVo.getSysHouseId());
		int i = query.executeUpdate();
		return i;
	}

	/**
	 * 根据房间ID查找房间信息
	 * 
	 * @param id
	 * @return
	 */
	public void findRoomByRoomId(RoomVo roomVo) throws Exception {
		Room room = (Room) this.loadEntity(Room.class, roomVo.getRoomId());
		BeanUtils.copyPropertiesNotNull(room, roomVo);
	}

	/**
	 * 更新房间
	 * 
	 * @param roomVo
	 */
	public void updateRoom(RoomVo roomVo) throws Exception {
		Room room = (Room) this.loadEntity(Room.class, roomVo.getRoomId());
		BeanUtils.copyPropertiesNull(roomVo, room);
		this.updateEntity(room);
	}

	/**
	 * 统计优先展示房间数
	 * 
	 * @param roomVo
	 * @return
	 */
	@SuppressWarnings( { "unchecked", "deprecation" })
	public int totalPriorRoomNum(RoomVo roomVo) throws Exception {
		StringBuilder stringBuilder = new StringBuilder(
				"select count(t_room.room_id) as c from t_room,t_house where t_room.sys_house_id=t_house.sys_house_id and t_room.room_type!='KITCHEN' and t_room.is_promotions='Y' and t_house.steward_code=:stewardCode");
		Query query = this.getSession().createSQLQuery(stringBuilder.toString()).addScalar("c", Hibernate.INTEGER);
		query.setString("stewardCode", roomVo.getStewardCode());
		List list = query.list();
		int count = 0;
		if (list != null && list.size() > 0) {
			count = Integer.parseInt(list.get(0).toString());
		}
		return count;
	}

	/**
	 * 统计推荐房间数
	 * 
	 * @param roomVo
	 * @return
	 */
	@SuppressWarnings( { "deprecation", "unchecked" })
	public int totalTopRoomNum(RoomVo roomVo) throws Exception {
		StringBuilder stringBuilder = new StringBuilder(
				"select count(t_room.room_id) as c from t_room,t_house where t_room.sys_house_id=t_house.sys_house_id and t_room.room_type!='KITCHEN' and t_room.is_top='Y' and t_house.steward_code=:stewardCode");
		Query query = this.getSession().createSQLQuery(stringBuilder.toString()).addScalar("c", Hibernate.INTEGER);
		query.setString("stewardCode", roomVo.getStewardCode());
		List list = query.list();
		int count = 0;
		if (list != null && list.size() > 0) {
			count = Integer.parseInt(list.get(0).toString());
		}
		return count;
	}

	/**
	 * 其它房间租住信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings( { "deprecation", "unchecked" })
	public List<Map<String, String>> searchOtherRoom(Integer sysRoomId, Integer sysHouseId) throws Exception {
		List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
		StringBuilder sql = new StringBuilder();
		sql
				.append("select room_code as code, (select d_value from t_dict where t_room.room_position=t_dict.d_code and d_type='WINDOW_FACE') as roomposition,");
		sql
				.append("(select d_value from t_dict where t_room.rent_status=t_dict.d_code and d_type='ROOM_STATUS') as roomstatus,");
		sql.append("t_room.rent_status as rentstatus,");
		sql.append("(select d_value from t_dict where t_room.cust_sex=t_dict.d_code and d_type='SEX') as sex,");
		sql
				.append("(select professional from t_customer where t_customer.cust_code=t_room.cust_code limit 0,1) as professional");
		sql
				.append(" from t_room where t_room.room_type != 'KITCHEN' and sys_room_id!=:sysRoomId  and sys_house_id=:sysHouseId");
		Query query = this.getSession().createSQLQuery(sql.toString()).addScalar("code", Hibernate.STRING).addScalar(
				"roomposition", Hibernate.STRING).addScalar("roomstatus", Hibernate.STRING).addScalar("rentstatus",
				Hibernate.STRING).addScalar("sex", Hibernate.STRING).addScalar("professional", Hibernate.STRING);
		query.setInteger("sysRoomId", sysRoomId);
		query.setInteger("sysHouseId", sysHouseId);
		List list = query.list();
		for (Object s : list) {
			Object[] oes = (Object[]) s;
			Map<String, String> map = new HashMap<String, String>();
			map.put("code", oes[0] != null ? String.valueOf(oes[0]): "");
			map.put("roomposition", oes[1] != null ? String.valueOf(oes[1]): "");
			map.put("roomstatus", oes[2] != null ? String.valueOf(oes[2]): "");
			map.put("rentstatus", oes[3] != null ? String.valueOf(oes[3]): "");
			map.put("sex", oes[4] != null ? String.valueOf(oes[4]): "");
			map.put("professional", oes[5] != null ? String.valueOf(oes[5]): "");
			maps.add(map);
		}
		return maps;
	}

	/**
	 * 根据房屋查询房间
	 * 
	 * @param sysHouseId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RoomVo> findRoomBySysHouseId(Integer sysHouseId) throws Exception {
		List<RoomVo> roomVoes = new ArrayList<RoomVo>();
		StringBuilder hql = new StringBuilder("from Room where sysHouseId=:sysHouseId and flag!='N'");
		Query query = this.createQuery(hql.toString());
		query.setInteger("sysHouseId", sysHouseId);
		List<Room> list = query.list();
		if(list != null) {
			for(Room room : list) {
				RoomVo roomVo = new RoomVo();
				BeanUtils.copyPropertiesNotNull(room, roomVo);
				roomVoes.add(roomVo);
			}
		}
		return roomVoes;
	}
}