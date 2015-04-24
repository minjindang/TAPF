/**
*
* @author Andrew Sung
* @createDate 2006/6/23
*/
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.form.Gama0201Form;

public class GAMA0202 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
			Gama0201Form myForm = (Gama0201Form)form;
			myForm.clean();
	}

}
