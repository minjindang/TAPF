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
import tw.gov.nta.debt.common.CentralDebtDetManager;
import tw.gov.nta.exchequer.form.Bima0401Form;
import tw.gov.nta.exchequer.form.Bima0501Form;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

public class BIMA0507 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bima0501Form myForm = (Bima0501Form)form;
		try{
			new CentralDebtDetManager().delete(myForm.getCentralDebtDet());
			setAlertMessage(request, Messages.SUCCESS_DELETE);
		}
		catch(Exception e){
			setAlertMessage(request, Messages.FAILURE_DELETE);
		}
	}

}
