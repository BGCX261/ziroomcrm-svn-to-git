package com.ziroom.module.customer.dao;

import java.util.List;

import com.ziroom.module.customer.vo.RefereeVo;

/**
 * 自如客推荐数据访问接口
 * 
 * @author 孙树林
 */
public interface RefereeDao {

	/**
	 * 查询自如客信息
	 * 
	 * @param refereeVo
	 * @throws Exception
	 */
	public List<RefereeVo> searchReferee(RefereeVo refereeVo) throws Exception;
}
