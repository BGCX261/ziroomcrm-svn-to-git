package net.ziroom.crm.entity.sales;

/**
 * 租客求租信息实体模型
 * 
 * @author 孙树林
 */
public class LeasedAsks extends Asks {
	
	private TenantSales tenantSales;

	public TenantSales getTenantSales() {
		return tenantSales;
	}

	public void setTenantSales(TenantSales tenantSales) {
		this.tenantSales = tenantSales;
	}
}
