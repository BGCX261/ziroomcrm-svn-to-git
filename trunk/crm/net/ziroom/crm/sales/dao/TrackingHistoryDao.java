package net.ziroom.crm.sales.dao;

import net.ziroom.crm.sales.vo.TrackingHistoryVo;

/**
 * 销售机会跟踪历史数据访问接口
 * 
 * @author 孙树林
 */
public interface TrackingHistoryDao {

	/**
	 * 保存销售机会跟踪历史方法定义
	 * 
	 * @param trackingHistoryVo
	 * @throws Exception
	 */
	public void saveTrackingHistory(TrackingHistoryVo trackingHistoryVo) throws Exception;
	
}
