/**
*
* @author Andrew Sung
* @createDate 2006/6/7
*/
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.form.Hamb0401Form;

public class HAMC0400 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Hamb0401Form myForm = (Hamb0401Form) form;
		myForm.setMonKind("2");
		if (myForm.getQryAllYear() ==null){
			myForm.setQryAllYear(Taxaction.getMaxYearDate("2").getTaxYear());
		}
		myForm.setQryAllMonth((Taxaction.getMaxYearDate("2").getTaxMonth()!=null)?Taxaction.getMaxYearDate("2").getTaxMonth():"");
	}

}
