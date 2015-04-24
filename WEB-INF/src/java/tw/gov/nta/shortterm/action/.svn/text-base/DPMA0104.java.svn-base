//Andrew Sung
package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.ContractBankManager;
import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.DebtPlanDetVectors;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.shortterm.form.Dpma0101Form;
import tw.gov.nta.sql.debt.ContractBankMain;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.ContractBankMainDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class DPMA0104 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dpma0101Form myForm = (Dpma0101Form) form;
		PayManager payManager = new PayManager();
		for(Iterator it=myForm.getDebtPlanDets().iterator();it.hasNext();)
		{
			DebtPlanDetVectors vectors = (DebtPlanDetVectors) it.next();
			if(vectors!=null)
			{
				if( "on".equals( vectors.getRepay() ) )
				{
					int pPlanId = vectors.getId().intValue();
					int pCapitalNo = Integer.parseInt( vectors.getCapitalSerial() );
					int pInterestNo = Integer.parseInt( vectors.getInterestSerial() );
					BigDecimal pCaptialAmount = (new BigDecimal(vectors.getCapitalAmount().replaceAll(",","")));
					BigDecimal pInterestAmount = (new BigDecimal(vectors.getInterestAmount().replaceAll(",","")).setScale(0,4));
//					System.out.println(pPlanId+"===="+pCapitalNo+"===="+pInterestNo+"===="+pCaptialAmount+"===="+pInterestAmount+"===="+myForm.getRepayDate());
					payManager.repayDebt(pPlanId,pCapitalNo,pInterestNo,pCaptialAmount.doubleValue(),pInterestAmount.doubleValue(),myForm.getRepayDate());
					//更新年度簽約銀行借款額度
//					DebtPlanDet debtPlanDet = new PlanManager().getBean(pPlanId);	
//					List contractBankList = new ContractBankManager().Search(new String[]{"contractYear","bank.id"},new Object[]{debtPlanDet.getDebt().getIssue().getAccountYear(),debtPlanDet.getDebt().getBank().getId()},new String[]{"=","="},new String[]{""});
//					if(contractBankList.size() > 0 ){
//						ContractBankMain contractBankMain = (ContractBankMain) contractBankList.get(0);
//						BigDecimal borrowAmount = (contractBankMain.getBorrowAmount() != null )?contractBankMain.getBorrowAmount(): new BigDecimal(0);
//						contractBankMain.setBorrowAmount(borrowAmount.subtract(pCaptialAmount));
//						new ContractBankMainDAO().saveOrUpdate(contractBankMain);
//					}
				}
			}
		}
		setAlertMessage(request,"修改成功");
	}
}
