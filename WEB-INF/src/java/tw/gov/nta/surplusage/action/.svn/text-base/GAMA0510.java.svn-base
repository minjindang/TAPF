/**
*
* @author Andrew Sung
* @createDate 2006/7/12
*/
package tw.gov.nta.surplusage.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.common.UserStatisticsDetManager;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0502Form;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

public class GAMA0510 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0502Form myForm = (Gama0502Form)form;
		myForm.setUserStatisticsMain(new UserStatisticsManager().get(myForm.getMainId()));
		try{
			new UserStatisticsDetManager().confirm(myForm.getUserStatisticsDet());
			setAlertMessage(request,Messages.SUCCESS_MODIFY);
		}
		catch(Exception e){
			setAlertMessage(request,Messages.FAILURE_MODIFY);
			throw e;
		}
	}

}
