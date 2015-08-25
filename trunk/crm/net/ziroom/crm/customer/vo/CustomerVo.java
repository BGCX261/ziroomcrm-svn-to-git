package net.ziroom.crm.customer.vo;

import net.ziroom.common.action.ZiroomVo;

/**
 * 租客/业主值对象
 * 
 * @author 孙树林
 */
public class CustomerVo extends ZiroomVo {

	private Integer custId;
	private String custName;
	private String telphone;

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
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
}
