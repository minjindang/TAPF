/**
 * @author Andrew Sung
 * @create 2006/3/30
 */

package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bima0202Form;

public class BIMA0210 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Bima0202Form myForm = (Bima0202Form)form;
		if(myForm.getPaymentMainId()==0)
			myForm.setPaymentMainId(myForm.getId());
		myForm.clean();
		myForm.setTotalAmount(new BigDecimal(0));
	}
}
