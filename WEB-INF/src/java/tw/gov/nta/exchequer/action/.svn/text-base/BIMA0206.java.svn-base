/**
 * @author Andrew Sung
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.debt.common.TreasuryPayManager;
import tw.gov.nta.exchequer.form.Bima0201Form;
import tw.gov.nta.sql.debt.IssueMain;

public class BIMA0206 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bima0201Form myForm = (Bima0201Form)form;
		myForm.setIssueId(myForm.getQryIssueId());
		//使用PaymentTicketManager取得債票面額
		//查詢出清單 
		/*if(myForm.getQryIssueId()!=null || myForm.getQryIssueId()!=0)
		{
			//myForm.setPaymentMain(new PayManager().getBean(myForm.getId()));
			IssueMain issueMain = new IssueManager().getBean(myForm.getQryIssueId());
			myForm.setPaymentMain(new TreasuryPayManager().getBean(myForm.getId()));
			myForm.setDebtName(issueMain.getDebtName());
			myForm.setIssueDate(issueMain.getIssueDate());
			myForm.setIssueAmount(issueMain.getIssueAmount());
		}*/
		if(myForm.getPaymentMainId()!=null)
		{
			myForm.setPaymentMain(new PayManager().getBean(myForm.getPaymentMainId()));
			IssueMain issueMain = new IssueManager().getBean(myForm.getQryIssueId());
			myForm.setPaymentMain(new TreasuryPayManager().getBean(myForm.getId()));
			myForm.setDebtName(issueMain.getDebtName());
			myForm.setIssueDate(issueMain.getIssueDate());
			myForm.setIssueAmount(issueMain.getIssueAmount());
		}
		List list = (List)new TicketManager().getBeanByIssue(myForm.getIssueId());
		request.setAttribute("collection",list);
	}
}
