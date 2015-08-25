package com.ziroom.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import com.common.hibernate.Filter;
import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Appointment;
import com.ziroom.entity.House;
import com.ziroom.entity.Room;
import com.ziroom.entity.UserAppointment;
import com.ziroom.module.customer.dao.UserAppointmentDao;
import com.ziroom.module.customer.vo.AppointmentVo;
import com.ziroom.module.customer.vo.UserAppointmentVo;

/**
 * 
 * 客户数据访问接口实现类
 * 
 * @author 孙树林
 */
public class UserAppointmentDaoImpl extends HibernateQBCQuery implements UserAppointmentDao {

	/**
	 * 查询用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<UserAppointmentVo> searchUserAppointment(UserAppointmentVo userAppointmentVo, List<Filter> filters, String staffid)
			throws Exception {
		List<UserAppointmentVo> userAppointmentVoes = new ArrayList<UserAppointmentVo>();
		// 查询客户
		List<UserAppointment> userAppointments = this.criteriaOfSimple(userAppointmentVo, UserAppointment.class,
				filters, false);
		for (UserAppointment userAppointment : userAppointments) {
			UserAppointmentVo vo = new UserAppointmentVo();
			BeanUtils.copyPropertiesNotNull(userAppointment, vo);
			// 获得该用户的待看单
			if(staffid != null && !staffid.equals("")) {				
				this.getSession().enableFilter("appointentSecond").setParameter("staffid", staffid);
			}
			Iterator<Appointment> appointments = userAppointment.getAppointments().iterator();
			while (appointments.hasNext()) {
				// 待看单资料
				Appointment appointment = appointments.next();
				AppointmentVo appointmentVo = new AppointmentVo();
				BeanUtils.copyPropertiesNotNull(appointment, appointmentVo);
				
				// 获得房间信息
				Room room = appointment.getRoom();
				if (room != null) {
					StringBuilder hql = new StringBuilder("from House where sysHouseId=:sysHouseId");
					Query q = this.getSession().createQuery(hql.toString());
					q.setInteger("sysHouseId", room.getSysHouseId());
					List l = q.list();
					if (l != null && l.size() > 0) {
						House house = (House) l.get(0);
						appointmentVo.setRoomCode(house.getHouseCode() + "-" + room.getRoomCode());
						appointmentVo.setStewardName(house.getStewardName());
						appointmentVo.setAgentName(house.getAgentName());
					}
					appointmentVo.setRoomName(room.getRoomName());
				}
				vo.setLookCount(userAppointment.getAppointments().size());
				vo.getAppointmentVoes().add(appointmentVo);
			}
			userAppointmentVoes.add(vo);
		}
		return userAppointmentVoes;
	}

	/**
	 * 查找用户
	 * 
	 * @param userAppointmentVo
	 * @throws Exception
	 */
	public void findUserAppointment(UserAppointmentVo userAppointmentVo) throws Exception {
		UserAppointment userAppointment = (UserAppointment) this.loadEntity(UserAppointment.class, userAppointmentVo
				.getUserId());
		BeanUtils.copyPropertiesNotNull(userAppointment, userAppointmentVo);
	}

	/**
	 * 保存用户
	 * 
	 * @param userAppointmentVo
	 * @throws Exception
	 */
	public void saveUserAppointment(UserAppointmentVo userAppointmentVo) throws Exception {
		UserAppointment userAppointment = (UserAppointment) this.loadEntity(UserAppointment.class, userAppointmentVo
				.getUserId());
		BeanUtils.copyPropertiesNotNull(userAppointmentVo, userAppointment);
		this.updateEntity(userAppointment);
	}
}
