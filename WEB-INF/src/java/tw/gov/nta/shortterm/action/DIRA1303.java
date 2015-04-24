package tw.gov.nta.shortterm.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

public class DIRA1303 extends JacobReportAction{

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request){
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "DIRA13";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A2",request.getAttribute("title"));
		map.put("C6",request.getAttribute("column1"));
		map.put("E6",request.getAttribute("column2"));
		map.put("G6",request.getAttribute("column3"));
		map.put("I6",request.getAttribute("column4"));
		map.put("K6",request.getAttribute("column5"));
		return map;
	}

}
