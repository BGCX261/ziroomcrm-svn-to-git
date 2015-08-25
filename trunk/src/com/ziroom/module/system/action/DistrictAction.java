package com.ziroom.module.system.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.common.manager.DictManager;
import com.ziroom.module.system.vo.DictVo;

/**
 * 区域，商圈请求处理
 * 
 * @author 孙树林
 */
public class DistrictAction extends ZiroomAction {

	private static final long serialVersionUID = -8701635094412203836L;

	private Map<String, String> vo = new TreeMap<String, String>();
	
	private String districtCode;

	/**
	 * 查询区域
	 * 
	 * @throws Exception
	 */
	public void searchDistrict() throws Exception {
		vo = DictManager.getType("T_DISTRICT");
	}

	/**
	 * 异步请求商圈
	 * 
	 * @throws Exception
	 */
	public void ajaxBusiness() throws Exception {
		List<DictVo> dictVoes = new ArrayList<DictVo>();
		Map<String, String> T_BUSINESS = DictManager.getType("T_BUSINESS");
		Map<String, String> T_DISTRICT_BUSINESS = DictManager.getType("T_DISTRICT_BUSINESS");
		Iterator<String> it = T_DISTRICT_BUSINESS.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String code = T_DISTRICT_BUSINESS.get(key);
			if(code != null && code.equals(districtCode)) {
				DictVo dictVo = new DictVo();
				dictVo.setCode(key);
				dictVo.setValue(T_BUSINESS.get(key));
				dictVoes.add(dictVo);
			}
		}
		json(dictVoes);
	}

	public Map<String, String> getVo() {
		return vo;
	}

	public void setVo(Map<String, String> vo) {
		this.vo = vo;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

}
