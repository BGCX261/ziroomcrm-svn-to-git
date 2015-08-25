package com.common.fusioncharts;

import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * flash fusioncharts 辅助工具类，用来生成xml,json。
 * 
 * @author 孙树林
 */
public class FusionChartsUtils {

	/**
	 * 生成fusioncharts图表需要的xml格式数据(销售漏斗图表)
	 * 
	 * @param fusionChartsHead
	 * @param FusionChartsDataes
	 * @return
	 * @throws Exception
	 */
	public static String createFusionChartsXml(Map<String, String> headers,
			Map<String, String> dataes) throws Exception {
		Document document = DocumentHelper.createDocument();
		// 创建头元素并加入属性
		Element root = document.addElement("chart");
		Iterator<String> key = headers.keySet().iterator();
		while(key.hasNext()) {
			String attr = key.next();
			String value = headers.get(attr);
			root.addAttribute(attr, value);
		}
		// 加入数据元素
		key = dataes.keySet().iterator();
		while(key.hasNext()) {
			String attr = key.next();
			String value = dataes.get(attr);
			Element set = root.addElement("set");
			set.addAttribute("label", attr);
			set.addAttribute("value", value);
		}
		// 加入样式
		Element styles = root.addElement("styles");
		Element definition = styles.addElement("definition");
		Element style = definition.addElement("style");
		style.addAttribute("type", "font");
		style.addAttribute("name", "captionFont");
		style.addAttribute("size", "15");
		Element application = styles.addElement("application");
		Element apply = application.addElement("apply");
		apply.addAttribute("toObject", "CAPTION");
		apply.addAttribute("styles", "captionFont");
		return root.asXML();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
