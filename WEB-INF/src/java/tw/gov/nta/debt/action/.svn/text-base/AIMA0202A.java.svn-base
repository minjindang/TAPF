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
import tw.gov.nta.debt.form.Aima0202MForm;
import tw.gov.nta.sql.debt.DebtMain;

public class AIMA0202A extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0202MForm aima0202MForm = (Aima0202MForm) form;
		aima0202MForm.setDebtMain(new DebtMain());
		aima0202MForm.setIssueMain(new IssueManager().getBean(aima0202MForm.getIssueMainId()));
		List tDebtMainList = new DebtManager().getBeanByIssue(aima0202MForm.getIssueMainId());
		BigDecimal totalIssueAmount = new BigDecimal(0);
		BigDecimal totalRealAmount = new BigDecimal(0);
		for(Iterator it = tDebtMainList.iterator();it.hasNext();){
			DebtMain debt = (DebtMain)it.next();
			totalIssueAmount = totalIssueAmount.add(debt.getIssueAmount());
			totalRealAmount = totalRealAmount.add((debt.getRealAmount()!= null)?debt.getRealAmount():new BigDecimal(0));
		}
		request.setAttribute("totalIssueAmount",totalIssueAmount);
		request.setAttribute("totalRealAmount",totalRealAmount);
		request.setAttribute("issueRealAmount",aima0202MForm.getIssueMain().getRealAmount());
	}
}
