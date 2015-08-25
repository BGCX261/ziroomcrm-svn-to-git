package com.ziroom.module.pay.vo;

import java.util.Date;

import com.ziroom.common.action.ZiroomVo;

/**
 * 
 * @author 孙树林
 */
public class PayPlanVo extends ZiroomVo {

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
	
	private String houseCode;
	
	private BillsVo billsVo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSysContractId() {
		return sysContractId;
	}

	public void setSysContractId(Integer sysContractId) {
		this.sysContractId = sysContractId;
	}

	public String getOutContract() {
		return outContract;
	}

	public void setOutContract(String outContract) {
		this.outContract = outContract;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getReceivableCycle() {
		return receivableCycle;
	}

	public void setReceivableCycle(String receivableCycle) {
		this.receivableCycle = receivableCycle;
	}

	public Double getMonthRent() {
		return monthRent;
	}

	public void setMonthRent(Double monthRent) {
		this.monthRent = monthRent;
	}

	public Integer getPeriods() {
		return periods;
	}

	public void setPeriods(Integer periods) {
		this.periods = periods;
	}

	public Date getReceivableDate() {
		return receivableDate;
	}

	public void setReceivableDate(Date receivableDate) {
		this.receivableDate = receivableDate;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public Double getCashPledge() {
		return cashPledge;
	}

	public void setCashPledge(Double cashPledge) {
		this.cashPledge = cashPledge;
	}

	public Double getBaoJieFei() {
		return baoJieFei;
	}

	public void setBaoJieFei(Double baoJieFei) {
		this.baoJieFei = baoJieFei;
	}

	public Double getTelevisionRent() {
		return televisionRent;
	}

	public void setTelevisionRent(Double televisionRent) {
		this.televisionRent = televisionRent;
	}

	public Double getReceivableMoney() {
		return receivableMoney;
	}

	public void setReceivableMoney(Double receivableMoney) {
		this.receivableMoney = receivableMoney;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSysPayPlanId() {
		return sysPayPlanId;
	}

	public void setSysPayPlanId(Integer sysPayPlanId) {
		this.sysPayPlanId = sysPayPlanId;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public BillsVo getBillsVo() {
		return billsVo;
	}

	public void setBillsVo(BillsVo billsVo) {
		this.billsVo = billsVo;
	}
}
