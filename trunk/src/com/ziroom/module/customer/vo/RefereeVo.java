package com.ziroom.module.customer.vo;

import java.util.ArrayList;
import java.util.List;

import com.ziroom.common.action.ZiroomVo;

/**
 * 自如客推荐值对象
 * 
 * @author 孙树林
 */
public class RefereeVo extends ZiroomVo {

	private Integer id;
	private Integer sysCustId;
	private Integer sysContractId;
	private String custName;
	private String telphone;
	private String certNo;
	private String contractCode;
	
	private List<RefereeVo> list = new ArrayList<RefereeVo>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSysCustId() {
		return sysCustId;
	}

	public void setSysCustId(Integer sysCustId) {
		this.sysCustId = sysCustId;
	}

	public Integer getSysContractId() {
		return sysContractId;
	}

	public void setSysContractId(Integer sysContractId) {
		this.sysContractId = sysContractId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public List<RefereeVo> getList() {
		return list;
	}

	public void setList(List<RefereeVo> list) {
		this.list = list;
	}
}
