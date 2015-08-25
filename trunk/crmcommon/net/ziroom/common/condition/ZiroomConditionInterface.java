package net.ziroom.common.condition;

import java.util.List;

import com.common.bean.SearchBean;
import com.common.hibernate.Filter;

/**
 * 通用数据权限
 * 
 * @author 孙树林
 */
public class ZiroomConditionInterface implements ConditionInterface {
	
	public void handlerCondition(SearchBean searchBean) {
	}

	public List<Filter> handlerFilter() {
		return null;
	}

}
