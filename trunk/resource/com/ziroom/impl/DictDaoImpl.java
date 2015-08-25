package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Business;
import com.ziroom.entity.Dict;
import com.ziroom.entity.District;
import com.ziroom.entity.DistrictBusiness;
import com.ziroom.entity.Subway;
import com.ziroom.entity.SubwayStation;
import com.ziroom.module.system.dao.DictDao;
import com.ziroom.module.system.vo.DictVo;

/**
 * 数据字典数据访问接口实现类
 * 
 * @author 孙树林
 */
public class DictDaoImpl extends HibernateQBCQuery implements DictDao {

	/**
	 * 读取所有字典数据
	 */
	@SuppressWarnings("unchecked")
	public List<DictVo> searchAllDict() {
		List<DictVo> dictVoes = new ArrayList<DictVo>();
		List<Dict> dicts = this.createCriteria(Dict.class).list();
		for (Dict dict : dicts) {
			DictVo vo = new DictVo();
			BeanUtils.copyPropertiesNotNull(dict, vo);
			dictVoes.add(vo);
		}
		return dictVoes;
	}

	/**
	 * 读取所有的商圈
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DictVo> searchAllBusiness() {
		List<DictVo> dictVoes = new ArrayList<DictVo>();
		List<Business> businesses = this.createCriteria(Business.class).list();
		for (Business business : businesses) {
			DictVo vo = new DictVo();
			vo.setType("T_BUSINESS");
			vo.setCode(business.getBusinessCode());
			vo.setValue(business.getBusinessName());
			dictVoes.add(vo);
		}
		return dictVoes;
	}

	/**
	 * 读取所有区域
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DictVo> searchAllDistrict() {
		List<DictVo> dictVoes = new ArrayList<DictVo>();
		List<District> districts = this.createCriteria(District.class).list();
		for (District district : districts) {
			DictVo vo = new DictVo();
			vo.setType("T_DISTRICT");
			vo.setCode(district.getDistrictCode());
			vo.setValue(district.getDistrictName());
			dictVoes.add(vo);
		}
		return dictVoes;
	}

	/**
	 * 读取区域与商圈关系
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DictVo> searchAllDistrictBusiness() {
		List<DictVo> dictVoes = new ArrayList<DictVo>();
		List<DistrictBusiness> districtBusinesses = this.createCriteria(DistrictBusiness.class).list();
		for (DistrictBusiness districtBusiness : districtBusinesses) {
			DictVo vo = new DictVo();
			vo.setType("T_DISTRICT_BUSINESS");
			vo.setCode(districtBusiness.getBusinessCode());
			vo.setValue(districtBusiness.getDistrictCode());
			dictVoes.add(vo);
		}
		return dictVoes;
	}

	/**
	 * 读取所有的地铁线
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DictVo> searchAllSubway() {
		List<DictVo> dictVoes = new ArrayList<DictVo>();
		List<Subway> subways = this.createCriteria(Subway.class).list();
		for (Subway subway : subways) {
			DictVo vo = new DictVo();
			vo.setType("T_SUBWAY");
			vo.setCode(subway.getSubwayCode());
			vo.setValue(subway.getSubwayName());
			dictVoes.add(vo);
		}
		return dictVoes;
	}

	/**
	 * 读取所有的地点站点
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DictVo> searchAllSubwayStation() {
		List<DictVo> dictVoes = new ArrayList<DictVo>();
		List<SubwayStation> subwayStations = this.createCriteria(SubwayStation.class).list();
		for (SubwayStation subwayStation : subwayStations) {
			DictVo vo = new DictVo();
			vo.setType("T_SUBWAYSTATION");
			vo.setCode(subwayStation.getStationCode());
			vo.setValue(subwayStation.getStationName());
			dictVoes.add(vo);
		}
		return dictVoes;
	}

}
