package com.ziroom.entity;

// default package

/**
 * District entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class District {

	// Fields

	private Integer districtId;
	private String cityCode;
	private String districtName;
	private String districtCode;
	private String flag;

	// Constructors

	/** default constructor */
	public District() {
	}

	/** full constructor */
	public District(String cityCode, String districtName, String districtCode,
			String flag) {
		this.cityCode = cityCode;
		this.districtName = districtName;
		this.districtCode = districtCode;
		this.flag = flag;
	}

	// Property accessors

	public Integer getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}