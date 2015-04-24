/**
*
* @author Andrew Sung
* @createDate 2006/7/12
*/
package tw.gov.nta.surplusage.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.UserStatisticsMain;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0501Form;
import tw.gov.nta.surplusage.form.Gama0502Form;

import gov.dnt.tame.common.DefaultAction;

public class GAMA0511 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0502Form myForm = (Gama0502Form)form;
		UserStatisticsMain main = new UserStatisticsManager().get(myForm.getMainId());
		Gama0501Form mainForm = new Gama0501Form();
		mainForm.setUserStatisticsMain(main);
		request.setAttribute("Gama0501Form",mainForm);
	}
}
