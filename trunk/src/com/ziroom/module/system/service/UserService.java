package com.ziroom.module.system.service;

import java.util.ArrayList;
import java.util.List;

import com.ziroom.module.system.dao.UserDao;
import com.ziroom.module.system.vo.UserVo;

/**
 * 用户业务处理方法
 * 
 * @author 孙树林
 */
public class UserService {

	private UserDao userDao;

	/**
	 * 通过组织机构编码和用户职位查询用户信息
	 * 
	 * @param deptCode
	 * @param job
	 * @return
	 */
	public List<UserVo> searchUserByDeptAndJob(String deptCode, String job) {
		List<UserVo> userVoes = new ArrayList<UserVo>();
		userVoes = userDao.searchUserByDeptAndJob(deptCode, job);
		return userVoes;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
