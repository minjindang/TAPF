package tw.gov.nta.shortterm.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

public class DIRA1403 extends JacobReportAction {

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request){
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "DIRA14";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A2",request.getAttribute("title"));
		map.put("C4",request.getAttribute("year1"));
		map.put("I4",request.getAttribute("year2"));
		return map;
	}

}
