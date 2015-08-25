package com.ziroom.module.cms.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.common.util.FileUtils;
import com.common.util.ResourceManager;
import com.common.util.UUIDFactory;
import com.ziroom.common.connector.ConditionInterface;
import com.ziroom.common.util.ShellUtils;
import com.ziroom.common.util.TemplateUtils;
import com.ziroom.module.cms.dao.SowingDao;
import com.ziroom.module.cms.vo.SowingVo;

/**
 * 首页轮播图业务处理类
 * 
 * @author 孙树林
 */
public class SowingService {

	private SowingDao sowingDao;

	private ConditionInterface sowingConditionInterface;

	/**
	 * 查询首页轮播图列表
	 * 
	 * @param sowingVo
	 * @throws Exception
	 */
	public void searchSowing(SowingVo sowingVo) throws Exception {
		sowingConditionInterface.handlerCondition(sowingVo);
		sowingVo.setSowingVoes(sowingDao.search(sowingVo));
	}

	/**
	 * 保存轮播信息
	 * 
	 * @param sowingVo
	 * @throws Exception
	 */
	public void saveSowing(SowingVo sowingVo, String root) throws Exception {
		// 获得图片保存文件目录
		String path = ResourceManager.getString("sowing.upload.path");
		String big = UUIDFactory.createUUID();
		String small = UUIDFactory.createUUID();
		// 设置保存图片的路径
		String[] bigSuffix = sowingVo.getBigFileName().split("\\.");
		String[] smallSuffix = sowingVo.getSmallFileName().split("\\.");
		String bigPicturePath = path + "/" + big + "." + bigSuffix[1];
		String smallPicturePath = path + "/" + small  + "." + smallSuffix[1];
		sowingVo.setBigPicturePath(bigPicturePath);
		sowingVo.setSmallPicturePath(smallPicturePath);
		// 排序号
		int sortNum = sowingDao.getMaxSortNum() + 1;
		sowingVo.setSortNum(sortNum);
		sowingVo.setIsShow("N");
		sowingDao.saveSowing(sowingVo);
		// 对于上传图片处理,保存图片
		File smallFile = sowingVo.getSmall();
		File bigFile = sowingVo.getBig();
		FileUtils.copyFile(bigFile, root + bigPicturePath);
		FileUtils.copyFile(smallFile, root + smallPicturePath);
	}

	/**
	 * 删除轮播图信息
	 * 
	 * @param sowingVo
	 * @throws Exception
	 */
	public void deleteSowing(SowingVo sowingVo, String root) throws Exception {
		// 查询信息
		sowingDao.findSowing(sowingVo);
		// 删除信息
		sowingDao.deleteSowing(sowingVo);
		// 更新排序号
		sowingDao.updateSortNum(sowingVo.getSortNum());
		// 删除图片信息
		String big = sowingVo.getBigPicturePath();
		String small = sowingVo.getSmallPicturePath();
		FileUtils.deleteFile(root + "/" + big);
		FileUtils.deleteFile(root + "/" + small);
	}

	/**
	 * 查找轮播图信息
	 * 
	 * @param sowingVo
	 * @throws Exception
	 */
	public void findSowing(SowingVo sowingVo) throws Exception {
		sowingDao.findSowing(sowingVo);
	}

	/**
	 * 轮播图上移下移操作
	 * 
	 * @param sowingVo
	 * @throws Exception
	 */
	public void upOrDownSowing(SowingVo sowingVo) throws Exception {
		sowingDao.findSowing(sowingVo);

		if (sowingVo.getOperator().equals("next")) {
			// 下移
			SowingVo other = new SowingVo();
			other.setSortNum(sowingVo.getSortNum() + 1);
			sowingDao.findSowingBySortNum(other);
			// 如果不存在下个节点，不操作
			if (other.getId() != null) {
				sowingVo.setSortNum(sowingVo.getSortNum() + 1);
				other.setSortNum(other.getSortNum() - 1);
				sowingDao.updateSowing(other);
				sowingDao.updateSowing(sowingVo);
			}
		} else if (sowingVo.getOperator().equals("previson")) {
			// 上移
			SowingVo other = new SowingVo();
			other.setSortNum(sowingVo.getSortNum() - 1);
			sowingDao.findSowingBySortNum(other);
			// 如果不存在下个节点，不操作
			if (other.getId() != null) {
				sowingVo.setSortNum(sowingVo.getSortNum() - 1);
				other.setSortNum(other.getSortNum() + 1);
				sowingDao.updateSowing(other);
				sowingDao.updateSowing(sowingVo);
			}
		}
	}

	/**
	 * 轮播图发布操作
	 * 
	 * @param sowingVo
	 * @throws Exception
	 */
	public void pubSowing(SowingVo sowingVo) throws Exception {
		sowingDao.findSowing(sowingVo);
		if (sowingVo.getIsShow().equals("Y")) {
			sowingVo.setIsShow("N");
		} else {
			sowingVo.setIsShow("Y");
		}
		sowingDao.updateSowing(sowingVo);
	}

	/**
	 * 发布生成静态页
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void publishSowing(String webRoot) throws Exception {
		// 获得所有的发布首页信息
		List<SowingVo> sowingVoes = sowingDao.searchAll();
		// 设置模板参数
		Map map = new TreeMap();
		map.put("sowing", sowingVoes);
		String dir = webRoot + ResourceManager.getString("sowing.template.path");
		String templatePath = webRoot + ResourceManager.getString("sowing.tpl.path") + "/index.tpl";
		TemplateUtils.createHtml(map, templatePath, dir, "index.ftl");
		
		// 同步图片资源，模板文件
		String pics = webRoot + ResourceManager.getString("sowing.upload.path") + "/";
		List<String> rsyncs = new ArrayList<String>();
		// 删除服务器目录中与源目录不存在文件
		//rsyncs[0] = "rsync -av --delete " + ShellUtils.handerDisk(pics) + " " + ResourceManager.getString("sowing.remote.index.pics.address");
		//rsyncs[1] = "rsync -av --delete " + ShellUtils.handerDisk(templatePath) + " " + ResourceManager.getString("remote.index.tpl.address");
		// 不删除
		//rsyncs[0] = "rsync -av " + ShellUtils.handerDisk(pics) + " " + ResourceManager.getString("sowing.remote.index.pics.address");
		//rsyncs[1] = "rsync -av " + ShellUtils.handerDisk(templatePath) + " " + ResourceManager.getString("");
		ShellUtils shellUtils = new ShellUtils();
		String s_pic = ShellUtils.handerDisk(pics);
		String[] pictures = ResourceManager.getString("sowing.remote.index.pics.address").split(",");
		for(String picture : pictures) {
			rsyncs.add("rsync -av " + s_pic + " " + picture);
		}
		String s_tpl = ShellUtils.handerDisk(templatePath);
		String[] tpls = ResourceManager.getString("remote.index.tpl.address").split(",");
		for(String tpl : tpls) {
			rsyncs.add("rsync -av " + s_tpl + " " + tpl);
		}
		// 执行外部程序
		shellUtils.exec(rsyncs);
	}

	public void setSowingDao(SowingDao sowingDao) {
		this.sowingDao = sowingDao;
	}

	public void setSowingConditionInterface(ConditionInterface sowingConditionInterface) {
		this.sowingConditionInterface = sowingConditionInterface;
	}
}
