package net.ziroom.crm.entity.sales;

/**
 * 求租/出租信息实体模型
 * 
 * @author Administrator
 * 
 */
public class Asks {

	private Integer asksId;
	private String address;
	private String family;
	private String region;
	private String decorate;
	private String houseType;
	private String watfor;
	private String area;
	private String amount;
	private String infrastructure;
	private String facilities;
	private String price;
	private String otherDesc;

	public Asks() {
	}

	public Integer getAsksId() {
		return this.asksId;
	}

	public void setAsksId(Integer asksId) {
		this.asksId = asksId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDecorate() {
		return this.decorate;
	}

	public void setDecorate(String decorate) {
		this.decorate = decorate;
	}

	public String getHouseType() {
		return this.houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getWatfor() {
		return this.watfor;
	}

	public void setWatfor(String watfor) {
		this.watfor = watfor;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getInfrastructure() {
		return this.infrastructure;
	}

	public void setInfrastructure(String infrastructure) {
		this.infrastructure = infrastructure;
	}

	public String getFacilities() {
		return this.facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOtherDesc() {
		return this.otherDesc;
	}

	public void setOtherDesc(String otherDesc) {
		this.otherDesc = otherDesc;
	}
}