package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.debt.form.Aima0203MForm;
import tw.gov.nta.sql.debt.IssueTicketDet;

public class AIMA0203A extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0203MForm aima0203MForm = (Aima0203MForm) form;
		aima0203MForm.setIssueMain(new IssueManager().getBean(aima0203MForm.getIssueMainId()));
		aima0203MForm.setIssueTicketDet(new IssueTicketDet());
		List tIssueTicketList = new TicketManager().getBeanByIssue(aima0203MForm.getIssueMainId());
		
		BigDecimal totalIssueAmount = new BigDecimal(0);
		for(Iterator it = tIssueTicketList.iterator();it.hasNext();){
			IssueTicketDet det = (IssueTicketDet)it.next();
			totalIssueAmount = totalIssueAmount.add(det.getTicketAmount().multiply(new BigDecimal(det.getTicketCount())));
		}
		request.setAttribute("totalIssueAmount",totalIssueAmount);
	}
}
