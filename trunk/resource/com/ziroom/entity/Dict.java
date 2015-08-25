package com.ziroom.entity;

/**
 * TDict entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Dict {

	// Fields

	private Integer id;
	private String type;
	private String code;
	private String value;

	// Constructors

	/** default constructor */
	public Dict() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}