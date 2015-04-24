package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

public class ECRE1103 extends JacobReportAction {
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "ECRE11";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		if (null != request.getAttribute("startIssueDate") && !request.getAttribute("startIssueDate").equals(""))
			map.put("A4","中華民國"+request.getAttribute("startIssueDate"));
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}


}
