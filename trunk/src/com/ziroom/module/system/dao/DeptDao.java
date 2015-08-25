package com.ziroom.module.system.dao;

import java.util.List;

import com.ziroom.module.system.vo.DeptVo;

/**
 * 人员部门数据访问接口
 * 
 * @author 孙树林
 */
public interface DeptDao {

	/**
	 * 根据组织机构编码查询机构
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<DeptVo> searchDeptByDeptCode(String deptCode, String deptLevel) throws Exception;
}
