package com.ziroom.impl;

import org.hibernate.Query;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.module.pay.dao.BillsDao;
import com.ziroom.module.pay.vo.BillsVo;

/**
 * 账单数据访问接口实现类
 * 
 * @author 孙树林
 */
public class BillsDaoImpl extends HibernateQBCQuery implements BillsDao {

	/**
	 * 收款计划ID，查询账单
	 * 
	 * @param id
	 * @return
	 */
	public BillsVo searchByPlanId(Integer id) {
		String hql = "from Bills where sysPayPlanId=:sysPayPlanId";
		Query query = this.getSession().createQuery(hql);
		query.setInteger("sysPayPlanId", id);
		Object o = query.uniqueResult();
		BillsVo bills = new BillsVo();
		
		if(o != null) {
			BeanUtils.copyPropertiesNotNull(o, bills);
		} else {
			return null;
		}
		return bills;
	}

}
