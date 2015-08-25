package com.ziroom.module.cms.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author 孙树林
 */
@XmlRootElement(name="root")
public class Root {
	
	@SuppressWarnings("unchecked")
	private List dataList = new ArrayList();

	@SuppressWarnings("unchecked")
	@XmlElements( {
		@XmlElement(name = "sowing", type = SowingModel.class)
	})
	public List getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}
}

