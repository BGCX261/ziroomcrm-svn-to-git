package com.ziroom.module.house.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import com.ziroom.common.action.ZiroomAction;
import com.ziroom.module.house.service.RoomService;
import com.ziroom.module.house.vo.RoomVo;

/**
 * 房间请求处理类
 * 
 * @author 孙树林
 * 
 */
public class RoomAction extends ZiroomAction {

	private static final long serialVersionUID = 5583591190879926627L;

	private RoomVo vo = new RoomVo();

	private RoomService roomService;
	
	/** 文件下载参数 */
	protected String fileName;
	/** 下载文件的长度 */
	protected Long size;

	/**
	 * 房间发布
	 * 
	 * @return
	 * @throws Exception
	 */
	public String pubRoom() throws Exception {
		roomService.pubRoom(vo);
		addMessage("操作成功！");
		return SUCCESS;
	}

	/**
	 * 出租房间发布界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String pubRoomPage() throws Exception {
		roomService.findRoom(vo);
		return SUCCESS;
	}

	/**
	 * 优先展示房间
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showPriorRoom() throws Exception {
		String msg = roomService.showPriorRoom(vo);
		if (!msg.equals("success")) {
			addMessage(msg);
		} else {
			addMessage("操作成功！");
		}
		return SUCCESS;
	}

	/**
	 * 推荐房间
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showTopRoom() throws Exception {
		String msg = roomService.topRoom(vo);
		if (!msg.equals("success")) {
			addMessage(msg);
		} else {
			addMessage("操作成功！");
		}
		return SUCCESS;
	}

	/**
	 * 房源包下载
	 * 
	 * @throws Exception
	 */
	public String downRoomPackage() throws Exception {
		// TODO 暂时不处理内容
		return SUCCESS;
	}

	/**
	 * 返回文件流
	 * 
	 * @return
	 * @throws Exception
	 */
	public InputStream getInputStream() throws Exception {
		// 房源包生成路径
		String roomPath = getServletContext().getRealPath("/roomPackage");
		// 报表路径
		String reportPath = getServletContext().getRealPath("/report/roomPackage.jasper");
		Map<String, String> roomPackage = roomService.createRoomPackage(vo, roomPath, reportPath);
		fileName = roomPackage.get("fileName");
		String downFilePath = roomPackage.get("downFilePath");
		fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
		//fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		File file = new File(downFilePath);
		size = file.length();
		InputStream is = new FileInputStream(file);
		return is;
	}

	public RoomVo getVo() {
		return vo;
	}

	public void setVo(RoomVo vo) {
		this.vo = vo;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
}