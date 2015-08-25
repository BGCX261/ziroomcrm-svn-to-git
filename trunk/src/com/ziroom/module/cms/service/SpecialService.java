package com.ziroom.module.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.common.bean.ArgumentsBean;
import com.common.util.FileUtils;
import com.common.util.ResourceManager;
import com.common.util.UUIDFactory;
import com.ziroom.common.connector.ConditionInterface;
import com.ziroom.common.manager.DictManager;
import com.ziroom.common.util.ShellUtils;
import com.ziroom.common.util.TemplateUtils;
import com.ziroom.common.util.ZiroomImagesUtils;
import com.ziroom.module.cms.dao.SpecialDao;
import com.ziroom.module.cms.vo.SpecialVo;
import com.ziroom.module.house.dao.HouseDao;
import com.ziroom.module.house.dao.RoomDao;
import com.ziroom.module.house.dao.RoomPictureDao;
import com.ziroom.module.house.vo.HouseVo;
import com.ziroom.module.house.vo.RoomPictureVo;
import com.ziroom.module.house.vo.RoomVo;

/**
 * 专题页业务处理类
 * 
 * @author 孙树林
 */
public class SpecialService {

	private SpecialDao specialDao;

	private HouseDao houseDao;

	private RoomDao roomDao;

	private RoomPictureDao roomPictureDao;

	private ConditionInterface specialConditionInterface;

	/**
	 * 专题页查询业务处理方法
	 * 
	 * @throws Exception
	 */
	public void searchSpecial(SpecialVo specialVo) throws Exception {
		String type = null;
		// 根据查询条件获得搜索的专题信息
		List<ArgumentsBean> argumentsBeans = specialVo.getArgumentsBeans();
		if (argumentsBeans != null && argumentsBeans.size() > 0 && !argumentsBeans.get(0).getValues().get(0).equals("")) {
			type = argumentsBeans.get(0).getValues().get(0);
			if (type.equals("11000001")) {
				specialVo.setNewType("2000001");
			} else if (type.equals("11000002")) {
				specialVo.setNewType("2000002");
			} else if (type.equals("11000003")) {
				specialVo.setNewType("2000003");
			}
			specialConditionInterface.handlerCondition(specialVo);
			List<SpecialVo> list = specialDao.searchSpecial(specialVo);
			specialVo.setSpecialVoes(list);
		}
		String s1 = specialVo.getHouseCode();
		String s2 = specialVo.getContractCode();
		String s3 = specialVo.getHouseName();
		if ((s1 != null && !s1.equals("")) || (s2 != null && !s2.equals("")) || (s3 != null && !s3.equals(""))
				|| (type != null && !type.equals(""))) {
			// 查找房屋
			specialVo.setPage(true);
			List<HouseVo> houseVoes = houseDao.findHouse(specialVo);
			specialVo.setHouseVoes(houseVoes);
		}
	}

	/**
	 * 保存专题页
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void saveSpecail(SpecialVo specialVo, String root) throws Exception {
		// 查询房间信息
		RoomVo roomVo = new RoomVo();
		roomVo.setRoomId(specialVo.getRoomId());
		roomDao.findRoomByRoomId(roomVo);
		// 获得图片保存文件目录
		String path = ResourceManager.getString("special.upload.path");
		// 获得图片信息
		RoomPictureVo roomPictureVo = new RoomPictureVo();
		roomPictureVo.setHpimageid(specialVo.getImageId());
		roomPictureDao.findRoomPictureVo(roomPictureVo);
		// 设置保存图片的路径
		String[] s = roomPictureVo.getImagepath().split("\\.");
		String type = specialVo.getSpecialType();
		/* 存储不同目录 */
		if (type.equals("11000001")) {
			path += "/" + "jd";
		} else if (type.equals("11000002")) {
			path += "/" + "yc";
		} else if (type.equals("11000003")) {
			path += "/" + "gs";
		}

		String picture = path + "/" + UUIDFactory.createUUID() + "." + s[1];

		// 设置值
		specialVo.setImagePath(picture);
		specialVo.setCleaningFee(30F);
		specialVo.setRentFee(roomVo.getRentFee().floatValue());
		specialVo.setRoomArea(roomVo.getRoomArea());
		specialVo.setRoomCode(roomVo.getRoomCode());
		specialVo.setRoomPosition(DictManager.getName("WINDOW_FACE", roomVo.getRoomPosition()));
		specialVo.setRoomType(DictManager.getName("ROOM_TYPE", roomVo.getRoomType()));
		int max = specialDao.getMaxSortNum(specialVo.getSpecialType()) + 1;
		specialVo.setSortNum(max);

		specialDao.saveSpecial(specialVo);

		// 生成图片，对剪切图片进行处理。
		// int x1 = specialVo.getX1();
		// int y1 = specialVo.getY1();
		// Long w = specialVo.getWidth();
		// Long h = specialVo.getHeight();
		String sourePath = ResourceManager.getString("image.url") + roomPictureVo.getImagepath(); // 原始图片url
		String targetPath = root + picture; // 目标地址
		String pressPath = root + "images/water_logo.png";
		// ZiroomImagesUtils.handlerCMSProject(sourePath, targetPath, pressPath,
		// x1, y1, w.intValue(), h.intValue(), s[1]);
		int left = specialVo.getTxtLeft();
		int top = specialVo.getTxtTop();
		float ratio = specialVo.getTxtZoom();
		ZiroomImagesUtils.handlerCMSProject(sourePath, targetPath, pressPath, left, top, ratio, s[1]);
	}

	/**
	 * 查找专题
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void findSpecial(SpecialVo specialVo) throws Exception {
		if (specialVo.getId() != null) {
			// ID存在，查找专题信息
			specialDao.findSpecial(specialVo);
		}
	}

	/**
	 * 删除专题页
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void deleteSpecail(SpecialVo specialVo) throws Exception {
		// 查询信息
		specialDao.findSpecial(specialVo);
		specialDao.deleteSpecial(specialVo);
		// 更新排序号
		specialDao.updateSortNum(specialVo.getSortNum(), specialVo.getSpecialType());
		// 删除文件
		FileUtils.deleteFile(specialVo.getImagePath());
	}

	/**
	 * 上移，下移操作
	 * 
	 * @throws Exception
	 */
	public void upOrDownSpecial(SpecialVo specialVo) throws Exception {
		specialDao.findSpecial(specialVo);

		if (specialVo.getOperation().equals("next")) {
			// 下移
			SpecialVo other = new SpecialVo();
			other.setSortNum(specialVo.getSortNum() + 1);
			other.setSpecialType(specialVo.getSpecialType());
			specialDao.findSpecialBySortNum(other);
			// 如果不存在下个节点，不操作
			if (other.getId() != null) {
				specialVo.setSortNum(specialVo.getSortNum() + 1);
				other.setSortNum(other.getSortNum() - 1);
				specialDao.updateSpecial(other);
				specialDao.updateSpecial(specialVo);
			}
		} else if (specialVo.getOperation().equals("previson")) {
			// 上移
			SpecialVo other = new SpecialVo();
			other.setSortNum(specialVo.getSortNum() - 1);
			other.setSpecialType(specialVo.getSpecialType());
			specialDao.findSpecialBySortNum(other);
			// 如果不存在下个节点，不操作
			if (other.getId() != null) {
				specialVo.setSortNum(specialVo.getSortNum() - 1);
				other.setSortNum(other.getSortNum() + 1);
				specialDao.updateSpecial(other);
				specialDao.updateSpecial(specialVo);
			}
		}
	}

	/**
	 * 根据房源编号查找房屋及房屋所有房间信息,图片信息等内容。
	 * 
	 * @param specialVo
	 * @throws Exception
	 */
	public void searchHouseByHouseCode(SpecialVo specialVo) throws Exception {
		// if (specialVo.getType().equals("11000001")) {
		// specialVo.setNewType("2000001");
		// } else if (specialVo.getType().equals("11000002")) {
		// specialVo.setNewType("2000002");
		// } else if (specialVo.getType().equals("11000003")) {
		// specialVo.setNewType("2000003");
		// }
		HouseVo hosueVo = houseDao.findHouseByHouseCode(specialVo);
		specialVo.setHouseVo(hosueVo);
	}

	/**
	 * 发布生成专题页
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void publish(SpecialVo specialVo, String webRoot) throws Exception {
		// 获得所有的发布专题信息
		List<SpecialVo> specialVoes = specialDao.searchAll(specialVo.getSpecialType());
		// 设置模板参数
		Map map = new TreeMap();
		map.put("special", specialVoes);
		String dir = webRoot + ResourceManager.getString("special.template.path");
		String templatePath = webRoot + ResourceManager.getString("special.tpl.path");
		String templateName = null;
		String tpl = null;
		String name = null;
		String pics = webRoot + "/cms/special/";
		if (specialVo.getSpecialType().equals("11000001")) {
			tpl = "hp_JD.tpl";
			map.put("title", "友家·经典");
			templateName = "JD.ftl";
			pics += "/jd/";
			name = "jd";
		} else if (specialVo.getSpecialType().equals("11000002")) {
			tpl = "hp_YC.tpl";
			map.put("title", "友家·原创");
			templateName = "YC.ftl";
			pics += "/yc/";
			name = "yc";
		} else if (specialVo.getSpecialType().equals("11000003")) {
			tpl = "hp_GS.tpl";
			map.put("title", "友家·闺宿");
			templateName = "GS.ftl";
			pics += "/gs/";
			name = "gs";
		}
		String savepath = templatePath + "/" + tpl;
		TemplateUtils.createHtml(map, savepath, dir, templateName);
		
		// 发布命令
		List<String> rsyncs = new ArrayList<String>();
		ShellUtils shellUtils = new ShellUtils();
		String s_pic = ShellUtils.handerDisk(pics);
		String[] pictures = ResourceManager.getString("special.remote.index.pics.address").split(",");
		for(String picture : pictures) {
			rsyncs.add("rsync -av " + s_pic + " " + picture + "/" + name);
		}
		String s_tpl = ShellUtils.handerDisk(savepath);
		String[] tpls = ResourceManager.getString("remote.index.tpl.address").split(",");
		for(String tp : tpls) {
			rsyncs.add("rsync -av " + s_tpl + " " + tp);
		}
		// 执行外部程序
		shellUtils.exec(rsyncs);
	}

	public void setSpecialDao(SpecialDao specialDao) {
		this.specialDao = specialDao;
	}

	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}

	public void setRoomPictureDao(RoomPictureDao roomPictureDao) {
		this.roomPictureDao = roomPictureDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public void setSpecialConditionInterface(ConditionInterface specialConditionInterface) {
		this.specialConditionInterface = specialConditionInterface;
	}
}
