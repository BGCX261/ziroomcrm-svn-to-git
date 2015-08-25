package com.ziroom.module.customer.dao;

import java.util.List;

import com.common.hibernate.Filter;
import com.ziroom.module.customer.vo.CustomerVo;

/**
 * 租客信息数据访问接口
 * 
 * @author 孙树林
 */
public interface CustomerDao {

	/**
	 * 租客及付款计划数据访问方法
	 * 
	 * @param customerVo
	 * @param filters
	 * @return
	 * @throws Exception
	 */
	public List<CustomerVo> searchCustomerAndPayPlan(CustomerVo customerVo, List<Filter> filters) throws Exception;
}
