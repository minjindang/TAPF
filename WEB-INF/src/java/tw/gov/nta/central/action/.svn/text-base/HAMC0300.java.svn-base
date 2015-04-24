package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb0301Form;
import tw.gov.nta.sql.TaxactionDet;

public class HAMC0300 extends DefaultAction
{
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception
	{
		Hamb0301Form myForm = (Hamb0301Form) form;
		myForm.setTaxactionDet(Taxaction.getMaxYearDate("2"));
		myForm.setTaxKind("2");
		TaxactionDet myDet = Taxaction.getByYear(myForm.getTaxYear(),myForm.getTaxMonth(),myForm.getTaxKind());
		if(null != myDet)
		{
			myForm.setTaxactionDet(myDet);
			myForm.setTotMon(UnitAllocate.SrcAccount(myForm.getTaxYear(),myForm.getTaxMonth(),myForm.getTaxKind()));
		}
	}
}
