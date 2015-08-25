package com.ziroom.entity;

/**
 * Special entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Special {

	// Fields

	private Integer id;
	private String roomName;
	private String houseCode;
	private String roomCode;
	private String roomType;
	private Float roomArea;
	private String roomPosition;
	private Float rentFee;
	private Float cleaningFee;
	private String imagePath;
	private String specialType;
	private Integer sortNum;

	private Room room;

	// Constructors

	/** default constructor */
	public Special() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getHouseCode() {
		return this.houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getRoomCode() {
		return this.roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Float getRoomArea() {
		return this.roomArea;
	}

	public void setRoomArea(Float roomArea) {
		this.roomArea = roomArea;
	}

	public String getRoomPosition() {
		return this.roomPosition;
	}

	public void setRoomPosition(String roomPosition) {
		this.roomPosition = roomPosition;
	}

	public Float getRentFee() {
		return this.rentFee;
	}

	public void setRentFee(Float rentFee) {
		this.rentFee = rentFee;
	}

	public Float getCleaningFee() {
		return cleaningFee;
	}

	public void setCleaningFee(Float cleaningFee) {
		this.cleaningFee = cleaningFee;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getSpecialType() {
		return this.specialType;
	}

	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}

	public Integer getSortNum() {
		return this.sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}