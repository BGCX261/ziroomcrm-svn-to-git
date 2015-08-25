package com.ziroom.impl;

import org.hibernate.Query;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Contract;
import com.ziroom.entity.PayPlan;
import com.ziroom.module.pay.dao.PayPlanDao;
import com.ziroom.module.pay.vo.PayPlanVo;

/**
 * 付款计划数据访问接口实现类
 * 
 * @author 孙树林
 */
public class PayPlanDaoImpl extends HibernateQBCQuery implements PayPlanDao {

	/**
	 * 根据合同，付款期数查询
	 * 
	 * @param contract
	 * @param periods
	 * @return
	 * @throws Exception
	 */
	public PayPlanVo searchByContractAndPeriods(String contract, Integer periods) throws Exception {
		PayPlanVo payPlanVo = new PayPlanVo();
		// 查找合同的付款期数记录
		String hql = "from PayPlan where outContract=:contract and periods=:periods";
		Query query = this.getSession().createQuery(hql);
		query.setString("contract", contract);
		query.setInteger("periods", periods);
		Object o = query.uniqueResult();
		if (o != null) {
			PayPlan payPlan = (PayPlan) o;
			BeanUtils.copyPropertiesNotNull(payPlan, payPlanVo);
			// 关联的合同信息
			hql = "from Contract where sysContractId=:sysContractId and contractType!='SF'";
			query = this.getSession().createQuery(hql);
			query.setInteger("sysContractId", payPlan.getSysContractId());
			Object c = query.uniqueResult();
			if (c != null) {
				Contract tract = (Contract) c;
				payPlanVo.setHouseCode(tract.getHouseCode());
			}
		}
		return payPlanVo;
	}

	/**
	 * 更新付款计划状态
	 * 
	 * @param payPlanVo
	 * @throws Exception
	 */
	public void updatePayPlan(PayPlanVo payPlanVo) throws Exception {
		PayPlan payPlan = (PayPlan) this.loadEntity(PayPlan.class, payPlanVo.getId());
		BeanUtils.copyPropertiesNotNull(payPlanVo, payPlan);
		this.updateEntity(payPlan);
	}
}