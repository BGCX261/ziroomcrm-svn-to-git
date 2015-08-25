package com.ziroom.entity;

/**
 * Config entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Config {

	// Fields

	private Integer id;
	private String houseCode;
	private String roomCode;
	private String itemCode;
	private String itemName;
	private String itemBrand;
	private Integer itemNum;
	private String itemUnit;
	private String itemUseYears;
	private String itemDesc;
	private String itemType;
	private String itemSpac;
	private String pictUrl;
	private String flag;
	private Integer sysRoomId;
	private Integer sysHouseId;

	// Constructors

	/** default constructor */
	public Config() {
	}

	/** full constructor */
	public Config(String houseCode, String roomCode, String itemCode,
			String itemName, String itemBrand, Integer itemNum,
			String itemUnit, String itemUseYears, String itemDesc,
			String itemType, String itemSpac, String pictUrl, String flag,
			Integer sysRoomId, Integer sysHouseId) {
		this.houseCode = houseCode;
		this.roomCode = roomCode;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.itemNum = itemNum;
		this.itemUnit = itemUnit;
		this.itemUseYears = itemUseYears;
		this.itemDesc = itemDesc;
		this.itemType = itemType;
		this.itemSpac = itemSpac;
		this.pictUrl = pictUrl;
		this.flag = flag;
		this.sysRoomId = sysRoomId;
		this.sysHouseId = sysHouseId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHouseCode() {
		return this.houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getRoomCode() {
		return this.roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemBrand() {
		return this.itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public Integer getItemNum() {
		return this.itemNum;
	}

	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}

	public String getItemUnit() {
		return this.itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public String getItemUseYears() {
		return this.itemUseYears;
	}

	public void setItemUseYears(String itemUseYears) {
		this.itemUseYears = itemUseYears;
	}

	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemType() {
		return this.itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemSpac() {
		return this.itemSpac;
	}

	public void setItemSpac(String itemSpac) {
		this.itemSpac = itemSpac;
	}

	public String getPictUrl() {
		return this.pictUrl;
	}

	public void setPictUrl(String pictUrl) {
		this.pictUrl = pictUrl;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getSysRoomId() {
		return this.sysRoomId;
	}

	public void setSysRoomId(Integer sysRoomId) {
		this.sysRoomId = sysRoomId;
	}

	public Integer getSysHouseId() {
		return this.sysHouseId;
	}

	public void setSysHouseId(Integer sysHouseId) {
		this.sysHouseId = sysHouseId;
	}

}