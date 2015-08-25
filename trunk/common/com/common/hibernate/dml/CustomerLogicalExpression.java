package com.common.hibernate.dml;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.engine.TypedValue;

/**
 * 自定义QBC Or和AND表达式
 * 
 * @author 孙树林
 * 
 */
public class CustomerLogicalExpression implements Criterion {

	private static final long serialVersionUID = -1226110031194155693L;

	private final List<Criterion> criterions;
	private final String op;

	public CustomerLogicalExpression(List<Criterion> criterions, String op) {
		super();
		this.criterions = criterions;
		this.op = op;
	}

	public TypedValue[] getTypedValues(Criteria criteria,
			CriteriaQuery criteriaQuery) throws HibernateException {
		int total = 0;
		for (Criterion c : criterions) {
			TypedValue[] lhstv = c.getTypedValues(criteria, criteriaQuery);
			total += lhstv.length;
		}
		TypedValue[] result = new TypedValue[total];
		int first = 0;
		for (Criterion c : criterions) {
			TypedValue[] lhstv = c.getTypedValues(criteria, criteriaQuery);
			System.arraycopy(lhstv, 0, result, first, lhstv.length);
			first = lhstv.length;
		}
		return result;
	}

	public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery)
			throws HibernateException {
		StringBuilder sql = new StringBuilder("(");
		int i = 0;
		for (Criterion c : criterions) {
			if (i == 0) {
				sql.append(c.toSqlString(criteria, criteriaQuery));
			} else {
				sql.append(" " + getOp() + " ");
				sql.append(c.toSqlString(criteria, criteriaQuery));
			}
		}
		sql.append(")");
		return null;
	}

	public List<Criterion> getCriterions() {
		return criterions;
	}

	public String getOp() {
		return op;
	}

}
