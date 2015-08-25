package com.ziroom.module.cms.action;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.cms.service.SpecialService;
import com.ziroom.module.cms.vo.SpecialVo;

/**
 * 专题页请求类
 * 
 * @author 孙树林
 */
public class SpecialAction extends ZiroomAction {

	private static final long serialVersionUID = 5305427865756195911L;

	private SpecialVo vo = new SpecialVo();

	private SpecialService specialService;

	/**
	 * 查询专题页信息列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String searchSpecial() throws Exception {
		specialService.searchSpecial(vo);
		return SUCCESS;
	}

	/**
	 * 查找专题页信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findSpecail() throws Exception {
		if (vo.getId() != null) {
			specialService.findSpecial(vo);
		}
		return SUCCESS;
	}

	/**
	 * 查询房源
	 * 
	 * @return
	 * @throws Exception
	 */
	public String searchHouseByHouseCode() throws Exception {
		specialService.searchHouseByHouseCode(vo);
		return SUCCESS;
	}

	/**
	 * 保存专题页信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveSpecail() throws Exception {
		specialService.saveSpecail(vo, getServletContext().getRealPath("/"));
		return SUCCESS;
	}

	/**
	 * 删除专题页信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteSpecail() throws Exception {
		specialService.deleteSpecail(vo);
		return SUCCESS;
	}

	/**
	 * 上移下移专题页信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String upOrDownSpecial() throws Exception {
		specialService.upOrDownSpecial(vo);
		return SUCCESS;
	}

	/**
	 * 发布
	 * 
	 * @return
	 * @throws Exception
	 */
	public void pubSpecial() throws Exception {
		specialService.publish(vo, this.getServletContext().getRealPath("/"));
		this.out("success");
	}

	public SpecialVo getVo() {
		return vo;
	}

	public void setVo(SpecialVo vo) {
		this.vo = vo;
	}

	public void setSpecialService(SpecialService specialService) {
		this.specialService = specialService;
	}

}
