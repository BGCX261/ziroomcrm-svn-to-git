package com.ziroom.entity;

import java.util.Date;

/**
 * Room entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Room {

	// Fields

	private Integer roomId;
	private String roomCode;
	private String roomName;
	private String houseCode;
	private String roomType;
	private Float roomArea;
	private String roomPosition;
	private Long rentFee;
	private String payWay;
	private String noiseEffect;
	private String agentPhone;
	private String agentName;
	private String stewardName;
	private String stewardPhone;
	private String roomLength;
	private String roomWidth;
	private String roomHeight;
	private String roomComment;
	private Float saloonLength;
	private Float saloonWidth;
	private Float saloonHeight;
	private Float saloonTotal;
	private String saloonMaterial;
	private String saloonMaster;
	private String saloonPosition;
	private String saloonDesc;
	private Float kitchenLength;
	private Float kitchenWidth;
	private Float kitchenHeight;
	private Float kitchenTotal;
	private String kitchenStove;
	private String kitchenGastype;
	private String kitchenDesc;
	private String tolietExist;
	private Float toiletLength;
	private Float toiletWidth;
	private Float toiletHeight;
	private Float toiletTotal;
	private String toiletWindow;
	private String toiletCurtain;
	private String toiletFan;
	private String toiletDesc;
	private String balconyExist;
	private Float balconyLength;
	private Float balconyWidth;
	private Float balconyHeight;
	private Float balconyTotal;
	private String balconyType;
	private String balconyDesc;
	private String garderExist;
	private Float gardenLength;
	private Float gardenWidth;
	private Float gardenHeight;
	private Float gardenTotal;
	private String gardenType;
	private String gardenClay;
	private String gardenDesc;
	private String terraceExist;
	private Float terraceLength;
	private Float terraceWidth;
	private Float terraceHeight;
	private Float terraceTotal;
	private String terraceDesc;
	private Date checkInTime;
	private String isTop;
	private String isShow;
	private String isAvailable;
	private String isPromotions;
	private String rentStatus;
	private String roomStatus;
	private String custSex;
	private String custCode;
	private String flag;
	private Integer sysRoomId;
	private Integer sysHouseId;
	private Integer radomNum;
	

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** full constructor */
	public Room(String roomCode, String roomName, String houseCode,
			String roomType, Float roomArea, String roomPosition, Long rentFee,
			String payWay, String noiseEffect, String agentPhone,
			String agentName, String stewardName, String stewardPhone,
			String roomLength, String roomWidth, String roomHeight,
			String roomComment, Float saloonLength, Float saloonWidth,
			Float saloonHeight, Float saloonTotal, String saloonMaterial,
			String saloonMaster, String saloonPosition, String saloonDesc,
			Float kitchenLength, Float kitchenWidth, Float kitchenHeight,
			Float kitchenTotal, String kitchenStove, String kitchenGastype,
			String kitchenDesc, String tolietExist, Float toiletLength,
			Float toiletWidth, Float toiletHeight, Float toiletTotal,
			String toiletWindow, String toiletCurtain, String toiletFan,
			String toiletDesc, String balconyExist, Float balconyLength,
			Float balconyWidth, Float balconyHeight, Float balconyTotal,
			String balconyType, String balconyDesc, String garderExist,
			Float gardenLength, Float gardenWidth, Float gardenHeight,
			Float gardenTotal, String gardenType, String gardenClay,
			String gardenDesc, String terraceExist, Float terraceLength,
			Float terraceWidth, Float terraceHeight, Float terraceTotal,
			String terraceDesc, Date checkInTime, String isTop, String isShow,
			String isAvailable, String isPromotions, String rentStatus,
			String roomStatus, String custSex, String custCode, String flag,
			Integer sysRoomId, Integer sysHouseId, Integer radomNum) {
		this.roomCode = roomCode;
		this.roomName = roomName;
		this.houseCode = houseCode;
		this.roomType = roomType;
		this.roomArea = roomArea;
		this.roomPosition = roomPosition;
		this.rentFee = rentFee;
		this.payWay = payWay;
		this.noiseEffect = noiseEffect;
		this.agentPhone = agentPhone;
		this.agentName = agentName;
		this.stewardName = stewardName;
		this.stewardPhone = stewardPhone;
		this.roomLength = roomLength;
		this.roomWidth = roomWidth;
		this.roomHeight = roomHeight;
		this.roomComment = roomComment;
		this.saloonLength = saloonLength;
		this.saloonWidth = saloonWidth;
		this.saloonHeight = saloonHeight;
		this.saloonTotal = saloonTotal;
		this.saloonMaterial = saloonMaterial;
		this.saloonMaster = saloonMaster;
		this.saloonPosition = saloonPosition;
		this.saloonDesc = saloonDesc;
		this.kitchenLength = kitchenLength;
		this.kitchenWidth = kitchenWidth;
		this.kitchenHeight = kitchenHeight;
		this.kitchenTotal = kitchenTotal;
		this.kitchenStove = kitchenStove;
		this.kitchenGastype = kitchenGastype;
		this.kitchenDesc = kitchenDesc;
		this.tolietExist = tolietExist;
		this.toiletLength = toiletLength;
		this.toiletWidth = toiletWidth;
		this.toiletHeight = toiletHeight;
		this.toiletTotal = toiletTotal;
		this.toiletWindow = toiletWindow;
		this.toiletCurtain = toiletCurtain;
		this.toiletFan = toiletFan;
		this.toiletDesc = toiletDesc;
		this.balconyExist = balconyExist;
		this.balconyLength = balconyLength;
		this.balconyWidth = balconyWidth;
		this.balconyHeight = balconyHeight;
		this.balconyTotal = balconyTotal;
		this.balconyType = balconyType;
		this.balconyDesc = balconyDesc;
		this.garderExist = garderExist;
		this.gardenLength = gardenLength;
		this.gardenWidth = gardenWidth;
		this.gardenHeight = gardenHeight;
		this.gardenTotal = gardenTotal;
		this.gardenType = gardenType;
		this.gardenClay = gardenClay;
		this.gardenDesc = gardenDesc;
		this.terraceExist = terraceExist;
		this.terraceLength = terraceLength;
		this.terraceWidth = terraceWidth;
		this.terraceHeight = terraceHeight;
		this.terraceTotal = terraceTotal;
		this.terraceDesc = terraceDesc;
		this.checkInTime = checkInTime;
		this.isTop = isTop;
		this.isShow = isShow;
		this.isAvailable = isAvailable;
		this.isPromotions = isPromotions;
		this.rentStatus = rentStatus;
		this.roomStatus = roomStatus;
		this.custSex = custSex;
		this.custCode = custCode;
		this.flag = flag;
		this.sysRoomId = sysRoomId;
		this.sysHouseId = sysHouseId;
		this.radomNum = radomNum;
	}

	// Property accessors

	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomCode() {
		return this.roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
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

	public Long getRentFee() {
		return this.rentFee;
	}

	public void setRentFee(Long rentFee) {
		this.rentFee = rentFee;
	}

	public String getPayWay() {
		return this.payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getNoiseEffect() {
		return this.noiseEffect;
	}

	public void setNoiseEffect(String noiseEffect) {
		this.noiseEffect = noiseEffect;
	}

	public String getAgentPhone() {
		return this.agentPhone;
	}

	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
	}

	public String getAgentName() {
		return this.agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getStewardName() {
		return this.stewardName;
	}

	public void setStewardName(String stewardName) {
		this.stewardName = stewardName;
	}

	public String getStewardPhone() {
		return this.stewardPhone;
	}

	public void setStewardPhone(String stewardPhone) {
		this.stewardPhone = stewardPhone;
	}

	public String getRoomLength() {
		return this.roomLength;
	}

	public void setRoomLength(String roomLength) {
		this.roomLength = roomLength;
	}

	public String getRoomWidth() {
		return this.roomWidth;
	}

	public void setRoomWidth(String roomWidth) {
		this.roomWidth = roomWidth;
	}

	public String getRoomHeight() {
		return this.roomHeight;
	}

	public void setRoomHeight(String roomHeight) {
		this.roomHeight = roomHeight;
	}

	public String getRoomComment() {
		return this.roomComment;
	}

	public void setRoomComment(String roomComment) {
		this.roomComment = roomComment;
	}

	public Float getSaloonLength() {
		return this.saloonLength;
	}

	public void setSaloonLength(Float saloonLength) {
		this.saloonLength = saloonLength;
	}

	public Float getSaloonWidth() {
		return this.saloonWidth;
	}

	public void setSaloonWidth(Float saloonWidth) {
		this.saloonWidth = saloonWidth;
	}

	public Float getSaloonHeight() {
		return this.saloonHeight;
	}

	public void setSaloonHeight(Float saloonHeight) {
		this.saloonHeight = saloonHeight;
	}

	public Float getSaloonTotal() {
		return this.saloonTotal;
	}

	public void setSaloonTotal(Float saloonTotal) {
		this.saloonTotal = saloonTotal;
	}

	public String getSaloonMaterial() {
		return this.saloonMaterial;
	}

	public void setSaloonMaterial(String saloonMaterial) {
		this.saloonMaterial = saloonMaterial;
	}

	public String getSaloonMaster() {
		return this.saloonMaster;
	}

	public void setSaloonMaster(String saloonMaster) {
		this.saloonMaster = saloonMaster;
	}

	public String getSaloonPosition() {
		return this.saloonPosition;
	}

	public void setSaloonPosition(String saloonPosition) {
		this.saloonPosition = saloonPosition;
	}

	public String getSaloonDesc() {
		return this.saloonDesc;
	}

	public void setSaloonDesc(String saloonDesc) {
		this.saloonDesc = saloonDesc;
	}

	public Float getKitchenLength() {
		return this.kitchenLength;
	}

	public void setKitchenLength(Float kitchenLength) {
		this.kitchenLength = kitchenLength;
	}

	public Float getKitchenWidth() {
		return this.kitchenWidth;
	}

	public void setKitchenWidth(Float kitchenWidth) {
		this.kitchenWidth = kitchenWidth;
	}

	public Float getKitchenHeight() {
		return this.kitchenHeight;
	}

	public void setKitchenHeight(Float kitchenHeight) {
		this.kitchenHeight = kitchenHeight;
	}

	public Float getKitchenTotal() {
		return this.kitchenTotal;
	}

	public void setKitchenTotal(Float kitchenTotal) {
		this.kitchenTotal = kitchenTotal;
	}

	public String getKitchenStove() {
		return this.kitchenStove;
	}

	public void setKitchenStove(String kitchenStove) {
		this.kitchenStove = kitchenStove;
	}

	public String getKitchenGastype() {
		return this.kitchenGastype;
	}

	public void setKitchenGastype(String kitchenGastype) {
		this.kitchenGastype = kitchenGastype;
	}

	public String getKitchenDesc() {
		return this.kitchenDesc;
	}

	public void setKitchenDesc(String kitchenDesc) {
		this.kitchenDesc = kitchenDesc;
	}

	public String getTolietExist() {
		return this.tolietExist;
	}

	public void setTolietExist(String tolietExist) {
		this.tolietExist = tolietExist;
	}

	public Float getToiletLength() {
		return this.toiletLength;
	}

	public void setToiletLength(Float toiletLength) {
		this.toiletLength = toiletLength;
	}

	public Float getToiletWidth() {
		return this.toiletWidth;
	}

	public void setToiletWidth(Float toiletWidth) {
		this.toiletWidth = toiletWidth;
	}

	public Float getToiletHeight() {
		return this.toiletHeight;
	}

	public void setToiletHeight(Float toiletHeight) {
		this.toiletHeight = toiletHeight;
	}

	public Float getToiletTotal() {
		return this.toiletTotal;
	}

	public void setToiletTotal(Float toiletTotal) {
		this.toiletTotal = toiletTotal;
	}

	public String getToiletWindow() {
		return this.toiletWindow;
	}

	public void setToiletWindow(String toiletWindow) {
		this.toiletWindow = toiletWindow;
	}

	public String getToiletCurtain() {
		return this.toiletCurtain;
	}

	public void setToiletCurtain(String toiletCurtain) {
		this.toiletCurtain = toiletCurtain;
	}

	public String getToiletFan() {
		return this.toiletFan;
	}

	public void setToiletFan(String toiletFan) {
		this.toiletFan = toiletFan;
	}

	public String getToiletDesc() {
		return this.toiletDesc;
	}

	public void setToiletDesc(String toiletDesc) {
		this.toiletDesc = toiletDesc;
	}

	public String getBalconyExist() {
		return this.balconyExist;
	}

	public void setBalconyExist(String balconyExist) {
		this.balconyExist = balconyExist;
	}

	public Float getBalconyLength() {
		return this.balconyLength;
	}

	public void setBalconyLength(Float balconyLength) {
		this.balconyLength = balconyLength;
	}

	public Float getBalconyWidth() {
		return this.balconyWidth;
	}

	public void setBalconyWidth(Float balconyWidth) {
		this.balconyWidth = balconyWidth;
	}

	public Float getBalconyHeight() {
		return this.balconyHeight;
	}

	public void setBalconyHeight(Float balconyHeight) {
		this.balconyHeight = balconyHeight;
	}

	public Float getBalconyTotal() {
		return this.balconyTotal;
	}

	public void setBalconyTotal(Float balconyTotal) {
		this.balconyTotal = balconyTotal;
	}

	public String getBalconyType() {
		return this.balconyType;
	}

	public void setBalconyType(String balconyType) {
		this.balconyType = balconyType;
	}

	public String getBalconyDesc() {
		return this.balconyDesc;
	}

	public void setBalconyDesc(String balconyDesc) {
		this.balconyDesc = balconyDesc;
	}

	public String getGarderExist() {
		return this.garderExist;
	}

	public void setGarderExist(String garderExist) {
		this.garderExist = garderExist;
	}

	public Float getGardenLength() {
		return this.gardenLength;
	}

	public void setGardenLength(Float gardenLength) {
		this.gardenLength = gardenLength;
	}

	public Float getGardenWidth() {
		return this.gardenWidth;
	}

	public void setGardenWidth(Float gardenWidth) {
		this.gardenWidth = gardenWidth;
	}

	public Float getGardenHeight() {
		return this.gardenHeight;
	}

	public void setGardenHeight(Float gardenHeight) {
		this.gardenHeight = gardenHeight;
	}

	public Float getGardenTotal() {
		return this.gardenTotal;
	}

	public void setGardenTotal(Float gardenTotal) {
		this.gardenTotal = gardenTotal;
	}

	public String getGardenType() {
		return this.gardenType;
	}

	public void setGardenType(String gardenType) {
		this.gardenType = gardenType;
	}

	public String getGardenClay() {
		return this.gardenClay;
	}

	public void setGardenClay(String gardenClay) {
		this.gardenClay = gardenClay;
	}

	public String getGardenDesc() {
		return this.gardenDesc;
	}

	public void setGardenDesc(String gardenDesc) {
		this.gardenDesc = gardenDesc;
	}

	public String getTerraceExist() {
		return this.terraceExist;
	}

	public void setTerraceExist(String terraceExist) {
		this.terraceExist = terraceExist;
	}

	public Float getTerraceLength() {
		return this.terraceLength;
	}

	public void setTerraceLength(Float terraceLength) {
		this.terraceLength = terraceLength;
	}

	public Float getTerraceWidth() {
		return this.terraceWidth;
	}

	public void setTerraceWidth(Float terraceWidth) {
		this.terraceWidth = terraceWidth;
	}

	public Float getTerraceHeight() {
		return this.terraceHeight;
	}

	public void setTerraceHeight(Float terraceHeight) {
		this.terraceHeight = terraceHeight;
	}

	public Float getTerraceTotal() {
		return this.terraceTotal;
	}

	public void setTerraceTotal(Float terraceTotal) {
		this.terraceTotal = terraceTotal;
	}

	public String getTerraceDesc() {
		return this.terraceDesc;
	}

	public void setTerraceDesc(String terraceDesc) {
		this.terraceDesc = terraceDesc;
	}

	public Date getCheckInTime() {
		return this.checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getIsTop() {
		return this.isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public String getIsShow() {
		return this.isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getIsAvailable() {
		return this.isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getIsPromotions() {
		return this.isPromotions;
	}

	public void setIsPromotions(String isPromotions) {
		this.isPromotions = isPromotions;
	}

	public String getRentStatus() {
		return this.rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
	}

	public String getRoomStatus() {
		return this.roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getCustSex() {
		return this.custSex;
	}

	public void setCustSex(String custSex) {
		this.custSex = custSex;
	}

	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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

	public Integer getRadomNum() {
		return this.radomNum;
	}

	public void setRadomNum(Integer radomNum) {
		this.radomNum = radomNum;
	}
}