package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.UserStatisticsDet;
import tw.gov.nta.surplusage.common.UserStatisticsDetManager;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0502Form;

public class GAMA0506 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		UserStatisticsDet dto = new UserStatisticsDet();
		Gama0502Form myForm = (Gama0502Form) form;
		dto = new UserStatisticsDetManager().get(myForm.getId());
		myForm.setUserStatisticsDet(dto);
		myForm.setLastKeepAmount(dto.getKeepAmount());
		request.setAttribute("mainAccountYear", new UserStatisticsManager().get(myForm.getMainId()).getAccountYear());
	}

}
