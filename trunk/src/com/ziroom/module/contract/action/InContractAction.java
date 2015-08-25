package com.ziroom.module.contract.action;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.contract.service.InContractService;
import com.ziroom.module.contract.vo.InContractVo;

/**
 * 收房合同请求处理类
 * 
 * @author 孙树林
 */
public class InContractAction extends ZiroomAction {

	private static final long serialVersionUID = 8251919851093263109L;

	private InContractVo inContractVo = new InContractVo();

	private InContractService inContractService;

	/**
	 * 查询收房合同
	 * 
	 * @return
	 * @throws Exception
	 */
	public String searchInContract() throws Exception {
		inContractService.searchOutContract(inContractVo);
		return SUCCESS;
	}

	public InContractVo getInContractVo() {
		return inContractVo;
	}

	public void setInContractVo(InContractVo inContractVo) {
		this.inContractVo = inContractVo;
	}

	public void setInContractService(InContractService inContractService) {
		this.inContractService = inContractService;
	}
}
