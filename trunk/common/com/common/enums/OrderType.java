package com.common.enums;

/**
 * 
 * @author 孙树林
 */
public enum OrderType {

	asc("asc"), desc("desc");

	private String value;

	OrderType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
