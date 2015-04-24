package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EARE1603 extends JacobReportAction{

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request){
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "EARE16";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A7",request.getAttribute("top"));
		return map;
	}
}
