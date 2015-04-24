package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.InterestAdjustManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.InterestAdjustMain;

public class CIMA0119 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form ;
		List ratelist = (List)request.getSession().getAttribute("ratelist");
		DebtRateDet temp = new DebtRateDet();
		Date compareDate = new Date();
		Date comparedDate = new Date();
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
		
		if(null != ratelist)
		{
			for(int i=0;i<ratelist.size();i++)
			{
				compareDate = ((DebtRateDet)ratelist.get(i)).getEffectiveDate();
				for(int j=i+1;j<ratelist.size();j++)
				{	
					comparedDate = ((DebtRateDet)ratelist.get(j)).getEffectiveDate();
					if(compareDate.after(comparedDate))
					{
						temp = ((DebtRateDet)ratelist.get(i));
						ratelist.set(i,((DebtRateDet)ratelist.get(j)));
						ratelist.set(j,temp);
					}
				}	
			}	
		}	

		myform.setNowindex(index+1);
		request.getSession().setAttribute("EffectiveDate",myform.getEffectiveDate());
		request.getSession().setAttribute("NewRate",myform.getDebtRate());
		request.getSession().setAttribute("ratelist",ratelist);
		request.getSession().setAttribute("isDelete",true);
		setAlertMessage(request,"新增成功");
	}

}
