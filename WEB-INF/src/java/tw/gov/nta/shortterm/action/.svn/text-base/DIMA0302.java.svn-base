package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.shortterm.form.Dima0301Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;

public class DIMA0302 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO 自動產生方法 Stub
		Dima0301Form dima0301Form = (Dima0301Form) form;
		IssueManager issueManager = new IssueManager();
		IssueMain issueMain = issueManager.getBean(dima0301Form.getId());
		dima0301Form.setIssueMain( issueMain );
		//計算已償金額
		PayManager payManager = new PayManager();
		List payList = payManager.getDataByIssue(issueMain.getId());
		BigDecimal capitalAmount = new BigDecimal(0);
		for (Iterator itPay = payList.iterator();itPay.hasNext();) {
			PaymentMain paymentMain = (PaymentMain)itPay.next();
			capitalAmount = capitalAmount.add(paymentMain.getCapitalAmount());
		}		
		
		DebtManager debtManager = new DebtManager();
		List collection = (List) debtManager.getBeanByIssue(dima0301Form.getId());
		for(Iterator it =collection.iterator();it.hasNext();)
		{	
			DebtMain debtMain = (DebtMain) it.next();
			//if(null == debtMain.getGet() || "".equals(debtMain.getGet()) || " ".equals(debtMain.getGet()))
			//{
			//	debtMain.setGet("N");
			//}	
		}	
		dima0301Form.setDebtMains( collection );
		dima0301Form.setCapitalAmount(capitalAmount);
	}
}