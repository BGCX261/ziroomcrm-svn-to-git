package com.ziroom.module.system.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 孙树林
 */
public class DictVo {

	private Integer id;
	private String type;
	private String code;
	private String value;
	
	private List<DictVo> dictVoes = new ArrayList<DictVo>();

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

	public List<DictVo> getDictVoes() {
		return dictVoes;
	}

	public void setDictVoes(List<DictVo> dictVoes) {
		this.dictVoes = dictVoes;
	}
}
