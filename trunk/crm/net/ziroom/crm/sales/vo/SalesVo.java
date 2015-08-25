package net.ziroom.crm.sales.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.ziroom.common.action.ZiroomVo;

/**
 * 
 * @author 孙树林
 */
public class SalesVo extends ZiroomVo {

	private Integer salesId;
	private Integer custId;
	private String custName;
	private String telphone;
	private String type;
	private Integer houseId;
	private String houseNo;
	private String floorNo;
	private String unit;
	private String floor;
	private String totalFloor;
	private String apartment;
	private String salesName;
	private Date createTime;
	private String salesType;
	private String origin;
	private String stage;
	private String stageDesc;
	private BigDecimal chance = new BigDecimal(0);
	private String family;
	private String region;
	private String decorate;
	private String houseType;
	private String watfor;
	private String area;
	private String amount;
	private String price;
	private String infrastructure;
	private String facilities;
	private String otherDesc;
	private String buildingYear;

	private List<SalesVo> salesVoes = new ArrayList<SalesVo>();
	private List<TrackingHistoryVo> trackingHistoryVoes = new ArrayList<TrackingHistoryVo>();

	public Integer getSalesId() {
		return salesId;
	}

	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	public String getBuildingYear() {
		return buildingYear;
	}

	public void setBuildingYear(String buildingYear) {
		this.buildingYear = buildingYear;
	}

	public String getOtherDesc() {
		return otherDesc;
	}

	public void setOtherDesc(String otherDesc) {
		this.otherDesc = otherDesc;
	}

	public String getInfrastructure() {
		return infrastructure;
	}

	public void setInfrastructure(String infrastructure) {
		this.infrastructure = infrastructure;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDecorate() {
		return decorate;
	}

	public void setDecorate(String decorate) {
		this.decorate = decorate;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getWatfor() {
		return watfor;
	}

	public void setWatfor(String watfor) {
		this.watfor = watfor;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getTotalFloor() {
		return totalFloor;
	}

	public void setTotalFloor(String totalFloor) {
		this.totalFloor = totalFloor;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public List<SalesVo> getSalesVoes() {
		return salesVoes;
	}

	public void setSalesVoes(List<SalesVo> salesVoes) {
		this.salesVoes = salesVoes;
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

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public List<TrackingHistoryVo> getTrackingHistoryVoes() {
		return trackingHistoryVoes;
	}

	public void setTrackingHistoryVoes(List<TrackingHistoryVo> trackingHistoryVoes) {
		this.trackingHistoryVoes = trackingHistoryVoes;
	}

}
