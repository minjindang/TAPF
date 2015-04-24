/**
 * @author Andrew Sung
 * @create 2006/4/21
 */

package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.Eard0901Form;

public class EARD1201 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Eard0901Form myForm = (Eard0901Form)form;
		request.setAttribute("reportType",myForm.getReportType());
	}

}
