package com.ziroom.module.contract.dao;

import java.util.List;

import com.common.hibernate.Filter;
import com.ziroom.module.contract.vo.InContractVo;

/**
 * 收房合同数据访问接口
 * 
 * @author 孙树林
 */
public interface InContractDao {

	/**
	 * 查询收房合同及合同的付款计划数据访问方法
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public List<InContractVo> searchInContract(InContractVo vo, List<Filter> filters) throws Exception;
}
