package net.ziroom.crm.entity.house;

import net.ziroom.crm.entity.component.HouseComponent;
import net.ziroom.crm.entity.customer.Proprietor;

/**
 * 房屋实体模型
 * 
 * @author Administrator
 * 
 */
public class House {

	private Integer houseId;
	private String houseCode;
	private HouseComponent houseComponent;
	private Proprietor proprietor;

	public House() {
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public HouseComponent getHouseComponent() {
		return houseComponent;
	}

	public void setHouseComponent(HouseComponent houseComponent) {
		this.houseComponent = houseComponent;
	}

	public Proprietor getProprietor() {
		return proprietor;
	}

	public void setProprietor(Proprietor proprietor) {
		this.proprietor = proprietor;
	}

}