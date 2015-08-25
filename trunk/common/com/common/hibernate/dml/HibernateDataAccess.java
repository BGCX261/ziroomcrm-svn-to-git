package com.common.hibernate.dml;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * hibernate操作类
 * 
 * @author 孙树林
 * 
 */
public class HibernateDataAccess {

	protected SessionFactory sessionFactory;

	public HibernateDataAccess() {
		super();
	}

	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @return
	 */
	public Serializable saveEntity(Object entity) throws HibernateException {
		return getSession().save(entity);
	}

	/**
	 * 根据实体名称保存实体
	 * 
	 * @param session
	 * @param entityName
	 * @param entity
	 * @return
	 */
	public Serializable saveEntity(String entityName, Object entity)
			throws HibernateException {
		return getSession().save(entityName, entity);
	}

	/**
	 * 更新实体
	 * 
	 * @param session
	 * @param entity
	 */
	public void updateEntity(Object entity) throws HibernateException {
		getSession().update(entity);
	}

	/**
	 * 根据实体名称更新实体
	 * 
	 * @param session
	 * @param entityName
	 * @param entity
	 */
	public void updateEntity(String entityName, Object entity)
			throws HibernateException {
		getSession().update(entityName, entity);
	}

	/**
	 * 删除实体
	 * 
	 * @param session
	 * @param entity
	 */
	public void deleteEntity(Object entity) throws HibernateException {
		getSession().delete(entity);
	}

	/**
	 * 根据实体名称删除实体
	 * 
	 * @param session
	 * @param entityName
	 * @param entity
	 */
	public void deleteEntity(String entityName, Object entity)
			throws HibernateException {
		getSession().delete(entityName, entity);
	}

	/**
	 * 根据id，clazz查找实体
	 * 
	 * @param session
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object getEntity(Class clazz, Serializable id)
			throws HibernateException {
		return getSession().get(clazz, id);
	}

	/**
	 * 根据id，实体名称查找实体
	 * 
	 * @param session
	 * @param entityName
	 * @param id
	 * @return
	 */
	public Object getEntity(String entityName, Serializable id)
			throws HibernateException {
		return getSession().get(entityName, id);
	}

	/**
	 * 根据id，clazz查找实体，并设置锁定模式
	 * 
	 * @param session
	 * @param clazz
	 * @param id
	 * @param lockOptions
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object getEntity(Class clazz, Serializable id,
			LockOptions lockOptions) throws HibernateException {
		return getSession().get(clazz, id, lockOptions);
	}

	/**
	 * 根据id，实体名称查找实体，并设置锁定模式
	 * 
	 * @param session
	 * @param entityName
	 * @param id
	 * @param lockOptions
	 * @return
	 */
	public Object getEntity(String entityName, Serializable id,
			LockOptions lockOptions) throws HibernateException {
		return getSession().get(entityName, id, lockOptions);
	}

	/**
	 * 根据id，clazz查找实体
	 * 
	 * @param session
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object loadEntity(Class clazz, Serializable id)
			throws HibernateException {
		return getSession().load(clazz, id);
	}

	/**
	 * 根据id，实体名称查找实体
	 * 
	 * @param session
	 * @param entityName
	 * @param id
	 * @return
	 */
	public Object loadEntity(String entityName, Serializable id)
			throws HibernateException {
		return getSession().load(entityName, id);
	}

	/**
	 * 根据id，clazz查找实体，并设置锁定模式
	 * 
	 * @param session
	 * @param clazz
	 * @param id
	 * @param lockOptions
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object loadEntity(Class clazz, Serializable id,
			LockOptions lockOptions) throws HibernateException {
		return getSession().load(clazz, id, lockOptions);
	}

	/**
	 * 根据id，实体名称查找实体，并设置锁定模式
	 * 
	 * @param session
	 * @param entityName
	 * @param id
	 * @param lockOptions
	 * @return
	 */
	public Object loadEntity(String entityName, Serializable id,
			LockOptions lockOptions) throws HibernateException {
		return getSession().load(entityName, id, lockOptions);
	}

	/**
	 * 根据id，实体查找实体
	 * 
	 * @param session
	 * @param entity
	 * @param id
	 */
	public void loadEntity(Object entity, Serializable id) {
		getSession().load(entity, id);
	}

	/**
	 * 保存实体，如果ID由hibernate负责生产
	 * 
	 * @param session
	 * @param entity
	 * @param replicationMode
	 */
	public void replicateEntity(Object entity, ReplicationMode replicationMode) {
		getSession().replicate(entity, replicationMode);
	}

	/**
	 * 根据实体名称保存实体，如果ID由hibernate负责生产
	 * 
	 * @param session
	 * @param entityName
	 * @param entity
	 * @param replicationMode
	 */
	public void replicateEntity(String entityName, Object entity,
			ReplicationMode replicationMode) {
		getSession().replicate(entityName, entity, replicationMode);
	}

	/**
	 * 对实体执行相应的操作，如果实体是游离状态执行保存，托管状态update。
	 * 
	 * @param session
	 * @param entityName
	 * @param entity
	 */
	public void merge(Object entity) {
		getSession().merge(entity);
	}

	/**
	 * 根据实体名称对实体执行相应的操作，如果实体是游离状态执行保存，托管状态update。
	 * 
	 * @param session
	 * @param entityName
	 * @param entity
	 */
	public void merge(String entityName, Object entity) {
		getSession().merge(entityName, entity);
	}

	/**
	 * 保存实体，代理主键的情况下不保证立即为持久化对象的ID赋值， 而是有可能在Session清理缓存时才为ID赋值，如果在事务边
	 * 界以外调用persist()方法，那么该方法不会计划执行insert语句， 这可以提高负责长时间运行事务的程序的健壮性
	 * 
	 * @param session
	 * @param entity
	 */
	public void persist(Object entity) {
		getSession().persist(entity);
	}

	/**
	 * 根据实体名称保存实体，代理主键的情况下不保证立即为持久化对象的ID赋值， 而是有可能在Session清理缓存时才为ID赋值，如果在事务边
	 * 界以外调用persist()方法，那么该方法不会计划执行insert语句， 这可以提高负责长时间运行事务的程序的健壮性
	 * 
	 * @param session
	 * @param entity
	 */
	public void persist(String entityName, Object entity) {
		getSession().persist(entityName, entity);
	}

	/**
	 * 将对象从指定缓冲区删除
	 * 
	 * @param session
	 * @param entity
	 */
	public void evict(Object entity) {
		getSession().evict(entity);
	}

	/**
	 * hql语句执行
	 * 
	 * @return
	 */
	public Query createQuery(String hql) {
		return getSession().createQuery(hql);
	}

	/**
	 * 原生sql语句执行
	 * 
	 * @param sql
	 * @return
	 */
	public Query createSqlQuery(String sql) {
		return getSession().createSQLQuery(sql);
	}

	/**
	 * QBC查询
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Criteria createCriteria(Class clazz) {
		return getSession().createCriteria(clazz);
	}

	/**
	 * QBC查询
	 * 
	 * @param clazz
	 * @return
	 */
	public Criteria createCriteria(String clazz) {
		return getSession().createCriteria(clazz);
	}

	/**
	 * QBC查询
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Criteria createCriteria(Class clazz, String param) {
		return getSession().createCriteria(clazz, param);
	}

	/**
	 * QBC查询
	 * 
	 * @param clazz
	 * @return
	 */
	public Criteria createCriteria(String clazz, String param) {
		return getSession().createCriteria(clazz, param);
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
