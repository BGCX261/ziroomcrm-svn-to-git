package com.ziroom.module.pay.dao;

import com.ziroom.module.pay.vo.BillsVo;

/**
 * 账单数据访问接口
 * 
 * @author 孙树林
 */
public interface BillsDao {

	/**
	 * 收款计划ID，查询账单
	 * 
	 * @param id
	 * @return
	 */
	public BillsVo searchByPlanId(Integer id);
}
