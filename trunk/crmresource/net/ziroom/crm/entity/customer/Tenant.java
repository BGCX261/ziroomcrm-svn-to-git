package net.ziroom.crm.entity.customer;

/**
 * 租客实体模型，扩展客户实体模型
 * 
 * @author 孙树林
 */
public class Tenant extends Customer {

	private String custSource;
	private String custLevel;
	private String industry;
	private String stage;
	private String custState;
	private String custFlag;

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getCustState() {
		return custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}

	public String getCustFlag() {
		return custFlag;
	}

	public void setCustFlag(String custFlag) {
		this.custFlag = custFlag;
	}
}
