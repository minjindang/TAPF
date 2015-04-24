package gov.dnt.tame.sys;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import gov.dnt.tame.common.DefaultAction;

public class ConvertPassword extends DefaultAction {
	
	public String convertPasswordtoMd5(String passWord)
	{
		String passwdMd5 = passWord;
		byte[] defaultBytes = passwdMd5.getBytes();
		try{
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(defaultBytes);
			byte messageDigest[] = algorithm.digest();
		            
			StringBuffer hexString = new StringBuffer();
			for (int i=0;i<messageDigest.length;i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
//			System.out.println("password md5 version is "+hexString.toString());
			passwdMd5=hexString+"";
		}catch(NoSuchAlgorithmException nsae){
			//do nothing
		}
		
		return passwdMd5;
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub

	}

}
