package net.ziroom.crm.entity.sales;

import net.ziroom.crm.entity.component.SalesComponent;

/**
 * 销售机会跟踪历史
 * 
 * @author Administrator
 * 
 */
public class TrackingHistory {

	private Integer historyId;
	private Sales sales;
	private SalesComponent salesComponent;

	public TrackingHistory() {
	}

	public Integer getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}

	public Sales getSales() {
		return sales;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	public SalesComponent getSalesComponent() {
		return salesComponent;
	}

	public void setSalesComponent(SalesComponent salesComponent) {
		this.salesComponent = salesComponent;
	}

}