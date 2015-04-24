/**
*
* @author Andrew Sung
* @createDate 2006/7/12
*/
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.common.UserStatisticsDetManager;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0502Form;

public class GAMA0508 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0502Form myForm = (Gama0502Form)form;
		myForm.setUserStatisticsMain(new UserStatisticsManager().get(myForm.getMainId()));
		try{
			new UserStatisticsDetManager().confirm(myForm.getUserStatisticsDet());
			setAlertMessage(request,Messages.SUCCESS_ADD);
		}
		catch(Exception e){
			setAlertMessage(request,Messages.FAILURE_ADD);
			throw e;
		}
	}
}
