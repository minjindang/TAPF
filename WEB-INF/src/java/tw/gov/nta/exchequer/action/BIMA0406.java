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
import tw.gov.nta.exchequer.form.Bima0401Form;
import tw.gov.nta.sql.debt.AheadpayMain;

import gov.dnt.tame.common.DefaultAction;

public class BIMA0406 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bima0401Form myForm = (Bima0401Form)form;
		myForm.setAheadpayMain(new AheadpayManager().getBean(myForm.getId()));
	}

}
