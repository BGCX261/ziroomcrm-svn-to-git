package com.common.hibernate.dml;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.common.bean.ArgumentsBean;
import com.common.bean.OrderBean;
import com.common.bean.SearchBean;
import com.common.enums.OrderType;
import com.common.enums.Symbol;
import com.common.exception.HibernateQueryException;
import com.common.util.ObjectUtils;
import com.common.util.StringUtils;

/**
 * hibernate criteria查询条件处理类
 * 
 * @author 孙树林
 * 
 */
public class HibernateSentenceHandle {

	/**
	 * 复合查询条件处理方法
	 * 
	 * @param criteria
	 * @param argumentsBeans
	 * @throws ParseException
	 */
	public void addCompositeCriteria(Criteria criteria, SearchBean searchBean, String[] fetchModels) {
		if(fetchModels != null && fetchModels.length > 0) {			
			// fetchModel
			for(String fetchModel : fetchModels) {			
				criteria.setFetchMode(fetchModel, FetchMode.SELECT);
			}
		}
		if (!ObjectUtils.isNull(searchBean.getArgumentsBeans())) {
			// 加入简单查询条件
			addSimpleCriteria(criteria, searchBean.getArgumentsBeans());
			// 加入关联属性查询条件
			List<SearchBean> searchBeans = searchBean.getSearchBeans();
			for (SearchBean sb : searchBeans) {
				if (sb.getProperty() != null && !sb.getProperty().equals("")) {
					Criteria propertyCriteria = criteria.createCriteria(sb.getProperty(), sb.getProperty()).setFetchMode(sb.getProperty(), FetchMode.SELECT);
					// 加入关联属性查询条件
					addSimpleCriteria(propertyCriteria, sb.getArgumentsBeans());
				}
			}
		}
	}

	/**
	 * 复合查询条件处理方法
	 * 
	 * @param criteria
	 * @param argumentsBeans
	 * @throws ParseException
	 */
	public void addCompositeCriteria(Criteria criteria, SearchBean searchBean) {
		if (!ObjectUtils.isNull(searchBean.getArgumentsBeans())) {
			// 加入简单查询条件
			addSimpleCriteria(criteria, searchBean.getArgumentsBeans());
			// 加入关联属性查询条件
			List<SearchBean> searchBeans = searchBean.getSearchBeans();
			for (SearchBean sb : searchBeans) {
				if (sb.getProperty() != null && !sb.getProperty().equals("")) {
					Criteria propertyCriteria = criteria.createCriteria(sb.getProperty());
					// 加入关联属性查询条件
					addSimpleCriteria(propertyCriteria, sb.getArgumentsBeans());
				}
			}
		}
	}

	/**
	 * 简单查询条件处理方法
	 * 
	 * @param criteria
	 * @param argumentsBeans
	 * @throws ParseException
	 */
	public void addSimpleCriteria(Criteria criteria, List<ArgumentsBean> argumentsBeans) {
		if (!ObjectUtils.isNull(argumentsBeans)) {
			// isOr“or”条件
			boolean isOr = false;
			List<Criterion> criterions = null;
			for (ArgumentsBean argumentsBean : argumentsBeans) {
				List<String> vals = argumentsBean.getValues();
				if (vals == null || vals.size() == 0 || vals.get(0).equals("")) {
					continue;
				}
				// “and”和“or”处理，自定义查询条件规则
				if (!argumentsBean.isAnd()) {
					// 如果where条件连接符是OR
					isOr = true;
					criterions = new ArrayList<Criterion>();
					criterions.add(handlerArguments(argumentsBean));
					continue;
				} else {
					// 如果where条件连接符不是OR
					criteria.add(handlerArguments(argumentsBean));
					// 如果isOr为flase，情况orArgumentsBean
					isOr = false;
				}
				// 如果isOr为flase，并且orArgumentsBean不为NULL
				if (!isOr && criterions != null && criterions.size() > 0) {
					CustomerLogicalExpression customerLogicalExpression = new CustomerLogicalExpression(criterions,
							"or");
					criteria.add(customerLogicalExpression);
					criterions = null;
				}
			}
		}
	}

	/**
	 * 查询排序方式设置
	 * 
	 * @throws Exception
	 */
	public void addOrderCriterial(Criteria criteria, List<OrderBean> orderBeans) {
		if (orderBeans != null) {
			for (OrderBean orderBean : orderBeans) {
				// 设置排序
				if (orderBean.getSort().equals(OrderType.asc.getValue())) {
					criteria.addOrder(Order.asc(orderBean.getParam()));
				} else if (orderBean.getSort().equals(OrderType.desc.getValue())) {
					criteria.addOrder(Order.desc(orderBean.getParam()));
				}
			}
		}
	}

	/**
	 * 查询条件值设置
	 * 
	 * @param criteria
	 * @param argumentsBean
	 */
	@SuppressWarnings("unchecked")
	private Criterion handlerArguments(ArgumentsBean argumentsBean) {
		try {
			if (StringUtils.equalsign(argumentsBean.getSymbol(), Symbol.eq.getValue())) {
				Object value = ObjectUtils.fromStringToObject(argumentsBean.getParamType(), argumentsBean.getValues()
						.get(0));
				return Restrictions.eq(argumentsBean.getParamName(), value);
			} else if (StringUtils.equalsign(argumentsBean.getSymbol(), Symbol.between.getValue())) {
				Object first = ObjectUtils.fromStringToObject(argumentsBean.getParamType(), argumentsBean.getValues()
						.get(0));
				Object end = ObjectUtils.fromStringToObject(argumentsBean.getParamType(), argumentsBean.getValues()
						.get(1));
				return Restrictions.between(argumentsBean.getParamName(), first, end);
			} else if (StringUtils.equalsign(argumentsBean.getSymbol(), Symbol.gt.getValue())) {
				Object value = ObjectUtils.fromStringToObject(argumentsBean.getParamType(), argumentsBean.getValues()
						.get(0));
				return Restrictions.gt(argumentsBean.getParamName(), value);
			} else if (StringUtils.equalsign(argumentsBean.getSymbol(), Symbol.ge.getValue())) {
				Object value = ObjectUtils.fromStringToObject(argumentsBean.getParamType(), argumentsBean.getValues()
						.get(0));
				return Restrictions.ge(argumentsBean.getParamName(), value);
			} else if (StringUtils.equalsign(argumentsBean.getSymbol(), Symbol.lt.getValue())) {
				Object value = ObjectUtils.fromStringToObject(argumentsBean.getParamType(), argumentsBean.getValues()
						.get(0));
				return Restrictions.lt(argumentsBean.getParamName(), value);
			} else if (StringUtils.equalsign(argumentsBean.getSymbol(), Symbol.in.getValue())) {
				Collection value = ObjectUtils.fromStringArrayToCollection(argumentsBean.getParamType(), argumentsBean
						.getValues());
				return Restrictions.in(argumentsBean.getParamName(), value);
			} else if (StringUtils.equalsign(argumentsBean.getSymbol(), Symbol.eqProperty.getValue())) {
				String value = argumentsBean.getValues().get(0);
				return Restrictions.eqProperty(argumentsBean.getParamName(), value);
			} else if (StringUtils.equalsign(argumentsBean.getSymbol(), Symbol.gtProperty.getValue())) {
				String value = argumentsBean.getValues().get(0);
				return Restrictions.gtProperty(argumentsBean.getParamName(), value);
			} else if (StringUtils.equalsign(argumentsBean.getSymbol(), Symbol.geProperty.getValue())) {
				String value = argumentsBean.getValues().get(0);
				return Restrictions.geProperty(argumentsBean.getParamName(), value);
			} else if (StringUtils.equalsign(argumentsBean.getSymbol(), Symbol.ltProperty.getValue())) {
				String value = argumentsBean.getValues().get(0);
				return Restrictions.ltProperty(argumentsBean.getParamName(), value);
			} else if (StringUtils.equalsign(argumentsBean.getSymbol(), Symbol.leProperty.getValue())) {
				String value = argumentsBean.getValues().get(0);
				return Restrictions.leProperty(argumentsBean.getParamName(), value);
			} else if (StringUtils.equalsign(argumentsBean.getSymbol(), Symbol.sql.getValue())) {
				// String value = argumentsBean.getValues().get(0);
				String value = argumentsBean.getParamName();
				return Restrictions.sqlRestriction(value);
			}
		} catch (ParseException e) {
			throw new HibernateQueryException("日期解析", e);
		} catch (Exception e) {
			throw new HibernateQueryException("", e);
		}
		throw new HibernateQueryException("Hibernate查询条件语句中存在问题");
	}
}
