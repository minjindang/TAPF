package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Aima0104MForm;
import tw.gov.nta.sql.debt.DebtRateDet;

public class AIMA0104DAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0104MForm aima0104MForm = (Aima0104MForm) form;
		List tDebtRateList = (ArrayList)request.getSession().getAttribute("debtRateList");
		try{
			for(int i = 0 ; i < tDebtRateList.size() ; i++)
			{
				DebtRateDet tDebtRateDet = (DebtRateDet) tDebtRateList.get(i);
				if(tDebtRateDet.getSeqNo().compareTo(aima0104MForm.getSeqNo())==0){
					tDebtRateList.remove(i);
				}				
			}
			request.getSession().setAttribute("debtRateList",tDebtRateList);
			setAlertMessage(request,Messages.SUCCESS_DELETE);
		}
		catch(Exception e){
			System.out.println(e);
			setAlertMessage(request,Messages.FAILURE_DELETE);
			throw new Exception(Messages.FAILURE_DELETE);
		}
	}
}
