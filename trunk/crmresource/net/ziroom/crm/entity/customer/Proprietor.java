package net.ziroom.crm.entity.customer;

import java.util.HashSet;
import java.util.Set;

import net.ziroom.crm.entity.house.House;

/**
 * 业主实体模型，扩展客户实体模型
 * 
 * @author 孙树林
 */
public class Proprietor extends Customer {

	private Set<House> houses = new HashSet<House>(0);

	public Set<House> getHouses() {
		return houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}
}
