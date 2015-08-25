package com.common.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.common.exception.GeneralException;

/**
 * XMLBen辅助工具类
 * 
 * @author 孙树林
 */
public class XMLBeanUtils {

	/**
	 * 将Bean转换成XML
	 * 
	 * @param obj
	 * @return
	 * @throws GeneralException
	 */
	public static String beanToXml(Object root) throws GeneralException {
		String xml = null;
		try {
			StringWriter writer = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(Object.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(root, writer);
			xml = writer.toString();
		} catch (JAXBException e) {
			throw new GeneralException(e);
		}
		return xml;
	}
	
	/**
	 * 将XML转换成Bean
	 * 
	 * @param obj
	 * @return
	 * @throws GeneralException
	 */
	public static Object xmlToBean(String xml) throws GeneralException {
		Object obj = null;
		try {
			StringReader reader = new StringReader(xml);
			JAXBContext jaxbContext = JAXBContext.newInstance(Object.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			obj = unmarshaller.unmarshal(reader);
		} catch (JAXBException e) {
			throw new GeneralException(e);
		}
		return obj;
	}
}
