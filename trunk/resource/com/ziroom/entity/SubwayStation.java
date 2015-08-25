package com.ziroom.entity;

// default package

/**
 * SubwayStation entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SubwayStation {

	// Fields

	private Integer stationId;
	private String stationName;
	private String stationCode;
	private Float longitude;
	private Float latitude;
	private String flag;

	// Constructors

	/** default constructor */
	public SubwayStation() {
	}

	/** full constructor */
	public SubwayStation(String stationName, String stationCode,
			Float longitude, Float latitude, String flag) {
		this.stationName = stationName;
		this.stationCode = stationCode;
		this.longitude = longitude;
		this.latitude = latitude;
		this.flag = flag;
	}

	// Property accessors

	public Integer getStationId() {
		return this.stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return this.stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationCode() {
		return this.stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public Float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}