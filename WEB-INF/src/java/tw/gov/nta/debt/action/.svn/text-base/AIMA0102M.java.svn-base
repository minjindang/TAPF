package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Aima0102MForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.PaymentMain;

public class AIMA0102M extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0102MForm aima0102MForm = (Aima0102MForm) form;
		if(request.getAttribute("debtId")!=null)
			aima0102MForm.setDebtMain(new DebtManager().getBean(Integer.parseInt(request.getAttribute("debtId").toString())));
		else
			aima0102MForm.setDebtMain(new DebtManager().getBean(aima0102MForm.getDebtId()));
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
		
		List planManagerList = new PlanManager().getAllPlanListByDebtNotDelete(aima0102MForm.getDebtMain());
		Date repayDate = null;
		for(Iterator it = planManagerList.iterator();it.hasNext();){
			DebtPlanDet debtPlanDet = (DebtPlanDet)it.next();
			if(debtPlanDet.getCapitalAmount().compareTo(new BigDecimal(0)) >= 1)
			{
				repayDate = debtPlanDet.getRepayDate();
			}
		}
		List tPayMainList = new PayManager().getListByDebt(aima0102MForm.getDebtId());
		List tPaymentMainList = new ArrayList();
		for(Iterator it = tPayMainList.iterator();it.hasNext();){
			PaymentMain paymentMain = (PaymentMain)it.next();
			if(paymentMain.getCapitalAmount().compareTo(new BigDecimal(0)) >= 1)
			{
				if(repayDate.compareTo(paymentMain.getRepayDate()) >= 1)
				{
					tPaymentMainList.add(paymentMain);
				}
			}
		}
		request.setAttribute("collection", tPaymentMainList);
	}
}
