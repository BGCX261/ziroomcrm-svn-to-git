package com.common.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.DocumentResult;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.SAXReader;

import com.common.exception.GeneralException;

/**
 * XSL格式处理
 * 
 * @author 孙树林
 */
public class XSLUtils {

	/**
	 * xsl转换xml
	 * 
	 * @param xml
	 * @param xslFilePath
	 * @return
	 * @throws GeneralException
	 */
	public static String stringTransformDocument(String xml, String xslFilePath) throws GeneralException {
		Document doc = xmlTransformDocument(xml, xslFilePath);
		return doc.asXML();
	}

	/**
	 * xsl转换xml
	 * 
	 * @param xml
	 * @param xslFilePath
	 * @return
	 * @throws TransformerException
	 */
	public static Document xmlTransformDocument(String xml, String xslFilePath) throws GeneralException {
		SAXReader saxreader = new SAXReader();
		InputStream is;
		Document doc;
		Document document = null;
		try {
			is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
			doc = saxreader.read(is);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(new FileInputStream(xslFilePath)));
			DocumentSource ds = new DocumentSource(doc);
			DocumentResult result = new DocumentResult();
			transformer.transform(ds, result);
			document = result.getDocument();
		} catch (UnsupportedEncodingException e) {
			throw new GeneralException(e);
		} catch (DocumentException e) {
			throw new GeneralException(e);
		} catch (TransformerConfigurationException e) {
			throw new GeneralException(e);
		} catch (FileNotFoundException e) {
			throw new GeneralException(e);
		} catch (TransformerException e) {
			throw new GeneralException(e);
		}
		return document;
	}
}
