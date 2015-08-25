package com.ziroom.entity;

import java.util.Date;

/**
 * Customer entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 4810030756748134318L;
	private Integer id;
	private String custName;
	private String custCode;
	private String phone;
	private String sex;
	private String birthPlace;
	private Date birth;
	private String email;
	private String certificateType;
	private String certNum;
	private String origin;
	private String degree;
	private String marriage;
	private String professional;
	private String nationality;
	private String workUnit;
	private String address;
	private String national;
	private String custStatus;
	private Integer sysCustId;
	private String custType;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(String custName, String custCode, String phone, String sex, String birthPlace, Date birth,
			String email, String certificateType, String certNum, String origin, String degree, String marriage,
			String professional, String nationality, String workUnit, String address, String national,
			String custStatus, Integer sysCustId, String custType) {
		this.custName = custName;
		this.custCode = custCode;
		this.phone = phone;
		this.sex = sex;
		this.birthPlace = birthPlace;
		this.birth = birth;
		this.email = email;
		this.certificateType = certificateType;
		this.certNum = certNum;
		this.origin = origin;
		this.degree = degree;
		this.marriage = marriage;
		this.professional = professional;
		this.nationality = nationality;
		this.workUnit = workUnit;
		this.address = address;
		this.national = national;
		this.custStatus = custStatus;
		this.sysCustId = sysCustId;
		this.custType = custType;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCertificateType() {
		return this.certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertNum() {
		return this.certNum;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getProfessional() {
		return this.professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getWorkUnit() {
		return this.workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNational() {
		return this.national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public String getCustStatus() {
		return this.custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public Integer getSysCustId() {
		return this.sysCustId;
	}

	public void setSysCustId(Integer sysCustId) {
		this.sysCustId = sysCustId;
	}

	public String getCustType() {
		return this.custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

}