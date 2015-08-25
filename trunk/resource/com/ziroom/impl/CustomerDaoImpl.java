package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.common.bean.PageBean;
import com.common.hibernate.Filter;
import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Customer;
import com.ziroom.entity.PayPlan;
import com.ziroom.module.customer.dao.CustomerDao;
import com.ziroom.module.customer.vo.CustomerVo;
import com.ziroom.module.pay.vo.PayPlanVo;

/**
 * 租客数据访问接口实现类
 * 
 * @author 孙树林
 */
public class CustomerDaoImpl extends HibernateQBCQuery implements CustomerDao {

	/**
	 * 租客及付款计划数据访问方法
	 * 
	 * @param customerVo
	 * @param filters
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerVo> searchCustomerAndPayPlan(CustomerVo customerVo, List<Filter> filters) throws Exception {
		List<CustomerVo> customerVoes = new ArrayList<CustomerVo>();
		// 查询客户SQL
		StringBuilder hql = new StringBuilder(
				"select distinct t from Customer t,Contract c,User u,House h where t.sysCustId = c.sysCustId and h.sysHouseId=c.sysHouseId and t.sysCustId=c.sysCustId and u.staffid=c.agentCode and c.contractType !='SF' and t.custType='KH'");

		// 先统计记录数
		int count = countCustomerAndPayPlan(customerVo, filters);
		PageBean pageBean = customerVo.getPageBean();
		pageBean.setTotalSize(count);

		// 执行查询
		HibernateQBCQuery hibernateQBCQuery = new HibernateQBCQuery();
		Query query = this.getSession().createQuery(hibernateQBCQuery.query(hql, customerVo, filters));
		query.setFirstResult(pageBean.getStart());
		query.setMaxResults(pageBean.getPageSize());
		List<Customer> list = query.list();

		if (list != null && list.size() > 0) {
			for (Customer customer : list) {
				CustomerVo vo = new CustomerVo();
				BeanUtils.copyPropertiesNotNull(customer, vo);
				customerVoes.add(vo);
				hql = new StringBuilder("select distinct p from Customer t,Contract c, PayPlan p where t.sysCustId=c.sysCustId and c.sysContractId=p.sysContractId and t.sysCustId=:sysCustId");
				query = this.getSession().createQuery(hql.toString());
				query.setInteger("sysCustId", customer.getSysCustId());
				// 租客对账单
				List<PayPlan> payPlans = query.list();
				for(PayPlan payPlan : payPlans) {
					PayPlanVo payPlanVo = new PayPlanVo();
					BeanUtils.copyPropertiesNotNull(payPlan, payPlanVo);
					vo.getPayPlanVoes().add(payPlanVo);
				}
			}
		}

		return customerVoes;
	}

	/**
	 * 统计租客及账单
	 * 
	 * @param customerVo
	 * @param filters
	 * @return
	 * @throws Exception
	 */
	private int countCustomerAndPayPlan(CustomerVo customerVo, List<Filter> filters) throws Exception {
		int count = 0;
		// hql统计语句
		StringBuilder hql = new StringBuilder(
				"select count(distinct t.id) from Customer t,Contract c,User u,House h where t.sysCustId = c.sysCustId and h.sysHouseId=c.sysHouseId and u.staffid=c.agentCode and c.contractType !='SF' and t.custType='KH'");
		// 加入条件
		HibernateQBCQuery hibernateQBCQuery = new HibernateQBCQuery();
		Query query = this.getSession().createQuery(hibernateQBCQuery.query(hql, customerVo, filters));
		Object o = query.uniqueResult();
		if (o != null) {
			count = Integer.parseInt(String.valueOf(o));
		}
		return count;
	}
}
