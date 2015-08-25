/*
 * 类说明： 作者：孙树林 创建日期：2010-11-9
 */
package com.common.util;

import java.beans.PropertyDescriptor;

import com.common.exception.GeneralException;

/**
 * 两个对象属性拷贝方法，如果属性为空不进行复制
 * 
 * @author 孙树林
 * 
 */
public class BeanUtils {

	/**
	 * 属性复制包含Null值
	 * 
	 * @param source
	 * @param target
	 */
	public static void copyPropertiesNull(Object source, Object target) {
		copyProperties(source, target, true);
	}

	/**
	 * 属性复制对于Null属性不赋值
	 * 
	 * @param source
	 * @param target
	 */
	public static void copyPropertiesNotNull(Object source, Object target) {
		copyProperties(source, target, false);
	}

	/**
	 * 属性复制
	 * 
	 * @param source
	 * @param target
	 * @param isNull
	 */
	public static void copyProperties(Object source, Object target,
			boolean isNull) {
		// 目标对象属性
		PropertyDescriptor[] descriptors = PropertyUtils
				.getPropertyDescriptors(target);
		for (int i = 0; i < descriptors.length; i++) {
			PropertyDescriptor pd = descriptors[i];
			String name = pd.getName();
			if (StringUtils.equalsignIgnoreCase(name, "class")) {
				continue;
			}
			PropertyDescriptor pdr = PropertyUtils.getPropertyDescriptor(
					source, name);
			if (pdr != null) {
				try {					
					// 源目标对象中通过属性查找值
					Object value = PropertyUtils.getPropertyValue(source, name);
					if (isNull) {
						// 写入目的对象属性中
						copyProperty(target, name, value);
					} else if (!isNull && value != null) {
						// 写入目的对象属性中
						copyProperty(target, name, value);
					}
				} catch(Exception e) {
					// TODO 相同属性不同类型处理
					new GeneralException(e.getMessage());
				}
			}
		}
	}

	/**
	 * 值拷贝到目标对象属性
	 * 
	 * @param target
	 * @param name
	 * @param value
	 */
	public static void copyProperty(Object target, String name, Object value) {
		PropertyUtils.setPropertyValue(target, name, value);
	}

}
