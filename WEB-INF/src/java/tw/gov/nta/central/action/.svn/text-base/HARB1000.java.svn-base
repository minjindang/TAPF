package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.form.Harb1001Form;

public class HARB1000 extends DefaultAction
{
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception
	{
		Harb1001Form myForm = (Harb1001Form) form;
//		TaxactionDet det = Taxaction.getMaxYearDate("2");
//		myForm.set(det.getTaxYear());
//		myForm.setAllMonth(det.getTaxMonth());
		myForm.setMonKind("1");
	}
}
