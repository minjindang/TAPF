package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Harb0801Form;
import tw.gov.nta.sql.TaxactionDet;

public class HARB0800 extends DefaultAction
{
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception
	{
		Harb0801Form myForm = (Harb0801Form) form;
		if(myForm.getAllYear() == null){
			TaxactionDet det = Taxaction.getMaxYearDate("1");
			myForm.setAllYear(det.getTaxYear());
			myForm.setAllMonth(det.getTaxMonth());
		}
		myForm.setMonKind("1");
	}
}
