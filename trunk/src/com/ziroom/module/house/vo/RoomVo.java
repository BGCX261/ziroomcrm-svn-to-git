package com.ziroom.module.house.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ziroom.common.action.ZiroomVo;

/**
 * 
 * @author 孙树林
 */
public class RoomVo extends ZiroomVo {

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

	private String stewardCode;

	private HouseVo houseVo = new HouseVo();
	
	private List<ConfigVo> configVoes = new ArrayList<ConfigVo>();
	private List<RoomPictureVo> roomPictures = new ArrayList<RoomPictureVo>();

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Float getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(Float roomArea) {
		this.roomArea = roomArea;
	}

	public String getRoomPosition() {
		return roomPosition;
	}

	public void setRoomPosition(String roomPosition) {
		this.roomPosition = roomPosition;
	}

	public Long getRentFee() {
		return rentFee;
	}

	public void setRentFee(Long rentFee) {
		this.rentFee = rentFee;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getNoiseEffect() {
		return noiseEffect;
	}

	public void setNoiseEffect(String noiseEffect) {
		this.noiseEffect = noiseEffect;
	}

	public String getAgentPhone() {
		return agentPhone;
	}

	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getStewardName() {
		return stewardName;
	}

	public void setStewardName(String stewardName) {
		this.stewardName = stewardName;
	}

	public String getStewardPhone() {
		return stewardPhone;
	}

	public void setStewardPhone(String stewardPhone) {
		this.stewardPhone = stewardPhone;
	}

	public String getRoomLength() {
		return roomLength;
	}

	public void setRoomLength(String roomLength) {
		this.roomLength = roomLength;
	}

	public String getRoomWidth() {
		return roomWidth;
	}

	public void setRoomWidth(String roomWidth) {
		this.roomWidth = roomWidth;
	}

	public String getRoomHeight() {
		return roomHeight;
	}

	public void setRoomHeight(String roomHeight) {
		this.roomHeight = roomHeight;
	}

	public String getRoomComment() {
		return roomComment;
	}

	public void setRoomComment(String roomComment) {
		this.roomComment = roomComment;
	}

	public Float getSaloonLength() {
		return saloonLength;
	}

	public void setSaloonLength(Float saloonLength) {
		this.saloonLength = saloonLength;
	}

	public Float getSaloonWidth() {
		return saloonWidth;
	}

	public void setSaloonWidth(Float saloonWidth) {
		this.saloonWidth = saloonWidth;
	}

	public Float getSaloonHeight() {
		return saloonHeight;
	}

	public void setSaloonHeight(Float saloonHeight) {
		this.saloonHeight = saloonHeight;
	}

	public Float getSaloonTotal() {
		return saloonTotal;
	}

	public void setSaloonTotal(Float saloonTotal) {
		this.saloonTotal = saloonTotal;
	}

	public String getSaloonMaterial() {
		return saloonMaterial;
	}

	public void setSaloonMaterial(String saloonMaterial) {
		this.saloonMaterial = saloonMaterial;
	}

	public String getSaloonMaster() {
		return saloonMaster;
	}

	public void setSaloonMaster(String saloonMaster) {
		this.saloonMaster = saloonMaster;
	}

	public String getSaloonPosition() {
		return saloonPosition;
	}

	public void setSaloonPosition(String saloonPosition) {
		this.saloonPosition = saloonPosition;
	}

	public String getSaloonDesc() {
		return saloonDesc;
	}

	public void setSaloonDesc(String saloonDesc) {
		this.saloonDesc = saloonDesc;
	}

	public Float getKitchenLength() {
		return kitchenLength;
	}

	public void setKitchenLength(Float kitchenLength) {
		this.kitchenLength = kitchenLength;
	}

	public Float getKitchenWidth() {
		return kitchenWidth;
	}

	public void setKitchenWidth(Float kitchenWidth) {
		this.kitchenWidth = kitchenWidth;
	}

	public Float getKitchenHeight() {
		return kitchenHeight;
	}

	public void setKitchenHeight(Float kitchenHeight) {
		this.kitchenHeight = kitchenHeight;
	}

	public Float getKitchenTotal() {
		return kitchenTotal;
	}

	public void setKitchenTotal(Float kitchenTotal) {
		this.kitchenTotal = kitchenTotal;
	}

	public String getKitchenStove() {
		return kitchenStove;
	}

	public void setKitchenStove(String kitchenStove) {
		this.kitchenStove = kitchenStove;
	}

	public String getKitchenGastype() {
		return kitchenGastype;
	}

	public void setKitchenGastype(String kitchenGastype) {
		this.kitchenGastype = kitchenGastype;
	}

	public String getKitchenDesc() {
		return kitchenDesc;
	}

	public void setKitchenDesc(String kitchenDesc) {
		this.kitchenDesc = kitchenDesc;
	}

	public String getTolietExist() {
		return tolietExist;
	}

	public void setTolietExist(String tolietExist) {
		this.tolietExist = tolietExist;
	}

	public Float getToiletLength() {
		return toiletLength;
	}

	public void setToiletLength(Float toiletLength) {
		this.toiletLength = toiletLength;
	}

	public Float getToiletWidth() {
		return toiletWidth;
	}

	public void setToiletWidth(Float toiletWidth) {
		this.toiletWidth = toiletWidth;
	}

	public Float getToiletHeight() {
		return toiletHeight;
	}

	public void setToiletHeight(Float toiletHeight) {
		this.toiletHeight = toiletHeight;
	}

	public Float getToiletTotal() {
		return toiletTotal;
	}

	public void setToiletTotal(Float toiletTotal) {
		this.toiletTotal = toiletTotal;
	}

	public String getToiletWindow() {
		return toiletWindow;
	}

	public void setToiletWindow(String toiletWindow) {
		this.toiletWindow = toiletWindow;
	}

	public String getToiletCurtain() {
		return toiletCurtain;
	}

	public void setToiletCurtain(String toiletCurtain) {
		this.toiletCurtain = toiletCurtain;
	}

	public String getToiletFan() {
		return toiletFan;
	}

	public void setToiletFan(String toiletFan) {
		this.toiletFan = toiletFan;
	}

	public String getToiletDesc() {
		return toiletDesc;
	}

	public void setToiletDesc(String toiletDesc) {
		this.toiletDesc = toiletDesc;
	}

	public String getBalconyExist() {
		return balconyExist;
	}

	public void setBalconyExist(String balconyExist) {
		this.balconyExist = balconyExist;
	}

	public Float getBalconyLength() {
		return balconyLength;
	}

	public void setBalconyLength(Float balconyLength) {
		this.balconyLength = balconyLength;
	}

	public Float getBalconyWidth() {
		return balconyWidth;
	}

	public void setBalconyWidth(Float balconyWidth) {
		this.balconyWidth = balconyWidth;
	}

	public Float getBalconyHeight() {
		return balconyHeight;
	}

	public void setBalconyHeight(Float balconyHeight) {
		this.balconyHeight = balconyHeight;
	}

	public Float getBalconyTotal() {
		return balconyTotal;
	}

	public void setBalconyTotal(Float balconyTotal) {
		this.balconyTotal = balconyTotal;
	}

	public String getBalconyType() {
		return balconyType;
	}

	public void setBalconyType(String balconyType) {
		this.balconyType = balconyType;
	}

	public String getBalconyDesc() {
		return balconyDesc;
	}

	public void setBalconyDesc(String balconyDesc) {
		this.balconyDesc = balconyDesc;
	}

	public String getGarderExist() {
		return garderExist;
	}

	public void setGarderExist(String garderExist) {
		this.garderExist = garderExist;
	}

	public Float getGardenLength() {
		return gardenLength;
	}

	public void setGardenLength(Float gardenLength) {
		this.gardenLength = gardenLength;
	}

	public Float getGardenWidth() {
		return gardenWidth;
	}

	public void setGardenWidth(Float gardenWidth) {
		this.gardenWidth = gardenWidth;
	}

	public Float getGardenHeight() {
		return gardenHeight;
	}

	public void setGardenHeight(Float gardenHeight) {
		this.gardenHeight = gardenHeight;
	}

	public Float getGardenTotal() {
		return gardenTotal;
	}

	public void setGardenTotal(Float gardenTotal) {
		this.gardenTotal = gardenTotal;
	}

	public String getGardenType() {
		return gardenType;
	}

	public void setGardenType(String gardenType) {
		this.gardenType = gardenType;
	}

	public String getGardenClay() {
		return gardenClay;
	}

	public void setGardenClay(String gardenClay) {
		this.gardenClay = gardenClay;
	}

	public String getGardenDesc() {
		return gardenDesc;
	}

	public void setGardenDesc(String gardenDesc) {
		this.gardenDesc = gardenDesc;
	}

	public String getTerraceExist() {
		return terraceExist;
	}

	public void setTerraceExist(String terraceExist) {
		this.terraceExist = terraceExist;
	}

	public Float getTerraceLength() {
		return terraceLength;
	}

	public void setTerraceLength(Float terraceLength) {
		this.terraceLength = terraceLength;
	}

	public Float getTerraceWidth() {
		return terraceWidth;
	}

	public void setTerraceWidth(Float terraceWidth) {
		this.terraceWidth = terraceWidth;
	}

	public Float getTerraceHeight() {
		return terraceHeight;
	}

	public void setTerraceHeight(Float terraceHeight) {
		this.terraceHeight = terraceHeight;
	}

	public Float getTerraceTotal() {
		return terraceTotal;
	}

	public void setTerraceTotal(Float terraceTotal) {
		this.terraceTotal = terraceTotal;
	}

	public String getTerraceDesc() {
		return terraceDesc;
	}

	public void setTerraceDesc(String terraceDesc) {
		this.terraceDesc = terraceDesc;
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getIsPromotions() {
		return isPromotions;
	}

	public void setIsPromotions(String isPromotions) {
		this.isPromotions = isPromotions;
	}

	public String getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getCustSex() {
		return custSex;
	}

	public void setCustSex(String custSex) {
		this.custSex = custSex;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getSysRoomId() {
		return sysRoomId;
	}

	public void setSysRoomId(Integer sysRoomId) {
		this.sysRoomId = sysRoomId;
	}

	public Integer getSysHouseId() {
		return sysHouseId;
	}

	public void setSysHouseId(Integer sysHouseId) {
		this.sysHouseId = sysHouseId;
	}

	public Integer getRadomNum() {
		return radomNum;
	}

	public void setRadomNum(Integer radomNum) {
		this.radomNum = radomNum;
	}

	public String getStewardCode() {
		return stewardCode;
	}

	public void setStewardCode(String stewardCode) {
		this.stewardCode = stewardCode;
	}

	public HouseVo getHouseVo() {
		return houseVo;
	}

	public void setHouseVo(HouseVo houseVo) {
		this.houseVo = houseVo;
	}

	public List<ConfigVo> getConfigVoes() {
		return configVoes;
	}

	public void setConfigVoes(List<ConfigVo> configVoes) {
		this.configVoes = configVoes;
	}

	public List<RoomPictureVo> getRoomPictures() {
		return roomPictures;
	}

	public void setRoomPictures(List<RoomPictureVo> roomPictures) {
		this.roomPictures = roomPictures;
	}
}
