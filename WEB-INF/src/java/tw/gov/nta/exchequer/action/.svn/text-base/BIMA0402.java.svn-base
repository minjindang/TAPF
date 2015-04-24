/**
*
* @author Andrew Sung
* @createDate 2006/12/5
*/
package tw.gov.nta.exchequer.action;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.AheadpayManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.exchequer.form.Bima0401Form;

import gov.dnt.tame.common.DefaultAction;

public class BIMA0402 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bima0401Form myForm = (Bima0401Form)form;
		String[] tCols = new String[]{"accountYear"};
		String[] tConds = new String[]{"="};
		Object[] tValue = new Object[]{myForm.getQryAccountYear()};
		List list = new AheadpayManager().Search(tCols, tValue, tConds, new String[]{"accountYear"});
		request.setAttribute("collection",list);
	}

}
