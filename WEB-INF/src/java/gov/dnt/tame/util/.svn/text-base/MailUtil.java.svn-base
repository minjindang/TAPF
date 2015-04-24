package gov.dnt.tame.util;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtil
{
	private static ResourceBundle bundle = ResourceBundle.getBundle("resources.mail");
	private static String smtp_host = bundle.getString("smtp.host");
	private static String smtp_auth = bundle.getString("smtp.auth");
	private static String uid = bundle.getString("send.user");
	private static String passwd = bundle.getString("send.passwd");
//	private static String DEFAULT_SENDER = bundle.getString("sender.mail");
	private static String DEFAULT_SENDER = "catr@mail.nta.gov.tw";
	

	private static String CONTENT_TYPE = "text/html; charset=Big5";
	private static String TODAY = DateUtil.ROCDate();

	public static String setMailAddress(MimeMessage msg, Message.RecipientType type, String addlist)
		throws Exception
	{
		try
		{
			InternetAddress to;
			String rStr = "";
			int sM = 0, eM = 0;

			do {
				eM = addlist.indexOf(";",sM);
				if(-1 != eM) {
				  to = new InternetAddress(addlist.substring(sM,eM));
				  rStr += "<br>" + addlist.substring(sM,eM);
				  sM = eM + 1;
				}
				else
				{
				  to = new InternetAddress(addlist.substring(sM));
				  rStr += "<br>" + addlist.substring(sM);
				}
				msg.addRecipient(type, to);
			}while(-1 != eM);

			return rStr;
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	public void SendMail(String TO_add,String CC_add,String BCC_add,String SUBJECT,String CONTENTS)
		throws Exception
	{
		CC_add = DEFAULT_SENDER;
		String MSG = "SUCCESS";
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", smtp_host);
		props.put("mail.smtp.auth", smtp_auth);
		props.put("mail.smtp.ehlo", Boolean.TRUE);
		props.put("mail.smtp.user", uid);
		props.put("mail.smtp.port", 25);
		props.put("mail.smtp.from", DEFAULT_SENDER);

		Authenticator authenticator = new SMTPAuthenticator(uid, passwd);

		Session sess = Session.getInstance(props, authenticator);

		MimeMessage message = new MimeMessage(sess);
		InternetAddress from = new InternetAddress(DEFAULT_SENDER);
		message.setFrom(from);
		try
		{
			MimeMultipart mm = new MimeMultipart();
			if( !"".equals(TO_add) || !"".equals(CC_add) || !"".equals(BCC_add) )
			{
				if( null!=TO_add && !"".equals(TO_add) )
					MSG += setMailAddress(message, Message.RecipientType.TO, TO_add);
				if( null!=CC_add && !"".equals(CC_add) )
					MSG += setMailAddress(message, Message.RecipientType.CC, CC_add);
				if( null!=BCC_add && !"".equals(BCC_add) )
					MSG += setMailAddress(message, Message.RecipientType.BCC, BCC_add);
			}
			else
			{
				throw new SendMailException("收件者不可為空!!");
			}

			if( "".equals(SUBJECT) ) throw new SendMailException("主旨不可為空!!");
			if( "".equals(CONTENTS) ) throw new SendMailException("內容不可為空!!");

			message.setSubject(SUBJECT,"Big5");
			MimeBodyPart mbp = new MimeBodyPart();
			DataHandler dh = new DataHandler("<font face='標楷體' size='16' size='5'>"+CONTENTS+"</font>", CONTENT_TYPE);
			mbp.setDataHandler(dh);
			mm.addBodyPart(mbp);

			smtp_host = "mailsr.kangdainfo.com";
			uid = "Chris.Wu";
			passwd = "11coco";
			
			Transport transport = sess.getTransport("smtp");
			try {
				transport.connect(smtp_host, uid, passwd);
				message.setHeader("Content-Transfer-Encoding","BIG5");
				message.setContent(mm);
				transport.sendMessage(message, message.getAllRecipients());
			}
			catch(MessagingException e) {
				System.out.println("傳送失敗");
				MSG += e.getMessage();
				throw new MessagingException(e.getMessage());
			}
			finally {
				transport.close();
			}
		}
		catch(MessagingException e)
		{
			System.out.println("傳送失敗2");
			throw new MessagingException(e.getMessage());
		}
	}
	/*
	 * 取得郵件
	 */
	public Folder getMail() throws MessagingException{
		Session mailsession=Session.getInstance(System.getProperties(),new SMTPAuthenticator(uid, passwd));
		mailsession.setDebug(false);
		Store store=mailsession.getStore("pop3");//protocol為連接協議，IMAP或是POP
		store.connect(smtp_host,-1,uid,passwd);//mailhost主機，user為用戶名，passwd為密碼
		Folder folder = store.getFolder("INBOX");
		try
		{ folder.open(Folder.READ_WRITE);}
		catch (MessagingException ex)
		{ folder.open(Folder.READ_ONLY);}
		return folder;
//		Message message[]=folder.getMessages();
//		FetchProfile fp=new FetchProfile();
//		fp.add(FetchProfile.Item.ENVELOPE);
//		fp.add(FetchProfile.Item.FLAGS);
//		fp.add("X-Mailer");
//		folder.fetch(message,fp);
//		String idArray[] = new String[folder.getMessageCount()];
//		System.out.println("共"+folder.getMessageCount()+"封");
//		for(int i=0;i<folder.getMessageCount();i++){
//			message[i].setFlag(Flags.Flag.SEEN,true);
//			System.out.println("標題:"+message[i].getSubject());
//			System.out.println("寄信時間:"+message[i].getSentDate());
//			Address[] to  = message[i].getAllRecipients();
//			取得郵件內容...因此處僅需取得id值{$xx}故不需下列處理
//			String from=new String();
//			Address[] fr = message[i].getFrom();
//			if(fr!=null){ 
//				boolean tf=true;
//				for(int j=0;j<fr.length;j++){
//					from=from+getDisplayAddress(fr[j]);
//					System.out.println("寄信者:"+from);
//				}
//			}
//			try{
//				if(message[i].isMimeType("multipart/*")){
//					System.out.println("multipart/*");
//					MimeMultipart mp=(MimeMultipart)message[i].getContent();
//					Part part=mp.getBodyPart(0);
//					String msg=(String)part.getContent().toString();
//					System.out.println("msg:"+msg);
//					
//				}
//				else if(message[i].isMimeType("text/plain")){
//					System.out.println("text/plain");
//					System.out.println("msg:"+message[i].getContent().toString());
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
	}
}