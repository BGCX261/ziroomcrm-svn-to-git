/**
 *用户数据访问接口实现类
 *
 * Author 孙树林
 */
package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.User;
import com.ziroom.module.system.dao.UserDao;
import com.ziroom.module.system.vo.UserVo;

public class UserDaoImpl extends HibernateQBCQuery implements UserDao {

	/**
	 * 查找用户实现
	 */
	@SuppressWarnings("unchecked")
	public UserVo searchUser(String staffid, String staffPass) {
		StringBuilder hql = new StringBuilder(
				"from User where staffid=:staffid and staffPass=:staffPass");
		Query query = this.createQuery(hql.toString());
		query.setString("staffid", staffid);
		query.setString("staffPass", staffPass);
		List<User> users = query.list();
		if (users.size() > 0) {
			UserVo userVo = new UserVo();
			User user = users.get(0);
			BeanUtils.copyPropertiesNotNull(user, userVo);
			return userVo;
		}
		return null;
	}

	/**
	 * 通过deptpath、setjob查询用户信息
	 * 
	 * @param dept
	 * @param job
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserVo> searchUserByDeptAndJob(String dept, String job) {
		List<UserVo> userVoes = new ArrayList<UserVo>();
		StringBuilder hql = new StringBuilder(
				"from User where deptPath like :dept and setidJobcode=:job");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString("dept", "%" + dept + "%");
		query.setString("job", job);
		List<User> users = query.list();
		for(User user : users) {
			UserVo userVo = new UserVo();
			BeanUtils.copyPropertiesNotNull(user, userVo);
			userVoes.add(userVo);
		}
		return userVoes;
	}

}
