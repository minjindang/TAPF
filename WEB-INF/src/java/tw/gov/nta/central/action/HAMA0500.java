package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.LawPercent101;
import tw.gov.nta.central.form.Hama0501Form;
import tw.gov.nta.sql.LawPercentRef101;

public class HAMA0500 extends DefaultAction {
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception
	{
		LawPercentRef101 lawPercentRef101 = LawPercent101.get(1);
		Hama0501Form hama0501Form = (Hama0501Form) form;
		hama0501Form.setLawPercentRef(lawPercentRef101);
	}
}
