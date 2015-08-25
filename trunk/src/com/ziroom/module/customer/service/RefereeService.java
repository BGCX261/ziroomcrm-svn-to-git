package com.ziroom.module.customer.service;

import java.util.List;

import com.ziroom.module.customer.dao.RefereeDao;
import com.ziroom.module.customer.vo.RefereeVo;

/**
 * 自如推荐
 * 
 * @author 孙树林
 */
public class RefereeService {

	private RefereeDao refereeDao;

	private RefereeConditionInterface refereeConditionInterface;

	/**
	 * 查询自如推荐客
	 * 
	 * @param refereeVo
	 * @throws Exception
	 */
	public void searchReferee(RefereeVo refereeVo) throws Exception {
		refereeConditionInterface.handlerCondition(refereeVo);
		List<RefereeVo> refereeVoes = refereeDao.searchReferee(refereeVo);
		refereeVo.setList(refereeVoes);
	}

	public void setRefereeDao(RefereeDao refereeDao) {
		this.refereeDao = refereeDao;
	}

	public void setRefereeConditionInterface(RefereeConditionInterface refereeConditionInterface) {
		this.refereeConditionInterface = refereeConditionInterface;
	}
}