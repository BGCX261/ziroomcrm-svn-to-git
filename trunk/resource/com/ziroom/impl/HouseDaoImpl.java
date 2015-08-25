package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.common.bean.SearchBean;
import com.common.hibernate.Filter;
import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Contract;
import com.ziroom.entity.House;
import com.ziroom.entity.Room;
import com.ziroom.entity.RoomPicture;
import com.ziroom.module.cms.vo.SpecialVo;
import com.ziroom.module.house.dao.HouseDao;
import com.ziroom.module.house.vo.HouseVo;
import com.ziroom.module.house.vo.RoomPictureVo;
import com.ziroom.module.house.vo.RoomVo;

/**
 * 房源数据房屋接口实现类
 * 
 * @author 孙树林
 */
public class HouseDaoImpl extends HibernateQBCQuery implements HouseDao {

	/**
	 * 查询房屋
	 * 
	 * @param specialVo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<HouseVo> findHouse(SpecialVo specialVo) throws Exception {
		int totalSize = totalHoouse(specialVo);
		specialVo.getPageBean().setTotalSize(totalSize);
		StringBuilder hql = new StringBuilder(
				"select a,b from House as a, Contract as b where 1=1 and b.sysHouseId=a.sysHouseId and b.contractType='SF' ");
		if (specialVo.getHouseCode() != null && !specialVo.getHouseCode().equals("")) {
			hql.append(" and a.houseCode=:houseCode");
		}
		if (specialVo.getContractCode() != null && !specialVo.getContractCode().equals("")) {
			hql.append(" and b.contractCode=:contractCode");
		}
		if (specialVo.getHouseName() != null && !specialVo.getHouseName().equals("")) {
			hql.append(" and a.title like :title");
		}
		if (specialVo.getNewType() != null && !specialVo.getNewType().equals("")) {
			hql.append(" and a.houseProduct=:type");
		}
		Query query = this.getSession().createQuery(hql.toString());
		if (specialVo.getHouseCode() != null && !specialVo.getHouseCode().equals("")) {
			query.setString("houseCode", specialVo.getHouseCode());
		}
		if (specialVo.getContractCode() != null && !specialVo.getContractCode().equals("")) {
			query.setString("contractCode", specialVo.getContractCode());
		}
		if (specialVo.getHouseName() != null && !specialVo.getHouseName().equals("")) {
			query.setString("title", "%" + specialVo.getHouseName() + "%");
		}
		if (specialVo.getNewType() != null && !specialVo.getNewType().equals("")) {
			query.setString("type", specialVo.getNewType());
		}
		query.setFirstResult(specialVo.getPageBean().getStart());
		query.setMaxResults(specialVo.getPageBean().getPageSize());
		List list = query.list();
		List<HouseVo> houseVoes = new ArrayList<HouseVo>();
		for (int i = 0; i < list.size(); i++) {
			Object[] o = (Object[])list.get(i);
			HouseVo houseVo = new HouseVo();
			// 保存房间信息
			House house = (House)o[0];
			Contract contract = (Contract)o[1];
			BeanUtils.copyPropertiesNotNull(house, houseVo);
			houseVo.setContractCode(contract.getContractCode());
			houseVoes.add(houseVo);
		}
		return houseVoes;
	}

	/**
	 * 统计
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private int totalHoouse(SpecialVo specialVo) throws Exception {
		StringBuilder hql = new StringBuilder(
				"select count(a.houseId) from House as a, Contract as b where 1=1 and b.sysHouseId=a.sysHouseId and b.contractType='SF'");
		if (specialVo.getHouseCode() != null && !specialVo.getHouseCode().equals("")) {
			hql.append(" and a.houseCode=:houseCode");
		}
		if (specialVo.getContractCode() != null && !specialVo.getContractCode().equals("")) {
			hql.append(" and b.contractCode=:contractCode");
		}
		if (specialVo.getHouseName() != null && !specialVo.getHouseName().equals("")) {
			hql.append(" and a.title like :title");
		}
		if (specialVo.getNewType() != null && !specialVo.getNewType().equals("")) {
			hql.append(" and a.houseProduct=:type");
		}
		Query query = this.getSession().createQuery(hql.toString());
		if (specialVo.getHouseCode() != null && !specialVo.getHouseCode().equals("")) {
			query.setString("houseCode", specialVo.getHouseCode());
		}
		if (specialVo.getContractCode() != null && !specialVo.getContractCode().equals("")) {
			query.setString("contractCode", specialVo.getContractCode());
		}
		if (specialVo.getHouseName() != null && !specialVo.getHouseName().equals("")) {
			query.setString("title", "%" + specialVo.getHouseName() + "%");
		}
		if (specialVo.getNewType() != null && !specialVo.getNewType().equals("")) {
			query.setString("type", specialVo.getNewType());
		}
		List l = query.list();
		if(l != null && l.size() > 0) {
			String i = String.valueOf(l.get(0));
			return Integer.parseInt(i);
		}
		return 0;
	}

	/**
	 * 房源查询数据操作
	 */
	@SuppressWarnings("unchecked")
	public List<HouseVo> searchHouse(SearchBean searchBean, List<Filter> filters) throws Exception {
		List<HouseVo> houseVoes = new ArrayList<HouseVo>();
		// 查询房屋
		List<House> houses = this.criteriaOfSimple(searchBean, House.class, filters, false);
		// 房屋查询
		for (House house : houses) {
			HouseVo vo = new HouseVo();
			BeanUtils.copyPropertiesNotNull(house, vo);
			this.getSession().enableFilter("room").setParameter("sysHouseId", house.getSysHouseId());
			List<Room> rooms = this.criteriaOfSimple(null, Room.class, false);
			for (Room r : rooms) {
				RoomVo roomVo = new RoomVo();
				BeanUtils.copyPropertiesNotNull(r, roomVo);
				vo.addRoom(roomVo);
			}
			houseVoes.add(vo);
		}
		return houseVoes;
	}

	/**
	 * 房屋查找
	 * 
	 * @param houseId
	 * @return
	 */
	public void findHouseById(HouseVo vo) throws Exception {
		House house = (House) this.loadEntity(House.class, vo.getHouseId());
		BeanUtils.copyPropertiesNotNull(house, vo);
	}

	/**
	 * 更新房屋
	 */
	public void updateHouse(HouseVo houseVo) throws Exception {
		House house = (House) this.loadEntity(House.class, houseVo.getHouseId());
		BeanUtils.copyPropertiesNull(houseVo, house);
		this.updateEntity(house);
	}

	/**
	 * 统计房屋发布的房间数量
	 * 
	 * @param sysHouseId
	 * @return
	 */
	public int totalHousePubRoomNum(Integer sysHouseId) throws Exception {
		StringBuilder stringBuilder = new StringBuilder(
				"select count(roomId) from Room where sysHouseId=:sysHouseId and roomType!='KITCHEN'");
		Query query = this.createQuery(stringBuilder.toString());
		query.setInteger("sysHouseId", sysHouseId);
		int count = Integer.parseInt(query.list().get(0).toString());
		return count;
	}

	/**
	 * 统计房屋的房间数量
	 * 
	 * @param sysHouseId
	 * @return
	 */
	public int totalHouseRoomNum(Integer sysHouseId) throws Exception {
		StringBuilder stringBuilder = new StringBuilder(
				"select count(roomId) from Room where sysHouseId=:sysHouseId and roomType!='KITCHEN' and isShow='Y'");
		Query query = this.createQuery(stringBuilder.toString());
		query.setInteger("sysHouseId", sysHouseId);
		int count = Integer.parseInt(query.list().get(0).toString());
		return count;
	}

	/**
	 * 更新房屋信息通过sys_house_id更新
	 * 
	 * @param houseVo
	 */
	public void updateHouseBySysHouseId(HouseVo houseVo) throws Exception {
		StringBuilder stringBuilder = new StringBuilder("update House set isShow=:isShow where sysHouseId=:sysHouseId");
		Query query = this.createQuery(stringBuilder.toString());
		query.setInteger("sysHouseId", houseVo.getSysHouseId());
		query.setString("isShow", houseVo.getIsShow());
		query.executeUpdate();
	}

	/**
	 * 房屋syshouseid查找房屋
	 * 
	 * @param houseVo
	 */
	@SuppressWarnings("unchecked")
	public void findHouseBySysHouseId(HouseVo houseVo) throws Exception {
		StringBuilder stringBuilder = new StringBuilder("from House where sysHouseId=:sysHouseId");
		Query query = this.createQuery(stringBuilder.toString());
		query.setInteger("sysHouseId", houseVo.getSysHouseId());
		List<House> houses = query.list();
		if (houses != null && houses.size() > 0) {
			House house = houses.get(0);
			BeanUtils.copyPropertiesNotNull(house, houseVo);
		}
	}

	/**
	 * 房屋优先展示房间数量
	 * 
	 * @param sysHouseId
	 * @return
	 * @throws Exception
	 */
	public int totalHousePriorNum(Integer sysHouseId) throws Exception {
		StringBuilder stringBuilder = new StringBuilder(
				"select count(roomId) from Room where sysHouseId=:sysHouseId and roomType!='KITCHEN' and isPromotions='Y'");
		Query query = this.createQuery(stringBuilder.toString());
		query.setInteger("sysHouseId", sysHouseId);
		int count = Integer.parseInt(query.list().get(0).toString());
		return count;
	}

	/**
	 * 房屋推荐房间数量
	 * 
	 * @param sysHouseId
	 * @return
	 * @throws Exception
	 */
	public int totalHouseTopNum(Integer sysHouseId) throws Exception {
		StringBuilder stringBuilder = new StringBuilder(
				"select count(roomId) from Room where sysHouseId=:sysHouseId and roomType!='KITCHEN' and isTop='Y'");
		Query query = this.createQuery(stringBuilder.toString());
		query.setInteger("sysHouseId", sysHouseId);
		int count = Integer.parseInt(query.list().get(0).toString());
		return count;
	}

	/**
	 * 房屋编号查询房屋信息
	 * 
	 * @param houseCode
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public HouseVo findHouseByHouseCode(SpecialVo specialVo) throws Exception {
		StringBuilder hql = new StringBuilder(
				"select a from House as a, Contract as b where 1=1 and b.sysHouseId=a.sysHouseId ");
		hql.append(" and a.houseCode=:houseCode");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString("houseCode", specialVo.getHouseCode1());
		List<House> list = query.list();
		HouseVo houseVo = new HouseVo();
		if (list != null && list.size() > 0) {
			// 保存房间信息
			House house = list.get(0);
			BeanUtils.copyPropertiesNotNull(house, houseVo);
			// 查询房屋的房间
			this.getSession().enableFilter("room").setParameter("sysHouseId", house.getSysHouseId());
			List<Room> rooms = this.criteriaOfSimple(null, Room.class, false);
			for (Room r : rooms) {
				RoomVo roomVo = new RoomVo();
				BeanUtils.copyPropertiesNotNull(r, roomVo);
				// 查询每个房间的卧室图片
				query = this.getSession().createQuery("from RoomPicture where sysRoomId=:sysRoomId and (imagetype=1)");
				query.setInteger("sysRoomId", r.getSysRoomId());
				List<RoomPicture> roomPictures = query.list();
				if (roomPictures != null) {
					for (RoomPicture rp : roomPictures) {
						RoomPictureVo rpv = new RoomPictureVo();
						BeanUtils.copyPropertiesNotNull(rp, rpv);
						roomVo.getRoomPictures().add(rpv);
					}
				}
				houseVo.getRooms().add(roomVo);
			}
		}
		return houseVo;
	}
}