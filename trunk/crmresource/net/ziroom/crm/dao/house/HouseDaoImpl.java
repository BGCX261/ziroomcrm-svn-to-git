package net.ziroom.crm.dao.house;

import net.ziroom.crm.entity.component.HouseComponent;
import net.ziroom.crm.entity.customer.Proprietor;
import net.ziroom.crm.entity.house.House;
import net.ziroom.crm.house.dao.HouseDao;
import net.ziroom.crm.house.vo.HouseVo;

import org.hibernate.Query;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;

/**
 * 房屋数据房屋接口实现类
 * 
 * @author 孙树林
 */
public class HouseDaoImpl extends HibernateQBCQuery implements HouseDao {

	/**
	 * 根据房屋小区，楼盘，单元，门牌号查询房源
	 * 
	 * @param houseVo
	 * @return
	 * @throws Exception
	 */
	public HouseVo findHouseByInfo(HouseVo houseVo) throws Exception {
		HouseVo vo = new HouseVo();
		StringBuilder hql = new StringBuilder("from House where houseComponent.floorNo=:floorNo");
		hql
				.append(" and houseComponent.unit=:unit and houseComponent.floor=:floor and houseComponent.apartment=:apartment");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString("floorNo", houseVo.getFloorNo());
		query.setString("unit", houseVo.getUnit());
		query.setString("floor", houseVo.getFloor());
		query.setString("apartment", houseVo.getApartment());
		Object obj = query.uniqueResult();
		if (obj != null) {
			BeanUtils.copyPropertiesNotNull(obj, vo);
		}
		return vo;
	}

	/**
	 * 保存房屋信息方法定义
	 * 
	 * @param houseVo
	 * @return
	 * @throws Exception
	 */
	public Integer saveHouse(HouseVo houseVo) throws Exception {
		// 业主资料
		Proprietor proprietor = (Proprietor) this.getEntity(Proprietor.class, houseVo.getCustId());
		// 房屋资料
		House house = new House();
		HouseComponent houseComponent = new HouseComponent();
		BeanUtils.copyPropertiesNotNull(houseVo, house);
		BeanUtils.copyPropertiesNotNull(houseVo, houseComponent);
		house.setHouseComponent(houseComponent);
		house.setProprietor(proprietor);
		
		this.saveEntity(house);
		return house.getHouseId();
	}
}
