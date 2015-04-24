package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb0301Form;
import tw.gov.nta.sql.TaxactionDet;

public class HAMB0300 extends DefaultAction
{
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception
	{
		Hamb0301Form myForm = (Hamb0301Form) form;
		myForm.setTaxactionDet(Taxaction.getMaxYearDate("1"));
		myForm.setTaxKind("1");
		TaxactionDet myDet = Taxaction.getByYear(myForm.getTaxYear(),myForm.getTaxMonth(),myForm.getTaxKind());
		if(null != myDet)
		{
			myForm.setTaxactionDet(myDet);
			myForm.setTotMon(UnitAllocate.SrcAccount(myForm.getTaxYear(),myForm.getTaxMonth(),myForm.getTaxKind()));
		}
		try{
		myForm.setFillAmount(
				Taxaction.tryCountAmountUpd(myForm.getTaxYear(),
				myForm.getTaxMonth(),myForm.getTaxKind(),
				null!=myForm.getNationTax()?myForm.getNationTax():new BigDecimal("0"),
				null!=myForm.getLocalTax()?myForm.getLocalTax():new BigDecimal("0"),
				null!=myForm.getIntTax()?myForm.getIntTax():new BigDecimal("0"),
				myForm.getUsrid(),
				null!=myForm.getNationRate()?myForm.getNationRate():new BigDecimal("0"),
				null!=myForm.getLocalRate()?myForm.getLocalRate():new BigDecimal("0"),
				null!=myForm.getIntRate()?myForm.getIntRate():new BigDecimal("0")
				));
		}catch (Exception e) {
			// TODO: handle exception
		}
		myForm.setFillAmount(myForm.getTotMon().subtract(myForm.getFillAmount()));
	}
}
