package com.ziroom.module.cms.action;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.cms.service.SowingService;
import com.ziroom.module.cms.vo.SowingVo;

/**
 * 首页轮播图请求
 * 
 * @author 孙树林
 */
public class SowingAction extends ZiroomAction {

	private static final long serialVersionUID = -1610503717103501666L;

	private SowingVo vo = new SowingVo();

	private SowingService sowingService;

	/**
	 * 首页轮播图列表请求
	 * 
	 * @return
	 * @throws Exception
	 */
	public String searchSowing() throws Exception {
		sowingService.searchSowing(vo);
		return SUCCESS;
	}

	/**
	 * 保存轮播图信息请求
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveSowing() throws Exception {
		sowingService.saveSowing(vo, getServletContext().getRealPath("/"));
		this.addMessage("操作成功！");
		return SUCCESS;
	}

	/**
	 * 查找请求
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findSowing() throws Exception {
		if (vo.getId() != null) {
			sowingService.findSowing(vo);
		}
		return SUCCESS;
	}

	/**
	 * 删除请求
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteSowing() throws Exception {
		sowingService.deleteSowing(vo, getServletContext().getRealPath("/"));
		this.addMessage("操作成功！");
		return SUCCESS;
	}

	/**
	 * 上移下移请求
	 * 
	 * @return
	 * @throws Exception
	 */
	public String upOrDownSowing() throws Exception {
		sowingService.upOrDownSowing(vo);
		return SUCCESS;
	}

	/**
	 * 发布请求
	 * 
	 * @return
	 * @throws Exception
	 */
	public String pubSowing() throws Exception {
		sowingService.pubSowing(vo);
		this.addMessage("操作成功！");
		return SUCCESS;
	}

	/**
	 * 发布首页静态界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String publishSowing() throws Exception {
		sowingService.publishSowing(this.getServletContext().getRealPath("/"));
		return SUCCESS;
	}

	public SowingVo getVo() {
		return vo;
	}

	public void setVo(SowingVo vo) {
		this.vo = vo;
	}

	public void setSowingService(SowingService sowingService) {
		this.sowingService = sowingService;
	}
}
