package com.ziroom.entity;

/**
 * User entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class User {

	// Fields

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

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String staffid, String account, String staffPass,
			String staffName, String mobileNumber, String managerId,
			String groupName, String staffType, String setidJobcode,
			String staffRole, String deptCode, String departName,
			String deptPath, String deptLevel, String status) {
		this.staffid = staffid;
		this.account = account;
		this.staffPass = staffPass;
		this.staffName = staffName;
		this.mobileNumber = mobileNumber;
		this.managerId = managerId;
		this.groupName = groupName;
		this.staffType = staffType;
		this.setidJobcode = setidJobcode;
		this.staffRole = staffRole;
		this.deptCode = deptCode;
		this.departName = departName;
		this.deptPath = deptPath;
		this.deptLevel = deptLevel;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStaffid() {
		return this.staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getStaffPass() {
		return this.staffPass;
	}

	public void setStaffPass(String staffPass) {
		this.staffPass = staffPass;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getManagerId() {
		return this.managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getStaffType() {
		return this.staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	public String getSetidJobcode() {
		return this.setidJobcode;
	}

	public void setSetidJobcode(String setidJobcode) {
		this.setidJobcode = setidJobcode;
	}

	public String getStaffRole() {
		return this.staffRole;
	}

	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDepartName() {
		return this.departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDeptPath() {
		return this.deptPath;
	}

	public void setDeptPath(String deptPath) {
		this.deptPath = deptPath;
	}

	public String getDeptLevel() {
		return this.deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}