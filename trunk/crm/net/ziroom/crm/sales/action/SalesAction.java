package net.ziroom.crm.sales.action;

import java.util.HashMap;
import java.util.Map;

import net.ziroom.common.action.ZiroomAction;
import net.ziroom.crm.sales.service.SalesService;
import net.ziroom.crm.sales.vo.SalesVo;

import com.common.fusioncharts.FusionChartsUtils;

/**
 * 销售机会业务请求处理类
 * 
 * @author 孙树林
 */
public class SalesAction extends ZiroomAction {

	private static final long serialVersionUID = -1194945533703175082L;

	private SalesVo salesVo = new SalesVo();

	private SalesService salesService;

	/**
	 * 查询销售机会
	 * 
	 * @return
	 * @throws Exception
	 */
	public String searchSales() throws Exception {
		salesService.searchSales(salesVo);
		return SUCCESS;
	}

	/**
	 * 销售机会编辑页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String forwardSalesPage() throws Exception {
		return SUCCESS;
	}

	/**
	 * 机会跟踪编辑页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String followSalesPage() throws Exception {
		salesService.followSalesPage(salesVo);
		return SUCCESS;
	}

	/**
	 * 销售机会保存
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveSales() throws Exception {
		String type = salesVo.getType();
		if (type.equals("00004")) {
			salesService.addTenantSales(salesVo);
		} else {
			salesService.addProprietorSales(salesVo);
		}
		return SUCCESS;
	}

	/**
	 * 销售机会跟踪
	 * 
	 * @return
	 * @throws Exception
	 */
	public String followSales() throws Exception {
		String type = salesVo.getType();
		if (type.equals("00004")) {
			salesService.editTenantSales(salesVo);
		} else {
			salesService.editProprietorSales(salesVo);
		}
		return SUCCESS;
	}

	/**
	 * 销售机会跟踪历史
	 * 
	 * @return
	 * @throws Exception
	 */
	public String salesHistory() throws Exception {
		salesService.salesHistory(salesVo);
		return SUCCESS;
	}

	/**
	 * 销售漏斗统计
	 * 
	 * @return
	 * @throws Exception
	 */
	public String totalSalesFunnel() throws Exception {
		Map<String, String> dataes = salesService.totalSalesFunnel(salesVo);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("baseFontSize", "11");
		headers.put("isSliced", "0");
		headers.put("decimals", "0");
		//headers.put("showPercentValues", "1");
		headers.put("isHollow", "0");
		headers.put("streamlinedData", "0");
		salesVo.setXml(FusionChartsUtils.createFusionChartsXml(headers, dataes));
		return SUCCESS;
	}

	public SalesVo getSalesVo() {
		return salesVo;
	}

	public void setSalesVo(SalesVo salesVo) {
		this.salesVo = salesVo;
	}

	public void setSalesService(SalesService salesService) {
		this.salesService = salesService;
	}

}
