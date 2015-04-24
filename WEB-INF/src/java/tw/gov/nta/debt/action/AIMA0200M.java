package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.beans.Beans;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Aima0201MForm;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.system.common.CodeDetManage;

public class AIMA0200M extends DefaultAction
{
	private final static Date TODAY = new Date();
	
	@SuppressWarnings("deprecation")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception
	{
//		try{
			Aima0201MForm aima0201MForm = (Aima0201MForm) form;
			IssueMain issueMain = aima0201MForm.getIssueMain();
			IssueMain sourceIssueMain = new IssueManager().getBean(issueMain.getSourceIssueId());
			if(issueMain.getIssueDate() == null){
				issueMain.setIssueDate( TODAY );
				aima0201MForm.setDiffOriginDay( DateUtil.getDays( sourceIssueMain.getIssueDate(), TODAY ).toString() );
			}
			else{
				aima0201MForm.setDiffOriginDay( DateUtil.getDays( sourceIssueMain.getIssueDate(), issueMain.getIssueDate() ).toString() );
			}
			BigDecimal issueAmount = (issueMain.getIssueAmount()!=null)?issueMain.getIssueAmount():new BigDecimal(0);
			BigDecimal averageRate = (aima0201MForm.getAverageRate()!=null)?issueMain.getAverageRate():new BigDecimal(0);
			BigDecimal repayInterestAmount = new IssueManager().getRepayInterestAmount(issueAmount,averageRate,sourceIssueMain.getIssueDate(),issueMain.getIssueDate());
			aima0201MForm.setRepayInterestAmount(repayInterestAmount);
			if(aima0201MForm.getBondType() == null){
				aima0201MForm.setBondType("");
			}

			if(aima0201MForm.getIssueKind() == null){
				aima0201MForm.setIssueKind("0");
			}

			if(aima0201MForm.getRateKind() == null){
				aima0201MForm.setRateKind("F");
			}	
			String codeName = (aima0201MForm.getBondType()!= null)?CodeDetManage.getCodeName("BT",aima0201MForm.getBondType()):CodeDetManage.getCodeName("BT","");
			if(!codeName.equals(""))
				codeName = codeName.substring(0,codeName.indexOf("("))+codeName.substring(codeName.indexOf(")")+1,codeName.length());
			aima0201MForm.setDebtName(aima0201MForm.getAccountYear()+"年度"+codeName+"第"+aima0201MForm.getSerialNo()+"期中央政府建設公債(增額發行)");
			request.setAttribute("sourceIssueMain",sourceIssueMain);
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}
	}
}