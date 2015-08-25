package com.common.hibernate.session;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.common.util.ResourceResolver;

/**
 * hibernate辅助类，用于加载.hbm.xml映射文件获取session,sessionfactory
 * 
 * @author 孙树林
 * 
 */
public class HibernateSession {

	/** session工厂 */
	private static SessionFactory sessionFactory;
	/** 线程本地变量 */
	private static ThreadLocal<Session> local = new ThreadLocal<Session>();
	/** hibernate mapping xml */
	public static final String FILE_PATTERN = "classpath*:/**/*.hbm.xml";

	/**
	 * HibernateSession初始化
	 * 
	 * @throws IOException
	 */
	public static void init() throws IOException {
		Configuration config = new Configuration().configure();
		// 获得所有mapping xml文件
		ResourceResolver resolver = new ResourceResolver();
		List<URL> results = resolver.findClassPathResources(FILE_PATTERN);
		for (URL url : results) {
			if (url != null) {
				config.addURL(url);
			}
		}
		// 创建sessionFactory
		sessionFactory = config.buildSessionFactory();
	}

	/**
	 * 从当前的线程变量获得一个会话，当这个任务完成后，用户必须返回会话关闭方法
	 * 
	 * @return
	 */
	public static synchronized Session getCurrentSession() {
		Session session = local.get();
		if (session == null) {
			session = sessionFactory.openSession();
			local.set(session);
		}
		return session;
	}

	/**
	 * 关闭session
	 */
	public static void closeSession() {
		Session session = local.get();
		if (session != null) {
			session.close();
		}
	}
}