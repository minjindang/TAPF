package tw.gov.nta.debt.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueDetManager;
import tw.gov.nta.debt.form.Cima0101Form;

import gov.dnt.tame.common.DefaultAction;

public class GAMA0130 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form;
		IssueDetManager issueDetManager = new IssueDetManager();
		if(0 != myform.getMyIssDet().getId())
		{	
			issueDetManager.IssueDetDelete(myform.getMyIssDet());
			setAlertMessage(request,"刪除成功");
		}
		else
		{
			setAlertMessage(request,"無此筆資料");
		}
	}

}
