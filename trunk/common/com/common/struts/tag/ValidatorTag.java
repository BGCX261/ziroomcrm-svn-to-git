package com.common.struts.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.common.struts.validator.Validator;

/**
 * 基于struts2验证标签，通过struts2配置文件自动生成客户验证程序，验证程序基于JQuery实现
 * 
 * @author 孙树林
 * 
 */
public class ValidatorTag extends TagSupport {

	private static final long serialVersionUID = 4694691907461777512L;

	/** 请求 */
	private String actionName;

	/** 命名空间 */
	private String nameSpace;

	/** 表单ID使用formID作为js方法名 */
	private String formId;

	/** 是否使用spring */
	private boolean spring = false;

	@Override
	public int doStartTag() throws JspException {
		Validator validator = new Validator();
		JspWriter writer = pageContext.getOut();
		try {
			writer.write(validator.createXMLToJson(pageContext, formId, actionName, nameSpace, spring));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public void setSpring(boolean spring) {
		this.spring = spring;
	}

}