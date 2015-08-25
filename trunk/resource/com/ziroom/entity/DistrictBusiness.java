package com.ziroom.entity;

// default package

/**
 * DistrictBusiness entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class DistrictBusiness implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -7766761593743131880L;
	private Integer id;
	private String districtCode;
	private String businessCode;

	// Constructors

	/** default constructor */
	public DistrictBusiness() {
	}

	/** full constructor */
	public DistrictBusiness(String districtCode, String businessCode) {
		this.districtCode = districtCode;
		this.businessCode = businessCode;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getBusinessCode() {
		return this.businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

}