package com.common.hibernate.dml;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;

import com.common.bean.ArgumentsBean;
import com.common.bean.PageBean;
import com.common.bean.SearchBean;
import com.common.hibernate.Filter;
import com.common.hibernate.Parmater;

/**
 * hibernate查询通用查询类(QBC查询)
 * 
 * @author 孙树林
 * 
 */
public class HibernateQBCQuery extends HibernateDataAccess {

	/**
	 * hql查询语句
	 * 
	 * @param searchBean
	 * @param filters
	 * @param isRoot
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String query(StringBuilder hql, SearchBean searchBean, List<Filter> filters) {
		boolean addWhere = hql.toString().indexOf("where") != -1 ? true : false;
		List<ArgumentsBean> argumentsBeans = searchBean.getArgumentsBeans();
		for (ArgumentsBean argumentsBean : argumentsBeans) {
			String param = argumentsBean.getParamName();
			if (param != null && !param.equals("")) {
				if (addWhere) {
					hql.append(" and " + param);
				} else {
					hql.append(" where " + param);
				}
			}
		}
		// 过滤
		if (filters != null && filters.size() > 0) {
			for (Filter filter : filters) {
				if(filter.getFilterName() != null && !filter.getFilterName().equals("")) {
					if (addWhere) {
						hql.append(" and " + filter.getFilterName());
					} else {
						hql.append(" where " + filter.getFilterName());
					}
				}
			}
		}
		return hql.toString();
	}

	/**
	 * hibernate QBC通用分页查询(简单查询)
	 * 
	 * @param searchBean
	 * @param clazz
	 * @return map
	 */
	@SuppressWarnings("unchecked")
	public List criteriaOfSimple(SearchBean searchBean, Class clazz, List<Filter> filters, boolean isRoot) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(clazz);
		if (searchBean != null) {
			// 简单的查询条件
			HibernateSentenceHandle hibernateSentenceHandle = new HibernateSentenceHandle();
			hibernateSentenceHandle.addSimpleCriteria(criteria, searchBean.getArgumentsBeans());
			hibernateSentenceHandle.addOrderCriterial(criteria, searchBean.getOrderBeans());
		}
		if (filters != null) {
			for (Filter filter : filters) {
				org.hibernate.Filter f = session.enableFilter(filter.getFilterName());
				for (Parmater p : filter.getParmaters()) {
					f.setParameter(p.getName(), p.getValue());
				}
			}
		}
		return criteria(criteria, searchBean, isRoot);
	}

	/**
	 * hibernate QBC通用分页查询(简单查询)
	 * 
	 * @param searchBean
	 * @param clazz
	 * @return map
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List criteriaOfSimple(SearchBean searchBean, Class clazz, boolean isRoot) {
		Criteria criteria = getSession().createCriteria(clazz);
		if (searchBean != null) {
			// 简单的查询条件
			HibernateSentenceHandle hibernateSentenceHandle = new HibernateSentenceHandle();
			hibernateSentenceHandle.addSimpleCriteria(criteria, searchBean.getArgumentsBeans());
			hibernateSentenceHandle.addOrderCriterial(criteria, searchBean.getOrderBeans());
		}
		// 返回结果集
		return criteria(criteria, searchBean, isRoot);
	}

	/**
	 * hibernate QBC通用分页查询(复合查询)
	 * 
	 * @param searchBean
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List criteriaOfComposite(SearchBean searchBean, Class clazz, List<Filter> filters, String[] model,
			boolean isRoot) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(clazz);
		if (searchBean != null) {
			// 复合查询条件
			HibernateSentenceHandle hibernateSentenceHandle = new HibernateSentenceHandle();
			hibernateSentenceHandle.addCompositeCriteria(criteria, searchBean);
			hibernateSentenceHandle.addOrderCriterial(criteria, searchBean.getOrderBeans());
		}
		if (filters != null) {
			for (Filter filter : filters) {
				org.hibernate.Filter f = session.enableFilter(filter.getFilterName());
				for (Parmater p : filter.getParmaters()) {
					f.setParameter(p.getName(), p.getValue());
				}
			}
		}
		return criteria(criteria, searchBean, isRoot);
	}

	/**
	 * hibernate QBC通用分页查询(复合查询)
	 * 
	 * @param searchBean
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List criteriaOfComposite(SearchBean searchBean, Class clazz, List<Filter> filters, boolean isRoot) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(clazz);
		if (searchBean != null) {
			// 复合查询条件
			HibernateSentenceHandle hibernateSentenceHandle = new HibernateSentenceHandle();
			hibernateSentenceHandle.addCompositeCriteria(criteria, searchBean);
			hibernateSentenceHandle.addOrderCriterial(criteria, searchBean.getOrderBeans());
		}
		if (filters != null) {
			for (Filter filter : filters) {
				org.hibernate.Filter f = session.enableFilter(filter.getFilterName());
				for (Parmater p : filter.getParmaters()) {
					f.setParameter(p.getName(), p.getValue());
				}
			}
		}
		// 返回结果集
		return criteria(criteria, searchBean, isRoot);
	}

	/**
	 * hibernate QBC通用分页查询(复合查询)
	 * 
	 * @param searchBean
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List criteriaOfComposite(SearchBean searchBean, Class clazz, boolean isRoot) {
		Criteria criteria = getSession().createCriteria(clazz);
		// 复合查询条件
		HibernateSentenceHandle hibernateSentenceHandle = new HibernateSentenceHandle();
		hibernateSentenceHandle.addCompositeCriteria(criteria, searchBean);
		hibernateSentenceHandle.addOrderCriterial(criteria, searchBean.getOrderBeans());
		// 返回结果集
		return criteria(criteria, searchBean, isRoot);
	}

	/**
	 * 查询
	 * 
	 * @param criteria
	 * @param searchBean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List criteria(Criteria criteria, SearchBean searchBean, boolean isRoot) {
		if (searchBean != null && searchBean.isPage()) {
			// 查询分页
			PageBean pageBean = searchBean.getPageBean();
			Long rowCount = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
			criteria.setFirstResult(pageBean.getStart());
			criteria.setMaxResults(pageBean.getPageSize());
			pageBean.setTotalSize(rowCount.intValue());
			criteria.setProjection(null);
		}
		if (isRoot) {
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		}
		return criteria.list();
	}

	/**
	 * jdbc connection
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Connection getConnection() throws Exception {
		Session session = getSession();
		return session.connection();
	}
}
