package com.ziroom.module.house.vo;

/**
 * 物品值对象
 * 
 * @author 孙树林
 */
public class ConfigVo {

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public Integer getItemNum() {
		return itemNum;
	}

	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public String getItemUseYears() {
		return itemUseYears;
	}

	public void setItemUseYears(String itemUseYears) {
		this.itemUseYears = itemUseYears;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemSpac() {
		return itemSpac;
	}

	public void setItemSpac(String itemSpac) {
		this.itemSpac = itemSpac;
	}

	public String getPictUrl() {
		pictUrl = pictUrl.replaceAll("amsupload", "ams");
		return pictUrl;
	}

	public void setPictUrl(String pictUrl) {
		pictUrl.replaceAll("amsupload", "ams");
		this.pictUrl = pictUrl;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getSysRoomId() {
		return sysRoomId;
	}

	public void setSysRoomId(Integer sysRoomId) {
		this.sysRoomId = sysRoomId;
	}

	public Integer getSysHouseId() {
		return sysHouseId;
	}

	public void setSysHouseId(Integer sysHouseId) {
		this.sysHouseId = sysHouseId;
	}
}
