package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtRateDet;

public class GAMA0912 extends DefaultAction {

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
//		DebtRateDet myRate = new DebtRateDet();
//		myRate.setSuspendDate(myform.getSuspendDate());
//		myRate.setEffectiveDate(myform.getEffectiveDate());
//		myRate.setDebtRate(myform.getDebtRate());
//		myRate.setDebt(myDebt.getBean(myform.getDebtId()));
//		myRate.setDeleteMark("N");
		Map myRate = new HashMap();
		myRate.put("suspendDate",myform.getSuspendDate());
		myRate.put("effectiveDate",myform.getEffectiveDate());
		Integer days = DateUtil.getDays(myform.getEffectiveDate(),myform.getSuspendDate());
		myRate.put("days",days);
		myRate.put("debtRate",myform.getDebtRate());
//		myRate.put("debt",myDebt.getBean(myform.getDebtId()));
		myRate.put("debtId",myform.getDebtId());
		myRate.put("deleteMark","N");
		myRate.put("issueAmount",new BigDecimal(0));
		myRate.put("interestAmount",new BigDecimal(0));
		
		ratelist.add(myRate);
		if(null != ratelist)
		{
			for(int i=0;i<ratelist.size();i++)
			{
				compareDate = (Date)((Map)ratelist.get(i)).get("effectiveDate");
				for(int j=i+1;j<ratelist.size();j++)
				{	
					comparedDate = (Date)((Map)ratelist.get(j)).get("effectiveDate");
					if(compareDate.after(comparedDate))
					{
//						Map temp = new HashMap();
						temp = ((DebtRateDet)ratelist.get(i));
//						Map tempList = (Map)ratelist.get(i);
//						myRate.put("suspendDate",myform.getSuspendDate());
//						myRate.put("effectiveDate",myform.getEffectiveDate());
//						myRate.put("debtRate",myform.getDebtRate());
//						myRate.put("debt",myDebt.getBean(myform.getDebtId()));
						
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
