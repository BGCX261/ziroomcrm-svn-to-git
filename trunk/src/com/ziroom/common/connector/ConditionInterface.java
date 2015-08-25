package com.ziroom.common.connector;

import java.util.List;

import com.common.bean.SearchBean;
import com.common.hibernate.Filter;

/**
 * 定义查询接口，用来处理查询及用户数据权限查询接口
 * 
 * @author 孙树林
 */
public interface ConditionInterface {

	/**
	 * 处理通用查询方法
	 * 
	 * @param searchBean
	 */
	public void handlerCondition(SearchBean searchBean);

	/**
	 * 处理权限查询数据过滤器
	 * 
	 * @return
	 */
	public List<Filter> handlerFilter();
}
