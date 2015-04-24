/**
 * @author Andrew Sung
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TreasuryPayManager;
import tw.gov.nta.exchequer.form.Bima0201Form;

public class BIMA0203 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		// 取得畫面的form
		Bima0201Form myForm = (Bima0201Form)form;
		myForm.setIssueId(myForm.getQryIssueId());
		//使用 TreasuryPaymentManager來查詢
		 List list = (List) new TreasuryPayManager().getDataByIssue(myForm.getIssueId());
		//return to jsp
	    request.setAttribute("collection",list);

	}

}
