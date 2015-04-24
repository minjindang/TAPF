/**
*
* @author Andrew Sung
* @createDate 2006/7/2
*/
package tw.gov.nta.surplusage.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;
import tw.gov.nta.surplusage.form.Gama0601Form;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

public class GAMA0605 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0601Form myForm = (Gama0601Form)form;
		new PaymentMainDAO().delete(myForm.getId());
		setAlertMessage(request,Messages.SUCCESS_DELETE);
	}

}
