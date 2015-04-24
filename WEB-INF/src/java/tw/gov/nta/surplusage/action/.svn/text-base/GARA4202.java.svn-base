package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

public class GARA4202 extends JacobReportAction {
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA42";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		
		map.put("B4","承接省債"+request.getAttribute("accountYear")+"年度尚後借款餘額");
		map.put("C4",request.getAttribute("accountYear")+"年"+request.getAttribute("accountMonth")+"月應償還本金");
		map.put("I4",request.getAttribute("accountFinalDate")+"應支付利息");
		map.put("J4",request.getAttribute("accountFinalDate")+"應支付本息");
		
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
