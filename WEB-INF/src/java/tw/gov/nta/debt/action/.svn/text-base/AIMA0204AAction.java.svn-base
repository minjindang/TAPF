package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Aima0204MForm;
import tw.gov.nta.sql.debt.DebtRateDet;

public class AIMA0204AAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0204MForm aima0204MForm = (Aima0204MForm) form;
		List tDebtRateList = (ArrayList)request.getSession().getAttribute("debtRateList");
		DebtRateDet tDebtRateDet = new DebtRateDet();
		BeanUtils.copyProperties(tDebtRateDet,aima0204MForm.getDebtRateDet());
		int tVirtualId = 0;
		DebtRateDet tTempDebtRate = null;
		try{
			for(Iterator tIterator =tDebtRateList.iterator() ; tIterator.hasNext() ;){
				tTempDebtRate = (DebtRateDet)tIterator.next();
				if(tTempDebtRate.getSeqNo() == null) continue;
				if(tVirtualId >= tTempDebtRate.getSeqNo().intValue())
					tVirtualId = tTempDebtRate.getSeqNo().intValue()+1;
			}
			aima0204MForm.setSeqNo(tVirtualId);
			tDebtRateDet.setSeqNo(new Integer(tVirtualId));	
			tDebtRateList.add(tDebtRateDet);
			request.setAttribute("seqNo",tVirtualId);
			request.getSession().setAttribute("debtRateList",tDebtRateList);
			setAlertMessage(request,Messages.SUCCESS_ADD);
		}catch(Exception e){
			System.out.println(e);
			setAlertMessage(request,Messages.FAILURE_ADD);
			throw new Exception("Messages.FAILURE_ADD");
		}
	}
}
