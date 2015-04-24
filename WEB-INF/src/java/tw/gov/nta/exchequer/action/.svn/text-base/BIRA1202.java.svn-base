package tw.gov.nta.exchequer.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class BIRA1202 extends JacobReportAction{
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "BIRA12";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		if (request.getAttribute("debt_name")!=null)
			map.put("A2",request.getAttribute("debt_name"));

		if (null != request.getAttribute("issue_date") && !"".equals(request.getAttribute("issue_date")))
			map.put("A3", "發行日期：" + DateUtil.date2ChineseROC2((Date)request.getAttribute("issue_date")) + ",");
		if (null != request.getAttribute("cash_due_date") && !"".equals(request.getAttribute("cash_due_date")))
			map.put("B3", "到期日期：" + DateUtil.date2ChineseROC2((Date)request.getAttribute("cash_due_date")));
		if (null != request.getAttribute("due_date") && !"".equals(request.getAttribute("due_date")))
			map.put("A4", "買回日期：" + DateUtil.date2ChineseROC2((Date)request.getAttribute("due_date")) + ",");
		if (null != request.getAttribute("early_due_date") && !"".equals(request.getAttribute("early_due_date")))
			map.put("B4", "距到期日天數：" + request.getAttribute("early_due_date") + "天");
		map.put("A5", "製表日期:" + DateUtil.date2ChineseROC2(new Date()));
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}