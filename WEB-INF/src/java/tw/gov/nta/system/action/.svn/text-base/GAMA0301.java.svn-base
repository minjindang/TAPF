/**
 * @author AndrewSung
 * @date 2006/3/8
 */

package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.CentralStatisticsManager;
import tw.gov.nta.system.form.Gama0301Form;
public class GAMA0301 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Gama0301Form myForm = (Gama0301Form) form;
		myForm.setAccountYear(myForm.getQryAccountYear());
		myForm.setBudgetCode(myForm.getQryBudgetCode());
		myForm.setDebtCode(myForm.getQryDebtCode());
		myForm.setDebtType(myForm.getQryDebtType());
		myForm.setBoundCode(myForm.getQryBoundCode());
		myForm.setAccountKind(myForm.getQryAccountKind());
		List collection = CentralStatisticsManager.query(myForm.getCsMain());
		request.setAttribute("collection",collection);
		
	}
	
}
