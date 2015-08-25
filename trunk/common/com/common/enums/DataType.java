package com.common.enums;

/**
 * 数据类型枚举
 * 
 * @author 孙树林
 * 
 */
public enum DataType {

	it("int"), lg("long"), st("short"), ft("float"), de("double"), s("string"), dt("date");

	private String value;

	DataType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
