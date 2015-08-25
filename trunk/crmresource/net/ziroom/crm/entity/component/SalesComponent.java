package net.ziroom.crm.entity.component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售机会组件
 * 
 * @author 孙树林
 */
public class SalesComponent {

	private String salesName;
	private Date createTime;
	private String salesType;
	private String origin;
	private String stage;
	private String stageDesc;
	private BigDecimal chance = new BigDecimal(0);

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSalesType() {
		return salesType;
	}

	public void setSalesType(String salesType) {
		this.salesType = salesType;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getStageDesc() {
		return stageDesc;
	}

	public void setStageDesc(String stageDesc) {
		this.stageDesc = stageDesc;
	}

	public BigDecimal getChance() {
		return chance;
	}

	public void setChance(BigDecimal chance) {
		this.chance = chance;
	}
}
