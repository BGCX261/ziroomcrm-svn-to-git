package net.ziroom.crm.dao.customer;

import net.ziroom.crm.customer.dao.CustomerDao;
import net.ziroom.crm.customer.vo.CustomerVo;
import net.ziroom.crm.entity.customer.Proprietor;
import net.ziroom.crm.entity.customer.Tenant;

import com.common.hibernate.dml.HibernateQBCQuery;
import com.common.util.BeanUtils;

/**
 * 租客/业主数据访问接口实现类
 * 
 * @author 孙树林
 */
public class CustomerDaoImpl extends HibernateQBCQuery implements CustomerDao {

	/**
	 * 保存租客资料方法定义
	 * 
	 * @param customerVo
	 * @throws Exception
	 */
	public Integer saveTenantCustomer(CustomerVo customerVo) throws Exception {
		Tenant tenant = new Tenant();
		BeanUtils.copyPropertiesNotNull(customerVo, tenant);
		this.saveEntity(tenant);
		return tenant.getCustId();
	}

	/**
	 * 保存业主资料方法定义
	 * 
	 * @param customerVo
	 * @return
	 * @throws Exception
	 */
	public Integer saveProprietorCustomer(CustomerVo customerVo) throws Exception {
		Proprietor proprietor = new Proprietor();
		BeanUtils.copyPropertiesNotNull(customerVo, proprietor);
		this.saveEntity(proprietor);
		return proprietor.getCustId();
	}

	/**
	 * 查找业主资料方法实现
	 * 
	 * @param custId
	 * @return
	 * @throws Exception
	 */
	public CustomerVo findProprietor(Integer custId) throws Exception {
		Proprietor proprietor = (Proprietor) this.getEntity(Proprietor.class, custId);
		CustomerVo customerVo = null;
		if (proprietor != null) {
			customerVo = new CustomerVo();
			BeanUtils.copyPropertiesNotNull(proprietor, customerVo);
		}
		return customerVo;
	}

	/**
	 * 查找客户资料方法实现
	 * 
	 * @param custId
	 * @return
	 */
	public CustomerVo findTenant(Integer custId) throws Exception {
		Tenant tenant = (Tenant) this.getEntity(Tenant.class, custId);
		CustomerVo customerVo = null;
		if (tenant != null) {
			customerVo = new CustomerVo();
			BeanUtils.copyPropertiesNotNull(tenant, customerVo);
		}
		return customerVo;
	}

}
