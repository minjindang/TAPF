/**
*
* @author Andrew Sung
* @createDate 2006/12/5
*/
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.CentralDebtDetManager;
import tw.gov.nta.exchequer.form.Bima0501Form;

public class BIMA0506 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bima0501Form myForm = (Bima0501Form)form;
		myForm.setCentralDebtDet(new CentralDebtDetManager().getBean(myForm.getId()));
	}

}
