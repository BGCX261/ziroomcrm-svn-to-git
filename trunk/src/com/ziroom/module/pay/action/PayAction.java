package com.ziroom.module.pay.action;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.pay.service.PayService;
import com.ziroom.module.pay.vo.BillsVo;
import com.ziroom.module.pay.vo.PayPlanVo;

/**
 * 
 * 支付请求
 * 
 * @author 孙树林
 */
public class PayAction extends ZiroomAction {

	private static final long serialVersionUID = 2170903450977338127L;

	private String json;

	private PayService payService;
	
	private PayPlanVo payPlanVo = new PayPlanVo();

	/**
	 * 查询账单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String searchBills() throws Exception {
		BillsVo bills = payService.searchBillsByPlanId(payPlanVo.getSysPayPlanId());
		payPlanVo.setBillsVo(bills);
		return SUCCESS;
	}

	/**
	 * 网上支付回调请求Action
	 * 
	 * @throws Exception
	 */
	public void pay() throws Exception {
		payService.payHandler(json);
		out("success");
	}

	public void setPayService(PayService payService) {
		this.payService = payService;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public PayPlanVo getPayPlanVo() {
		return payPlanVo;
	}

	public void setPayPlanVo(PayPlanVo payPlanVo) {
		this.payPlanVo = payPlanVo;
	}
}
