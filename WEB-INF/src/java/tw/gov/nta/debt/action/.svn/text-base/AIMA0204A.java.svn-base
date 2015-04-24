package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Aima0204MForm;
import tw.gov.nta.sql.debt.DebtRateDet;

public class AIMA0204A extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0204MForm aima0204MForm = (Aima0204MForm) form;
		aima0204MForm.setDebtRateDet(new DebtRateDet());
	}
}
