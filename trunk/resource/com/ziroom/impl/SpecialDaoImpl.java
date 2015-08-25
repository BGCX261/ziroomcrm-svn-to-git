package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;

import com.common.bean.OrderBean;
import com.common.enums.OrderType;
import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Room;
import com.ziroom.entity.Special;
import com.ziroom.module.cms.dao.SpecialDao;
import com.ziroom.module.cms.vo.SpecialVo;

/**
 * 专题页数据房屋接口实现类
 * 
 * @author 孙树林
 */
public class SpecialDaoImpl extends HibernateQBCQuery implements SpecialDao {

	/**
	 * 专题页查询
	 * 
	 * @param specialVo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SpecialVo> searchSpecial(SpecialVo specialVo) throws Exception {
		// 设置按排序号排序
		OrderBean orderBean = new OrderBean(OrderType.asc.getValue(), "sortNum");
		specialVo.getOrderBeans().add(orderBean);
		// 不分页
		specialVo.setPage(false);
		List<SpecialVo> specialVoes = new ArrayList<SpecialVo>();
		List<Special> list = this.criteriaOfSimple(specialVo, Special.class, false);
		for (Special special : list) {
			SpecialVo vo = new SpecialVo();
			BeanUtils.copyPropertiesNotNull(special, vo);
			specialVoes.add(vo);
		}
		return specialVoes;
	}

	/**
	 * 保存专题页信息
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void saveSpecial(SpecialVo specialVo) throws Exception {
		Special special = new Special();
		BeanUtils.copyPropertiesNotNull(specialVo, special);
		special.setHouseCode(specialVo.getHouseCode1());
		// 读如房间信息
		Room room = (Room) this.loadEntity(Room.class, specialVo.getRoomId());
		special.setRoom(room);
		this.saveEntity(special);
	}

	/**
	 * 更新专题页信息
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void updateSpecial(SpecialVo specialVo) throws Exception {
		Special special = (Special) this.loadEntity(Special.class, specialVo.getId());
		BeanUtils.copyPropertiesNotNull(specialVo, special);
		this.updateEntity(special);
	}

	/**
	 * 查找专题页信息
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void findSpecial(SpecialVo specialVo) throws Exception {
		Special special = (Special) this.loadEntity(Special.class, specialVo.getId());
		BeanUtils.copyPropertiesNotNull(special, specialVo);
	}

	/**
	 * 删除专题页信息
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void deleteSpecial(SpecialVo specialVo) throws Exception {
		Special special = (Special) this.loadEntity(Special.class, specialVo.getId());
		this.deleteEntity(special);
	}

	/**
	 * 按排序号更新
	 * 
	 * @param sortNum
	 * @throws Exception
	 */
	public void updateSortNum(int sortNum, String specialType) throws Exception {
		StringBuilder hql = new StringBuilder(
				"update Special set sortNum=sortNum-1 where sortNum>:sortNum and specialType=:specialType");
		Query query = this.getSession().createQuery(hql.toString());
		query.setInteger("sortNum", sortNum);
		query.setString("specialType", specialType);
		query.executeUpdate();
	}

	/**
	 * 排序号查找
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void findSpecialBySortNum(SpecialVo specialVo) throws Exception {
		StringBuilder hql = new StringBuilder("from Special where sortNum=:sortNum and specialType=:specialType");
		Query query = this.getSession().createQuery(hql.toString());
		query.setInteger("sortNum", specialVo.getSortNum());
		query.setString("specialType", specialVo.getSpecialType());
		List list = query.list();
		if (list != null && list.size() > 0) {
			Special special = (Special) list.get(0);
			BeanUtils.copyPropertiesNotNull(special, specialVo);
		}
	}

	/**
	 * 查找最大值
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings( { "unchecked", "deprecation" })
	public int getMaxSortNum(String specialType) throws Exception {
		StringBuilder sql = new StringBuilder(
				"select max(sort_num) as sortNum from t_special where special_type=:specialType");
		Query query = this.getSession().createSQLQuery(sql.toString()).addScalar("sortNum", Hibernate.INTEGER);
		query.setString("specialType", specialType);
		List list = query.list();
		if (list != null && list.size() > 0) {
			Object o = list.get(0);
			if (o != null) {
				return Integer.parseInt(String.valueOf(list.get(0).toString()));
			}
		}
		return 0;
	}

	/**
	 * 专题信息列表
	 * 
	 * @param specialVo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SpecialVo> searchAll(String type) throws Exception {
		StringBuilder hql = new StringBuilder("from Special where specialType=:type order by sortNum asc");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString("type", type);
		List<SpecialVo> specialVoes = new ArrayList<SpecialVo>();
		List<Special> specials = query.list();
		for (Special special : specials) {
			SpecialVo specialVo = new SpecialVo();
			BeanUtils.copyPropertiesNotNull(special, specialVo);
			specialVo.setRoomId(special.getRoom().getRoomId());
			specialVoes.add(specialVo);
		}
		return specialVoes;
	}
}
