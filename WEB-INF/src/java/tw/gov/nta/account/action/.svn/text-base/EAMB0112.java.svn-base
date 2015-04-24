package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

public class EAMB0112 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
	// TODO Auto-generated method stub
		String makeDate = request.getParameter("date(voucherDate)");
		request.setAttribute("date(voucherDate)",makeDate.trim());
		String remark = request.getParameter("remark");
		request.setAttribute("remark",remark);
		String account = request.getParameter("account");
		request.setAttribute("account",account);
		String phaseId = request.getParameter("phaseId");
		request.setAttribute("phaseId",phaseId);
		String issueKind = request.getParameter("issueKind");
		request.setAttribute("issueKind",issueKind);
	}

}
