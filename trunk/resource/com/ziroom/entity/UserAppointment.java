package com.ziroom.entity;

// default package

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UserAppointment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class UserAppointment {

	// Fields

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
	private Set<Appointment> appointments = new HashSet<Appointment>(0);

	// Constructors

	/** default constructor */
	public UserAppointment() {
	}

	/** full constructor */
	public UserAppointment(String rentUserId, String userName, String userPassword, String userMobile,
			String userEmail, String userImType, String userImNum, String userGender, String userAge,
			String userOccupation, String userHobby, String userPrice, Date userRentDate, String userCause,
			String userNotes, String userCheck, String userType, Set<Appointment> appointments) {
		this.rentUserId = rentUserId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
		this.userImType = userImType;
		this.userImNum = userImNum;
		this.userGender = userGender;
		this.userAge = userAge;
		this.userOccupation = userOccupation;
		this.userHobby = userHobby;
		this.userPrice = userPrice;
		this.userRentDate = userRentDate;
		this.userCause = userCause;
		this.userNotes = userNotes;
		this.userCheck = userCheck;
		this.userType = userType;
		this.appointments = appointments;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRentUserId() {
		return this.rentUserId;
	}

	public void setRentUserId(String rentUserId) {
		this.rentUserId = rentUserId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserMobile() {
		return this.userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserImType() {
		return this.userImType;
	}

	public void setUserImType(String userImType) {
		this.userImType = userImType;
	}

	public String getUserImNum() {
		return this.userImNum;
	}

	public void setUserImNum(String userImNum) {
		this.userImNum = userImNum;
	}

	public String getUserGender() {
		return this.userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserAge() {
		return this.userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getUserOccupation() {
		return this.userOccupation;
	}

	public void setUserOccupation(String userOccupation) {
		this.userOccupation = userOccupation;
	}

	public String getUserHobby() {
		return this.userHobby;
	}

	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}

	public String getUserPrice() {
		return this.userPrice;
	}

	public void setUserPrice(String userPrice) {
		this.userPrice = userPrice;
	}

	public Date getUserRentDate() {
		return this.userRentDate;
	}

	public void setUserRentDate(Date userRentDate) {
		this.userRentDate = userRentDate;
	}

	public String getUserCause() {
		return this.userCause;
	}

	public void setUserCause(String userCause) {
		this.userCause = userCause;
	}

	public String getUserNotes() {
		return this.userNotes;
	}

	public void setUserNotes(String userNotes) {
		this.userNotes = userNotes;
	}

	public String getUserCheck() {
		return this.userCheck;
	}

	public void setUserCheck(String userCheck) {
		this.userCheck = userCheck;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Set<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

}