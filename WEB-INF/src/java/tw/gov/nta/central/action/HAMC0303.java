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

public class HAMC0303 extends DefaultAction {
	private final static String NO_SUITABLE_VALUE = "查無符合記帳年度和分配年月的資料!!";
	private final static BigDecimal DEFAULT_BIGDECIMAL = new BigDecimal(0).setScale(0);

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Hamb0301Form myform = (Hamb0301Form) form;
		//myform.setTaxKind("2"); //測試用 loadpage 時捉的

		TaxactionDet myDet = Taxaction.getByYear(myform.getTaxYear(),myform.getTaxMonth(),myform.getTaxKind());
		if( null == myDet )
		{
			setAlertMessage(request,NO_SUITABLE_VALUE);
			myform.setId(0);
			myform.setNationTax(DEFAULT_BIGDECIMAL);
			myform.setLocalTax(DEFAULT_BIGDECIMAL);
			myform.setIntTax(DEFAULT_BIGDECIMAL);
			myform.setTotMon(DEFAULT_BIGDECIMAL);
		}
		else
		{
			myform.setTaxactionDet(myDet);
			myform.setTotMon(UnitAllocate.SrcAccount(myform.getTaxYear(),myform.getTaxMonth(),myform.getTaxKind()));
		}
	}
}
