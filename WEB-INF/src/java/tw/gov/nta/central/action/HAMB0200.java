package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.form.Hamb0201Form;
import tw.gov.nta.sql.TaxactionDet;

public class HAMB0200 extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// ¨ú±o formBean
		Hamb0201Form myForm = (Hamb0201Form) form;
		myForm.setMyDto(Taxaction.getMaxYearDate("1"));
		myForm.setTaxKind("1");
		myForm.setMonKind("");
		TaxactionDet myDet = new TaxactionDet();
		myDet = Taxaction.getByYear(myForm.getTaxYear(),myForm.getTaxMonth(),myForm.getTaxKind());
		if(myDet != null)
			myForm.setMyDto(myDet);
	}
}