package com.ziroom.module.pay.vo;

import java.math.BigDecimal;

/**
 * 
 * @author 孙树林
 */
public class BillsVo {

	// Fields

	private Integer id;
	private Integer sysPayPlanId;
	private String orderCode;
	private String serialNumber;
	private BigDecimal receivables = new BigDecimal(0);
	private BigDecimal realCollection = new BigDecimal(0);
	private BigDecimal rent = new BigDecimal(0);
	private BigDecimal cleaning = new BigDecimal(0);
	private BigDecimal wired = new BigDecimal(0);
	private BigDecimal commission = new BigDecimal(0);
	private BigDecimal deposit = new BigDecimal(0);
	private BigDecimal water = new BigDecimal(0);
	private BigDecimal heatingFee = new BigDecimal(0);
	private BigDecimal electricity = new BigDecimal(0);
	private BigDecimal gasFee = new BigDecimal(0);
	private BigDecimal otherFee = new BigDecimal(0);
	private String payType;

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSysPayPlanId() {
		return this.sysPayPlanId;
	}

	public void setSysPayPlanId(Integer sysPayPlanId) {
		this.sysPayPlanId = sysPayPlanId;
	}

	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public BigDecimal getReceivables() {
		return this.receivables;
	}

	public void setReceivables(BigDecimal receivables) {
		this.receivables = receivables;
	}

	public BigDecimal getRealCollection() {
		return this.realCollection;
	}

	public void setRealCollection(BigDecimal realCollection) {
		this.realCollection = realCollection;
	}

	public BigDecimal getRent() {
		return this.rent;
	}

	public void setRent(BigDecimal rent) {
		this.rent = rent;
	}

	public BigDecimal getCleaning() {
		return this.cleaning;
	}

	public void setCleaning(BigDecimal cleaning) {
		this.cleaning = cleaning;
	}

	public BigDecimal getWired() {
		return this.wired;
	}

	public void setWired(BigDecimal wired) {
		this.wired = wired;
	}

	public BigDecimal getCommission() {
		return this.commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public BigDecimal getDeposit() {
		return this.deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public BigDecimal getWater() {
		return this.water;
	}

	public void setWater(BigDecimal water) {
		this.water = water;
	}

	public BigDecimal getHeatingFee() {
		return this.heatingFee;
	}

	public void setHeatingFee(BigDecimal heatingFee) {
		this.heatingFee = heatingFee;
	}

	public BigDecimal getElectricity() {
		return this.electricity;
	}

	public void setElectricity(BigDecimal electricity) {
		this.electricity = electricity;
	}

	public BigDecimal getGasFee() {
		return this.gasFee;
	}

	public void setGasFee(BigDecimal gasFee) {
		this.gasFee = gasFee;
	}

	public BigDecimal getOtherFee() {
		return this.otherFee;
	}

	public void setOtherFee(BigDecimal otherFee) {
		this.otherFee = otherFee;
	}

	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

}
