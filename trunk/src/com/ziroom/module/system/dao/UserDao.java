package com.ziroom.module.system.dao;

import java.util.List;

import com.ziroom.module.system.vo.UserVo;

/**
 * 
 * 用户数据访问接口
 * 
 * @author 孙树林
 */
public interface UserDao {

	/**
	 * 查找用户
	 * 
	 * @param userVo
	 * @return
	 */
	public UserVo searchUser(String staffid, String staffPass);

	/**
	 * 通过deptpath、setjob查询用户信息
	 * 
	 * @param dept
	 * @param job
	 * @return
	 */
	public List<UserVo> searchUserByDeptAndJob(String dept, String job);
}
