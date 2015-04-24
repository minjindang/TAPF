/*
 * �b 2007/3/27 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package gov.dnt.tame.util;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.sun.mail.smtp.SMTPMessage;


/**
 * @author Mulder
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class Test
{
	protected static String strTestMailServer = "ntamail";
	protected static String strTestMailFrom = "catr@mail.nta.gov.tw";
	protected static String strTestMailTo = "jack.du@gmail.com";
	protected static String strTestUser = "catr";
	protected static String strTestPasswd = "dnt-2322";
	

    public static void main(String[] args) {
		sendMailTest();
    }
 
    public static void sendMailTest()
    {
    	String username = "catr";
    	String password = "dnt-2322";
    	String host = "ntamail";
    	String sender = "catr@mail.nta.gov.tw";

		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ehlo", "true");
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.port", 25);
		props.put("mail.smtp.from", sender);

		props.put("sender.email", sender);
		props.put("sender.name", username);
		
		SMTPAuthenticator authenticator = new SMTPAuthenticator(username, password);

		Session sess = Session.getInstance(props, authenticator);
		sess.setDebug(Boolean.TRUE);

		try {
			SMTPMessage message = new SMTPMessage(sess);
			message.setFrom(new InternetAddress(sender));
			message.setSubject("test","Big5");
			message.setText("test","Big5");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("jack.du@gmail.com") );

			Transport transport = sess.getTransport("smtp");
			try {
				transport.connect(username, password);
				message.saveChanges();
				transport.sendMessage(message, message.getAllRecipients());
			}catch(MessagingException e) {
				System.out.println("�ǰe����");
				e.printStackTrace();
			}finally {
				transport.close();
			}
		} catch (AddressException e1) {
			e1.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    }
}
