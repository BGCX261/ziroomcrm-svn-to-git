package com.ziroom.module.customer.action;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.customer.service.CustomerService;
import com.ziroom.module.customer.vo.CustomerVo;

/**
 * 租客请求Action类
 * 
 * @author 孙树林
 */
public class CustomerAction extends ZiroomAction {

	private static final long serialVersionUID = -6356170658438617266L;

	private CustomerService customerService;

	private CustomerVo customerVo = new CustomerVo();

	/**
	 * 租客及付款计划
	 * 
	 * @return
	 * @throws Exception
	 */
	public String searchCustomerAndPayPlan() throws Exception {
		customerService.searchCustomerAndPayPlan(customerVo);
		return SUCCESS;
	}

	public CustomerVo getCustomerVo() {
		return customerVo;
	}

	public void setCustomerVo(CustomerVo customerVo) {
		this.customerVo = customerVo;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
