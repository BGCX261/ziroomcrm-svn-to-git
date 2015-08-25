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
import com.ziroom.entity.PayPlan;
import com.ziroom.module.contract.dao.OutContractDao;
import com.ziroom.module.contract.vo.OutContractVo;
import com.ziroom.module.pay.vo.PayPlanVo;

/**
 * 出房合同数据访问接口实现类
 * 
 * @author 孙树林
 */
public class OutContractDaoImpl extends HibernateQBCQuery implements OutContractDao {

	/**
	 * 查询出房合同及合同的付款计划数据访问方法
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<OutContractVo> searchOutContract(OutContractVo vo, List<Filter> filters) throws Exception {
		List<OutContractVo> outContractVoes = new ArrayList<OutContractVo>();
		// 查询出房合同
		StringBuilder hql = new StringBuilder(
				"from Contract c,House h,User u,Customer t where t.sysCustId = c.sysCustId and c.sysHouseId=h.sysHouseId and u.staffid=h.stewardCode and c.contractType!='SF'");
		// 先统计记录数
		int count = totalOutContract(vo, filters);
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
				OutContractVo outContractVo = new OutContractVo();
				BeanUtils.copyPropertiesNotNull(contract, outContractVo);
				outContractVo.setCustName(customer.getCustName());
				outContractVoes.add(outContractVo);
				query = this.getSession().createQuery("from PayPlan where sysContractId=:sysContractId");
				query.setInteger("sysContractId", contract.getSysContractId());
				List<PayPlan> payPlans = query.list();
				for(PayPlan payPlan : payPlans) {
					PayPlanVo payPlanVo = new PayPlanVo();
					BeanUtils.copyPropertiesNotNull(payPlan, payPlanVo);
					outContractVo.getPayPlanVoes().add(payPlanVo);
				}
			}
		}

		return outContractVoes;
	}

	/**
	 * 统计出房合同数
	 * 
	 * @param vo
	 * @param filters
	 * @return
	 * @throws Exception
	 */
	private int totalOutContract(OutContractVo vo, List<Filter> filters) throws Exception {
		int count = 0;
		// 查询出房合同
		StringBuilder hql = new StringBuilder(
				"select count(c.id) as c from Contract c,House h,User u,Customer t where t.sysCustId = c.sysCustId and c.sysHouseId=h.sysHouseId and u.staffid=h.stewardCode and c.contractType!='SF'");
		HibernateQBCQuery hibernateQBCQuery = new HibernateQBCQuery();
		Query query = this.getSession().createQuery(hibernateQBCQuery.query(hql, vo, filters));
		Object o = query.uniqueResult();
		if (o != null) {
			count = Integer.parseInt(String.valueOf(o));
		}
		return count;
	}
}