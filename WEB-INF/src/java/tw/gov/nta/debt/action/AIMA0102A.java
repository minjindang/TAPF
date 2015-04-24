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
import tw.gov.nta.debt.form.Aima0102MForm;
import tw.gov.nta.sql.debt.DebtMain;

public class AIMA0102A extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0102MForm aima0102MForm = (Aima0102MForm) form;
		aima0102MForm.setDebtMain(new DebtMain());
		aima0102MForm.setIssueMain(new IssueManager().getBean(aima0102MForm.getIssueMainId()));
		List tDebtMainList = new DebtManager().getBeanByIssue(aima0102MForm.getIssueMainId());
		BigDecimal totalIssueAmount = new BigDecimal(0);
		BigDecimal totalRealAmount = new BigDecimal(0);
		for(Iterator it = tDebtMainList.iterator();it.hasNext();){
			DebtMain debt = (DebtMain)it.next();
			totalIssueAmount = totalIssueAmount.add(debt.getIssueAmount());
			totalRealAmount = totalRealAmount.add((debt.getRealAmount()!= null)?debt.getRealAmount():new BigDecimal(0));
		}
		request.setAttribute("totalIssueAmount",totalIssueAmount);
		request.setAttribute("totalRealAmount",totalRealAmount);
		request.setAttribute("issueRealAmount",aima0102MForm.getIssueMain().getRealAmount());
	}
}
