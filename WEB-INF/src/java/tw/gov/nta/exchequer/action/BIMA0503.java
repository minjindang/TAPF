/**
*
* @author Andrew Sung
* @createDate 2006/12/5
*/
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.CentralDebtDetManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.exchequer.form.Bima0501Form;

public class BIMA0503 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bima0501Form myForm = (Bima0501Form)form;
		try{
			myForm.setIssueSerial(new IssueManager().getBean(myForm.getIssueId()).getIssueSerial());
			myForm.setModDate(new Date());
			myForm.setCreateDate(new Date());
			myForm.setUserId(this.getUserId(request));
			new CentralDebtDetManager().confirm(myForm.getCentralDebtDet());
			setAlertMessage(request, Messages.SUCCESS_ADD);
		}
		catch(Exception e){
			setAlertMessage(request, Messages.FAILURE_ADD);
		}
	}

}
