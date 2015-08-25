package com.ziroom.module.cms.vo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ziroom.common.action.ZiroomVo;

/**
 * 首页轮播图值对象
 * 
 * @author 孙树林
 */
public class SowingVo extends ZiroomVo {

	private Integer id;
	private String bigPicturePath;
	private String smallPicturePath;
	private String url;
	private String projectType;
	private String textDescription;
	private String isShow;
	private String houseCode;
	private Integer sortNum;
	private String roomCode;
	private String roomDesc;
	
	private String operator;
	// 大图
	private File big;
	private String bigFileName;
	private String bigContentType;
	// 小图
	private File small;
	private String smallFileName;
	private String smallContextType;

	List<SowingVo> sowingVoes = new ArrayList<SowingVo>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBigPicturePath() {
		return bigPicturePath;
	}

	public void setBigPicturePath(String bigPicturePath) {
		this.bigPicturePath = bigPicturePath;
	}

	public String getSmallPicturePath() {
		return smallPicturePath;
	}

	public void setSmallPicturePath(String smallPicturePath) {
		this.smallPicturePath = smallPicturePath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public List<SowingVo> getSowingVoes() {
		return sowingVoes;
	}

	public void setSowingVoes(List<SowingVo> sowingVoes) {
		this.sowingVoes = sowingVoes;
	}

	public File getBig() {
		return big;
	}

	public void setBig(File big) {
		this.big = big;
	}

	public String getBigFileName() {
		return bigFileName;
	}

	public void setBigFileName(String bigFileName) {
		this.bigFileName = bigFileName;
	}

	public String getBigContentType() {
		return bigContentType;
	}

	public void setBigContentType(String bigContentType) {
		this.bigContentType = bigContentType;
	}

	public File getSmall() {
		return small;
	}

	public void setSmall(File small) {
		this.small = small;
	}

	public String getSmallFileName() {
		return smallFileName;
	}

	public void setSmallFileName(String smallFileName) {
		this.smallFileName = smallFileName;
	}

	public String getSmallContextType() {
		return smallContextType;
	}

	public void setSmallContextType(String smallContextType) {
		this.smallContextType = smallContextType;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}
}
