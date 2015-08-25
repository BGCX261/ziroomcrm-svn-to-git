package com.ziroom.module.mobile.service;

import com.ziroom.module.mobile.dao.MobileDao;
import com.ziroom.module.mobile.vo.MobileVo;

/**
 * 手机报表服务的service
 * 
 * @author manguo
 */
public class MobileService {

	private MobileDao mobileDao;

	/**
	 * 向手机终端发送报表数据
	 * @return
	 */
	public MobileVo report(){
		return mobileDao.report();
	}

	public void setMobileDao(MobileDao mobileDao) {
		this.mobileDao = mobileDao;
	}
	
}
