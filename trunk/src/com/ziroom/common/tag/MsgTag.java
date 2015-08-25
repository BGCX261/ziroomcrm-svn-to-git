package com.ziroom.common.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts2.views.jsp.TagUtils;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * 处理action返回msg内容信息，并打印到当前界面
 * 
 * @author 孙树林
 */
public class MsgTag extends TagSupport {

	private static final long serialVersionUID = -761176740253897346L;

	/**
	 * 标签开始执行
	 */
	@Override
	public int doStartTag() throws JspException {
		JspWriter writer = pageContext.getOut();
		try {
			writer.write(echoMsg(pageContext));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * 输出action反馈信息
	 * 
	 * @param pageContext
	 * @return
	 */
	public String echoMsg(PageContext pageContext) {
		StringBuilder stringBuilder = new StringBuilder();
		ValueStack stack = TagUtils.getStack(pageContext);
		Object obj = stack.findValue("msg");
		if (obj != null) {
			String msg = String.valueOf(obj);
			if(!msg.equals("")) {				
				stringBuilder.append("<script type=\"text/javascript\">");
				stringBuilder.append("alert('" + msg + "')");
				stringBuilder.append("</script>");
			}
		}
		return stringBuilder.toString();
	}
}
