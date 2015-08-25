package com.ziroom.module.mobile.vo;

import java.util.HashMap;

public class MobileVo {

	private HashMap<String, String> contracts;
	private HashMap<String, String> houses;
	private HashMap<String, String> rooms;
	
	public MobileVo(){
		contracts = new HashMap<String, String>();
		houses = new HashMap<String, String>();
		rooms = new HashMap<String, String>();
	}

	public HashMap<String, String> getContracts() {
		return contracts;
	}

	public void setContracts(HashMap<String, String> contracts) {
		this.contracts = contracts;
	}

	public HashMap<String, String> getHouses() {
		return houses;
	}

	public void setHouses(HashMap<String, String> houses) {
		this.houses = houses;
	}

	public HashMap<String, String> getRooms() {
		return rooms;
	}

	public void setRooms(HashMap<String, String> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "MobileVo [contracts=" + contracts + ", houses=" + houses
				+ ", rooms=" + rooms + "]";
	}
}
