package com.ziroom.entity;

/**
 * RoomPicture entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class RoomPicture {

	// Fields

	private Integer hpimageid;
	private String roomCode;
	private String imageName;
	private Integer imagetype;
	private String imagepath;
	private String imageCate;
	private String imageCode;
	private String flag;
	private String houseCode;
	private Integer sysRoomId;
	private Integer sysHouseId;

	// Constructors

	/** default constructor */
	public RoomPicture() {
	}

	/** full constructor */
	public RoomPicture(String roomCode, String imageName, Integer imagetype,
			String imagepath, String imageCate, String imageCode, String flag,
			String houseCode, Integer sysRoomId, Integer sysHouseId) {
		this.roomCode = roomCode;
		this.imageName = imageName;
		this.imagetype = imagetype;
		this.imagepath = imagepath;
		this.imageCate = imageCate;
		this.imageCode = imageCode;
		this.flag = flag;
		this.houseCode = houseCode;
		this.sysRoomId = sysRoomId;
		this.sysHouseId = sysHouseId;
	}

	// Property accessors

	public Integer getHpimageid() {
		return this.hpimageid;
	}

	public void setHpimageid(Integer hpimageid) {
		this.hpimageid = hpimageid;
	}

	public String getRoomCode() {
		return this.roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Integer getImagetype() {
		return this.imagetype;
	}

	public void setImagetype(Integer imagetype) {
		this.imagetype = imagetype;
	}

	public String getImagepath() {
		return this.imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getImageCate() {
		return this.imageCate;
	}

	public void setImageCate(String imageCate) {
		this.imageCate = imageCate;
	}

	public String getImageCode() {
		return this.imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getHouseCode() {
		return this.houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public Integer getSysRoomId() {
		return this.sysRoomId;
	}

	public void setSysRoomId(Integer sysRoomId) {
		this.sysRoomId = sysRoomId;
	}

	public Integer getSysHouseId() {
		return this.sysHouseId;
	}

	public void setSysHouseId(Integer sysHouseId) {
		this.sysHouseId = sysHouseId;
	}

}