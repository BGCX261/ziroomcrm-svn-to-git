package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.common.bean.PageBean;
import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Contract;
import com.ziroom.entity.Referee;
import com.ziroom.module.customer.dao.RefereeDao;
import com.ziroom.module.customer.vo.RefereeVo;

/**
 * 自如客推荐数据访问接口实现类
 * 
 * @author 孙树林
 */
public class RefereeDaoImpl extends HibernateQBCQuery implements RefereeDao {

	/**
	 * 查询自如客信息
	 * 
	 * @param refereeVo
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RefereeVo> searchReferee(RefereeVo refereeVo) throws Exception {
		
		List<RefereeVo> refereeVoes = new ArrayList<RefereeVo>();
		
		StringBuilder hql = new StringBuilder("from Referee r,Contract c where r.sysContractId=c.sysContractId");
		
		// 先统计记录数
		int count = countReferee(refereeVo);
		PageBean pageBean = refereeVo.getPageBean();
		pageBean.setTotalSize(count);
		
		// 执行查询
		HibernateQBCQuery hibernateQBCQuery = new HibernateQBCQuery();
		Query query = this.getSession().createQuery(hibernateQBCQuery.query(hql, refereeVo, null));
		query.setFirstResult(pageBean.getStart());
		query.setMaxResults(pageBean.getPageSize());
		List<Object> objs = query.list();
		
		// 查询
		if (objs != null && objs.size() > 0) {
			for (Object o : objs) {
				Object[] l = (Object[])o;
				Referee referee = (Referee) l[0]; 
				Contract contract = (Contract) l[1]; 
				RefereeVo vo = new RefereeVo();
				BeanUtils.copyPropertiesNotNull(referee, vo);
				vo.setContractCode(contract.getContractCode());
				refereeVoes.add(vo);
			}
		}
		
		return refereeVoes;
	}
	
	/**
	 * 统计租客及账单
	 * 
	 * @param customerVo
	 * @param filters
	 * @return
	 * @throws Exception
	 */
	private int countReferee(RefereeVo refereeVo) throws Exception {
		int count = 0;
		// hql统计语句
		StringBuilder hql = new StringBuilder(
				"select count(distinct r.id) from Referee r,Contract c where r.sysContractId=c.sysContractId");
		// 加入条件
		HibernateQBCQuery hibernateQBCQuery = new HibernateQBCQuery();
		Query query = this.getSession().createQuery(hibernateQBCQuery.query(hql, refereeVo, null));
		Object o = query.uniqueResult();
		if (o != null) {
			count = Integer.parseInt(String.valueOf(o));
		}
		return count;
	}
}
