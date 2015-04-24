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
import tw.gov.nta.debt.form.Aima0202MForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.PaymentMain;

public class AIMA0202M extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0202MForm aima0202MForm = (Aima0202MForm) form;
		if(request.getAttribute("debtId")!=null)
			aima0202MForm.setDebtMain(new DebtManager().getBean(Integer.parseInt(request.getAttribute("debtId").toString())));
		else
			aima0202MForm.setDebtMain(new DebtManager().getBean(aima0202MForm.getDebtId()));
		
		List tDebtMainList = new DebtManager().getBeanByIssue(aima0202MForm.getIssueMainId());
		
		BigDecimal totalIssueAmount = new BigDecimal(0);
		BigDecimal totalRealAmount = new BigDecimal(0);
		BigDecimal diversityAmount = new BigDecimal(0);
		BigDecimal issueRealAmount = new BigDecimal(0);
		for(Iterator it = tDebtMainList.iterator();it.hasNext();){
			DebtMain debt = (DebtMain)it.next();
			totalIssueAmount = totalIssueAmount.add(debt.getIssueAmount());
			issueRealAmount = debt.getIssue().getRealAmount();
			totalRealAmount = totalRealAmount.add((debt.getRealAmount()!= null)?debt.getRealAmount():new BigDecimal(0));
			diversityAmount = aima0202MForm.getDiversityAmount();
		}
		request.setAttribute("diversityAmount",diversityAmount);
		request.setAttribute("totalIssueAmount",totalIssueAmount);
		request.setAttribute("issueRealAmount",issueRealAmount);
		request.setAttribute("totalRealAmount",totalRealAmount);

		List planManagerList = new PlanManager().getAllPlanListByDebtNotDelete(aima0202MForm.getDebtMain());
		Date repayDate = null;
		for(Iterator it = planManagerList.iterator();it.hasNext();){
			DebtPlanDet debtPlanDet = (DebtPlanDet)it.next();
			if(debtPlanDet.getCapitalAmount().compareTo(new BigDecimal(0)) >= 1)
			{
				repayDate = debtPlanDet.getRepayDate();
			}
		}
		List tPayMainList = new PayManager().getListByDebt(aima0202MForm.getDebtId());
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
