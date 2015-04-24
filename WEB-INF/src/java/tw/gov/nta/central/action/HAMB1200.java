package tw.gov.nta.central.action;
import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.Taxaction101;
import tw.gov.nta.central.form.Hamb1201Form;
public class HAMB1200 extends DefaultAction{
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Hamb1201Form myForm = (Hamb1201Form) form;
		myForm.setMonKind("1");
		if (myForm.getQryAllYear() ==null){
			myForm.setQryAllYear(Taxaction101.getMaxYearDate().getTaxYear());
		}
		myForm.setQryAllMonth(Taxaction101.getMaxYearDate().getTaxMonth());
	}
}
