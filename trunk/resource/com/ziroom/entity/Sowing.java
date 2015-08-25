package com.ziroom.entity;

/**
 * Sowing entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Sowing {

	// Fields

	private Integer id;
	private String bigPicturePath;
	private String smallPicturePath;
	private String url;
	private String projectType;
	private String textDescription;
	private String isShow;
	private Integer sortNum;
	private String houseCode;
	private String roomCode;
	private String roomDesc;

	// Constructors

	/** default constructor */
	public Sowing() {
	}

	/** full constructor */
	public Sowing(String bigPicturePath, String smallPicturePath, String url, String projectType,
			String textDescription, String isShow, Integer sortNum) {
		this.bigPicturePath = bigPicturePath;
		this.smallPicturePath = smallPicturePath;
		this.url = url;
		this.projectType = projectType;
		this.textDescription = textDescription;
		this.isShow = isShow;
		this.sortNum = sortNum;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBigPicturePath() {
		return this.bigPicturePath;
	}

	public void setBigPicturePath(String bigPicturePath) {
		this.bigPicturePath = bigPicturePath;
	}

	public String getSmallPicturePath() {
		return this.smallPicturePath;
	}

	public void setSmallPicturePath(String smallPicturePath) {
		this.smallPicturePath = smallPicturePath;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProjectType() {
		return this.projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getTextDescription() {
		return this.textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getIsShow() {
		return this.isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public Integer getSortNum() {
		return this.sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

}