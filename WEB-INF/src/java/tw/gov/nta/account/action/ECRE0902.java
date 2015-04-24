package tw.gov.nta.account.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class ECRE0902 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "ECRE09";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		//map.put( position, value );
		AccountQueryForm myForm = (AccountQueryForm) form;
		IssueMain issue = IssueMainDAO.getInstance().get(myForm.getIssueId());
		map.put("A4",DateUtil.date2Str(issue.getIssueDate(),"yyyy/MM/dd"));							
		map.put("A2",issue.getDebtName());
        map.put("Z1","TAPF");
		return map;
	}
}