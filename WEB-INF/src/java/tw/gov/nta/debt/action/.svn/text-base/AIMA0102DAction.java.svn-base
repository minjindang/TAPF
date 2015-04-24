package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.form.Aima0102MForm;
import tw.gov.nta.sql.debt.DebtMain;

public class AIMA0102DAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0102MForm aima0102MForm = (Aima0102MForm) form;
		DebtMain tDebtMain = aima0102MForm.getDebtMain();
		try{
			new DebtManager().cancel(tDebtMain.getId());
			setAlertMessage(request,Messages.SUCCESS_DELETE);
		}catch(Exception e){
			System.out.println(e);
			setAlertMessage(request,Messages.FAILURE_DELETE);
		}
		
	}
}
