package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtRateDet;

public class GAMA0119 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form ;
		List ratelist = (List)request.getSession().getAttribute("ratelist");
		int index = ratelist.size();
		RateManager myRManager = new RateManager();
		DebtManager myDebt = new DebtManager();
		DebtRateDet myRate = new DebtRateDet();
		myRate.setSuspendDate(myform.getSuspendDate());
		myRate.setEffectiveDate(myform.getEffectiveDate());
		myRate.setDebtRate(myform.getDebtRate());
		myRate.setDebt(myDebt.getBean(myform.getDebtId()));
		myRate.setDeleteMark("N");
		ratelist.add(myRate);	
		myform.setNowindex(index+1);
		request.getSession().setAttribute("ratelist",ratelist);
		setAlertMessage(request,"新增成功");
	}

}
