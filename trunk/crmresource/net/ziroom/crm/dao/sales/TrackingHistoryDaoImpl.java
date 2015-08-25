package net.ziroom.crm.dao.sales;

import net.ziroom.crm.entity.component.SalesComponent;
import net.ziroom.crm.entity.sales.Sales;
import net.ziroom.crm.entity.sales.TrackingHistory;
import net.ziroom.crm.sales.dao.TrackingHistoryDao;
import net.ziroom.crm.sales.vo.TrackingHistoryVo;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;

/**
 * 销售机会跟踪历史
 * 
 * @author 孙树林
 */
public class TrackingHistoryDaoImpl extends HibernateQBCQuery implements TrackingHistoryDao {

	/**
	 * 保存销售机会跟踪历史方法实现
	 * 
	 * @param trackingHistoryVo
	 * @throws Exception
	 */
	public void saveTrackingHistory(TrackingHistoryVo trackingHistoryVo) throws Exception {
		// 查询销售机会
		Sales sales = (Sales) this.loadEntity(Sales.class, trackingHistoryVo.getSalesId());
		TrackingHistory trackingHistory = new TrackingHistory();
		SalesComponent salesComponent = new SalesComponent();
		BeanUtils.copyPropertiesNotNull(trackingHistoryVo, salesComponent);
		BeanUtils.copyPropertiesNotNull(trackingHistoryVo, trackingHistory);
		trackingHistory.setSalesComponent(salesComponent);
		trackingHistory.setSales(sales);
		// 保存销售机会跟踪历史
		this.saveEntity(trackingHistory);
	}

}
