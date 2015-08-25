package com.common.hibernate;

import java.util.ArrayList;
import java.util.List;

/**
 * hibernate filter过滤器
 * 
 * @author 孙树林
 */
public class Filter {

	private String filterName;

	private List<Parmater> parmaters = new ArrayList<Parmater>();

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public List<Parmater> getParmaters() {
		return parmaters;
	}

	public void setParmaters(List<Parmater> parmaters) {
		this.parmaters = parmaters;
	}
	
	public void addParmater(Parmater parmater) {
		parmaters.add(parmater);
	}
}
