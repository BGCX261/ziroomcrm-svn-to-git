package com.ziroom.entity;

// default package

import java.util.Date;

/**
 * Appointment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Appointment {

	// Fields

	private Integer id;
	private UserAppointment userAppointment;
	private String staffid;
	private Date choosetime;
	private Date printtime;
	private Integer clicktime;
	private String release;

	private Room room;

	// Constructors

	/** default constructor */
	public Appointment() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserAppointment getUserAppointment() {
		return this.userAppointment;
	}

	public void setUserAppointment(UserAppointment userAppointment) {
		this.userAppointment = userAppointment;
	}

	public String getStaffid() {
		return this.staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public Date getChoosetime() {
		return this.choosetime;
	}

	public void setChoosetime(Date choosetime) {
		this.choosetime = choosetime;
	}

	public Date getPrinttime() {
		return this.printtime;
	}

	public void setPrinttime(Date printtime) {
		this.printtime = printtime;
	}

	public Integer getClicktime() {
		return this.clicktime;
	}

	public void setClicktime(Integer clicktime) {
		this.clicktime = clicktime;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

}