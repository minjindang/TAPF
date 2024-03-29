package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Aima0104MForm;
import tw.gov.nta.sql.debt.DebtRateDet;

public class AIMA0104M extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0104MForm aima0104MForm = (Aima0104MForm) form;
		List tDebtRateList = (ArrayList)request.getSession().getAttribute("debtRateList");
		for(Iterator tIterator = tDebtRateList.iterator(); tIterator.hasNext(); ){
			DebtRateDet tTempDebtRateDet = (DebtRateDet)tIterator.next();
			if(request.getAttribute("seqNo")!=null){
				if(new Integer(request.getAttribute("seqNo").toString()).compareTo(tTempDebtRateDet.getSeqNo())==0){
					aima0104MForm.setDebtRateDet(tTempDebtRateDet);
					System.out.println("設定1" + tTempDebtRateDet + "帳號:" + tTempDebtRateDet.getGroupId());
					break;
				}
			}
			else{
				if(aima0104MForm.getSeqNo().compareTo(tTempDebtRateDet.getSeqNo())==0){
					aima0104MForm.setDebtRateDet(tTempDebtRateDet);
					System.out.println("設定1" + tTempDebtRateDet + "帳號:" + tTempDebtRateDet.getGroupId());
					break;
				}
			}
		}
	}
}
