package com.ziroom.entity;

// default package

import java.util.Date;

/**
 * Contract entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Contract {

	// Fields

	private Integer id;
	private String custCode;
	private String houseCode;
	private String roomCode;
	private String contractCode;
	private String securityCode;
	private String cycle;
	private String vacancy;
	private Date signDate;
	private Date effectDate;
	private Date stopDate;
	private Double price;
	private String storeNum;
	private String storeName;
	private String businessName;
	private String areaName;
	private String storeLeaderCode;
	private String storeLeaderName;
	private String storeAgentCode;
	private String storeAgentName;
	private String agentCode;
	private String houseProduct;
	private String rental;
	private String payment;
	private String contractState;
	private String contractType;
	private Integer sysContractId;
	private Integer sysRoomId;
	private Integer sysHouseId;
	private Integer sysCustId;

	private House house;
	
	// Constructors

	/** default constructor */
	public Contract() {
	}

	/** full constructor */
	public Contract(String custCode, String houseCode, String roomCode, String contractCode, String securityCode,
			String cycle, String vacancy, Date signDate, Date effectDate, Date stopDate, Double price, String storeNum,
			String storeName, String businessName, String areaName, String storeLeaderCode, String storeLeaderName,
			String storeAgentCode, String storeAgentName, String agentCode, String houseProduct, String rental,
			String payment, String contractState, String contractType, Integer sysContractId, Integer sysRoomId,
			Integer sysHouseId, Integer sysCustId) {
		this.custCode = custCode;
		this.houseCode = houseCode;
		this.roomCode = roomCode;
		this.contractCode = contractCode;
		this.securityCode = securityCode;
		this.cycle = cycle;
		this.vacancy = vacancy;
		this.signDate = signDate;
		this.effectDate = effectDate;
		this.stopDate = stopDate;
		this.price = price;
		this.storeNum = storeNum;
		this.storeName = storeName;
		this.businessName = businessName;
		this.areaName = areaName;
		this.storeLeaderCode = storeLeaderCode;
		this.storeLeaderName = storeLeaderName;
		this.storeAgentCode = storeAgentCode;
		this.storeAgentName = storeAgentName;
		this.agentCode = agentCode;
		this.houseProduct = houseProduct;
		this.rental = rental;
		this.payment = payment;
		this.contractState = contractState;
		this.contractType = contractType;
		this.sysContractId = sysContractId;
		this.sysRoomId = sysRoomId;
		this.sysHouseId = sysHouseId;
		this.sysCustId = sysCustId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
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

	public String getContractCode() {
		return this.contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getSecurityCode() {
		return this.securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getCycle() {
		return this.cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getVacancy() {
		return this.vacancy;
	}

	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}

	public Date getSignDate() {
		return this.signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public Date getEffectDate() {
		return this.effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public Date getStopDate() {
		return this.stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStoreNum() {
		return this.storeNum;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getBusinessName() {
		return this.businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getStoreLeaderCode() {
		return this.storeLeaderCode;
	}

	public void setStoreLeaderCode(String storeLeaderCode) {
		this.storeLeaderCode = storeLeaderCode;
	}

	public String getStoreLeaderName() {
		return this.storeLeaderName;
	}

	public void setStoreLeaderName(String storeLeaderName) {
		this.storeLeaderName = storeLeaderName;
	}

	public String getStoreAgentCode() {
		return this.storeAgentCode;
	}

	public void setStoreAgentCode(String storeAgentCode) {
		this.storeAgentCode = storeAgentCode;
	}

	public String getStoreAgentName() {
		return this.storeAgentName;
	}

	public void setStoreAgentName(String storeAgentName) {
		this.storeAgentName = storeAgentName;
	}

	public String getAgentCode() {
		return this.agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getHouseProduct() {
		return this.houseProduct;
	}

	public void setHouseProduct(String houseProduct) {
		this.houseProduct = houseProduct;
	}

	public String getRental() {
		return this.rental;
	}

	public void setRental(String rental) {
		this.rental = rental;
	}

	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getContractState() {
		return this.contractState;
	}

	public void setContractState(String contractState) {
		this.contractState = contractState;
	}

	public String getContractType() {
		return this.contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public Integer getSysContractId() {
		return this.sysContractId;
	}

	public void setSysContractId(Integer sysContractId) {
		this.sysContractId = sysContractId;
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

	public Integer getSysCustId() {
		return this.sysCustId;
	}

	public void setSysCustId(Integer sysCustId) {
		this.sysCustId = sysCustId;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

}