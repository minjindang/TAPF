package gov.dnt.tame.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SMTPAuthenticator extends Authenticator
{
	private String username;
	private String password;

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("username", username).append(
				"password", password).toString();
	}

	public SMTPAuthenticator(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(username, password);
//		sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder(); 
//        return new PasswordAuthentication(enc.encode(username.getBytes()), 
//                                          enc.encode(password.getBytes()));
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
