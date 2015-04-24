package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb0401Form;
import tw.gov.nta.sql.UnitAllocateMain;

public class HAMB0406 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO 自動產生方法 Stub
		Hamb0401Form hamb0401form = (Hamb0401Form) form;
		UnitAllocateMain unitAllocateMain = hamb0401form.getUnitAllocateMain();
		unitAllocateMain.setModDate( new Date() );
		
		//使用Service:UnitAllocate
		//使用 UnitAllocate.update
		UnitAllocate.update(unitAllocateMain);
		setAlertMessage(request, Messages.SUCCESS_MODIFY);
	}
}