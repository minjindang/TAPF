package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.form.Hamb0701Form;
import tw.gov.nta.sql.TaxactionDet;

public class HAMB0700 extends DefaultAction
{
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception
	{
		Hamb0701Form myForm = (Hamb0701Form) form;
		myForm.setMonKind("1");
		TaxactionDet det = Taxaction.getMaxYearDate("1");
		if(myForm.getQryallYear()==null)
			myForm.setQryallYear(det.getTaxYear());
		if(myForm.getQryallMonth()==null)
			myForm.setQryallMonth(det.getTaxMonth());
	}
}
