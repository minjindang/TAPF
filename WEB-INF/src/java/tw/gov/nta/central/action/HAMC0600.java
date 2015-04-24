package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.form.Hamb0601Form;
import tw.gov.nta.sql.TaxactionDet;

public class HAMC0600 extends DefaultAction
{
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception
	{
		Hamb0601Form myForm = (Hamb0601Form) form;
		myForm.setMonKind("2");
		TaxactionDet det = Taxaction.getMaxYearDate("2");
		if(myForm.getSUP_YEAR()==null)
			myForm.setSUP_YEAR(det.getTaxYear());
		if(myForm.getSUP_MONTH()==null)
			myForm.setSUP_MONTH(det.getTaxMonth());
	}
}
