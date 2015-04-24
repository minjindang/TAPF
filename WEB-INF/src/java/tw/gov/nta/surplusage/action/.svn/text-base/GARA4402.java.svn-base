package tw.gov.nta.surplusage.action;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

public class GARA4402 extends JacobReportAction {
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA44";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		if (null != request.getAttribute("accountYear") && !request.getAttribute("accountYear").equals("")){
			map.put("I3",request.getAttribute("accountYear")+"¦~«×");
		}
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
