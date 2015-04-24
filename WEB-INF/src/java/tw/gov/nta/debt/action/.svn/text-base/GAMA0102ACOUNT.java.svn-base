package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.InterestCounter;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtRateDet;

public class GAMA0102ACOUNT extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form;
		InterestCounter myCounter = new InterestCounter();
		BigDecimal tempCount = new BigDecimal(0);
		List list = new LinkedList();
		if(null == myform.getIssueAmountDet())
		{
			myform.setIssueAmountDet(new BigDecimal(0));
		}
		if(null != myform.getAccrue())
		{
			myform.setAccrue("on");
		}	
		if(null != myform.getMyDMain().getId())
		{
			RateManager myRate = new RateManager();
			list = myRate.getEffectiveRate(myform.getMyDMain().getId());
		}
		else
		{
			DebtRateDet debtRateDet = new DebtRateDet();
			debtRateDet.setDebtRate(myform.getCompareRate());
			debtRateDet.setEffectiveDate(myform.getIssueDate());	//起始日
			debtRateDet.setSuspendDate(myform.getDueDate());		//結束日
			list.add(debtRateDet);
		}
		tempCount = myCounter.countInterest(myform.getIssueDate(),myform.getDueDate(),
				list,myform.getIssueAmountDet().doubleValue(),0);
		myform.setOriginInterestAmount(tempCount.setScale(0,5));
		myform.setTotalAmount(myform.getIssueAmountDet().add(myform.getOriginInterestAmount()).setScale(0,5));

	}

}
