package tw.gov.nta.debt.action;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueDetManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.MiddleDebtManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DefaultBankRef;
import tw.gov.nta.sql.debt.IssueDet;
import tw.gov.nta.system.common.BankCodeManage;

import gov.dnt.tame.common.Constants;
import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Debug;

public class CIMA0133 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
//		 TODO Auto-generated method stub
		Cima0101Form myForm = (Cima0101Form)form;
		//呼叫 Service 新增資料
		BigDecimal tempAmount = new BigDecimal(0);	//issueDet 的planAmount加總
		BigDecimal sumAmount = new BigDecimal(0);	//debtMain 的issueAmount加總
		
		IssueDetManager issueDetManager = new IssueDetManager();
		DebtManager debtManager = new DebtManager();
		String[] cols = {"issueId","budgetYear","budgetCode","debtCode"}; //issueDet用
		String[] cols2 = {"issue.id","budgetYear","budgetCode","debtCode"}; //debtMain用
		Object[] objs = {myForm.getId(),myForm.getBudgetYear(),myForm.getBudgetCode(),myForm.getDebtCode()};
		String[] pConds ={"=","=","=","="};
		String[] pOrderby = null;
		if(null != myForm.getBudgetYear() && !"".equals(myForm.getBudgetYear()) 	//必要條件需要全部都有不然不查
				&& 0 != myForm.getBudgetCodeDebt() && 0 != myForm.getDebtCodeDebt())
		{	
			List list = issueDetManager.Search(cols,objs,pConds,pOrderby);
			if(null != list && 0!=list.size())
			{
				for(Iterator it=list.iterator();it.hasNext();)
				{
					IssueDet issueDet = (IssueDet)it.next();
					if(null != issueDet.getPlanAmount())
					{
						tempAmount = tempAmount.add(issueDet.getPlanAmount());
					}	
				}	
			}	
			
			List debtList = debtManager.Search(cols2,objs,pConds,pOrderby);
			if(null != debtList && 0!= debtList.size())
			{
				for(Iterator it2 = debtList.iterator();it2.hasNext();)
				{	
					DebtMain debtMain = (DebtMain)it2.next();
					if(debtMain.getId() != myForm.getDebtId())
					{
						if(null != debtMain.getIssueAmount())
						{
							sumAmount = sumAmount.add(debtMain.getIssueAmount());
						}
					}		
				}
			}	
			
		}
		
		myForm.setPlanAmount(tempAmount.subtract(sumAmount));
	}

}
