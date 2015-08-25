package com.ziroom.module.cms.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 首页模型，通过此模型用来生成XML或将XML转换成对象
 * 
 * @author 孙树林
 */
@XmlRootElement(name = "sowing")
public class SowingModel {

	private String bigPicturePath;

	private String smallPicturePath;

	private String url;

	private String projectType;

	private String textDescription;

	@XmlElement
	public String getBigPicturePath() {
		return bigPicturePath;
	}

	public void setBigPicturePath(String bigPicturePath) {
		this.bigPicturePath = bigPicturePath;
	}

	@XmlElement
	public String getSmallPicturePath() {
		return smallPicturePath;
	}

	public void setSmallPicturePath(String smallPicturePath) {
		this.smallPicturePath = smallPicturePath;
	}

	@XmlElement
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@XmlElement
	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	@XmlElement
	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
}
