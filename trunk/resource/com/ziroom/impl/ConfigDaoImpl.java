package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Config;
import com.ziroom.module.house.dao.ConfigDao;
import com.ziroom.module.house.vo.ConfigVo;

/**
 * 房间物品配置数据访问接口实现类
 * 
 * @author 孙树林
 */
public class ConfigDaoImpl extends HibernateQBCQuery implements ConfigDao {

	/**
	 * 根据房间sysHouseId，物品类型查询
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings( { "unchecked", "deprecation" })
	public List<String> searchPubHouseConfig(Integer sysHouseId, String itemType) throws Exception {
		StringBuilder sql = new StringBuilder(
				"select item from v_config where sys_house_id=:sysHouseId and item_type=:itemType and sys_room_id not in(select t_room.sys_room_id from t_room where t_room.room_type != 'KITCHEN' and t_room.sys_house_id=:sysHouseId)");
		Query query = this.getSession().createSQLQuery(sql.toString()).addScalar("item", Hibernate.STRING);
		query.setInteger("sysHouseId", sysHouseId);
		query.setString("itemType", itemType);
		List<String> list = query.list();
		return list;
	}

	/**
	 * 根据房间sysRoomId，物品类型查询
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings( { "unchecked", "deprecation" })
	public List<String> searchRoomConfig(Integer sysRoomId, String itemType) throws Exception {
		StringBuilder sql = new StringBuilder(
				"select item from v_config where sys_room_id=:sysRoomId and item_type=:itemType");
		Query query = this.getSession().createSQLQuery(sql.toString()).addScalar("item", Hibernate.STRING);
		query.setInteger("sysRoomId", sysRoomId);
		query.setString("itemType", itemType);
		List<String> list = query.list();
		return list;
	}

	/**
	 * 房屋公共区域配置物品
	 * 
	 * @param sysRoomId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ConfigVo> searchPubHouseConfig(Integer sysHouseId) throws Exception {
		List<ConfigVo> configVoes = new ArrayList<ConfigVo>();
		StringBuilder hql = new StringBuilder("from Config where sysHouseId=:sysHouseId and sysRoomId not in(select r.sysRoomId from Room as r where r.roomType != 'KITCHEN' and r.sysHouseId=:sysHouseId)");
		Query query = this.getSession().createQuery(hql.toString());
		query.setInteger("sysHouseId", sysHouseId);
		List<Config> list = query.list();
		for(Config config : list) {
			ConfigVo configVo = new ConfigVo();
			BeanUtils.copyPropertiesNotNull(config, configVo);
			configVoes.add(configVo);
		}
		return configVoes;
	}

	/**
	 * 房间配置物品
	 * 
	 * @param sysRoomId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ConfigVo> searchRoomConfig(Integer sysRoomId) throws Exception {
		List<ConfigVo> configVoes = new ArrayList<ConfigVo>();
		StringBuilder hql = new StringBuilder("from Config where sysRoomId=:sysRoomId");
		Query query = this.getSession().createQuery(hql.toString());
		query.setInteger("sysRoomId", sysRoomId);
		List<Config> list = query.list();
		for(Config config : list) {
			ConfigVo configVo = new ConfigVo();
			BeanUtils.copyPropertiesNotNull(config, configVo);
			configVoes.add(configVo);
		}
		return configVoes;
	}

}
