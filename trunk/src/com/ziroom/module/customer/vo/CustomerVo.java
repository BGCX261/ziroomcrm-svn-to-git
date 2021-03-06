package com.ziroom.module.customer.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ziroom.common.action.ZiroomVo;
import com.ziroom.module.pay.vo.PayPlanVo;

/**
 * 租客值对象
 * 
 * @author 孙树林
 */
public class CustomerVo extends ZiroomVo {

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
	
	private List<CustomerVo> customerVoes = new ArrayList<CustomerVo>();
	private List<PayPlanVo> payPlanVoes = new ArrayList<PayPlanVo>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertNum() {
		return certNum;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNational() {
		return national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public String getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public Integer getSysCustId() {
		return sysCustId;
	}

	public void setSysCustId(Integer sysCustId) {
		this.sysCustId = sysCustId;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public List<CustomerVo> getCustomerVoes() {
		return customerVoes;
	}

	public void setCustomerVoes(List<CustomerVo> customerVoes) {
		this.customerVoes = customerVoes;
	}

	public List<PayPlanVo> getPayPlanVoes() {
		return payPlanVoes;
	}

	public void setPayPlanVoes(List<PayPlanVo> payPlanVoes) {
		this.payPlanVoes = payPlanVoes;
	}
}
