package com.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 日期处理工具类
 * 
 * @author 孙树林
 * 
 */
public class DateUtils {

	/** 格式化日期格式 */
	private static SimpleDateFormat formatAll = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	/** 格式化日期格式 */
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 字符串转换日期类型
	 * 
	 * @param value
	 * @param isFull
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String value, boolean isFull) throws ParseException {
		if (isFull) {
			return formatAll.parse(value);
		} else {
			return format.parse(value);
		}
	}
}
