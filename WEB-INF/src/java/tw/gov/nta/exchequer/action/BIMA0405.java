/**
*
* @author Andrew Sung
* @createDate 2006/12/5
*/
package tw.gov.nta.exchequer.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.AheadpayManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.exchequer.form.Bima0401Form;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.Messages;

public class BIMA0405 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bima0401Form myForm = (Bima0401Form)form;
		myForm.setDebtName(new IssueManager().getBean(myForm.getIssueId()).getDebtName());
		myForm.setIssueDays(new DateUtil().getDays(myForm.getIssueDate(), myForm.getDueDate()));
		try{
			new AheadpayManager().confirm(myForm.getAheadpayMain());
			setAlertMessage(request, Messages.SUCCESS_MODIFY);
		}
		catch(Exception e){
			setAlertMessage(request, Messages.FAILURE_MODIFY);
		}
		
	}

}
