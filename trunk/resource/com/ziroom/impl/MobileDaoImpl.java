package com.ziroom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.ziroom.module.mobile.dao.MobileDao;
import com.ziroom.module.mobile.vo.MobileVo;

/**
 * 实现手机返回报表的信息。
 * 
 * @author manguo
 */
public class MobileDaoImpl extends HibernateQBCQuery implements MobileDao {

	@Override
	public MobileVo report() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		MobileVo vo = new MobileVo();
		
		try{
			conn = this.getConnection();
			stmt = conn.createStatement();
			
			//查询合同数量
			String sql = "select count(id) as nu, contract_type from t_contract group by contract_type";
			rs = stmt.executeQuery(sql);
			HashMap<String, String> contracts = new HashMap<String, String>();
			
			while(rs.next()){
				String nu = rs.getString("nu");
				String type = rs.getString("contract_type");
				if(type != null && nu != null){
					contracts.put(type, nu);
				}
			}
			vo.setContracts(contracts);
			
			rs.close();
			
			sql = "select count(house_id) as nu, rent_status from t_house group by rent_status ";
			rs = stmt.executeQuery(sql);
			HashMap<String, String> house = new HashMap<String ,String>();
			while(rs.next()){
				String nu = rs.getString("nu");
				String status = rs.getString("rent_status");
				if(nu != null && status != null){
					house.put(status, nu);
				}
			}
			vo.setHouses(house);
			rs.close();
			
			sql = "select count(room_id) as nu, rent_status from t_room  where room_type <> 'KITCHEN' group by rent_status";
			rs = stmt.executeQuery(sql);
			HashMap<String, String> room = new HashMap<String, String>();
			while(rs.next()){
				String nu = rs.getString("nu");
				String status = rs.getString("rent_status");
				if(status != null && nu != null){
					room.put(status, nu);
				}
			}
			vo.setRooms(room);
			
			rs.close();
			stmt.close();
			
		}catch(Exception sqle){
			sqle.printStackTrace();
		}finally{
			try{
				stmt.close();
				conn.close();
			}catch(Exception e){
				
			}
		}
		return vo;
	}

}
