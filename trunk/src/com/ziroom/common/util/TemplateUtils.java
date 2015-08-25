package com.ziroom.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import com.common.exception.GeneralException;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 
 * @author 孙树林
 */
public class TemplateUtils {

	/**
	 * 
	 * @param parameters
	 * @param templatePath
	 * @param dir
	 * @param templateName
	 */
	@SuppressWarnings("unchecked")
	public static void createHtml(Map parameters, String templatePath, String dir, String templateName)
			throws GeneralException {
		// 通过freemarker生成tpl
		Configuration configuration = new Configuration();
		try {
			configuration.setDirectoryForTemplateLoading(new File(dir));
			// configuration.setDefaultEncoding("UTF-8");
			configuration.setObjectWrapper(new DefaultObjectWrapper());
			Template template = configuration.getTemplate(templateName, "UTF-8");
			template.setEncoding("UTF-8");
			File file = new File(templatePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			Writer writer = new OutputStreamWriter(fos, "UTF-8");
			template.process(parameters, writer);
			writer.flush();
			writer.close();
			fos.close();
		} catch (IOException e) {
			throw new GeneralException(e);
		} catch (TemplateException e) {
			throw new GeneralException(e);
		}
	}
}
