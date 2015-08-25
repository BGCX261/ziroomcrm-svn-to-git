package net.ziroom.crm.entity.sales;

import net.ziroom.crm.entity.customer.Tenant;

/**
 * 租客销售机会实体模型(意向客户)
 * 
 * @author 孙树林
 */
public class TenantSales extends Sales {

	private Tenant tenant;
	
	private LeasedAsks leasedAsks;

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public LeasedAsks getLeasedAsks() {
		return leasedAsks;
	}

	public void setLeasedAsks(LeasedAsks leasedAsks) {
		this.leasedAsks = leasedAsks;
	}
}
