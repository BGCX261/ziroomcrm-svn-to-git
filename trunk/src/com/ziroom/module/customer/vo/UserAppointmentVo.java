package com.ziroom.module.customer.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ziroom.common.action.ZiroomVo;

/**
 * 客户值对象
 * 
 * @author 孙树林
 */
public class UserAppointmentVo extends ZiroomVo {

	private Integer userId;
	private String rentUserId;
	private String userName;
	private String userPassword;
	private String userMobile;
	private String userEmail;
	private String userImType;
	private String userImNum;
	private String userGender;
	private String userAge;
	private String userOccupation;
	private String userHobby;
	private String userPrice;
	private Date userRentDate;
	private String userCause;
	private String userNotes;
	private String userCheck;
	private String userType;
	private Integer lookCount;
	
	private List<UserAppointmentVo> userAppointmentVoes = new ArrayList<UserAppointmentVo>();
	
	private List<AppointmentVo> appointmentVoes = new ArrayList<AppointmentVo>();

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRentUserId() {
		return rentUserId;
	}

	public void setRentUserId(String rentUserId) {
		this.rentUserId = rentUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserImType() {
		return userImType;
	}

	public void setUserImType(String userImType) {
		this.userImType = userImType;
	}

	public String getUserImNum() {
		return userImNum;
	}

	public void setUserImNum(String userImNum) {
		this.userImNum = userImNum;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getUserOccupation() {
		return userOccupation;
	}

	public void setUserOccupation(String userOccupation) {
		this.userOccupation = userOccupation;
	}

	public String getUserHobby() {
		return userHobby;
	}

	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}

	public String getUserPrice() {
		return userPrice;
	}

	public void setUserPrice(String userPrice) {
		this.userPrice = userPrice;
	}

	public Date getUserRentDate() {
		return userRentDate;
	}

	public void setUserRentDate(Date userRentDate) {
		this.userRentDate = userRentDate;
	}

	public String getUserCause() {
		return userCause;
	}

	public void setUserCause(String userCause) {
		this.userCause = userCause;
	}

	public String getUserNotes() {
		return userNotes;
	}

	public void setUserNotes(String userNotes) {
		this.userNotes = userNotes;
	}

	public String getUserCheck() {
		return userCheck;
	}

	public void setUserCheck(String userCheck) {
		this.userCheck = userCheck;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<UserAppointmentVo> getUserAppointmentVoes() {
		return userAppointmentVoes;
	}

	public void setUserAppointmentVoes(List<UserAppointmentVo> userAppointmentVoes) {
		this.userAppointmentVoes = userAppointmentVoes;
	}

	public List<AppointmentVo> getAppointmentVoes() {
		return appointmentVoes;
	}

	public void setAppointmentVoes(List<AppointmentVo> appointmentVoes) {
		this.appointmentVoes = appointmentVoes;
	}

	public Integer getLookCount() {
		return lookCount;
	}

	public void setLookCount(Integer lookCount) {
		this.lookCount = lookCount;
	}
}
