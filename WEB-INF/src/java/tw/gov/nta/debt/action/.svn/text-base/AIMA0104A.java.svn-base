package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Aima0104MForm;
import tw.gov.nta.sql.debt.DebtRateDet;

public class AIMA0104A extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0104MForm aima0104MForm = (Aima0104MForm) form;
		aima0104MForm.setDebtRateDet(new DebtRateDet());
	}
}
