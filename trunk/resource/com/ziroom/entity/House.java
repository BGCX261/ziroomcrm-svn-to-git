package com.ziroom.entity;

import java.util.Date;

/**
 * House entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class House {

	// Fields

	private Integer houseId;
	private String title;
	private String houseCode;
	private String dictHouseCode;
	private String province;
	private String city;
	private String cycle;
	private String cycleFace;
	private String counties;
	private String shopping;
	private String subwayStations;
	private String subwayLine;
	private String projectcode;
	private String building;
	private String unit;
	private String floor;
	private String totalFloor;
	private String houseNumber;
	private String buildType;
	private String originalBuildType;
	private String houseFace;
	private String houseArea;
	private String heating;
	private Integer decorateLivingNum;
	private Integer decorateBedroomNum;
	private Integer decorateKitchenNum;
	private Integer decorateBathroomNum;
	private Integer decorateBalcony;
	private Integer decorateGarden;
	private Integer decorateGazebo;
	private Long payment;
	private Integer rentNum;
	private String houseEvaluate;
	private String characteristics;
	private String environmentEvaluate;
	private String rentType;
	private Integer assistantCode;
	private String agentPhone;
	private String agentName;
	private String stewardCode;
	private String stewardName;
	private String stewardPhone;
	private String leaderCode;
	private String broadband;
	private Integer ladder;
	private Integer household;
	private String houseProduct;
	private String customerPay;
	private Date checkInTime;
	private String flvUrl;
	private String isTop;
	private String isAvailable;
	private String isPromotions;
	private String isShow;
	private String houseStatus;
	private String rentStatus;
	private String flag;
	private Integer sysHouseId;
	private Integer sysContractId;
	private Integer walktime;
	private String busstation;
	private String buscode;

	// Constructors

	/** default constructor */
	public House() {
	}

	/** full constructor */
	public House(String title, String houseCode, String dictHouseCode,
			String province, String city, String cycle, String cycleFace,
			String counties, String shopping, String subwayStations,
			String subwayLine, String projectcode, String building,
			String unit, String floor, String totalFloor, String houseNumber,
			String buildType, String originalBuildType, String houseFace,
			String houseArea, String heating, Integer decorateLivingNum,
			Integer decorateBedroomNum, Integer decorateKitchenNum,
			Integer decorateBathroomNum, Integer decorateBalcony,
			Integer decorateGarden, Integer decorateGazebo, Long payment,
			Integer rentNum, String houseEvaluate, String characteristics,
			String environmentEvaluate, String rentType, Integer assistantCode,
			String agentPhone, String agentName, String stewardCode,
			String stewardName, String stewardPhone, String leaderCode,
			String broadband, Integer ladder, Integer household,
			String houseProduct, String customerPay, Date checkInTime,
			String flvUrl, String isTop, String isAvailable,
			String isPromotions, String isShow, String houseStatus,
			String rentStatus, String flag, Integer sysHouseId,
			Integer sysContractId, Integer walktime, String busstation,
			String buscode) {
		this.title = title;
		this.houseCode = houseCode;
		this.dictHouseCode = dictHouseCode;
		this.province = province;
		this.city = city;
		this.cycle = cycle;
		this.cycleFace = cycleFace;
		this.counties = counties;
		this.shopping = shopping;
		this.subwayStations = subwayStations;
		this.subwayLine = subwayLine;
		this.projectcode = projectcode;
		this.building = building;
		this.unit = unit;
		this.floor = floor;
		this.totalFloor = totalFloor;
		this.houseNumber = houseNumber;
		this.buildType = buildType;
		this.originalBuildType = originalBuildType;
		this.houseFace = houseFace;
		this.houseArea = houseArea;
		this.heating = heating;
		this.decorateLivingNum = decorateLivingNum;
		this.decorateBedroomNum = decorateBedroomNum;
		this.decorateKitchenNum = decorateKitchenNum;
		this.decorateBathroomNum = decorateBathroomNum;
		this.decorateBalcony = decorateBalcony;
		this.decorateGarden = decorateGarden;
		this.decorateGazebo = decorateGazebo;
		this.payment = payment;
		this.rentNum = rentNum;
		this.houseEvaluate = houseEvaluate;
		this.characteristics = characteristics;
		this.environmentEvaluate = environmentEvaluate;
		this.rentType = rentType;
		this.assistantCode = assistantCode;
		this.agentPhone = agentPhone;
		this.agentName = agentName;
		this.stewardCode = stewardCode;
		this.stewardName = stewardName;
		this.stewardPhone = stewardPhone;
		this.leaderCode = leaderCode;
		this.broadband = broadband;
		this.ladder = ladder;
		this.household = household;
		this.houseProduct = houseProduct;
		this.customerPay = customerPay;
		this.checkInTime = checkInTime;
		this.flvUrl = flvUrl;
		this.isTop = isTop;
		this.isAvailable = isAvailable;
		this.isPromotions = isPromotions;
		this.isShow = isShow;
		this.houseStatus = houseStatus;
		this.rentStatus = rentStatus;
		this.flag = flag;
		this.sysHouseId = sysHouseId;
		this.sysContractId = sysContractId;
		this.walktime = walktime;
		this.busstation = busstation;
		this.buscode = buscode;
	}

	// Property accessors

	public Integer getHouseId() {
		return this.houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHouseCode() {
		return this.houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getDictHouseCode() {
		return this.dictHouseCode;
	}

	public void setDictHouseCode(String dictHouseCode) {
		this.dictHouseCode = dictHouseCode;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCycle() {
		return this.cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getCycleFace() {
		return this.cycleFace;
	}

	public void setCycleFace(String cycleFace) {
		this.cycleFace = cycleFace;
	}

	public String getCounties() {
		return this.counties;
	}

	public void setCounties(String counties) {
		this.counties = counties;
	}

	public String getShopping() {
		return this.shopping;
	}

	public void setShopping(String shopping) {
		this.shopping = shopping;
	}

	public String getSubwayStations() {
		return this.subwayStations;
	}

	public void setSubwayStations(String subwayStations) {
		this.subwayStations = subwayStations;
	}

	public String getSubwayLine() {
		return this.subwayLine;
	}

	public void setSubwayLine(String subwayLine) {
		this.subwayLine = subwayLine;
	}

	public String getProjectcode() {
		return this.projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getFloor() {
		return this.floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getTotalFloor() {
		return this.totalFloor;
	}

	public void setTotalFloor(String totalFloor) {
		this.totalFloor = totalFloor;
	}

	public String getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getBuildType() {
		return this.buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	public String getOriginalBuildType() {
		return this.originalBuildType;
	}

	public void setOriginalBuildType(String originalBuildType) {
		this.originalBuildType = originalBuildType;
	}

	public String getHouseFace() {
		return this.houseFace;
	}

	public void setHouseFace(String houseFace) {
		this.houseFace = houseFace;
	}

	public String getHouseArea() {
		return this.houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getHeating() {
		return this.heating;
	}

	public void setHeating(String heating) {
		this.heating = heating;
	}

	public Integer getDecorateLivingNum() {
		return this.decorateLivingNum;
	}

	public void setDecorateLivingNum(Integer decorateLivingNum) {
		this.decorateLivingNum = decorateLivingNum;
	}

	public Integer getDecorateBedroomNum() {
		return this.decorateBedroomNum;
	}

	public void setDecorateBedroomNum(Integer decorateBedroomNum) {
		this.decorateBedroomNum = decorateBedroomNum;
	}

	public Integer getDecorateKitchenNum() {
		return this.decorateKitchenNum;
	}

	public void setDecorateKitchenNum(Integer decorateKitchenNum) {
		this.decorateKitchenNum = decorateKitchenNum;
	}

	public Integer getDecorateBathroomNum() {
		return this.decorateBathroomNum;
	}

	public void setDecorateBathroomNum(Integer decorateBathroomNum) {
		this.decorateBathroomNum = decorateBathroomNum;
	}

	public Integer getDecorateBalcony() {
		return this.decorateBalcony;
	}

	public void setDecorateBalcony(Integer decorateBalcony) {
		this.decorateBalcony = decorateBalcony;
	}

	public Integer getDecorateGarden() {
		return this.decorateGarden;
	}

	public void setDecorateGarden(Integer decorateGarden) {
		this.decorateGarden = decorateGarden;
	}

	public Integer getDecorateGazebo() {
		return this.decorateGazebo;
	}

	public void setDecorateGazebo(Integer decorateGazebo) {
		this.decorateGazebo = decorateGazebo;
	}

	public Long getPayment() {
		return this.payment;
	}

	public void setPayment(Long payment) {
		this.payment = payment;
	}

	public Integer getRentNum() {
		return this.rentNum;
	}

	public void setRentNum(Integer rentNum) {
		this.rentNum = rentNum;
	}

	public String getHouseEvaluate() {
		return this.houseEvaluate;
	}

	public void setHouseEvaluate(String houseEvaluate) {
		this.houseEvaluate = houseEvaluate;
	}

	public String getCharacteristics() {
		return this.characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public String getEnvironmentEvaluate() {
		return this.environmentEvaluate;
	}

	public void setEnvironmentEvaluate(String environmentEvaluate) {
		this.environmentEvaluate = environmentEvaluate;
	}

	public String getRentType() {
		return this.rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public Integer getAssistantCode() {
		return this.assistantCode;
	}

	public void setAssistantCode(Integer assistantCode) {
		this.assistantCode = assistantCode;
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

	public String getStewardCode() {
		return this.stewardCode;
	}

	public void setStewardCode(String stewardCode) {
		this.stewardCode = stewardCode;
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

	public String getLeaderCode() {
		return this.leaderCode;
	}

	public void setLeaderCode(String leaderCode) {
		this.leaderCode = leaderCode;
	}

	public String getBroadband() {
		return this.broadband;
	}

	public void setBroadband(String broadband) {
		this.broadband = broadband;
	}

	public Integer getLadder() {
		return this.ladder;
	}

	public void setLadder(Integer ladder) {
		this.ladder = ladder;
	}

	public Integer getHousehold() {
		return this.household;
	}

	public void setHousehold(Integer household) {
		this.household = household;
	}

	public String getHouseProduct() {
		return this.houseProduct;
	}

	public void setHouseProduct(String houseProduct) {
		this.houseProduct = houseProduct;
	}

	public String getCustomerPay() {
		return this.customerPay;
	}

	public void setCustomerPay(String customerPay) {
		this.customerPay = customerPay;
	}

	public Date getCheckInTime() {
		return this.checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getFlvUrl() {
		return this.flvUrl;
	}

	public void setFlvUrl(String flvUrl) {
		this.flvUrl = flvUrl;
	}

	public String getIsTop() {
		return this.isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
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

	public String getIsShow() {
		return this.isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getHouseStatus() {
		return this.houseStatus;
	}

	public void setHouseStatus(String houseStatus) {
		this.houseStatus = houseStatus;
	}

	public String getRentStatus() {
		return this.rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getSysHouseId() {
		return this.sysHouseId;
	}

	public void setSysHouseId(Integer sysHouseId) {
		this.sysHouseId = sysHouseId;
	}

	public Integer getSysContractId() {
		return this.sysContractId;
	}

	public void setSysContractId(Integer sysContractId) {
		this.sysContractId = sysContractId;
	}

	public Integer getWalktime() {
		return this.walktime;
	}

	public void setWalktime(Integer walktime) {
		this.walktime = walktime;
	}

	public String getBusstation() {
		return this.busstation;
	}

	public void setBusstation(String busstation) {
		this.busstation = busstation;
	}

	public String getBuscode() {
		return this.buscode;
	}

	public void setBuscode(String buscode) {
		this.buscode = buscode;
	}
}