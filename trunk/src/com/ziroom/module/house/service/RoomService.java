package com.ziroom.module.house.service;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tools.zip.ZipOutputStream;

import com.common.util.ResourceManager;
import com.common.util.StringUtils;
import com.ziroom.common.manager.SessionManager;
import com.ziroom.common.util.CompressionUtil;
import com.ziroom.common.util.JasperreportsUtils;
import com.ziroom.module.house.dao.ConfigDao;
import com.ziroom.module.house.dao.HouseDao;
import com.ziroom.module.house.dao.RoomDao;
import com.ziroom.module.house.dao.RoomPictureDao;
import com.ziroom.module.house.vo.HouseVo;
import com.ziroom.module.house.vo.RoomPictureVo;
import com.ziroom.module.house.vo.RoomVo;
import com.ziroom.module.system.vo.UserVo;

/**
 * 房间业务处理类，包括房间发布，推荐，优先展示等相关业务处理
 * 
 * @author 孙树林
 * 
 */
public class RoomService {

	private RoomDao roomDao;

	private HouseDao houseDao;

	private RoomPictureDao roomPictureDao;
	
	private ConfigDao configDao;

	/**
	 * 房间发布
	 * 
	 * @param vo
	 */
	public void pubRoom(RoomVo vo) throws Exception {
		// 获得要发布的房间信息
		roomDao.findRoomByRoomId(vo);
		if (vo.getIsShow().equals("N")) {
			// 发布房间
			vo.setIsShow("Y");
		} else {
			// 取消房间发布
			vo.setIsShow("N");
			vo.setIsTop("N");
			vo.setIsPromotions("N");
			vo.setCheckInTime(null);
		}
		roomDao.updateRoom(vo);
		// 获得该房间所属房屋发布房间数量和房屋的房间数量，如果相等更改房屋发布状态
		int pubNum = houseDao.totalHousePubRoomNum(vo.getSysHouseId());
		int roomNum = houseDao.totalHouseRoomNum(vo.getSysHouseId());
		HouseVo houseVo = new HouseVo();
		houseVo.setSysHouseId(vo.getSysHouseId());
		if (pubNum == roomNum) {
			// 如果发布数量等于房间数量
			houseVo.setIsShow("Y");
		} else {
			houseVo.setIsShow("N");
		}
		houseDao.updateHouseBySysHouseId(houseVo);
	}

	/**
	 * 查找房间
	 * 
	 * @param roomVo
	 * @throws Exception
	 */
	public void findRoom(RoomVo roomVo) throws Exception {
		// 获得要发布的房间信息
		roomDao.findRoomByRoomId(roomVo);
		// 获得房间所属房屋信息
		HouseVo houseVo = roomVo.getHouseVo();
		houseVo.setSysHouseId(roomVo.getSysHouseId());
		houseDao.findHouseBySysHouseId(houseVo);
	}

	/**
	 * 优先展示房间
	 * 
	 * @param roomVo
	 * @throws Exception
	 */
	public String showPriorRoom(RoomVo roomVo) throws Exception {
		String msg = "success";
		// 查找房间
		roomDao.findRoomByRoomId(roomVo);
		String isPromotions = roomVo.getIsPromotions();
		if (isPromotions != null && isPromotions.equals("N")) {
			// 验证房屋已优先展示房间数量
			int housePriorCount = houseDao.totalHousePriorNum(roomVo.getSysHouseId());
			if (housePriorCount > 0) {
				return "一个房屋只能有一个优先展示一间！";
			}
			// 验证管家已优先展示房间数
			UserVo userVo = SessionManager.getSessionUser();
			roomVo.setStewardCode(userVo.getStaffid());
			int stewardPriorCount = roomDao.totalPriorRoomNum(roomVo);
			if (stewardPriorCount >= 3) {
				return "每个管家最多只能优先展示三间！";
			}
			// 设置房间优先展示
			roomVo.setIsPromotions("Y");
		} else if (isPromotions != null && isPromotions.equals("Y")) {
			// 取消优先展示
			roomVo.setIsPromotions("N");
		}
		roomDao.updateRoom(roomVo);
		return msg;
	}

	/**
	 * 房间推荐
	 * 
	 * @param roomVo
	 * @return
	 * @throws Exception
	 */
	public String topRoom(RoomVo roomVo) throws Exception {
		String msg = "success";
		// 查找房间
		roomDao.findRoomByRoomId(roomVo);
		String top = roomVo.getIsTop();
		if (top != null && top.equals("N")) {
			// 验证房屋已推荐房间数量
			int totalTopNum = houseDao.totalHouseTopNum(roomVo.getSysHouseId());
			if (totalTopNum > 0) {
				return "一个房屋只能推荐一间！";
			}
			// 验证主管已推荐房间数
			UserVo userVo = SessionManager.getSessionUser();
			roomVo.setStewardCode(userVo.getStaffid());
			int stewardTopNum = roomDao.totalTopRoomNum(roomVo);
			if (stewardTopNum >= 3) {
				return "每个主管最多只能推荐三间房！";
			}
			roomVo.setIsTop("Y");
		} else {
			// 取消房间推荐
			roomVo.setIsTop("N");
		}
		roomDao.updateRoom(roomVo);
		return msg;
	}

	/**
	 * 生成房间房源包，并保持到系统roomPackage下。
	 * 
	 * @param roomVo
	 * @param savePath
	 *            文件保存路径
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> createRoomPackage(RoomVo roomVo, String savePath, String reportPath) throws Exception {
		Map<String, String> roomPackage = new HashMap<String, String>();
		// 通过房间获得房屋信息，小区信息及图片，以及其它房屋配置物品等内容。
		roomDao.findRoomByRoomId(roomVo);
		// 获得房间所属房屋信息
		HouseVo houseVo = new HouseVo();
		houseVo.setSysHouseId(roomVo.getSysHouseId());
		houseDao.findHouseBySysHouseId(houseVo);
		// 房源包名称
		String fileName = houseVo.getHouseCode() + roomVo.getRoomName() + ".zip";
		String file = savePath + "//" + fileName;
		roomPackage.put("fileName", fileName);
		roomPackage.put("downFilePath", file);
		// 创建zip房间压缩包
		FileOutputStream fos = new FileOutputStream(file);
		ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(fos));
		zos.setEncoding("GBK");
		// 图片服务器路径
		String imageUrl = ResourceManager.getString("image.url");
		// 室内图片处理
		List<RoomPictureVo> roomPictures = roomPictureDao.searchRoomPicture(roomVo.getSysRoomId());
		for (int i = 0; i < roomPictures.size(); i++) {
			RoomPictureVo roomPicture = roomPictures.get(i);
			String path = roomPicture.getImagepath();
			if (path != null && !path.equals("")) {
				int _a = path.lastIndexOf("/");
				path = path.substring(0, _a) + "//v480x360_" + path.substring(_a + 1);
				URL url = new URL(imageUrl + "//" + path);
				InputStream is = url.openStream();
				String _fileName = "室内图片/" + (i++) + ".jpg";
				CompressionUtil.compressFile(zos, is, _fileName);
				is.close();
			}
		}
		// 公共区域图片
		roomPictures = roomPictureDao.searchPubRegionPicture(houseVo.getSysHouseId());
		for (int i = 0; i < roomPictures.size(); i++) {
			RoomPictureVo roomPicture = roomPictures.get(i);
			String path = roomPicture.getImagepath();
			if (path != null && !path.equals("")) {
				int _a = path.lastIndexOf("/");
				path = path.substring(0, _a) + "//v480x360_" + path.substring(_a + 1);
				URL url = new URL(imageUrl + "//" + path);
				InputStream is = url.openStream();
				String _fileName = "公共区域图片/" + (i++) + ".jpg";
				CompressionUtil.compressFile(zos, is, _fileName);
				is.close();
			}
		}
		// 物品配置家具
		List<String> _c1 = configDao.searchRoomConfig(roomVo.getSysRoomId(), "jj4");
		List<String> _c2 = configDao.searchPubHouseConfig(houseVo.getSysHouseId(), "jj4");
		List<String> _c3 = configDao.searchRoomConfig(roomVo.getSysRoomId(), "jd");
		List<String> _c4 = configDao.searchPubHouseConfig(houseVo.getSysHouseId(), "jd");
		List<String> _c5 = configDao.searchRoomConfig(roomVo.getSysRoomId(), "jj1");
		List<String> _c6 = configDao.searchPubHouseConfig(houseVo.getSysHouseId(), "jj1");
		// 其它房屋租住状态
		StringBuilder sb = new StringBuilder();
		List<Map<String, String>> rooms = roomDao.searchOtherRoom(roomVo.getSysRoomId(), houseVo.getSysHouseId());
		int count = 0;
		for (int j = 0; j < rooms.size(); j++) {
			Map<String, String> rm = rooms.get(j);
			String rentstatus = rm.get("rentstatus") != null ? rm.get("rentstatus").toString() : "";
			String position = rm.get("roomposition") != null ? rm.get("roomposition").toString() : "";
			if (rentstatus.equals("ycz")) {
				String sex = rm.get("sex") != null ? rm.get("sex").toString() : "";
				String professional = rm.get("professional") != null ? rm.get("professional").toString() : "";
				String code = rm.get("code")!= null ? rm.get("code").toString() : "";;
				sb.append(!position.equals("") ? (position + "卧" + code + "住着一位") : "");
				sb.append(!sex.equals("") ? sex + "性" : "");
				sb.append(!professional.equals("") ? professional : "");
				sb.append(";");
			} else {
				sb.append(!position.equals("") ? (position + "卧待租 ;") : "卧室待租; ");
				count++;
			}
		}
		// 房间待租数量
		if(count == rooms.size()) {
			sb = new StringBuilder();
		}
		// 报表生成
		Map parameter = new HashMap();
		parameter.put("roomId", roomVo.getRoomId());
		parameter.put("c1", StringUtils.split(_c1, ","));
		parameter.put("c2", StringUtils.split(_c2, ","));
		parameter.put("c3", StringUtils.split(_c3, ","));
		parameter.put("c4", StringUtils.split(_c4, ","));
		parameter.put("c5", StringUtils.split(_c5, ","));
		parameter.put("c6", StringUtils.split(_c6, ","));
		parameter.put("c7", sb.toString());
		// 生成docx文件并进行压缩，删除该文件
		String filePath = JasperreportsUtils.docx(reportPath, parameter, roomDao.getConnection(), savePath);
		File _file = new File(filePath);
		FileInputStream fis = new FileInputStream(_file);
		CompressionUtil.compressFile(zos, fis, houseVo.getHouseCode() + roomVo.getRoomName() + ".docx");
		fis.close();
		_file.delete();
		// 生成html并进行压缩
		byte[] html = JasperreportsUtils.html(reportPath, parameter, roomDao.getConnection());
		InputStream is = new ByteArrayInputStream(html);
		CompressionUtil.compressFile(zos, is, houseVo.getHouseCode() + roomVo.getRoomName() + ".html");
		// 关闭流
		is.close();
		zos.close();
		fos.close();
		return roomPackage;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}

	public void setRoomPictureDao(RoomPictureDao roomPictureDao) {
		this.roomPictureDao = roomPictureDao;
	}

	public void setConfigDao(ConfigDao configDao) {
		this.configDao = configDao;
	}
}