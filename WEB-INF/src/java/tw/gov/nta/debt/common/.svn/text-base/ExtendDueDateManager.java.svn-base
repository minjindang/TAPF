/**
*
* @author Andrew Sung
* @createDate 2006/10/4
*/
package tw.gov.nta.debt.common;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.ExtendDueDateMain;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.DebtRateDetDAO;
import tw.gov.nta.sql.debt.dao.ExtendDueDateMainDAO;

public class ExtendDueDateManager {
	public void ExtendDueDateToRate(int tIssueId , Date tNewDueDate,String usrId) throws Exception{
		IssueMain pIssueMain = new IssueManager().getBean(tIssueId);
		List pDebtList = new DebtManager().getBeanByIssue(pIssueMain.getId());
		for(Iterator it = pDebtList.iterator();it.hasNext();){
			DebtMain pDebtMainDto = (DebtMain)it.next();
			DebtRateDet pDebtRateDet = new RateManager().getMaxDueDateRate(pDebtMainDto);
			pDebtRateDet.setSuspendDate(tNewDueDate);
			new DebtRateDetDAO().update(pDebtRateDet);
			createExtendDueDate(pIssueMain,pDebtMainDto,tNewDueDate ,usrId);
		}
		pIssueMain.setDueDate(tNewDueDate);
		new IssueManager().confirm(pIssueMain);
	}
	public void createExtendDueDate(IssueMain tIssueMain , DebtMain tDebtMain, Date tNewDueDate,String usrId){
			ExtendDueDateMain pExtendDueDateMain = new ExtendDueDateMain();
			pExtendDueDateMain.setDebt(tDebtMain);
			pExtendDueDateMain.setInsTime(new Date());
			pExtendDueDateMain.setInsUsr(usrId);
			pExtendDueDateMain.setNewDueDate(tNewDueDate);
			pExtendDueDateMain.setOldDueDate(tIssueMain.getDueDate());
			pExtendDueDateMain.setAddInterestAmount(new InterestCounter().countInterest(tIssueMain.getDueDate(), tNewDueDate, new RateManager().getEffectiveRate(tDebtMain.getId()), tIssueMain.getIssueAmount().doubleValue(), 0));
			confirm(pExtendDueDateMain);
	}
	public void confirm(ExtendDueDateMain tExtendDueDateMain){
		new ExtendDueDateMainDAO().saveOrUpdate(tExtendDueDateMain);
	}
}
