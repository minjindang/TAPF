package tw.gov.nta.debt.action;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueDetManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

public class GAMA0902 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myForm = (Cima0101Form)form;
		DebtManager myDManager = new DebtManager(); 
		IssueManager myManager = new IssueManager();
		IssueMain issueMain = myManager.getBean(myForm.getId());
		myForm.setMyIss(issueMain);
		myForm.setOldIssueDate(issueMain.getIssueDate());
		myForm.setOldDueDate(issueMain.getDueDate());
		if(null == issueMain.getIssueAmount())
		{
			myForm.setIssueAmount(new BigDecimal(0));
		}
		if(null == issueMain.getCapitalAmount())
		{
			myForm.setCapitalAmount(new BigDecimal(0));
		}
		
		String[] cols = {"issue.id"};
		Object[] pValues = {myForm.getId()}; 
		String[] pConds = {"="};
		String[] orderby ={"compareRate"};
		
		List collection = (List)myDManager.Search(cols,pValues,pConds,orderby);

		Set<DebtMain> debtMains = new HashSet<DebtMain>();
		BigDecimal totalA = new BigDecimal(0);		// 每筆未償金額A
		BigDecimal totalB = new BigDecimal(0);		// 每筆目前利率B
		BigDecimal totalASum = new BigDecimal(0);	//sum 每筆未償金額A
		BigDecimal totalBSum = new BigDecimal(0);	//sum 每筆目前利率B
		BigDecimal totalABSum = new BigDecimal(0);	//sum A*B
		Session session = new IssueMainDAO().createNewSession();
		Query queryAmount = null;
		Query queryRate = null;
		for(Iterator it=collection.iterator();it.hasNext();)
		{	
			totalA = new BigDecimal(0);
			totalB = new BigDecimal(0);
			
			DebtMain debtMain = (DebtMain) it.next();
			if(null == debtMain.getAccrue())
			{
				debtMain.setAccrue("N");
			}
			if(null == debtMain.getIssueAmount())
			{
				debtMain.setIssueAmount(new BigDecimal(0));
			}
			if(null == debtMain.getOriginInterestAmount())
			{
				debtMain.setOriginInterestAmount(new BigDecimal(0));
			}
			if(null == debtMain.getCompareRate())
			{
				debtMain.setCompareRate(new BigDecimal(0));
			}
			if(null == debtMain.getCompareAmount())
			{
				debtMain.setCompareAmount(new BigDecimal(0));
			}
			if(1 == debtMain.getIssueAmount().compareTo(new BigDecimal(0)))
			{	
				/** 每筆未償金額 **/
				StringBuffer strAmount = new StringBuffer();
				strAmount.append("select isnull(sum(capitalAmount),cast(0 as int)) from PaymentMain where debtId = ");
				strAmount.append(debtMain.getId());
				queryAmount = session.createQuery(strAmount.toString());
				List amountList = queryAmount.list();
				if(null != amountList && 0!=amountList.size())
				{
					if(null != amountList.get(0))
					{
						totalA = debtMain.getIssueAmount().subtract((BigDecimal)amountList.get(0));
					}	
					totalASum = totalASum.add(totalA);	
				}	
				
				/** 每筆目前利率 **/
				StringBuffer strRate = new StringBuffer();
				strRate.append(" select isnull(debtRateDet.debtRate,cast(0 as int)) from DebtRateDet debtRateDet where debtRateDet.deleteMark = 'N' ");
				strRate.append(" and debtRateDet.effectiveDate <= '");
				strRate.append(DateUtil.date2Str(new Date(),"yyyy/mm/dd"));
				strRate.append("' and debtRateDet.suspendDate >= '");
				strRate.append(DateUtil.date2Str(new Date(),"yyyy/mm/dd"));
				strRate.append("' and debtRateDet.debt.id = ");
				strRate.append(debtMain.getId());
				queryRate = session.createQuery(strRate.toString());
				List rateList = queryRate.list();
				if(null != rateList && 0!=rateList.size())
				{
					if(null != rateList.get(0))
					{
						totalB = (BigDecimal)rateList.get(0);
					}
					totalABSum = totalABSum.add(totalA.multiply(totalB));
				}
			}
			/** 每筆DebtMain 加到 vector **/
			debtMains.add(debtMain);
		}
		if(null != totalASum && 0 != totalASum.intValue())
		{
			myForm.setNowAverageRate(totalABSum.divide(totalASum,3,5)); /** 畫面中的 目前加權平均利率 **/
		}
		else
		{
			myForm.setNowAverageRate(new BigDecimal(0));
		}
		myForm.setDebtMains(debtMains);
		request.setAttribute("debtMains",collection);
		
	}

}
