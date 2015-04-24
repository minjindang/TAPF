package tw.gov.nta.debt.action;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cpra0301Form;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

public class CPRA0302 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "CPRA03";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Cpra0301Form myform = (Cpra0301Form)form;
		//map.put("usrId","TAPF");
		map.put("A3","­É´Ú´Á¦¸" + myform.getIssueSerial());
//		map.put("Z1",myform.getNote());
		map.put("Z1",request.getAttribute("note"));
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
