package tw.gov.nta.central.action;
import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.Taxaction101;
import tw.gov.nta.central.form.Hamb1101Form;
public class HAMB1101 extends DefaultAction {
	//¸Õºâ
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// ¨ú±o formBean
		Hamb1101Form myform = (Hamb1101Form) form;
		myform.setTotMon(Taxaction101.GetAllocatedMoneyTotal(myform.getTaxYear(),myform.getNationTax(),myform.getIntTax(),myform.getFinancial()));
		myform.setFillAmount(Taxaction101.GetFillAmountTotal(myform.getTaxYear(),myform.getNationTax(),myform.getIntTax(),myform.getNationRate(),myform.getLocalRate(),myform.getIntRate(),myform.getFinancial()));
		
	}
}
