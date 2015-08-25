package com.ziroom.entity;

// default package

/**
 * Subway entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Subway {

	// Fields

	private Integer subwayId;
	private String cityCode;
	private String subwayName;
	private String subwayCode;
	private String subwayDesc;
	private String flag;

	// Constructors

	/** default constructor */
	public Subway() {
	}

	/** full constructor */
	public Subway(String cityCode, String subwayName, String subwayCode,
			String subwayDesc, String flag) {
		this.cityCode = cityCode;
		this.subwayName = subwayName;
		this.subwayCode = subwayCode;
		this.subwayDesc = subwayDesc;
		this.flag = flag;
	}

	// Property accessors

	public Integer getSubwayId() {
		return this.subwayId;
	}

	public void setSubwayId(Integer subwayId) {
		this.subwayId = subwayId;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getSubwayName() {
		return this.subwayName;
	}

	public void setSubwayName(String subwayName) {
		this.subwayName = subwayName;
	}

	public String getSubwayCode() {
		return this.subwayCode;
	}

	public void setSubwayCode(String subwayCode) {
		this.subwayCode = subwayCode;
	}

	public String getSubwayDesc() {
		return this.subwayDesc;
	}

	public void setSubwayDesc(String subwayDesc) {
		this.subwayDesc = subwayDesc;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}