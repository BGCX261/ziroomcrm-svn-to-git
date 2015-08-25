package com.ziroom.module.mobile.action;

import java.io.IOException;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.mobile.service.MobileService;
import com.ziroom.module.mobile.vo.MobileVo;

public class MobileAction extends ZiroomAction {

	private static final long serialVersionUID = 1L;
	
	private MobileService mobileService;

	public void report() throws Exception{
		MobileVo vo = mobileService.report();
		this.json(vo);
	}

	public void setMobileService(MobileService mobileService) {
		this.mobileService = mobileService;
	}
}
