package com.ziroom.module.system.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 用户值对象
 * 
 * @author 孙树林
 */
public class UserVo {

	private Integer id;
	private String staffid;
	private String account;
	private String staffPass;
	private String staffName;
	private String mobileNumber;
	private String managerId;
	private String groupName;
	private String staffType;
	private String setidJobcode;
	private String staffRole;
	private String deptCode;
	private String departName;
	private String deptPath;
	private String deptLevel;
	private String status;
	
	private List<String> menuCode = new ArrayList<String>();
	
	private List<UserVo> userVoes = new ArrayList<UserVo>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getStaffPass() {
		return staffPass;
	}

	public void setStaffPass(String staffPass) {
		this.staffPass = staffPass;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	public String getSetidJobcode() {
		return setidJobcode;
	}

	public void setSetidJobcode(String setidJobcode) {
		this.setidJobcode = setidJobcode;
	}

	public String getStaffRole() {
		return staffRole;
	}

	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(List<String> menuCode) {
		this.menuCode = menuCode;
	}

	public List<UserVo> getUserVoes() {
		return userVoes;
	}

	public void setUserVoes(List<UserVo> userVoes) {
		this.userVoes = userVoes;
	}
}
