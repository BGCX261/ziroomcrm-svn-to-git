package net.ziroom.crm.entity.sales;

/**
 * 房屋出租信息实体模型
 * 
 * @author 孙树林
 */
public class HireAsks extends Asks {

	private String buildingYear;
	private String floorNo;
	private String unit;
	private String floor;
	private String totalFloor;
	private String apartment;
	
	private HouseSales houseSales;

	public String getBuildingYear() {
		return buildingYear;
	}

	public void setBuildingYear(String buildingYear) {
		this.buildingYear = buildingYear;
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

	public HouseSales getHouseSales() {
		return houseSales;
	}

	public void setHouseSales(HouseSales houseSales) {
		this.houseSales = houseSales;
	}
}
