package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.ziroom.module.system.dao.DeptDao;
import com.ziroom.module.system.vo.DeptVo;

/**
 * 组织机构数据访问接口实现类
 * 
 * @author 孙树林
 */
public class DeptDaoImpl extends HibernateQBCQuery implements DeptDao {

	/**
	 * 根据组织机构编码查询机构
	 * 
	 * @param deptCode
	 * @param deptLevel
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DeptVo> searchDeptByDeptCode(String deptCode, String deptLevel)
			throws Exception {
		List<DeptVo> deptVoes = new ArrayList<DeptVo>();
		StringBuilder stringBuilder = new StringBuilder(
				"select distinct dept_code as deptCode,depart_name as departName from t_user where dept_path like :deptCode and dept_level=:deptLevel");
		Query query = this.getSession()
				.createSQLQuery(stringBuilder.toString()).addScalar("deptCode", Hibernate.STRING).addScalar("departName", Hibernate.STRING);
		query.setString("deptCode", "%" + deptCode + "%");
		query.setString("deptLevel", deptLevel);
		List<Object[]> oes = query.list();
		for (Object[] o : oes) {
			DeptVo deptVo = new DeptVo();
			deptVo.setDepartName(String.valueOf(o[1]));
			deptVo.setDeptCode(String.valueOf(o[0]));
			deptVoes.add(deptVo);
		}
		return deptVoes;
	}
}
