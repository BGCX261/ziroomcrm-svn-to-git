package com.ziroom.entity;

/**
 * Referee entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Referee {

	// Fields

	private Integer id;
	private Integer sysCustId;
	private Integer sysContractId;
	private String custName;
	private String telphone;
	private String certNo;

	// Constructors

	/** default constructor */
	public Referee() {
	}

	/** full constructor */
	public Referee(Integer sysCustId, Integer sysContractId, String custName, String telphone, String certNo) {
		this.sysCustId = sysCustId;
		this.sysContractId = sysContractId;
		this.custName = custName;
		this.telphone = telphone;
		this.certNo = certNo;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSysCustId() {
		return this.sysCustId;
	}

	public void setSysCustId(Integer sysCustId) {
		this.sysCustId = sysCustId;
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

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getCertNo() {
		return this.certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
}