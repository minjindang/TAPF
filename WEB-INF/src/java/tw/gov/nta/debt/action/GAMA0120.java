package tw.gov.nta.debt.action;

import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.sql.debt.DebtRateDet;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

public class GAMA0120 extends DefaultAction {

	public GAMA0120() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		RateManager myRate = new RateManager();
		List ratelist = (List)request.getSession().getAttribute("ratelist");
		Date tempDate = ((DebtRateDet)(ratelist.get(0))).getEffectiveDate();
		tempDate = DateUtil.computeDueDate(tempDate,-1);
		boolean isOkDate = true;
		if(null != ratelist && 0 != ratelist.size())
		{	
			for(Iterator it = ratelist.iterator();it.hasNext();)
			{
				DebtRateDet myDebtRate = (DebtRateDet)it.next();
				
				if(0 != DateUtil.getDays(myDebtRate.getEffectiveDate(),(DateUtil.computeDueDate(tempDate,1))))
				{
					isOkDate = false;
					break;
				}	
				tempDate = myDebtRate.getSuspendDate();
			}
			
			if(isOkDate)
			{
				myRate.confirm(ratelist);
				request.getSession().removeAttribute("ratelist");
				setAlertMessage(request,"確認完成");
			}
			else
			{
				setAlertMessage(request,"日期不正確");	
			}
			
		}	
		//request.getSession().removeAttribute("rRateList");
	}

}
