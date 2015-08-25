package net.ziroom.crm.entity.sales;

import net.ziroom.crm.entity.customer.Proprietor;
import net.ziroom.crm.entity.house.House;

/**
 * 房屋销售机会实体模型（意向房源）
 * 
 * @author 孙树林
 */
public class HouseSales extends Sales {

	private Proprietor proprietor;

	private House house;

	private HireAsks hireAsks;
	
	public Proprietor getProprietor() {
		return proprietor;
	}

	public void setProprietor(Proprietor proprietor) {
		this.proprietor = proprietor;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public HireAsks getHireAsks() {
		return hireAsks;
	}

	public void setHireAsks(HireAsks hireAsks) {
		this.hireAsks = hireAsks;
	}
}