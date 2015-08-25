package com.ziroom.module.system.service;

import java.util.List;

import com.ziroom.module.system.dao.DeptDao;
import com.ziroom.module.system.vo.DeptVo;

/**
 * 组织机构业务处理类
 * 
 * @author 孙树林
 */
public class DeptService {
	
	private DeptDao deptDao;

	/**
	 * 查询组织机构
	 * 
	 * @param deptCode
	 * @param deptLevel
	 * @return
	 * @throws Exception
	 */
	public List<DeptVo> searchDept(String deptCode, String deptLevel) throws Exception {
		return deptDao.searchDeptByDeptCode(deptCode, deptLevel);
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
}
