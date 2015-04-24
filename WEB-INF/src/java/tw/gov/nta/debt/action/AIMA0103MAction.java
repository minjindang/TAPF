package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.debt.form.Aima0103MForm;
import tw.gov.nta.sql.debt.IssueTicketDet;

public class AIMA0103MAction extends DefaultAction {
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0103MForm aima0103MForm = (Aima0103MForm) form;
		IssueTicketDet tIssueTicketDet = aima0103MForm.getIssueTicketDet();
		tIssueTicketDet.setIssue(new IssueManager().getBean(aima0103MForm.getIssueMainId()));
		try{
			new TicketManager().confirm(tIssueTicketDet);
			setAlertMessage(request,Messages.SUCCESS_MODIFY);
		}
		catch(Exception e){
			setAlertMessage(request,Messages.FAILURE_MODIFY);
			aima0103MForm.setIssueTicketDet(new TicketManager().getBean(aima0103MForm.getIssueTicketDetId()));
			throw new Exception("§ó·s¥¢±Ñ");
			
		}
	}
}
