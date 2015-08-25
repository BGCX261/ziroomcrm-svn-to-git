package com.ziroom.module.pay.dao;

import com.ziroom.module.pay.vo.PayPlanVo;

/**
 * 付款计划数据访问接口
 * 
 * @author 孙树林
 */
public interface PayPlanDao {

	/**
	 * 根据合同，付款期数查询
	 * 
	 * @param contract
	 * @param periods
	 * @return
	 * @throws Exception
	 */
	public PayPlanVo searchByContractAndPeriods(String contract, Integer periods) throws Exception;
	
	/**
	 * 更新付款计划状态
	 * 
	 * @param payPlanVo
	 * @throws Exception
	 */
	public void updatePayPlan(PayPlanVo payPlanVo) throws Exception;
}