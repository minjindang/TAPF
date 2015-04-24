package tw.gov.nta.debt.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cira0201Form;

public class CIRA0202 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "CIRA02";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Cira0201Form myform = (Cira0201Form)form;
		map.put("Z2",myform.getIssueSerial().substring(0,3) + myform.getIssueSerial().substring(4)+"期中長期借款比價概況表");
		map.put("Z3",myform.getBaseUnitLabel());
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}
