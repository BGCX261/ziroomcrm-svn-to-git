package com.ziroom.module.cms.vo;

import java.util.ArrayList;
import java.util.List;

import com.ziroom.common.action.ZiroomVo;
import com.ziroom.module.house.vo.HouseVo;

/**
 * 专题页值对象
 * 
 * @author 孙树林
 */
public class SpecialVo extends ZiroomVo {

	private Integer id;
	private String roomName;
	private String houseCode;
	private String roomCode;
	private String roomType;
	private Float roomArea;
	private String roomPosition;
	private Float rentFee;
	private String imagePath;
	private String specialType;
	private Integer sortNum;
	private Float cleaningFee;
	private String operation;
	private String url;
	private String contractCode;
	private String type;
	private String newType;
	private String houseName;

	private Integer imageId;

	private Integer x1;
	private Integer y1;
	private Integer x2;
	private Integer y2;
	private Long width;
	private Long height;
	private Float txtZoom;
	private Integer txtTop;
	private Integer txtLeft;

	private Integer roomId;
	
	private String houseCode1;
	private String type1;

	private HouseVo houseVo = new HouseVo();
	
	private List<HouseVo> houseVoes = new ArrayList<HouseVo>();

	private List<SpecialVo> specialVoes = new ArrayList<SpecialVo>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
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

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Float getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(Float roomArea) {
		this.roomArea = roomArea;
	}

	public String getRoomPosition() {
		return roomPosition;
	}

	public void setRoomPosition(String roomPosition) {
		this.roomPosition = roomPosition;
	}

	public Float getRentFee() {
		return rentFee;
	}

	public void setRentFee(Float rentFee) {
		this.rentFee = rentFee;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getSpecialType() {
		return specialType;
	}

	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Float getCleaningFee() {
		return cleaningFee;
	}

	public void setCleaningFee(Float cleaningFee) {
		this.cleaningFee = cleaningFee;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public List<SpecialVo> getSpecialVoes() {
		return specialVoes;
	}

	public void setSpecialVoes(List<SpecialVo> specialVoes) {
		this.specialVoes = specialVoes;
	}

	public HouseVo getHouseVo() {
		return houseVo;
	}

	public void setHouseVo(HouseVo houseVo) {
		this.houseVo = houseVo;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Integer getX1() {
		return x1;
	}

	public void setX1(Integer x1) {
		this.x1 = x1;
	}

	public Integer getY1() {
		return y1;
	}

	public void setY1(Integer y1) {
		this.y1 = y1;
	}

	public Integer getX2() {
		return x2;
	}

	public void setX2(Integer x2) {
		this.x2 = x2;
	}

	public Integer getY2() {
		return y2;
	}

	public void setY2(Integer y2) {
		this.y2 = y2;
	}

	public Long getWidth() {
		return width;
	}

	public void setWidth(Long width) {
		this.width = width;
	}

	public Long getHeight() {
		return height;
	}

	public void setHeight(Long height) {
		this.height = height;
	}

	public Float getTxtZoom() {
		return txtZoom;
	}

	public void setTxtZoom(Float txtZoom) {
		this.txtZoom = txtZoom;
	}

	public Integer getTxtTop() {
		return txtTop;
	}

	public void setTxtTop(Integer txtTop) {
		this.txtTop = txtTop;
	}

	public Integer getTxtLeft() {
		return txtLeft;
	}

	public void setTxtLeft(Integer txtLeft) {
		this.txtLeft = txtLeft;
	}

	public String getUrl() {
		this.url = roomId + ".html";
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNewType() {
		return newType;
	}

	public void setNewType(String newType) {
		this.newType = newType;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public List<HouseVo> getHouseVoes() {
		return houseVoes;
	}

	public void setHouseVoes(List<HouseVo> houseVoes) {
		this.houseVoes = houseVoes;
	}

	public String getHouseCode1() {
		return houseCode1;
	}

	public void setHouseCode1(String houseCode1) {
		this.houseCode1 = houseCode1;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}
}
