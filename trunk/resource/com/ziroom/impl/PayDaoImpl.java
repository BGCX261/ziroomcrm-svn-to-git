package com.ziroom.impl;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Pay;
import com.ziroom.module.pay.dao.PayDao;
import com.ziroom.module.pay.vo.PayVo;

/**
 * 支付账单数据访问接口实现类
 * 
 * @author 孙树林
 */
public class PayDaoImpl extends HibernateQBCQuery implements PayDao {

	/**
	 * 保存支付返回账单数据
	 * 
	 * @param payVo
	 * @throws Exception
	 */
	public void savePay(PayVo payVo) throws Exception {
		Pay pay = new Pay();
		BeanUtils.copyPropertiesNotNull(payVo, pay);
		saveEntity(pay);
	}

}
