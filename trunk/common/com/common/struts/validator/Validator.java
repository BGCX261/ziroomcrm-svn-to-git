package com.common.struts.validator;

import java.io.File;
import java.net.URL;
import java.util.Map;

import javax.servlet.jsp.PageContext;

import org.apache.struts2.dispatcher.Dispatcher;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.common.exception.ValidatorException;
import com.common.struts.tag.ValidatorTag;
import com.google.gson.Gson;
import com.opensymphony.xwork2.config.RuntimeConfiguration;
import com.opensymphony.xwork2.config.entities.ActionConfig;

/**
 * struts validator.xml文件生成前段js验证
 * 
 * @author 孙树林
 * 
 */
public class Validator {

	/**
	 * 生成调用js验证方法
	 * 
	 * @param file
	 * @param formId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String createXMLToJson(PageContext pageContext, String formId, String actionName, String nameSpace, boolean spring) throws Exception {
		// struts验证文件
		File file = findValidatorXml(pageContext, actionName, nameSpace, spring);

		// 解析XML文件
		ValidatorSaxHandler handler = new ValidatorSaxHandler(file);
		handler.parser();
		Map map = handler.getSaxMaps();

		Gson gson = new Gson();

		StringBuilder sb = new StringBuilder("<script type=\"text/javascript\">\n");
		sb.append("	function ");
		sb.append(formId);
		sb.append("() {\n");
		sb.append("		var json = ");
		sb.append(gson.toJson(map));
		sb.append(";\n");
		sb.append("\n	return ");
		sb.append("$(\"#");
		sb.append(formId);
		sb.append("\").validator(json);\n}\n");
		sb.append("</script>\n");
		return sb.toString();
	}

	private File findValidatorXml(PageContext pageContext, String actionName, String nameSpace, boolean spring) throws ValidatorException {
		Dispatcher dispatcher = Dispatcher.getInstance();
		RuntimeConfiguration config = dispatcher.getConfigurationManager().getConfiguration().getRuntimeConfiguration();
		// 命名空间、请求action处理
		nameSpace = (nameSpace == null || nameSpace.equals("")) ? "" : nameSpace;
		actionName = (actionName == null || actionName.equals("")) ? "execute" : actionName;
		ActionConfig actionConfig = config.getActionConfig(nameSpace, actionName);

		if (actionConfig != null) {
			String methodName = actionConfig.getMethodName();
			String name = actionConfig.getClassName();
			String clazz = "";
			// 对spring集成框架处理
			if (spring) {
				WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
				clazz = context.getBean(name).getClass().getName().replace(".", "/");
			} else {
				clazz = name.replace(".", "/");
			}

			// 根据方法名成获得对应的验证文件
			if (methodName != null && !methodName.equals("execute")) {
				clazz = clazz + "-" + actionName + "-validation.xml";
			} else {
				clazz = clazz + "-validation.xml";
			}

			URL url = ValidatorTag.class.getClassLoader().getResource(clazz);
			File file = new File(url.getPath());
			return file;
		} else {
			throw new ValidatorException("ValidatorException:没有找到验证xml文件");
		}
	}
}
