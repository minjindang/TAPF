/**
 * @author AndrewSung
 * @date 2006/3/7
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.common.ContractBankManager;
import tw.gov.nta.debt.common.DebtMainVectors;
import tw.gov.nta.debt.common.ShortDebtManager;
import tw.gov.nta.shortterm.form.Dima0201Form;
import tw.gov.nta.sql.debt.ContractBankMain;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.dao.ContractBankMainDAO;
public class DIMA0215 extends DefaultAction
{
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception{
		Dima0201Form myForm = (Dima0201Form) form;
	    ShortDebtManager shortDebtManager = new ShortDebtManager();
	    LinkedList list = new LinkedList();
	    //先將畫面上list多筆資料設成完整的debtMain
		for(Iterator it=myForm.getDebtMains().iterator();it.hasNext();)
		{
			DebtMainVectors debtMainVectors = (DebtMainVectors) it.next();
			if(debtMainVectors!=null)
			{
				DebtMain debtMain = shortDebtManager.getBean(debtMainVectors.getId());
				if(debtMainVectors.getAccrue() == null)
					debtMain.setAccrue("N");
				else 
					debtMain.setAccrue("Y");
				if(debtMainVectors.getIssueAmount() == null){
					debtMain.setIssueAmount(new BigDecimal (0));
					debtMain.setOriginInterestAmount(new BigDecimal(0));
				}
				else{
					debtMain.setIssueAmount(new BigDecimal(debtMainVectors.getIssueAmount().replaceAll(",","")));
					debtMain.setOriginInterestAmount(new BigDecimal(debtMainVectors.getOriginInterestAmount().replaceAll(",","")));
				}
				list.add(debtMain);
				//shortDebtManager.confirm(debtMain);
			}
		}
		//檢查額度是否通過
//		for(Iterator it = list.iterator();it.hasNext();){
//			DebtMain dto = (DebtMain)it.next();
//			if(dto.getAccrue().equals("Y")){
//				if (! new ContractBankManager().checkBean(dto)){
//					setAlertMessage(request,"確認得標失敗，借款額度不符");
//					return mapping.findForward("fail");
//				}
//			}
//		}
		// 若檢查通過則更新
		for(Iterator it = list.iterator();it.hasNext();){
			DebtMain dto = (DebtMain)it.next();
//			if(dto.getAccrue().equals("Y")){
//				List contractBankList = new ContractBankManager().Search(new String[]{"contractYear","bank.id"},new Object[]{dto.getIssue().getAccountYear(),dto.getBank().getId()},new String[]{"=","="},new String[]{""});
//				ContractBankMain contractBankMain = (ContractBankMain) contractBankList.get(0);
//				contractBankMain.setBorrowAmount(contractBankMain.getBorrowAmount().add(dto.getIssueAmount()));
//				new ContractBankMainDAO().saveOrUpdate(contractBankMain);
//			}
			shortDebtManager.confirm(dto);
		}
		setAlertMessage(request,"確認得標成功");
		return mapping.findForward("success");
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		
	}
}
