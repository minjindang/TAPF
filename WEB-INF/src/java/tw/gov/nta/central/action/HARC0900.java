package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.form.Harb0901Form;
import tw.gov.nta.sql.TaxactionDet;

public class HARC0900 extends DefaultAction
{
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception
	{
		Harb0901Form myForm = (Harb0901Form) form;
//		TaxactionDet det = Taxaction.getMaxYearDate("2");
//		myForm.set(det.getTaxYear());
//		myForm.setAllMonth(det.getTaxMonth());
		myForm.setMonKind("2");
	}
}
