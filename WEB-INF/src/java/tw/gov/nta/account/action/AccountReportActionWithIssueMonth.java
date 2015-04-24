/**
 * @author LinusTseng
 * @date 2006/3/8
 * 處理新增程式，並導向清單
 */

package tw.gov.nta.account.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.account.form.AccountQueryForm;



/**
 * 到查詢
 * @author Administrator
 *
 */
public class AccountReportActionWithIssueMonth extends AccountReportAction
{

	/* (non-Javadoc)
	 * @see tw.gov.nta.account.action.AccountReportAction#initialize(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void initialize(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		super.initialize(mapping, form, request, response);
		String systemDate = gov.dnt.tame.util.DateUtil.getSystemDate();
		String	monthValue = systemDate.substring(3,5);
		AccountQueryForm myform = (AccountQueryForm)form;
		if (myform.getIssueMonth() == null || "".equals(myform.getIssueMonth()))
			myform.setIssueMonth(monthValue);
	}



}
