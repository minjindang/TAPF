package tw.gov.nta.debt.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Cpra0201Form;

public class CPRA0202 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "CPRA02";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Cpra0201Form myform = (Cpra0201Form)form;
		//map.put("usrId","TAPF");
		map.put("A3",myform.getBankName() + " 第 "+ new IssueManager().getBean(myform.getIssueId()).getIssueSerial()+ " 期中長期借款");
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}
