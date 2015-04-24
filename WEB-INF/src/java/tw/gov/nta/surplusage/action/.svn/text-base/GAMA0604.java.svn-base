/**
*
* @author Andrew Sung
* @createDate 2006/7/2
*/
package tw.gov.nta.surplusage.action;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.surplusage.form.Gama0601Form;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

public class GAMA0604 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0601Form myForm = (Gama0601Form)form;
		DebtMain debtMain = (DebtMain) new DebtManager().getBeanByIssue(myForm.getIssueId()).get(0);
		DebtPlanDet debtPlanDet = (DebtPlanDet)new PlanManager().getAllPlanListByDebt(debtMain).get(0);
		myForm.setDebtId(debtMain.getId());
		myForm.setPlan(debtPlanDet);
		if(myForm.getRepayDate() == null )
			myForm.setRepayDate(new Date());
		new PayManager().confirm(myForm.getPaymentMain());
		setAlertMessage(request,Messages.SUCCESS_MODIFY);
	}

}
