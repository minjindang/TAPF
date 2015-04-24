package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.common.Gara04TempManager;
import tw.gov.nta.surplusage.form.Gama0701Form;

public class GAMA0705 extends DefaultAction {

	 
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Gama0701Form myForm = (Gama0701Form) form;
		Gara04TempManager.delete(myForm.getId());
		setAlertMessage(request,"§R°£¦¨¥\");
	}
}
