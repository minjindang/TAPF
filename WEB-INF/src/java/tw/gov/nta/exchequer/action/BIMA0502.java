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

import tw.gov.nta.debt.common.CentralDebtDetManager;
import tw.gov.nta.exchequer.form.Bima0501Form;

import gov.dnt.tame.common.DefaultAction;

public class BIMA0502 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bima0501Form myForm = (Bima0501Form)form;
		
		String[] tCols = new String[]{"IssueId" ,"UnitCode"};
		String[] tConds = new String[]{"=","="};
		Object[] tValue = new Object[]{myForm.getIssueId(),myForm.getUnitCode()};
		
		List list = new CentralDebtDetManager().Search(tCols, tValue, tConds, null);
		request.setAttribute("collection",list);

	}
}
