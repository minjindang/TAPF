/* CIMA0117.java
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

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.InterestCounter;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;

public class CIMA0117 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		// �s�W
		Cima0101Form myform = (Cima0101Form)form ;
		List caplist = (List)request.getSession().getAttribute("caplist");
		int index = caplist.size();
		PlanManager myPManager = new PlanManager();
		DebtManager myDManager = new DebtManager();
		DebtPlanDet myPlan = new DebtPlanDet();
		myPlan.setRepayDate(myform.getRepayDate());
		myPlan.setIssueId(myform.getId());
		myPlan.setDeleteMark("N");
		
		myPlan.setCapitalSerial(0);
		myPlan.setInterestSerial(0);
		
		myPlan.setCapitalAmount(myform.getCapitalAmount());
		myPlan.setDebt(myDManager.getBean(myform.getDebtId()));
		caplist.add(myPlan);	
		myform.setNowindex(index+1);
		
		Date repayDate = null;
		Date repayedDate = null;
		DebtPlanDet temp = null;
		
		for(int i=0;i<caplist.size();i++)
		{
			repayDate = ((DebtPlanDet)caplist.get(i)).getRepayDate();
			for(int j=i+1;j<caplist.size();j++)
			{	
				repayedDate = ((DebtPlanDet)caplist.get(j)).getRepayDate();
				if(repayDate.after(repayedDate))
				{
					temp = ((DebtPlanDet)caplist.get(i));
					caplist.set(i,((DebtPlanDet)caplist.get(j)));
					caplist.set(j,temp);
				}
			}	
		}	
		
		request.getSession().setAttribute("caplist",caplist);
		setAlertMessage(request,"�s�W���\");
		
		
		new InterestCounter().planListCountInterest(caplist);
		myPManager.confirm(caplist);
		
	}

}
