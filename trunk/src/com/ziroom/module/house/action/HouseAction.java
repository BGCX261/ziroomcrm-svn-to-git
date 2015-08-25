package com.ziroom.module.house.action;

import java.util.List;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.house.service.HouseService;
import com.ziroom.module.house.vo.HouseVo;

/**
 * 房屋请求处理类
 * 
 * @author 孙树林
 * 
 */
public class HouseAction extends ZiroomAction {

	private static final long serialVersionUID = 736126494301303838L;

	private HouseVo vo = new HouseVo();

	private HouseService houseService;

	/**
	 * 查询房屋
	 * 
	 * @return
	 * @throws Exception
	 */
	public String searchHouse() throws Exception {
		setPageBeanSize(vo, "house.page.size");
		List<HouseVo> houseVoes = houseService.searchHouse(vo);
		vo.setHouses(houseVoes);
		return SUCCESS;
	}

	/**
	 * 房屋发布
	 * 
	 * @return
	 * @throws Exception
	 */
	public String pubHouse() throws Exception {
		boolean isPub = houseService.pubHouse(vo);
		if (isPub) {
			addMessage("操作成功！");
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 房屋发布页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String pubHousePage() throws Exception {
		houseService.findHouse(vo);
		return SUCCESS;
	}
	
	/**
	 * 查看房屋详情
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewHouse() throws Exception {
		houseService.findHouseDetail(vo);
		return SUCCESS;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}

	public HouseVo getVo() {
		return vo;
	}

	public void setVo(HouseVo vo) {
		this.vo = vo;
	}
}
