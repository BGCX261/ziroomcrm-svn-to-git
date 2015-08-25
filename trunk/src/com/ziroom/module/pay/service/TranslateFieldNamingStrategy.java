package com.ziroom.module.pay.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.FieldNamingStrategy;

/**
 * 将json字段重命名
 * 
 * @author 孙树林
 */
public class TranslateFieldNamingStrategy implements FieldNamingStrategy {

	/** 要重命名的字段 */
	private Map<String, String> fields = new HashMap<String, String>();
	
	public TranslateFieldNamingStrategy(Map<String, String> fields) {
		super();
		this.fields = fields;
	}

	/**
	 * json命名转换
	 */
	public String translateName(Field field) {
		String fieldName = field.getName();
		if(fields.keySet().contains(fieldName)) {
			fieldName = fields.get(fieldName);
		}
		return fieldName;
	}

}
