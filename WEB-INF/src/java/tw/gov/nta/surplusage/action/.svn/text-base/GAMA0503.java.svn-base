package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.common.UserStatisticsDetManager;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0501Form;

public class GAMA0503 extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Gama0501Form myForm = (Gama0501Form) form;
		UserStatisticsManager manager = new UserStatisticsManager();
		if( myForm.getMainId()!=null)
			myForm.setUserStatisticsMain( manager.get( myForm.getMainId() ) );
		else
			myForm.setUserStatisticsMain( manager.get( myForm.getId() ) );
		List collection = new UserStatisticsDetManager().getBeanByMain(myForm.getId());
		request.setAttribute("collection",collection);
	}
}
