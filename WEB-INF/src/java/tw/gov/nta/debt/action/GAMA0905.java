package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.MiddleDebtManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueMain;

public class GAMA0905 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		try
		{
				Cima0101Form myForm = (Cima0101Form)form;
				//Cima0101Form myForm = (Cima0101Form) request.getSession().getAttribute("Cima0101Form");
				myForm.setUserid((String) request.getSession().getAttribute("ACCOUNT"));
				myForm.setModDate(new Date());
				IssueManager myIssue = new IssueManager();
				DebtManager debtManager = new DebtManager();
				MiddleDebtManager middleManager = new MiddleDebtManager();
				RateManager rateManager = new RateManager();
				PlanManager planManager = new PlanManager();
				PayManager payManager = new PayManager();
				//呼叫 Service 更新
				myForm.getMyIss().setDebtType("F");
				if("on".equals(myForm.getMyIss().getBondType()))
				{
					myForm.getMyIss().setBondType("1");	//true
				}
				else
				{
					myForm.getMyIss().setBondType("2");	//false
				}
				IssueMain issueMian = myIssue.getBean(myForm.getId());
				issueMian.setDueDate(myForm.getDueDate());
				myIssue.confirm(issueMian);
				setAlertMessage(request,"更新成功");
				if((!myForm.getOldIssueDate().equals(myForm.getIssueDate())) || (!myForm.getOldDueDate().equals(myForm.getDueDate()) ))
				{
					List debtList = debtManager.getBeanByIssue(myForm.getMyIss().getId());
					if(null != debtList && 0 != debtList.size())
					{
						for(Iterator debt=debtList.iterator();debt.hasNext();)
						{	
							DebtMain debtMain = (DebtMain)debt.next();
							List rateList = rateManager.getEffectiveRate(debtMain.getId());
							int groupId = rateManager.getEffectRateGroupId(debtMain.getId().intValue());
							if(null != rateList && 0 !=rateList.size())
							{
								DebtRateDet newRateDet = new DebtRateDet();
								newRateDet.setDebt(debtMain);
								newRateDet.setDeleteMark("N");
								newRateDet.setDebtRate(debtMain.getCompareRate());
								newRateDet.setEffectiveDate(myForm.getMyIss().getIssueDate());
								newRateDet.setSuspendDate(myForm.getDueDate());
								rateManager.confirm(newRateDet);
								rateManager.setDeleteRemark(debtMain.getId(),groupId);
							}
							
							List planList = planManager.byDebtId(debtMain.getId());
							List paymentList = payManager.getListByDebt(debtMain.getId());
							if(null == paymentList || 0 == paymentList.size())
							{	
								if(null != planList && 0 != planList.size())
								{
									planManager.setDeleteRemark(planList);
									middleManager.confirm(debtMain);
								}
							}	
						}	
					}

				}	
		}
		catch(Exception e)
		{
			setAlertMessage(request,"更新失敗");
		}
	}

}
