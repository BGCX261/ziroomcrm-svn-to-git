package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;

import com.common.bean.OrderBean;
import com.common.enums.OrderType;
import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Sowing;
import com.ziroom.module.cms.dao.SowingDao;
import com.ziroom.module.cms.vo.SowingVo;

/**
 * 首页轮播图数据访问接口实现类
 * 
 * @author 孙树林
 */
public class SowingDaoImpl extends HibernateQBCQuery implements SowingDao {

	/**
	 * 查询数据
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SowingVo> search(SowingVo vo) throws Exception {
		// 设置按排序号排序
		OrderBean orderBean = new OrderBean(OrderType.asc.getValue(), "sortNum");
		vo.getOrderBeans().add(orderBean);
		// 不分页
		vo.setPage(false);
		List<SowingVo> sowingVoes = new ArrayList<SowingVo>();
		List<Sowing> sowings = this.criteriaOfSimple(vo, Sowing.class, false);
		for (Sowing sowing : sowings) {
			SowingVo sowingVo = new SowingVo();
			BeanUtils.copyPropertiesNotNull(sowing, sowingVo);
			sowingVoes.add(sowingVo);
		}
		return sowingVoes;
	}

	/**
	 * 保存数据
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void saveSowing(SowingVo vo) throws Exception {
		Sowing sowing = new Sowing();
		BeanUtils.copyPropertiesNotNull(vo, sowing);
		this.saveEntity(sowing);
	}

	/**
	 * 更新数据
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void updateSowing(SowingVo vo) throws Exception {
		Sowing sowing = (Sowing) loadEntity(Sowing.class, vo.getId());
		BeanUtils.copyPropertiesNotNull(vo, sowing);
		this.updateEntity(sowing);
	}

	/**
	 * 删除数据
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void deleteSowing(SowingVo vo) throws Exception {
		Sowing sowing = (Sowing) loadEntity(Sowing.class, vo.getId());
		this.deleteEntity(sowing);
	}

	/**
	 * 查找数据
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void findSowing(SowingVo vo) throws Exception {
		Sowing sowing = (Sowing) loadEntity(Sowing.class, vo.getId());
		BeanUtils.copyPropertiesNotNull(sowing, vo);
	}

	/**
	 * 首页轮播图最大值
	 */
	@SuppressWarnings( { "deprecation", "unchecked" })
	public int getMaxSortNum() throws Exception {
		StringBuilder sql = new StringBuilder("select max(sort_num) as sortNum from t_sowing");
		Query query = this.getSession().createSQLQuery(sql.toString()).addScalar("sortNum", Hibernate.INTEGER);
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
	 * 排序号查找
	 * 
	 * @param vo
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void findSowingBySortNum(SowingVo vo) throws Exception {
		StringBuilder hql = new StringBuilder("from Sowing where sortNum=:sortNum");
		Query query = this.getSession().createQuery(hql.toString());
		query.setInteger("sortNum", vo.getSortNum());
		List list = query.list();
		if (list != null && list.size() > 0) {
			Sowing sowing = (Sowing) list.get(0);
			BeanUtils.copyPropertiesNotNull(sowing, vo);
		}
	}

	/**
	 * 根据排序号更新
	 * 
	 * @param sortNum
	 * @throws Exception
	 */
	public void updateSortNum(int sortNum) throws Exception {
		StringBuilder hql = new StringBuilder("update Sowing set sortNum=sortNum-1 where sortNum>:sortNum");
		Query query = this.getSession().createQuery(hql.toString());
		query.setInteger("sortNum", sortNum);
		query.executeUpdate();
	}

	/**
	 * 查询所有已发布的信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SowingVo> searchAll() throws Exception {
		StringBuilder hql = new StringBuilder("from Sowing where isShow='Y' order by sortNum asc");
		Query query = this.getSession().createQuery(hql.toString());
		List<SowingVo> sowingVoes = new ArrayList<SowingVo>();
		List<Sowing> sowings = query.list();
		for (Sowing sowing : sowings) {
			SowingVo sowingVo = new SowingVo();
			BeanUtils.copyPropertiesNotNull(sowing, sowingVo);
			sowingVoes.add(sowingVo);
		}
		return sowingVoes;
	}
}
