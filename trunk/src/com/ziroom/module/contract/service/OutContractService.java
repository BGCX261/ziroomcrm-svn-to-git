package com.ziroom.module.contract.service;

import java.util.List;

import com.ziroom.module.contract.dao.OutContractDao;
import com.ziroom.module.contract.vo.OutContractVo;

/**
 * 出房合同业务处理类
 * 
 * @author 孙树林
 */
public class OutContractService {

	private OutContractDao outContractDao;
	
	private OutContractConditionInterface outContractConditionInterface;

	/**
	 * 查询出房合同业务处理方法
	 * 
	 * @param outContractVo
	 * @throws Exception
	 */
	public void searchOutContract(OutContractVo outContractVo) throws Exception {
		outContractConditionInterface.handlerCondition(outContractVo);
		List<OutContractVo> outContractVoes = outContractDao.searchOutContract(outContractVo, outContractConditionInterface.handlerFilter());
		outContractVo.setOutContractVoes(outContractVoes);
	}

	public void setOutContractDao(OutContractDao outContractDao) {
		this.outContractDao = outContractDao;
	}

	public void setOutContractConditionInterface(OutContractConditionInterface outContractConditionInterface) {
		this.outContractConditionInterface = outContractConditionInterface;
	}

}
