package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cima0101Form;

public class GAMA0101LIST extends DefaultAction {

	public GAMA0101LIST() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
		Cima0101Form myform= (Cima0101Form)form;
		request.setAttribute("oklist",0);
		if(0 != myform.getBudgetCode())
		{
			request.setAttribute("oklist",myform.getBudgetCode());
		}

	}

}
