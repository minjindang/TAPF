/**
*
* @author Andrew Sung
* @createDate 2006/8/3
*/
package tw.gov.nta.central.action;

import java.sql.Connection;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.MailContent;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

public class HAMB0705 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		try {
			new MailContent().receiveMail();
			setAlertMessage(request, Messages.SUCCESS_MODIFY);
		} catch (MessagingException e) {
			setAlertMessage(request, Messages.FAILURE_MODIFY);
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}	
	}

}
