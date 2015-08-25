package net.ziroom.crm.entity.sales;

import java.util.HashSet;
import java.util.Set;

import net.ziroom.crm.entity.component.SalesComponent;

/**
 * 销售机会实体模型
 * 
 * @author Administrator
 * 
 */
public class Sales {

	private Integer salesId;
	private SalesComponent salesComponent;
	private Set<TrackingHistory> trackingHistories = new HashSet<TrackingHistory>();

	public Sales() {
	}

	public Integer getSalesId() {
		return this.salesId;
	}

	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	public SalesComponent getSalesComponent() {
		return salesComponent;
	}

	public void setSalesComponent(SalesComponent salesComponent) {
		this.salesComponent = salesComponent;
	}

	public Set<TrackingHistory> getTrackingHistories() {
		return trackingHistories;
	}

	public void setTrackingHistories(Set<TrackingHistory> trackingHistories) {
		this.trackingHistories = trackingHistories;
	}
}