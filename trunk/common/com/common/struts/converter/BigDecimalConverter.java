package com.common.struts.converter;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.common.util.StringUtils;

/**
 * struts BigDecimal 大数值对象处理类
 * 
 * @author 孙树林
 * 
 */
public class BigDecimalConverter extends StrutsTypeConverter {

	@SuppressWarnings("unchecked")
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values == null || values.length == 0) {
			return null;
		}
		BigDecimal bigDecimal = null;
		String dateString = values[0];
		if (StringUtils.isNotEmpty(dateString)) {
			bigDecimal = new BigDecimal(dateString);
		}
		return bigDecimal;
	}

	@SuppressWarnings("unchecked")
	public String convertToString(Map context, Object o) {
		if (o instanceof BigDecimal) {
			if (o != null) {
				BigDecimal big = (BigDecimal) o;
				return String.valueOf(big.doubleValue());
			}
		}
		return "";
	}
}
