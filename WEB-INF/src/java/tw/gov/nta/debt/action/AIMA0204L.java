package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Aima0204MForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtRateDet;

public class AIMA0204L extends DefaultAction {
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0204MForm aima0204MForm = (Aima0204MForm) form;
		List tDebtRateList = new ArrayList();
		if(request.getSession().getAttribute("debtRateList") == null){
			List tDebtMainList = new DebtManager().getBeanByIssue(aima0204MForm.getIssueMainId());
			if(tDebtMainList == null || tDebtMainList.size() == 0){
				setAlertMessage(request, "沒有借款資料，無法執行維護利率作業!!");
				throw new Exception("沒有借款資料，無法執行維護利率作業!!");
			}
			else{
				tDebtRateList = new RateManager().getEffectiveRate(((DebtMain)tDebtMainList.get(0)).getId());
				for(int i = 0 ;i<tDebtRateList.size();i++){
					DebtRateDet det = (DebtRateDet)tDebtRateList.get(i);
					det.setSeqNo(i);
					tDebtRateList.set(i,det);
				}
			}
		}
		else{
			tDebtRateList = (ArrayList)request.getSession().getAttribute("debtRateList");
		}
		request.setAttribute("collection", tDebtRateList);
		request.getSession().setAttribute("debtRateList", tDebtRateList);

		
//		Aima0104MForm actionForm = (Aima0104MForm) form;
//		Aima0104LForm aima0104LForm2 = (Aima0104LForm) request.getSession().getAttribute("AIMA0104LForm");
//		aima0104LForm.setIssueMain(aima0104LForm2.getIssueMain());
//		aima0104LForm.setDebtRateDetList(aima0104LForm2.getDebtRateDetList());
//		aima0104LForm.setDebtRateDetList(aima0104LForm2.getDebtRateDetList());
//		request.setAttribute("collection", aima0104LForm2.getDebtRateDetList());
	}
}
