package net.ziroom.crm.sales.dao;

import java.util.List;
import java.util.Map;

import net.ziroom.crm.sales.vo.SalesVo;
import net.ziroom.crm.sales.vo.TrackingHistoryVo;

import com.common.hibernate.Filter;

/**
 * 销售机会数据访问接口
 * 
 * @author 孙树林
 */
public interface SalesDao {

	/**
	 * 销售机会查询方法定义
	 * 
	 * @param salesVo
	 * @return
	 * @throws Exception
	 */
	public List<SalesVo> searchSales(SalesVo salesVo, List<Filter> filters) throws Exception;

	/**
	 * 保存客户求租销售机会方法定义
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public Integer saveTenantSales(SalesVo salesVo) throws Exception;

	/**
	 * 保存业主出租房屋销售机会方法定义
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public Integer saveHouseSales(SalesVo salesVo) throws Exception;

	/**
	 * 销售机会查找方法定义
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public void findSalesById(SalesVo salesVo) throws Exception;
	
	/**
	 * 编辑租客销售机会方法定义
	 * 
	 * @param salesVo
	 * @return
	 * @throws Exception
	 */
	public Integer editTenantSales(SalesVo salesVo) throws Exception;
	
	/**
	 * 编辑业主销售机会方法定义
	 * 
	 * @param salesVo
	 * @return
	 * @throws Exception
	 */
	public Integer editHouseSales(SalesVo salesVo) throws Exception;
	
	/**
	 * 销售机会跟踪历史方法定义
	 * 
	 * @param salesVo
	 * @return
	 * @throws Exception
	 */
	public List<TrackingHistoryVo> findTrackingHistoryVoBySalesId(SalesVo salesVo) throws Exception;
	
	/**
	 * 销售漏斗统计方法定义
	 * 
	 * @param salesVo
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> totalSalesFunnel(SalesVo salesVo) throws Exception;
}
