package com.ziroom.module.contract.service;

import java.util.List;

import com.ziroom.common.connector.ConditionInterface;
import com.ziroom.module.contract.dao.InContractDao;
import com.ziroom.module.contract.vo.InContractVo;

/**
 * 收房合同业务处理类
 * 
 * @author 孙树林
 */
public class InContractService {

	private InContractDao inContractDao;
	
	private ConditionInterface inContractConditionInterface;
	
	/**
	 * 查询收房合同业务处理方法
	 * 
	 * @param outContractVo
	 * @throws Exception
	 */
	public void searchOutContract(InContractVo inContractVo) throws Exception {
		inContractConditionInterface.handlerCondition(inContractVo);
		List<InContractVo> inContractVoes = inContractDao.searchInContract(inContractVo, inContractConditionInterface.handlerFilter());
		inContractVo.setInContractVoes(inContractVoes);
	}

	public void setInContractDao(InContractDao inContractDao) {
		this.inContractDao = inContractDao;
	}

	public void setInContractConditionInterface(ConditionInterface inContractConditionInterface) {
		this.inContractConditionInterface = inContractConditionInterface;
	}

	
}
