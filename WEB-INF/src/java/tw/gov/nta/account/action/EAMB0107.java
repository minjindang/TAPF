package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.account.form.Eamb0103Form;

public class EAMB0107 extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Eamb0103Form myForm = (Eamb0103Form) form;
		List<Integer> voucherIdList = new ArrayList<Integer>();
		voucherIdList.add(myForm.getId());		
		request.setAttribute("voucherIdList",voucherIdList);
	}
}
