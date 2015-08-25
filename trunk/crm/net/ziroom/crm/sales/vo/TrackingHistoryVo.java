package net.ziroom.crm.sales.vo;

import java.math.BigDecimal;
import java.util.Date;

import net.ziroom.common.action.ZiroomVo;

/**
 * 销售机会跟踪历史值对象
 * 
 * @author 孙树林
 */
public class TrackingHistoryVo extends ZiroomVo {

	private Integer salesId;
	private String salesName;
	private Date createTime;
	private String salesType;
	private String origin;
	private String stage;
	private String stageDesc;
	private BigDecimal chance = new BigDecimal(0);
	
	public Integer getSalesId() {
		return salesId;
	}

	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

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
