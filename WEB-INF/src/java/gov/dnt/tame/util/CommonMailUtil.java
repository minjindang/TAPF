package gov.dnt.tame.util;

import java.util.ResourceBundle;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CommonMailUtil {

	/**
	 * @param to_add
	 * @param subject
	 * @param contents
	 * @throws EmailException
	 */
	public static void sentMail(String to_add,String subject,String contents) throws EmailException
	{
		sentMail(to_add,null,null,subject,contents);
	}

	/**
	 * @param to_add
	 * @param cc_add
	 * @param bcc_add
	 * @param subject
	 * @param contents
	 * @throws EmailException
	 */
	public static void sentMail(String to_add,String cc_add,String bcc_add,String subject,String contents) throws EmailException
	{
		ResourceBundle bundle = ResourceBundle.getBundle("resources.mail");

		SimpleEmail email = new SimpleEmail();
		email.setAuthentication(bundle.getString("send.user"),bundle.getString("send.passwd"));
		email.setFrom(bundle.getString("sender.mail"));
		email.setHostName(bundle.getString("smtp.host"));
		email.setSubject(subject);
		email.setContent(contents,"text/html; charset=Big5");
		if( to_add!=null && !"".equals( to_add ) ) email.addTo(to_add);
		if( cc_add!=null && !"".equals( cc_add ) ) email.addCc(cc_add);
		if( bcc_add!=null && !"".equals( bcc_add ) ) email.addBcc(bcc_add);
		email.send();
	}

}
