/* CIMA0117.java
 程式目的：CIMA01
 程式代號：CIMA01
 程式日期：0950307
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
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
		// 新增
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
		setAlertMessage(request,"新增成功");
		
		
		new InterestCounter().planListCountInterest(caplist);
		myPManager.confirm(caplist);
		
	}

}
