package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.LawPercent;
import tw.gov.nta.central.form.Hama0201Form;
import tw.gov.nta.sql.LawPercentRef;

public class HAMA0200 extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception
	{
		LawPercentRef lawPercentRef = LawPercent.get(1);
		Hama0201Form hama0201Form = (Hama0201Form) form;
		hama0201Form.setLawPercentRef(lawPercentRef);
	}
}
