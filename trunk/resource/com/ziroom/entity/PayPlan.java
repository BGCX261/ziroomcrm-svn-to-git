package com.ziroom.entity;

import java.util.Date;

/**
 * PayPlan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PayPlan implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1316382769699913582L;

	private Integer id;
	private Integer sysContractId;
	private String outContract;
	private String custName;
	private String receivableCycle;
	private Double monthRent;
	private Integer periods;
	private Date receivableDate;
	private String rentDate;
	private Double rent;
	private Double commission;
	private Double cashPledge;
	private Double baoJieFei;
	private Double televisionRent;
	private Double receivableMoney;
	private String status;
	private Integer sysPayPlanId;

	// Constructors

	/** default constructor */
	public PayPlan() {
	}

	/** full constructor */
	public PayPlan(Integer sysContractId, String custName, String receivableCycle, Double monthRent, Integer periods,
			Date receivableDate, String rentDate, Double rent, Double commission, Double cashPledge, Double baoJieFei,
			Double televisionRent, Double receivableMoney, String status, Integer sysPayPlanId) {
		this.sysContractId = sysContractId;
		this.custName = custName;
		this.receivableCycle = receivableCycle;
		this.monthRent = monthRent;
		this.periods = periods;
		this.receivableDate = receivableDate;
		this.rentDate = rentDate;
		this.rent = rent;
		this.commission = commission;
		this.cashPledge = cashPledge;
		this.baoJieFei = baoJieFei;
		this.televisionRent = televisionRent;
		this.receivableMoney = receivableMoney;
		this.status = status;
		this.sysPayPlanId = sysPayPlanId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSysContractId() {
		return this.sysContractId;
	}

	public void setSysContractId(Integer sysContractId) {
		this.sysContractId = sysContractId;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getReceivableCycle() {
		return this.receivableCycle;
	}

	public void setReceivableCycle(String receivableCycle) {
		this.receivableCycle = receivableCycle;
	}

	public Double getMonthRent() {
		return this.monthRent;
	}

	public void setMonthRent(Double monthRent) {
		this.monthRent = monthRent;
	}

	public Integer getPeriods() {
		return this.periods;
	}

	public void setPeriods(Integer periods) {
		this.periods = periods;
	}

	public Date getReceivableDate() {
		return this.receivableDate;
	}

	public void setReceivableDate(Date receivableDate) {
		this.receivableDate = receivableDate;
	}

	public String getRentDate() {
		return this.rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public Double getRent() {
		return this.rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public Double getCommission() {
		return this.commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public Double getCashPledge() {
		return this.cashPledge;
	}

	public void setCashPledge(Double cashPledge) {
		this.cashPledge = cashPledge;
	}

	public Double getBaoJieFei() {
		return this.baoJieFei;
	}

	public void setBaoJieFei(Double baoJieFei) {
		this.baoJieFei = baoJieFei;
	}

	public Double getTelevisionRent() {
		return this.televisionRent;
	}

	public void setTelevisionRent(Double televisionRent) {
		this.televisionRent = televisionRent;
	}

	public Double getReceivableMoney() {
		return this.receivableMoney;
	}

	public void setReceivableMoney(Double receivableMoney) {
		this.receivableMoney = receivableMoney;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSysPayPlanId() {
		return this.sysPayPlanId;
	}

	public void setSysPayPlanId(Integer sysPayPlanId) {
		this.sysPayPlanId = sysPayPlanId;
	}

	public String getOutContract() {
		return outContract;
	}

	public void setOutContract(String outContract) {
		this.outContract = outContract;
	}

}