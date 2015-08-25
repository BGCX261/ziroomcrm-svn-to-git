package com.ziroom.entity;

import java.util.Date;

/**
 * Pay entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Pay implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -138012710945606080L;

	private Integer id;
	private String contract;
	private Float price;
	private Float totalPrice;
	private String uid;
	private String userName;
	private String payNumber;
	private Integer totalFee;
	private String houseName;
	private String houseCode;
	private String roomCode;
	private Integer payPlan;
	private String state;
	private String signInfo;
	private Date createTime;
	private String msg;

	// Constructors

	/** default constructor */
	public Pay() {
	}

	/** full constructor */
	public Pay(String contract, Float price, Float totalPrice, String uid, String userName, String payNumber,
			Integer totalFee, String houseName, String houseCode, String roomCode, Integer payPlan, String state,
			String signInfo) {
		this.contract = contract;
		this.price = price;
		this.totalPrice = totalPrice;
		this.uid = uid;
		this.userName = userName;
		this.payNumber = payNumber;
		this.totalFee = totalFee;
		this.houseName = houseName;
		this.houseCode = houseCode;
		this.roomCode = roomCode;
		this.payPlan = payPlan;
		this.state = state;
		this.signInfo = signInfo;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContract() {
		return this.contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPayNumber() {
		return this.payNumber;
	}

	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}

	public Integer getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getHouseName() {
		return this.houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
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

	public Integer getPayPlan() {
		return this.payPlan;
	}

	public void setPayPlan(Integer payPlan) {
		this.payPlan = payPlan;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSignInfo() {
		return this.signInfo;
	}

	public void setSignInfo(String signInfo) {
		this.signInfo = signInfo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}