/* CIMA0105.java
 �{���ت��GCIMA01
 �{���N���GCIMA01
 �{������G0950307
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.MiddleDebtManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;

public class CIMA0105 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		try
		{
				Cima0101Form myForm = (Cima0101Form)form;
				//Cima0101Form myForm = (Cima0101Form) request.getSession().getAttribute("Cima0101Form");
		//		myForm.setUserid((String) request.getSession().getAttribute("ACCOUNT"));
		//		myForm.setModDate(new Date());
				IssueManager myIssue = new IssueManager();
				DebtManager debtManager = new DebtManager();
				MiddleDebtManager middleManager = new MiddleDebtManager();
				RateManager rateManager = new RateManager();
				PlanManager planManager = new PlanManager();
				PayManager payManager = new PayManager();
				//�I�s Service ��s
				myForm.getMyIss().setDebtType("C");
				if("on".equals(myForm.getMyIss().getBondType()))
				{
					myForm.getMyIss().setBondType("1");	//true
				}
				else
				{
					myForm.getMyIss().setBondType("2");	//false
				}
				myForm.getMyIss().setBudgetCode(0);
				myForm.getMyIss().setDebtCode(0);
				myIssue.confirm(myForm.getMyIss());
				setAlertMessage(request,"��s���\");
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
			setAlertMessage(request,"��s����");
		}
	}

}
