package com.ziroom.module.pay.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ziroom.common.util.ArithmeticUtils;
import com.ziroom.module.pay.dao.BillsDao;
import com.ziroom.module.pay.dao.PayDao;
import com.ziroom.module.pay.dao.PayPlanDao;
import com.ziroom.module.pay.vo.BillsVo;
import com.ziroom.module.pay.vo.PayPlanVo;
import com.ziroom.module.pay.vo.PayVo;

/**
 * 网上支付业务处理
 * 
 * @author 孙树林
 */
public class PayService {

	private PayDao payDao;

	private PayPlanDao payPlanDao;

	private BillsDao billsDao;

	/**
	 * 查询收付款计划账单
	 * 
	 * @param sysPlanId
	 */
	public BillsVo searchBillsByPlanId(Integer sysPlanId) {
		return billsDao.searchByPlanId(sysPlanId);
	}

	/**
	 * 网上支付业务处理方法
	 * 
	 * @param json
	 * @throws Exception
	 */
	public void payHandler(String json) throws Exception {
		PayVo payVo = new PayVo();

		// 重命名的json字段参数
		Map<String, String> fields = new HashMap<String, String>();
		fields.put("totalPrice", "total_price");
		fields.put("userName", "user_name");
		fields.put("payNumber", "pay_number");
		fields.put("totalFee", "total_fee");
		fields.put("houseName", "house_name");
		fields.put("houseCode", "house_code");
		fields.put("roomCode", "room_code");
		fields.put("payPlan", "pay_plan");
		fields.put("signInfo", "sign_info");
		// 重命名json字段
		TranslateFieldNamingStrategy translateFieldNamingStrategy = new TranslateFieldNamingStrategy(fields);

		// 解析json字串
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setFieldNamingStrategy(translateFieldNamingStrategy);
		Gson gson = gsonBuilder.create();
		payVo = gson.fromJson(json, PayVo.class);

		// 设置保存数据时间,保存数据
		payVo.setCreateTime(new Date());

		// 根据承租合同号,付款期数查询付款计划信息
		PayPlanVo payPlanVo = payPlanDao.searchByContractAndPeriods(payVo.getContract(), payVo.getPayPlan());
		String msg = null;
		if (payPlanVo != null) {
			// 验证编码;根据md5(contract+ price+house_code+pay_plan +wkey);
			String source = payPlanVo.getOutContract() + payPlanVo.getReceivableMoney().intValue()
					+ payPlanVo.getHouseCode() + payPlanVo.getPeriods() + "cd574c3cfcc5afb82d5f1f578278c5dws";
			String validatorCode = ArithmeticUtils.md5(source);
			if (validatorCode.equalsIgnoreCase(payVo.getSignInfo())) {
				// 返回结果是否成功
				if (payVo.getState() != null && payVo.getState().equalsIgnoreCase("success")) {
					// 更改收款计划状态，标识已经支付。
					payPlanVo.setStatus("0002");
					payPlanDao.updatePayPlan(payPlanVo);
					msg = "保存支付信息，数据执行成功。";
				} else {
					msg = "保存支付信息，数据执行失败，查看支付接口。";
				}
			} else {
				msg = "保存支付信息，数据更新失败，验证码不一致。";
			}
		} else {
			msg = "保存支付信息，数据更新失败，没有发现付款计划。";
		}
		payVo.setMsg(msg);
		payDao.savePay(payVo);
	}

	public void setPayDao(PayDao payDao) {
		this.payDao = payDao;
	}

	public void setPayPlanDao(PayPlanDao payPlanDao) {
		this.payPlanDao = payPlanDao;
	}

	public void setBillsDao(BillsDao billsDao) {
		this.billsDao = billsDao;
	}
}
