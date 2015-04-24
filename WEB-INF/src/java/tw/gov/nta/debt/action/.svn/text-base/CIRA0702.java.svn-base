package tw.gov.nta.debt.action;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Cira0701Form;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

public class CIRA0702 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "CIRA07";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Cira0701Form myform = (Cira0701Form)form;
		map.put("A2","自"+ myform.getStartYear()+"年度至" + myform.getEndYear() + "年度");
		map.put("F5","金額單位 : 新台幣" + myform.getBaseUnitValue());
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
