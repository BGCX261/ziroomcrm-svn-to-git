package com.ziroom.module.system.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 组织机构值对象
 * 
 * @author 孙树林
 */
public class DeptVo {

	private String deptCode;
	private String departName;
	private String deptPath;
	private String deptLevel;
	
	private List<DeptVo> deptVoes = new ArrayList<DeptVo>();

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDeptPath() {
		return deptPath;
	}

	public void setDeptPath(String deptPath) {
		this.deptPath = deptPath;
	}

	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	public List<DeptVo> getDeptVoes() {
		return deptVoes;
	}

	public void setDeptVoes(List<DeptVo> deptVoes) {
		this.deptVoes = deptVoes;
	}
}
