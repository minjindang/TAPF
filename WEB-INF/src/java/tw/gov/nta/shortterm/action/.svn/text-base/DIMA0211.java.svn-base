/**
 * @author AndrewSung
 * @date 2006/3/7
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.ContractBankManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.ShortDebtManager;
import tw.gov.nta.shortterm.form.Dima0202Form;
import tw.gov.nta.sql.debt.ContractBankMain;
import tw.gov.nta.sql.debt.dao.ContractBankMainDAO;
public class DIMA0211 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dima0202Form myForm = (Dima0202Form)form;
		IssueManager issueManager = new IssueManager();
		myForm.setIssue(issueManager.getBean(myForm.getKindId()));
		ShortDebtManager shortDebtManager = new ShortDebtManager();
		shortDebtManager.cancel(myForm.getId());
		
//		List contractBankList = new ContractBankManager().Search(new String[]{"contractYear","bank.id"},new Object[]{myForm.getIssue().getAccountYear(),myForm.getBank().getId()},new String[]{"=","="},new String[]{""});
//		ContractBankMain contractBankMain = (ContractBankMain) contractBankList.get(0);
//		contractBankMain.setBorrowAmount(contractBankMain.getBorrowAmount().subtract(myForm.getIssueAmount()));
//		new ContractBankMainDAO().saveOrUpdate(contractBankMain);	
		
		setAlertMessage(request,"§R°£¦¨¥\");
	}

}
