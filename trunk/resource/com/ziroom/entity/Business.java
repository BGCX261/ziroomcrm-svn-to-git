package com.ziroom.entity;

// default package

/**
 * Business entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Business {

	// Fields

	private Integer businessId;
	private String businessName;
	private String businessCode;
	private String flag;

	// Constructors

	/** default constructor */
	public Business() {
	}

	/** full constructor */
	public Business(String businessName, String businessCode, String flag) {
		this.businessName = businessName;
		this.businessCode = businessCode;
		this.flag = flag;
	}

	// Property accessors

	public Integer getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public String getBusinessName() {
		return this.businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessCode() {
		return this.businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}