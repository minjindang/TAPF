/**
 * @author Andrew Sung
 * @create 2006/3/30
 */

package tw.gov.nta.exchequer.action;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bima0102Form;
import tw.gov.nta.sql.debt.IssueTicketDet;

import gov.dnt.tame.common.DefaultAction;

public class BIMA0110 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Bima0102Form myForm = (Bima0102Form)form;
		//因為票面維護畫面id為ticketid故需將issueId放回id以便新增
		if (myForm.getIssueId() != null)
		{
			Integer Id = myForm.getIssueId();
			myForm.setIssueTicketDet(new IssueTicketDet());
			myForm.setId(myForm.getIssueId());
			myForm.setTotalAmount(new BigDecimal(0));
		}
	}
}
