package com.common.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.common.enums.DataType;

/**
 * 对象工具类
 * 
 * @author 孙树林
 * 
 */
public class ObjectUtils {

	/**
	 * 对象是否为NULL
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNull(Object obj) {
		return obj != null ? false : true;
	}

	/**
	 * 字符串类型转换对象
	 * 
	 * @param type
	 * @param value
	 * @return
	 * @throws ParseException
	 */
	public static Object fromStringToObject(String type, String value) throws ParseException {
		if (StringUtils.equalsign(type, DataType.it.getValue())) {
			return Integer.parseInt(value);
		} else if (StringUtils.equalsign(type, DataType.lg.getValue())) {
			return Long.parseLong(value);
		} else if (StringUtils.equalsign(type, DataType.st.getValue())) {
			return Short.parseShort(value);
		} else if (StringUtils.equalsign(type, DataType.ft.getValue())) {
			return Float.parseFloat(value);
		} else if (StringUtils.equalsign(type, DataType.de.getValue())) {
			return Double.parseDouble(value);
		} else if (StringUtils.equalsign(type, DataType.dt.getValue())) {
			return DateUtils.stringToDate(value, false);
		} else {
			return value;
		}
	}

	/**
	 * 字符串类型转换对象
	 * 
	 * @param type
	 * @param value
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings({"unchecked" })
	public static Collection fromStringArrayToCollection(String type, List<String> values) throws ParseException {
		List list = new ArrayList();
		for (String value : values) {
			list.add(fromStringToObject(type, value));
		}
		return list;
	}
}
