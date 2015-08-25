package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.common.bean.PageBean;
import com.common.hibernate.Filter;
import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Contract;
import com.ziroom.entity.Customer;
import com.ziroom.module.contract.dao.InContractDao;
import com.ziroom.module.contract.vo.InContractVo;

/**
 * 收房合同数据访问接口实现类
 * 
 * @author 孙树林
 */
public class InContractDaoImpl extends HibernateQBCQuery implements InContractDao {

	/**
	 * 查询收房合同及合同的付款计划数据访问方法
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<InContractVo> searchInContract(InContractVo vo, List<Filter> filters) throws Exception {
		List<InContractVo> inContractVoes = new ArrayList<InContractVo>();
		// 查询出房合同
		StringBuilder hql = new StringBuilder(
				"from Contract c,House h,User u,Customer t where t.sysCustId = c.sysCustId and c.sysHouseId=h.sysHouseId and u.staffid=h.stewardCode and c.contractType='SF'");
		// 先统计记录数
		int count = totalInContract(vo, filters);
		PageBean pageBean = vo.getPageBean();
		pageBean.setTotalSize(count);
		// 执行查询
		HibernateQBCQuery hibernateQBCQuery = new HibernateQBCQuery();
		Query query = this.getSession().createQuery(hibernateQBCQuery.query(hql, vo, filters));
		query.setFirstResult(pageBean.getStart());
		query.setMaxResults(pageBean.getPageSize());
		List list = query.list();
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				Object[] o = (Object[]) obj;
				Contract contract = (Contract) o[0];
//				House house = (House) o[1];
//				User user = (User) o[2];
				Customer customer = (Customer) o[3];
				InContractVo inContractVo = new InContractVo();
				BeanUtils.copyPropertiesNotNull(contract, inContractVo);
				inContractVo.setCustName(customer.getCustName());
				inContractVoes.add(inContractVo);
				// TODO 收房合同付款计划
//				query = this.getSession().createQuery("from PayPlan where sysContractId=:sysContractId");
//				query.setInteger("sysContractId", contract.getSysContractId());
//				List<PayPlan> payPlans = query.list();
//				for(PayPlan payPlan : payPlans) {
//					PayPlanVo payPlanVo = new PayPlanVo();
//					BeanUtils.copyPropertiesNotNull(payPlan, payPlanVo);
//					inContractVo.getPayPlanVoes().add(payPlanVo);
//				}
			}
		}

		return inContractVoes;
	}

	/**
	 * 统计收房合同数
	 * 
	 * @param vo
	 * @param filters
	 * @return
	 * @throws Exception
	 */
	private int totalInContract(InContractVo vo, List<Filter> filters) throws Exception {
		int count = 0;
		// 查询出房合同
		StringBuilder hql = new StringBuilder(
				"select count(c.id) as c from Contract c,House h,User u,Customer t where t.sysCustId = c.sysCustId and c.sysHouseId=h.sysHouseId and u.staffid=h.stewardCode and c.contractType='SF'");
		HibernateQBCQuery hibernateQBCQuery = new HibernateQBCQuery();
		Query query = this.getSession().createQuery(hibernateQBCQuery.query(hql, vo, filters));
		Object o = query.uniqueResult();
		if (o != null) {
			count = Integer.parseInt(String.valueOf(o));
		}
		return count;
	}
}
