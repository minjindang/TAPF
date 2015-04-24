package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Cpra0501Form;
import tw.gov.nta.sql.debt.IssueMain;

public class CPRA0502 extends JacobReportAction {

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "CPRA05";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Cpra0501Form myform = (Cpra0501Form) form;
		DateUtil dateUtil = new DateUtil();
		Map<String,Object> map = new HashMap<String,Object>();
		IssueMain issueMain = new IssueManager().getBean(myform.getId());
		map.put("A1", issueMain.getDebtName()+"【"+issueMain.getIssueAmount().divide(new BigDecimal(100000000)).setScale(0,BigDecimal.ROUND_HALF_UP)+"億元】借款還本付息明細表");
		map.put("A2", "自"+dateUtil.date2ChineseROC2(issueMain.getIssueDate()) +"至"+ dateUtil.date2ChineseROC2(issueMain.getDueDate())+"止");
		map.put("Z4", new DateUtil().date2Str(new Date(), "yyyy/MM/dd"));
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}