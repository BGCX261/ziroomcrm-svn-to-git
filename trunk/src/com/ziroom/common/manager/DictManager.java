package com.ziroom.common.manager;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ziroom.module.system.vo.DictVo;

/**
 * 数据字典管理
 * 
 * @author 孙树林
 */
public class DictManager {

	/** 数据字典 */
	public static Map<String, Map<String, String>> DICTS = new TreeMap<String, Map<String, String>>();

	/**
	 * 组织数据字典
	 * 
	 * @param dictVoes
	 */
	public static void init(List<DictVo> dictVoes) {
		for (DictVo dictVo : dictVoes) {
			Map<String, String> map = DICTS.get(dictVo.getType());
			if (map == null) {
				map = new TreeMap<String, String>();
				DICTS.put(dictVo.getType(), map);
			}
			map.put(dictVo.getCode(), dictVo.getValue());
		}
	}

	/**
	 * 获得数据字典值
	 * 
	 * @return
	 */
	public static String getName(String type, String key) {
		String value = "";
		Map<String, String> map = getType(type);
		if (map != null) {
			value = map.get(key);
		}
		return value != null ? value : "";
	}

	/**
	 * 获得类型
	 * 
	 * @param type
	 * @return
	 */
	public static Map<String, String> getType(String type) {
		Map<String, String> map = DICTS.get(type);
		return map;
	}
}
