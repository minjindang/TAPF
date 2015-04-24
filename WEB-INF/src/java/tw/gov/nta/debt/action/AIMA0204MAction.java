package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Aima0204MForm;
import tw.gov.nta.sql.debt.DebtRateDet;

public class AIMA0204MAction extends DefaultAction {

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0204MForm aima0204MForm = (Aima0204MForm) form;
		List tDebtRateList = (ArrayList) request.getSession().getAttribute("debtRateList");
		try{
			for(int i = 0 ; i < tDebtRateList.size() ; i++){
				DebtRateDet tDebtRateDet = (DebtRateDet) tDebtRateList.get(i);
				if(tDebtRateDet.getSeqNo().compareTo(aima0204MForm.getSeqNo()) == 0)
					tDebtRateList.set(i, aima0204MForm.getDebtRateDet());
			}
			System.out.println("³]©w2" + aima0204MForm.getDebtRateDet() + "±b¸¹:" + aima0204MForm.getDebtRateDet().getGroupId());
			request.getSession().setAttribute("debtRateList",tDebtRateList);
			setAlertMessage(request,Messages.SUCCESS_MODIFY);
		}
		catch(Exception e){
			System.out.println(e);
			setAlertMessage(request,Messages.FAILURE_MODIFY);
			throw new Exception(Messages.FAILURE_MODIFY);
		}
	}
}
