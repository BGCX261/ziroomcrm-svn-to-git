package com.ziroom.module.customer.service;

import java.util.List;

import com.ziroom.module.customer.dao.CustomerDao;
import com.ziroom.module.customer.vo.CustomerVo;

/**
 * 租客业务处理类
 * 
 * @author 孙树林
 */
public class CustomerService {

	private CustomerDao customerDao;
	
	private CustomerConditionInterface customerConditionInterface;

	/**
	 * 查询租客及租客付款计划
	 * 
	 * @param customerVo
	 * @throws Exception
	 */
	public void searchCustomerAndPayPlan(CustomerVo customerVo) throws Exception {
		customerConditionInterface.handlerCondition(customerVo);
		List<CustomerVo> customerVoes = customerDao.searchCustomerAndPayPlan(customerVo, customerConditionInterface.handlerFilter());
		customerVo.setCustomerVoes(customerVoes);
	}

	public void setCustomerConditionInterface(CustomerConditionInterface customerConditionInterface) {
		this.customerConditionInterface = customerConditionInterface;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
}
