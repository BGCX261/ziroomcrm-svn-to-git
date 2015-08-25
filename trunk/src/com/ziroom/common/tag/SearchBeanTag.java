package com.ziroom.common.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts2.views.jsp.TagUtils;

import com.common.bean.ArgumentsBean;
import com.common.bean.SearchBean;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * 数据查询标签
 * 
 * @author 孙树林
 */
public class SearchBeanTag extends TagSupport {

	private static final long serialVersionUID = 1766764214788142706L;

	private String searchBean;

	private String preffiex;

	/**
	 * 标签开始执行
	 */
	@Override
	public int doStartTag() throws JspException {
		JspWriter writer = pageContext.getOut();
		try {
			writer.write(echoSearchBean(pageContext));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * 打印界面查询条件
	 * 
	 * @return
	 */
	private String echoSearchBean(PageContext pageContext) {
		ValueStack stack = TagUtils.getStack(pageContext);
		SearchBean search = (SearchBean) stack.findValue(searchBean);
		StringBuilder sb = new StringBuilder();
		if (search != null) {
			List<ArgumentsBean> argumentsBeans = search.getArgumentsBeans();
			int i = 0;
			for (ArgumentsBean argumentsBean : argumentsBeans) {
				int j = 0;
				List<String> values = argumentsBean.getValues();
				for (String value : values) {
					String val = (value != null && !value.equals("")) ? value
							: "";
					sb.append("<input type='hidden' name='" + preffiex
							+ ".argumentsBeans[" + i + "].values[" + j
							+ "]' value='" + val + "'/>");
					j++;
				}
				i++;
			}
		}
		return sb.toString();
	}

	public String getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(String searchBean) {
		this.searchBean = searchBean;
	}

	public String getPreffiex() {
		return preffiex;
	}

	public void setPreffiex(String preffiex) {
		this.preffiex = preffiex;
	}
}
