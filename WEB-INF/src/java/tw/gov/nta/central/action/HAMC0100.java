/**
*
* @author Andrew Sung
* @createDate 2006/8/11
*/
package tw.gov.nta.central.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.form.Hamb0101Form;

import gov.dnt.tame.common.DefaultAction;

public class HAMC0100 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Hamb0101Form myForm = (Hamb0101Form)form;
		myForm.setMonKind("2");
	}

}
