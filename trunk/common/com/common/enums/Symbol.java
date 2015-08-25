package com.common.enums;

/**
 * 
 * 条件符号
 * 
 * @author 孙树林
 * 
 */
public enum Symbol {
	
	eq("eq"), 
	allEq("allEq"), 
	gt("gt"), 
	ge("ge"), 
	lt("lt"), 
	le("le"), 
	between("between"), 
	in("in"), 
	eqProperty("eqProperty"),
	gtProperty("gtProperty"),
	geProperty("geProperty"),
	ltProperty("ltProperty"),
	leProperty("leProperty"),
	sql("sql");

	private String value;

	Symbol(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
