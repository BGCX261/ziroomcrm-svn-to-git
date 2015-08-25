package com.ziroom.module.contract.action;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.contract.service.OutContractService;
import com.ziroom.module.contract.vo.OutContractVo;

/**
 * 出房合同请求Action类
 * 
 * @author 孙树林
 */
public class OutContractAction extends ZiroomAction {

	private static final long serialVersionUID = -6050365765912189500L;

	private OutContractService outContractService;

	private OutContractVo outContractVo = new OutContractVo();

	/**
	 * 查询出房合同
	 * 
	 * @return
	 * @throws Exception
	 */
	public String searchOutContract() throws Exception {
		outContractService.searchOutContract(outContractVo);
		return SUCCESS;
	}

	public OutContractVo getOutContractVo() {
		return outContractVo;
	}

	public void setOutContractVo(OutContractVo outContractVo) {
		this.outContractVo = outContractVo;
	}

	public void setOutContractService(OutContractService outContractService) {
		this.outContractService = outContractService;
	}
}
