package tw.gov.nta.surplusage.action;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.YearAmountRef;
import tw.gov.nta.surplusage.common.YearAmountManager;
import tw.gov.nta.surplusage.form.Gama0401Form;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

public class GAMA0404 extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gama0401Form myForm = (Gama0401Form) form;
		YearAmountManager manager = new YearAmountManager();
		YearAmountRef dto = myForm.getYearAmountRef();
		dto.setUserid( this.getUserId( request ) );
		dto.setModDate( new Date() );
		manager.update( dto );
		setAlertMessage(request,Messages.SUCCESS_MODIFY);
	}
}
