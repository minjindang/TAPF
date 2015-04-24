/**
 * @author Andrew Sung
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.TreasuryPayManager;
import tw.gov.nta.exchequer.form.Bima0201Form;
import tw.gov.nta.sql.debt.IssueMain;

public class BIMA0205 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bima0201Form myForm = (Bima0201Form)form;
		//使用TreasuryPaymentManager(提前買回資料的id) 塞給dto 至修改畫面
		//TreasuryPayManager myManager = new TreasuryPayManager();
		if(myForm.getQryIssueId()==null)
			myForm.setQryIssueId(myForm.getIssueId());
		IssueMain issueMain = new IssueManager().getBean(myForm.getQryIssueId());
		myForm.setPaymentMain(new TreasuryPayManager().getBean(myForm.getId()));
		myForm.setDebtName(issueMain.getDebtName());
		myForm.setIssueDate(issueMain.getIssueDate());
		myForm.setIssueAmount(issueMain.getIssueAmount());
		myForm.setInterestDays(new DateUtil().getDays(myForm.getPaymentMain().getRepayDate(),issueMain.getDueDate()));
		myForm.setAverageRate(myForm.getAverageRate().multiply(new BigDecimal("100")).setScale(5,BigDecimal.ROUND_HALF_UP));
	}
}
