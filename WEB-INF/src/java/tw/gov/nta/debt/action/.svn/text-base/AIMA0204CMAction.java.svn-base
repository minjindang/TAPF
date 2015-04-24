package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Aima0204MForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtRateDet;

public class AIMA0204CMAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0204MForm aima0204MForm = (Aima0204MForm)form;
		List tDebtRateList = (ArrayList) request.getSession().getAttribute("debtRateList");
		DebtRateDet tDebtRateDet = null;
		Date tempDate = new Date();
		boolean isCorrectDate = true;
		for(Iterator tIterator = tDebtRateList.iterator() ; tIterator.hasNext() ;){
			tDebtRateDet = (DebtRateDet)tIterator.next();
			if(tDebtRateDet.getId().intValue() < 0)
				tDebtRateDet.setId(null);
			tDebtRateDet.setDeleteMark("N");
		}
		RateManager tRateManager = new RateManager();
		DebtMain tDebtMain = null;
		List tDebtList = new DebtManager().getBeanByIssue(aima0204MForm.getIssueMainId());
		for(Iterator tIterator = tDebtList.iterator(); tIterator.hasNext();){
			tDebtMain = (DebtMain) tIterator.next();
			tempDate = DateUtil.computeDueDate(((DebtRateDet)tDebtRateList.get(0)).getEffectiveDate(),-1);
			for(Iterator tIterator2 = tDebtRateList.iterator(); tIterator2.hasNext();){
				tDebtRateDet = (DebtRateDet) tIterator2.next();
				tDebtRateDet.setDebt(tDebtMain);
				if(null != tDebtRateDet.getEffectiveDate() && null != tempDate){
					if(0 != DateUtil.getDays(tDebtRateDet.getEffectiveDate(),(DateUtil.computeDueDate(tempDate,1))))
						isCorrectDate = false;
				}	
				tempDate = 	tDebtRateDet.getSuspendDate();
			}
			if(!isCorrectDate){
				setAlertMessage(request,"日期不正確");
				throw new Exception("日期不正確");
			}	
		}
		tRateManager.upDateIssueRate(aima0204MForm.getIssueMainId(),tDebtRateList);
		setAlertMessage(request,"確認完成");
		request.getSession().removeAttribute("debtRateList");
	}
}
