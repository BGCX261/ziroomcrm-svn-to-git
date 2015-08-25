package net.ziroom.crm.house.dao;

import net.ziroom.crm.house.vo.HouseVo;

/**
 * 房屋数据房屋接口
 * 
 * @author 孙树林
 */
public interface HouseDao {

	/**
	 * 根据房屋小区，楼盘，单元，门牌号查询房源
	 * 
	 * @param houseVo
	 * @return
	 * @throws Exception
	 */
	public HouseVo findHouseByInfo(HouseVo houseVo) throws Exception;
	
	/**
	 * 保存房屋信息方法定义
	 * 
	 * @param houseVo
	 * @return
	 * @throws Exception
	 */
	public Integer saveHouse(HouseVo houseVo) throws Exception;
}
