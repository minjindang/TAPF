package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Aima0202MForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueMain;

public class AIMA0202MAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0202MForm aima0202MForm = (Aima0202MForm) form;
		DebtMain tDebtMain = aima0202MForm.getDebtMain();
		IssueMain tIssueMain = new IssueManager().getBean(aima0202MForm.getIssueMainId());
		tDebtMain.setIssue(tIssueMain);
		
		
		tDebtMain.setIssue(new IssueManager().getBean(aima0202MForm.getIssueMainId()));
		tDebtMain.setDiversityAmount(aima0202MForm.getDiversityAmount());
		tDebtMain.setIssueCostAmount(aima0202MForm.getIssueCostAmount());
		tDebtMain.setOriginInterestAmount(tDebtMain.getIssueAmount().multiply(new BigDecimal(tIssueMain.getIssueInterval())).multiply(tIssueMain.getAverageRate().divide(new BigDecimal(100))));
		BigDecimal payableInterestAmount = new BigDecimal("0");
		payableInterestAmount = tIssueMain.getPayableInterestAmount().multiply(tDebtMain.getIssueAmount().divide(tIssueMain.getIssueAmount(),10,BigDecimal.ROUND_HALF_EVEN));
		tDebtMain.setPayableInterestAmount(payableInterestAmount.setScale(0,BigDecimal.ROUND_HALF_UP));
		try{
			new DebtManager().upDate(tDebtMain);
			setAlertMessage(request,Messages.SUCCESS_MODIFY);
		}
		catch(Exception e){
			setAlertMessage(request,Messages.FAILURE_MODIFY);
			throw new Exception("·s¼W¥¢±Ñ");
		}
		
	}
}
