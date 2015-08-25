package com.ziroom.module.pay.dao;

import com.ziroom.module.pay.vo.PayVo;

/**
 * 支付返回账单数据访问接口
 * 
 * @author 孙树林
 */
public interface PayDao {

	/**
	 * 保存支付返回账单数据
	 * 
	 * @param payVo
	 * @throws Exception
	 */
	public void savePay(PayVo payVo) throws Exception;
}
