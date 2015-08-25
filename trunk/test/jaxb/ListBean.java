package jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlElements;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("unchecked")
@XmlRootElement(name = "list-bean")
public class ListBean {

	private String name;

	private List list;

	@XmlElements( {
		@XmlElement(name = "bean", type = AccountBean.class)
	})
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}