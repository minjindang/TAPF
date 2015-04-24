package tw.gov.nta.surplusage.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.UserStatisticsMain;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0501Form;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

public class GAMA0505 extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Gama0501Form myForm = (Gama0501Form) form;
		UserStatisticsManager manager = new UserStatisticsManager();
		UserStatisticsMain dto = myForm.getUserStatisticsMain();
		try
		{
			manager.syncDeleteDetail(dto);
			setAlertMessage(request,Messages.SUCCESS_DELETE);
		}
		catch(Exception e)
		{
			System.out.println("GAMA0506 Exception = "+e);
			setAlertMessage(request,Messages.FAILURE_DELETE);
			throw e ;
		}
	}
}
