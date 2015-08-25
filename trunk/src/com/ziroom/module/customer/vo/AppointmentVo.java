package com.ziroom.module.customer.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ziroom.common.action.ZiroomVo;

/**
 * 带看单值对象
 * 
 * @author 孙树林
 */
public class AppointmentVo extends ZiroomVo {

	private Integer id;
	private String staffid;
	private Date choosetime;
	private Date printtime;
	private Integer clicktime;
	private Integer roomId;

	private String roomName;
	private String roomCode;
	private String stewardName;
	private String agentName;
	private Long rentFee;
	private String release;

	private List<AppointmentVo> appointmentVoes = new ArrayList<AppointmentVo>();

	private UserAppointmentVo userAppointmentVo = new UserAppointmentVo();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public Date getChoosetime() {
		return choosetime;
	}

	public void setChoosetime(Date choosetime) {
		this.choosetime = choosetime;
	}

	public Date getPrinttime() {
		return printtime;
	}

	public void setPrinttime(Date printtime) {
		this.printtime = printtime;
	}

	public Integer getClicktime() {
		return clicktime;
	}

	public void setClicktime(Integer clicktime) {
		this.clicktime = clicktime;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getStewardName() {
		return stewardName;
	}

	public void setStewardName(String stewardName) {
		this.stewardName = stewardName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public List<AppointmentVo> getAppointmentVoes() {
		return appointmentVoes;
	}

	public void setAppointmentVoes(List<AppointmentVo> appointmentVoes) {
		this.appointmentVoes = appointmentVoes;
	}

	public UserAppointmentVo getUserAppointmentVo() {
		return userAppointmentVo;
	}

	public void setUserAppointmentVo(UserAppointmentVo userAppointmentVo) {
		this.userAppointmentVo = userAppointmentVo;
	}

	public Long getRentFee() {
		return rentFee;
	}

	public void setRentFee(Long rentFee) {
		this.rentFee = rentFee;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

}
