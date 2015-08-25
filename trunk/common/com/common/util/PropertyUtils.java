/*
 * 类说明：类属性操作工具类 作者：孙树林 创建日期：2010-11-9
 */
package com.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 对象属性操作类
 * 
 * @author 孙树林
 * 
 */
public class PropertyUtils {

	@SuppressWarnings("unchecked")
	public static Map<Class, PropertyDescriptor[]> propertyDescriptors = new HashMap<Class, PropertyDescriptor[]>();

	/**
	 * 获得对象中的属性
	 * 
	 * @param source
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static PropertyDescriptor[] getPropertyDescriptors(Object source) {
		if (source == null) {
			throw new IllegalArgumentException("No bean class specified");
		}
		Class beanClass = source.getClass();
		PropertyDescriptor[] descriptors = null;
		synchronized (propertyDescriptors) {
			descriptors = propertyDescriptors.get(beanClass);
			if (descriptors != null) {
				return descriptors;
			}
		}
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(beanClass);
		} catch (IntrospectionException e) {
			return (new PropertyDescriptor[0]);
		}
		descriptors = beanInfo.getPropertyDescriptors();
		if (descriptors == null) {
			descriptors = new PropertyDescriptor[0];
		}
		propertyDescriptors.put(beanClass, descriptors);
		return descriptors;
	}

	/**
	 * 指定的属性
	 * 
	 * @param source
	 * @param name
	 * @return
	 */
	public static PropertyDescriptor getPropertyDescriptor(Object source, String name) {
		PropertyDescriptor[] descriptors = getPropertyDescriptors(source);
		if (descriptors != null) {
			for (int i = 0; i < descriptors.length; i++) {
				if (name.equals(descriptors[i].getName())) {
					return (descriptors[i]);
				}
			}
		}
		return null;
	}

	/**
	 * 获得对象属性值
	 * 
	 * @param source
	 * @param name
	 * @return
	 */
	public static Object getPropertyValue(Object source, String name) {
		if (source instanceof Integer) {
			return source;
		} else if (source instanceof Float) {
			return source;
		} else if (source instanceof Double) {
			return source;
		} else if (source instanceof Long) {
			return source;
		} else if (source instanceof String) {
			return source;
		}
		PropertyDescriptor descriptor = getPropertyDescriptor(source, name);
		if (descriptor != null) {
			Method readMethod = MethodUtils.getAccessibleMethod(source.getClass(), descriptor.getReadMethod());
			if (readMethod != null) {
				return MethodUtils.invokeMethod(source, readMethod);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 设置对象属性值
	 * 
	 * @param source
	 * @param name
	 * @param value
	 * @return
	 */
	public static void setPropertyValue(Object source, String name, Object value) {
		PropertyDescriptor descriptor = getPropertyDescriptor(source, name);
		if (descriptor != null) {
			Method writeMethod = MethodUtils.getAccessibleMethod(source.getClass(), descriptor.getWriteMethod());
			if (writeMethod != null) {
				MethodUtils.invokeMethod(source, writeMethod, value);
			}
		}
	}

	/**
	 * 判断是否为扩展类型
	 * 
	 * @param p
	 * @return
	 */
	public static boolean isExtend(PropertyDescriptor p) {
		return false;
	}

}