package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.debt.form.Aima0103MForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueTicketDet;

public class AIMA0103A extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0103MForm aima0103MForm = (Aima0103MForm) form;
		aima0103MForm.setIssueMain(new IssueManager().getBean(aima0103MForm.getIssueMainId()));
		aima0103MForm.setIssueTicketDet(new IssueTicketDet());
		List tIssueTicketList = new TicketManager().getBeanByIssue(aima0103MForm.getIssueMainId());
		
		BigDecimal totalIssueAmount = new BigDecimal(0);
		for(Iterator it = tIssueTicketList.iterator();it.hasNext();){
			IssueTicketDet det = (IssueTicketDet)it.next();
			totalIssueAmount = totalIssueAmount.add(det.getTicketAmount().multiply(new BigDecimal(det.getTicketCount())));
		}
		request.setAttribute("totalIssueAmount",totalIssueAmount);
	}
}
