package com.ziroom.module.customer.action;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.customer.service.RefereeService;
import com.ziroom.module.customer.vo.RefereeVo;

/**
 * 
 * @author 孙树林
 */
public class RefreeAction extends ZiroomAction {

	private static final long serialVersionUID = 6761926226233843058L;

	private RefereeService refereeService;

	private RefereeVo refereeVo = new RefereeVo();
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String searchReferee() throws Exception {
		refereeService.searchReferee(refereeVo);
		return SUCCESS;
	}

	public RefereeVo getRefereeVo() {
		return refereeVo;
	}

	public void setRefereeVo(RefereeVo refereeVo) {
		this.refereeVo = refereeVo;
	}

	public void setRefereeService(RefereeService refereeService) {
		this.refereeService = refereeService;
	}
}
