package net.ziroom.crm.dao.sales;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.ziroom.crm.entity.component.SalesComponent;
import net.ziroom.crm.entity.customer.Proprietor;
import net.ziroom.crm.entity.customer.Tenant;
import net.ziroom.crm.entity.house.House;
import net.ziroom.crm.entity.sales.HireAsks;
import net.ziroom.crm.entity.sales.HouseSales;
import net.ziroom.crm.entity.sales.LeasedAsks;
import net.ziroom.crm.entity.sales.Sales;
import net.ziroom.crm.entity.sales.TenantSales;
import net.ziroom.crm.entity.sales.TrackingHistory;
import net.ziroom.crm.sales.dao.SalesDao;
import net.ziroom.crm.sales.vo.SalesVo;
import net.ziroom.crm.sales.vo.TrackingHistoryVo;

import org.hibernate.Query;

import com.common.bean.PageBean;
import com.common.hibernate.Filter;
import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;

/**
 * 销售机会数类据访问接口实现类
 * 
 * @author 孙树林
 */
public class SalesDaoImpl extends HibernateQBCQuery implements SalesDao {

	/**
	 * 销售机会查询方法实现
	 * 
	 * @param salesVo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SalesVo> searchSales(SalesVo salesVo, List<Filter> filters) throws Exception {
		List<SalesVo> salesVoes = new ArrayList<SalesVo>();

		// 先统计记录数
		int count = totalSales(salesVo, filters);
		PageBean pageBean = salesVo.getPageBean();
		pageBean.setTotalSize(count);

		StringBuilder hql = new StringBuilder("from Sales");
		// 执行查询
		HibernateQBCQuery hibernateQBCQuery = new HibernateQBCQuery();
		Query query = this.getSession().createQuery(hibernateQBCQuery.query(hql, salesVo, filters));
		query.setFirstResult(pageBean.getStart());
		query.setMaxResults(pageBean.getPageSize());
		List list = query.list();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);
				SalesVo vo = new SalesVo();
				if (o instanceof HouseSales) {
					HouseSales sales = (HouseSales) o;
					BeanUtils.copyPropertiesNotNull(sales, vo);
					BeanUtils.copyPropertiesNotNull(sales.getSalesComponent(), vo);
					vo.setCustName(sales.getProprietor().getCustName());
					vo.setType("00003");
				} else {
					TenantSales sales = (TenantSales) o;
					BeanUtils.copyPropertiesNotNull(sales, vo);
					BeanUtils.copyPropertiesNotNull(sales.getSalesComponent(), vo);
					vo.setCustName(sales.getTenant().getCustName());
					vo.setType("00004");
				}
				salesVoes.add(vo);
			}
		}
		return salesVoes;
	}

	/**
	 * 统计销售记录数
	 * 
	 * @param salesVo
	 * @param filters
	 * @return
	 * @throws Exception
	 */
	private Integer totalSales(SalesVo salesVo, List<Filter> filters) throws Exception {
		int count = 0;
		StringBuilder hql = new StringBuilder("select count(salesId) from Sales");
		HibernateQBCQuery hibernateQBCQuery = new HibernateQBCQuery();
		Query query = this.getSession().createQuery(hibernateQBCQuery.query(hql, salesVo, filters));
		Object o = query.uniqueResult();
		if (o != null) {
			count = Integer.parseInt(String.valueOf(o));
		}
		return count;
	}

	/**
	 * 保存客户求租销售机会方法实现
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public Integer saveTenantSales(SalesVo salesVo) throws Exception {
		// 查询租客
		Tenant tenant = (Tenant) this.loadEntity(Tenant.class, salesVo.getCustId());
		// 销售机会信息
		TenantSales tenantSales = new TenantSales();
		SalesComponent salesComponent = new SalesComponent();
		BeanUtils.copyPropertiesNotNull(salesVo, salesComponent);
		tenantSales.setSalesComponent(salesComponent);
		tenantSales.setTenant(tenant);
		// 客户求租信息
		LeasedAsks leaseAsks = new LeasedAsks();
		BeanUtils.copyPropertiesNotNull(salesVo, leaseAsks);
		tenantSales.setLeasedAsks(leaseAsks);
		leaseAsks.setTenantSales(tenantSales);
		// 保存信息
		this.saveEntity(tenantSales);
		return tenantSales.getSalesId();
	}

	/**
	 * 编辑销售机会方法实现
	 * 
	 * @param salesVo
	 * @return
	 * @throws Exception
	 */
	public Integer editTenantSales(SalesVo salesVo) throws Exception {
		// 查找租客销售机会
		TenantSales tenantSales = (TenantSales) this.loadEntity(TenantSales.class, salesVo.getSalesId());
		// 销售机会信息
		SalesComponent salesComponent = new SalesComponent();
		BeanUtils.copyPropertiesNotNull(salesVo, salesComponent);
		tenantSales.setSalesComponent(salesComponent);
		// 客户求租信息
		LeasedAsks leaseAsks = tenantSales.getLeasedAsks();
		BeanUtils.copyPropertiesNotNull(salesVo, leaseAsks);

		this.updateEntity(tenantSales);

		return tenantSales.getSalesId();
	}

	/**
	 * 编辑业主销售机会方法实现
	 * 
	 * @param salesVo
	 * @return
	 * @throws Exception
	 */
	public Integer editHouseSales(SalesVo salesVo) throws Exception {
		// 查找业主销售机会
		HouseSales houseSales = (HouseSales) this.loadEntity(HouseSales.class, salesVo.getSalesId());
		// 销售机会信息
		SalesComponent salesComponent = new SalesComponent();
		BeanUtils.copyPropertiesNotNull(salesVo, salesComponent);
		houseSales.setSalesComponent(salesComponent);
		// 房屋出租信息
		HireAsks hireAsks = (HireAsks) houseSales.getHireAsks();
		BeanUtils.copyPropertiesNotNull(salesVo, hireAsks);

		return houseSales.getSalesId();
	}

	/**
	 * 保存业主出租房屋销售机会方法实现
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public Integer saveHouseSales(SalesVo salesVo) throws Exception {
		// 查询租客
		Proprietor proprietor = (Proprietor) this.loadEntity(Proprietor.class, salesVo.getCustId());
		// 查询房屋
		House house = (House) this.loadEntity(House.class, salesVo.getHouseId());
		// 销售机会信息
		HouseSales houseSales = new HouseSales();
		SalesComponent salesComponent = new SalesComponent();
		BeanUtils.copyPropertiesNotNull(salesVo, salesComponent);
		houseSales.setSalesComponent(salesComponent);
		houseSales.setProprietor(proprietor);
		houseSales.setHouse(house);
		// 房屋出租信息
		HireAsks hireAsks = new HireAsks();
		BeanUtils.copyPropertiesNotNull(salesVo, hireAsks);
		// 保存信息
		houseSales.setHireAsks(hireAsks);
		hireAsks.setHouseSales(houseSales);
		this.saveEntity(houseSales);
		return houseSales.getSalesId();
	}

	/**
	 * 销售机会查找方法实现
	 * 
	 * @param salesVo
	 * @throws Exception
	 */
	public void findSalesById(SalesVo salesVo) throws Exception {
		if (salesVo.getType() != null && salesVo.getType().equals("00003")) {
			HouseSales houseSales = (HouseSales) this.getSession().get(HouseSales.class, salesVo.getSalesId());
			BeanUtils.copyPropertiesNotNull(houseSales.getSalesComponent(), salesVo);
			BeanUtils.copyPropertiesNotNull(houseSales.getProprietor(), salesVo);
			BeanUtils.copyPropertiesNotNull(houseSales.getHireAsks(), salesVo);
		} else {
			TenantSales tenantSales = (TenantSales) this.getSession().get(TenantSales.class, salesVo.getSalesId());
			BeanUtils.copyPropertiesNotNull(tenantSales.getSalesComponent(), salesVo);
			BeanUtils.copyPropertiesNotNull(tenantSales.getTenant(), salesVo);
			BeanUtils.copyPropertiesNotNull(tenantSales.getLeasedAsks(), salesVo);
		}
	}

	/**
	 * 销售机会跟踪历史方法实现
	 * 
	 * @param salesVo
	 * @return
	 * @throws Exception
	 */
	public List<TrackingHistoryVo> findTrackingHistoryVoBySalesId(SalesVo salesVo) throws Exception {
		List<TrackingHistoryVo> trackingHistoryVoes = new ArrayList<TrackingHistoryVo>();
		Sales sales = (Sales) this.getEntity(Sales.class, salesVo.getSalesId());
		Iterator<TrackingHistory> iterator = sales.getTrackingHistories().iterator();
		while (iterator.hasNext()) {
			TrackingHistory trackingHistory = iterator.next();
			TrackingHistoryVo vo = new TrackingHistoryVo();
			BeanUtils.copyPropertiesNotNull(trackingHistory.getSalesComponent(), vo);
			trackingHistoryVoes.add(vo);
		}
		return trackingHistoryVoes;
	}

	/**
	 * 销售漏斗统计方法实现
	 * 
	 * @param salesVo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> totalSalesFunnel(SalesVo salesVo) throws Exception {
		Map<String, String> map = new TreeMap<String, String>();
		String hql = "select salesComponent.stage,count(salesId) as c from Sales group by salesComponent.stage";
		Query query = this.getSession().createQuery(hql);
		List list = query.list();
		for (int i = 0; i < list.size(); i++) {
			Object[] o = (Object[]) list.get(i);
			map.put(String.valueOf(o[0]), String.valueOf(o[1]));
		}
		return map;
	}

}