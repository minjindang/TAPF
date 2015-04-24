package tw.gov.nta.central.action;
import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
//import tw.gov.nta.central.common.Taxaction101;
import tw.gov.nta.central.common.Taxaction101;
import tw.gov.nta.sql.TaxactionDet101;
import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb1101Form;
import tw.gov.nta.sql.TaxactionDet;
public class HAMB1100 extends DefaultAction{
	
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception
	{
		Hamb1101Form myForm = (Hamb1101Form) form;
		myForm.setTaxactionDet(Taxaction101.getMaxYearDate());
		
		TaxactionDet101 myDet = Taxaction101.getByYear(myForm.getTaxYear(),myForm.getTaxMonth());
		if(null != myDet)
		{
			myForm.setTaxactionDet(myDet);
			//myForm.setTotMon(UnitAllocate.SrcAccount(myForm.getTaxYear(),myForm.getTaxMonth(),myForm.getTaxKind()));
		}
		try{
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		//myForm.setFillAmount(myForm.getTotMon().subtract(myForm.getFillAmount()));
	}
}
