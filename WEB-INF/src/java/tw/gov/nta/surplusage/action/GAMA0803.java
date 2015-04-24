/**
*
* @author Andrew Sung
* @createDate 2006/10/18
*/
package tw.gov.nta.surplusage.action;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.debt.OtherPlanDebt;
import tw.gov.nta.surplusage.common.OtherPlanDebtManager;
import tw.gov.nta.surplusage.form.Gama0801Form;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

public class GAMA0803 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0801Form myForm = (Gama0801Form)form;
		new OtherPlanDebtManager().confirm(myForm.getOtherPlanDebt());
		setAlertMessage(request, Messages.SUCCESS_ADD);
	}
}
