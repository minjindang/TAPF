package tw.gov.nta.surplusage.action;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

public class GARA4502 extends JacobReportAction {
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA45";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String intervalDate = "";
		if (null != request.getAttribute("statrDate") && !request.getAttribute("statrDate").equals("")){
			intervalDate = (String)request.getAttribute("statrDate");
		}
		if (null != request.getAttribute("endDate") && !request.getAttribute("endDate").equals("")){
			intervalDate = intervalDate +" - "+ (String)request.getAttribute("endDate")+"¤î";
		}
		map.put("A3",intervalDate);
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
