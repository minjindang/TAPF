/**
 * @author Andrew Sung
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.TreasuryPayManager;
import tw.gov.nta.exchequer.form.Bima0201Form;
import tw.gov.nta.sql.debt.PaymentMain;

public class BIMA0201 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Bima0201Form myform = (Bima0201Form)form;
		myform.setId(null);
		myform.setModDate(new Date());
		myform.setPlanRepayDate(myform.getPlan().getRepayDate());
		myform.setInterestAmount(myform.getManageInterestAmount());
		myform.setAverageRate(myform.getAverageRate().divide(new BigDecimal(100)));
		new TreasuryPayManager().confirm(myform.getPaymentMain());
		setAlertMessage(request,"儲存成功");
		//因為service沒有回傳值所以先不考慮成功或失敗
	}
}
