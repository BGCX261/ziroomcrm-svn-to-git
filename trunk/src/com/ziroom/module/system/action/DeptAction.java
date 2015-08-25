package com.ziroom.module.system.action;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.system.service.DeptService;
import com.ziroom.module.system.vo.DeptVo;

/**
 * 
 * @author 孙树林
 */
public class DeptAction extends ZiroomAction {

	private static final long serialVersionUID = 5078009148321949091L;

	private DeptVo deptVo = new DeptVo();

	private DeptService deptService;

	/**
	 * ajax请求部门
	 * 
	 * @throws Exception
	 */
	public void ajaxDept() throws Exception {
		searchDeptByCodeAndLevel();
		json(deptVo.getDeptVoes());
	}

	/**
	 * 机构编码及界别查询
	 * 
	 * @throws Exception
	 */
	public void searchDeptByCodeAndLevel() throws Exception {
		deptVo.setDeptVoes(deptService.searchDept(deptVo.getDeptCode(), deptVo
				.getDeptLevel()));
	}

	public DeptVo getDeptVo() {
		return deptVo;
	}

	public void setDeptVo(DeptVo deptVo) {
		this.deptVo = deptVo;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
}
