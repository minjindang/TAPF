package tw.gov.nta.exchequer.action;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.debt.common.TreasuryIssueManager;
import tw.gov.nta.exchequer.form.Bima0101Form;
import gov.dnt.tame.common.DefaultAction;

public class BIMA0105 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception 
	{
		Bima0101Form myForm = (Bima0101Form)form;
		if(myForm.getIssueId()!= null && myForm.getIssueId()!=0)
		{
			myForm.setId(myForm.getIssueId());
		}
		TreasuryIssueManager myManager = new TreasuryIssueManager();
		myForm.setIssueMain(myManager.getBean(myForm.getId()));
		myForm.setChargeRate(myForm.getChargeRate().multiply(new BigDecimal(1000)));
		if(myForm.getIssueId()!=null)
		{
			TicketManager ticketManager = new TicketManager();
			List list = (List)ticketManager.getBeanByIssue(myForm.getIssueMain().getId());
			request.setAttribute("collection",list);
		}
	}
}