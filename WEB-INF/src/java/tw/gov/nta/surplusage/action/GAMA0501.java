package tw.gov.nta.surplusage.action;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.sql.UserStatisticsMain;
import tw.gov.nta.surplusage.common.UserStatisticsManager;
import tw.gov.nta.surplusage.form.Gama0501Form;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

public class GAMA0501 extends DefaultAction {

	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
			HttpServletResponse response, Connection connection) throws Exception{
		Gama0501Form myForm = (Gama0501Form) form;
		UserStatisticsManager manager = new UserStatisticsManager();
		UserStatisticsMain dto = myForm.getUserStatisticsMain();
		dto.setUsrid( this.getUserId(request) );
		dto.setCreateDate( new Date() );
		dto.setModDate( new Date() );	
		dto.setOddKeepBamount1(dto.getKeepBamount1());
		dto.setOddKeepBamount2(dto.getKeepBamount2());
		dto.setOddKeepUamount1(dto.getKeepUamount1());
		dto.setOddKeepUamount2(dto.getKeepUamount2());
		if(null == dto.getAccountType())
			dto.setAccountType("N");
		else
			dto.setAccountType("Y");
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

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
	}
}
