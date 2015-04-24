package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.common.AccountException;
import tw.gov.nta.account.common.AccountManager;
import tw.gov.nta.account.form.Eamb0501Form;
import tw.gov.nta.sql.debt.DebtTypeRef;

public class EAMB0502 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
	// TODO Auto-generated method stub
		Eamb0501Form myform = (Eamb0501Form)form;
		AccountManager manager = new AccountManager();
		DebtTypeRef debtType = (DebtTypeRef)request.getSession().getAttribute("debtType");
		String issueYear = myform.getIssueYear();
		int issueId = myform.getIssueId();
		try {
			manager.postToLedger(myform.getAccountYear(),myform.getAccountMonth(),debtType,this.getUserId(request),
						issueYear,issueId);
			setAlertMessage(request,"¹L±b¦¨¥\");

		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setAlertMessage(request,e.getMessage());
		}
			
	}

}
