package net.ziroom.crm.customer.dao;

import net.ziroom.crm.customer.vo.CustomerVo;

/**
 * 租客/业主数据访问接口
 * 
 * @author 孙树林
 */
public interface CustomerDao {

	/**
	 * 查找客户资料方法定义
	 * 
	 * @param custId
	 * @return
	 */
	public CustomerVo findTenant(Integer custId) throws Exception;

	/**
	 * 查找业主资料方法定义
	 * 
	 * @param custId
	 * @return
	 * @throws Exception
	 */
	public CustomerVo findProprietor(Integer custId) throws Exception;

	/**
	 * 保存租客资料方法定义
	 * 
	 * @param customerVo
	 * @throws Exception
	 */
	public Integer saveTenantCustomer(CustomerVo customerVo) throws Exception;

	/**
	 * 保存业主资料方法定义
	 * 
	 * @param customerVo
	 * @return
	 * @throws Exception
	 */
	public Integer saveProprietorCustomer(CustomerVo customerVo) throws Exception;
}
