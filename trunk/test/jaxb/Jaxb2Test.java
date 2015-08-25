package jaxb;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.common.exception.GeneralException;


/**
 * 
 * @author 孙树林
 */
public class Jaxb2Test {
	
	private JAXBContext context = null;

	private StringWriter writer = null;

	private StringReader reader = null;

	private AccountBean bean = null;

	public void init() {
		bean = new AccountBean();
		bean.setAddress("北京");
		bean.setEmail("email");
		bean.setId(1);
		bean.setName("jack");
	}

	public void destory() {
		context = null;
		bean = null;
		try {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
			if (reader != null) {
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.gc();
	}

	public void fail(Object o) {
		System.out.println(o);
	}

	public void failRed(Object o) {
		System.err.println(o);
	}
	
	public void testBean2XML() {
	    try {
	        //下面代码演示将对象转变为xml
	        Marshaller mar = context.createMarshaller();
	        writer = new StringWriter();
	        mar.marshal(bean, writer);
	        fail(writer);
	        //下面代码演示将上面生成的xml转换为对象
	        reader = new StringReader(writer.toString());
	        Unmarshaller unmar = context.createUnmarshaller();
	        bean = (AccountBean)unmar.unmarshal(reader);
	        fail(bean);
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
	}
	
	public void testList2XML() {
	    ListBean listBean = new ListBean();
	    listBean.setName("list to xml");
	    List<Object> list = new ArrayList<Object>();
	    list.add(bean);
	    AccountBean bean1 = new AccountBean();
	    bean1.setAddress("china");
	    bean1.setEmail("tom@125.com");
	    bean1.setId(2);
	    bean1.setName("tom");
	    list.add(bean1);
	    AccountBean bean2 = new AccountBean();
	    bean2.setAddress("china");
	    bean2.setEmail("tom@125.com");
	    bean2.setId(2);
	    bean2.setName("tom");
	    list.add(bean2);
	    listBean.setList(list);
	    try {
	        context = JAXBContext.newInstance(ListBean.class);
	        //下面代码演示将对象转变为xml
	        Marshaller mar = context.createMarshaller();
	        writer = new StringWriter();
	        mar.marshal(listBean, writer);
	        fail(writer);
	        //下面代码演示将上面生成的xml转换为对象
	        reader = new StringReader(writer.toString());
	        Unmarshaller unmar = context.createUnmarshaller();
	        listBean = (ListBean)unmar.unmarshal(reader);
	        fail(listBean.getList().get(0));
	        fail(listBean.getList().get(1));
	        fail(listBean.getList().get(2));
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }

	}
	
	public static void main(String[] args) throws GeneralException, JAXBException {
		Jaxb2Test jaxb2Test = new Jaxb2Test();
		jaxb2Test.testList2XML();
	}

	public AccountBean getBean() {
		return bean;
	}
}
