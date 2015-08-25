package net.ziroom.crm.entity.customer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户实体模型，业主，租客的基类
 * 
 * @author Administrator
 * 
 */
public class Customer {

	private Integer custId;
	private String custType;
	private String custName;
	private String company;
	private String custCode;
	private String telphone;
	private String email;
	private String im;
	private String imNo;
	private String certificate;
	private String certificateNo;
	private Date createDate;
	private String bank;
	private String account;
	private String bankName;
	private BigDecimal deposit = new BigDecimal(0);
	private BigDecimal accounts = new BigDecimal(0);
	private BigDecimal paidin = new BigDecimal(0);
	private BigDecimal debt = new BigDecimal(0);

	/** default constructor */
	public Customer() {
	}

	public Integer getCustId() {
		return this.custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustType() {
		return this.custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIm() {
		return this.im;
	}

	public void setIm(String im) {
		this.im = im;
	}

	public String getImNo() {
		return this.imNo;
	}

	public void setImNo(String imNo) {
		this.imNo = imNo;
	}

	public String getCertificate() {
		return this.certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getCertificateNo() {
		return this.certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public BigDecimal getAccounts() {
		return accounts;
	}

	public void setAccounts(BigDecimal accounts) {
		this.accounts = accounts;
	}

	public BigDecimal getPaidin() {
		return paidin;
	}

	public void setPaidin(BigDecimal paidin) {
		this.paidin = paidin;
	}

	public BigDecimal getDebt() {
		return debt;
	}

	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}

}