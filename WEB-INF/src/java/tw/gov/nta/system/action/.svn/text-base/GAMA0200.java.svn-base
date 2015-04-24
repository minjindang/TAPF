/**
*
* @author Andrew Sung
* @createDate 2006/6/29
*/
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.form.Gama0201Form;

public class GAMA0200 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0201Form myForm = (Gama0201Form)form;
		
		String year = new Integer((new Date().getYear()-11)).toString();
		if (Integer.parseInt(year) < 100)
		{
			year="0"+year;
			
		}
		myForm.setAccountYear(year);
		myForm.setCaseRate(new BigDecimal(0));
		myForm.setRemainPayRate(new BigDecimal(0));
		myForm.setRemainRate(new BigDecimal(0));
	}

}
