package net.ziroom.crm.sales.service;

import java.util.List;
import java.util.Map;

import net.ziroom.common.condition.ConditionInterface;
import net.ziroom.crm.customer.dao.CustomerDao;
import net.ziroom.crm.customer.vo.CustomerVo;
import net.ziroom.crm.house.dao.HouseDao;
import net.ziroom.crm.house.vo.HouseVo;
import net.ziroom.crm.sales.dao.SalesDao;
import net.ziroom.crm.sales.dao.TrackingHistoryDao;
import net.ziroom.crm.sales.vo.SalesVo;
import net.ziroom.crm.sales.vo.TrackingHistoryVo;

import com.common.util.BeanUtils;

/**
 * 销售机会业务处理类
 * 
 * @author 孙树林
 */
public class SalesService {

	private SalesDao salesDao;

	private TrackingHistoryDao trackingHistoryDao;

	private ConditionInterface conditionInterface;

	private CustomerDao customerDao;

	private HouseDao houseDao;

	/**
	 * 查询销售机会
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public void searchSales(SalesVo salesVo) throws Exception {
		conditionInterface.handlerCondition(salesVo);
		List<SalesVo> salesVoes = salesDao.searchSales(salesVo, conditionInterface.handlerFilter());
		salesVo.setSalesVoes(salesVoes);
	}

	/**
	 * 机会跟踪
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public void followSalesPage(SalesVo salesVo) throws Exception {
		salesDao.findSalesById(salesVo);
	}

	/**
	 * 保存意向客户求租销售机会
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public void addTenantSales(SalesVo salesVo) throws Exception {
		// 保存客户基本资料
		Integer custId = null;
		CustomerVo customerVo = new CustomerVo();
		if (salesVo.getCustId() != null) {
			customerVo = customerDao.findTenant(salesVo.getCustId());
			custId = customerVo.getCustId();
		} else {
			BeanUtils.copyPropertiesNotNull(salesVo, customerVo);
			custId = customerDao.saveTenantCustomer(customerVo);
		}
		// 保存销售机会信息
		salesVo.setCustId(custId);
		Integer salesId = salesDao.saveTenantSales(salesVo);
		// 保存机会跟踪历史
		salesVo.setSalesId(salesId);
		saveTrackingHistory(salesVo);
	}

	/**
	 * 保存业主出租房屋业务处理
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public void addProprietorSales(SalesVo salesVo) throws Exception {
		// 业主资料
		Integer custId = null;
		CustomerVo customerVo = new CustomerVo();
		if (salesVo.getCustId() != null) {
			customerVo = customerDao.findProprietor(salesVo.getCustId());
			custId = customerVo.getCustId();
		} else {
			BeanUtils.copyPropertiesNotNull(salesVo, customerVo);
			custId = customerDao.saveProprietorCustomer(customerVo);
		}
		// 房源资料，通过录入房源基本信息进行房源库自动匹配。
		Integer houseId = null;
		HouseVo houseVo = new HouseVo();
		BeanUtils.copyPropertiesNotNull(salesVo, houseVo);
		houseVo = houseDao.findHouseByInfo(houseVo);
		if (houseVo != null && houseVo.getHouseId() != null) {
			houseId = houseVo.getHouseId();
		} else {
			houseVo = new HouseVo();
			houseVo.setCustId(custId);
			houseId = houseDao.saveHouse(houseVo);
		}
		// 保存销售机会
		salesVo.setCustId(custId);
		salesVo.setHouseId(houseId);
		Integer salesId = salesDao.saveHouseSales(salesVo);
		// 保存销售机会跟踪历史
		salesVo.setSalesId(salesId);
		saveTrackingHistory(salesVo);
	}

	/**
	 * 保存销售机会跟踪历史业务处理
	 * 
	 * @param trackingHistoryVo
	 * @throws Exception
	 */
	public void saveTrackingHistory(SalesVo salesVo) throws Exception {
		// 保存机会跟踪历史
		TrackingHistoryVo trackingHistoryVo = new TrackingHistoryVo();
		BeanUtils.copyPropertiesNotNull(salesVo, trackingHistoryVo);
		trackingHistoryDao.saveTrackingHistory(trackingHistoryVo);
	}

	/**
	 * 意向客户求租销售机会跟踪
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public void editTenantSales(SalesVo salesVo) throws Exception {
		// 保存销售机会信息
		Integer salesId = salesDao.editTenantSales(salesVo);
		// 保存机会跟踪历史
		salesVo.setSalesId(salesId);
		saveTrackingHistory(salesVo);
	}

	/**
	 * 保存业主出租房屋销售机会跟踪
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public void editProprietorSales(SalesVo salesVo) throws Exception {
		// 保存销售机会信息
		Integer salesId = salesDao.editHouseSales(salesVo);
		// 保存机会跟踪历史
		salesVo.setSalesId(salesId);
		saveTrackingHistory(salesVo);
	}
	
	/**
	 * 销售机会跟踪历史
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public void salesHistory(SalesVo salesVo) throws Exception {
		List<TrackingHistoryVo> trackingHistoryVoes = salesDao.findTrackingHistoryVoBySalesId(salesVo);
		salesVo.setTrackingHistoryVoes(trackingHistoryVoes);
	}
	
	/**
	 * 销售漏斗统计
	 * 
	 * @param salesVo
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> totalSalesFunnel(SalesVo salesVo) throws Exception {
		return salesDao.totalSalesFunnel(salesVo);
	}

	public void setSalesDao(SalesDao salesDao) {
		this.salesDao = salesDao;
	}

	public void setTrackingHistoryDao(TrackingHistoryDao trackingHistoryDao) {
		this.trackingHistoryDao = trackingHistoryDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}

	public void setConditionInterface(ConditionInterface conditionInterface) {
		this.conditionInterface = conditionInterface;
	}
}
