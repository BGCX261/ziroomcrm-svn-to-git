package net.ziroom.crm.house.vo;

import net.ziroom.common.action.ZiroomVo;

/**
 * 房屋值对象
 * 
 * @author 孙树林
 */
public class HouseVo extends ZiroomVo {

	private Integer houseId;
	private Integer custId;
	private String floorNo;
	private String unit;
	private String floor;
	private String apartment;

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
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

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
}
