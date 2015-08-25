package com.ziroom.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.common.hibernate.Filter;
import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;
import com.ziroom.entity.Appointment;
import com.ziroom.entity.House;
import com.ziroom.entity.Room;
import com.ziroom.entity.UserAppointment;
import com.ziroom.module.customer.dao.AppointmentDao;
import com.ziroom.module.customer.vo.AppointmentVo;

/**
 * 带看单数据访问接口实现类
 * 
 * @author 孙树林
 */
public class AppointmentDaoImpl extends HibernateQBCQuery implements AppointmentDao {

	/**
	 * 待看单查询数据
	 * 
	 * @param appointmentVo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<AppointmentVo> searchAppointment(AppointmentVo appointmentVo, List<Filter> filters) throws Exception {
		List<AppointmentVo> list = new ArrayList<AppointmentVo>();
		// 查询待看单
		List<Appointment> appointments = this.criteriaOfComposite(appointmentVo, Appointment.class, filters, true);
		for (Appointment appointment : appointments) {
			AppointmentVo vo = new AppointmentVo();
			BeanUtils.copyPropertiesNotNull(appointment, vo);
			// 获得房间信息
			Room room = appointment.getRoom();
			if (room != null) {
				StringBuilder hql = new StringBuilder("from House where sysHouseId=:sysHouseId");
				Query q = this.getSession().createQuery(hql.toString());
				q.setInteger("sysHouseId", room.getSysHouseId());
				List l = q.list();
				if (l != null && l.size() > 0) {
					House house = (House) l.get(0);
					vo.setRoomCode(house.getHouseCode() + "-" + room.getRoomCode());
					vo.setStewardName(house.getStewardName());
					vo.setAgentName(house.getAgentName());
				}
				vo.setRoomName(room.getRoomName());
			}
			list.add(vo);
		}
		return list;
	}

	/**
	 * 待看单查找数据访问
	 * 
	 * @param appointmentVo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void findAppointment(AppointmentVo appointmentVo) throws Exception {
		Appointment appointment = (Appointment) this.loadEntity(Appointment.class, appointmentVo.getId());
		BeanUtils.copyPropertiesNotNull(appointment, appointmentVo);
		// 待看单用户信息
		UserAppointment userAppointment = appointment.getUserAppointment();
		BeanUtils.copyPropertiesNotNull(userAppointment, appointmentVo.getUserAppointmentVo());
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
			appointmentVo.setRentFee(room.getRentFee());
		}
	}

	/**
	 * 保存
	 * 
	 * @param appointmentVo
	 * @throws Exception
	 */
	public void saveAppointment(AppointmentVo appointmentVo) throws Exception {
		Appointment appointment = (Appointment) this.loadEntity(Appointment.class, appointmentVo.getId());
		BeanUtils.copyPropertiesNotNull(appointmentVo, appointment);
		
		// 用户信息
		UserAppointment userAppointment = appointment.getUserAppointment();
		BeanUtils.copyPropertiesNotNull(appointmentVo.getUserAppointmentVo(), userAppointment);
		this.saveEntity(appointment);
	}
}