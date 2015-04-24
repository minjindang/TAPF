package tw.gov.nta.surplusage.action;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.sql.YearAmountRef;
import tw.gov.nta.surplusage.common.YearAmountManager;
import tw.gov.nta.surplusage.form.Gama0401Form;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

public class GAMA0401 extends DefaultAction {

	 public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception{
		Gama0401Form myForm = (Gama0401Form) form;
		YearAmountManager manager = new YearAmountManager();
		YearAmountRef dto = myForm.getYearAmountRef();
		dto.setUserid( this.getUserId(request) );
		dto.setCreateDate( new Date() );
		dto.setModDate( new Date() );
		if(manager.query(dto) == null || manager.query(dto).isEmpty()){
			Integer id = manager.create( dto );
			myForm.setId( id );
			setAlertMessage(request,Messages.SUCCESS_ADD);
			return mapping.findForward("success");
		}
		else{
			setAlertMessage(request,Messages.UNIQUE_DATA);
			return mapping.findForward("fail");
		}
		
	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
	
	}
}
