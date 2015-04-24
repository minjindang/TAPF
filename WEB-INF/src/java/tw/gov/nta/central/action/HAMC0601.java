/*
 * �b 2006/2/20 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.central.action;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.MailContent;
import tw.gov.nta.central.form.Hamb0601Form;
import tw.gov.nta.sql.MailContentRef;
import gov.dnt.tame.common.DefaultAction;

/**
 * @author AndrewSung
 * HAMB06.java
 * ���ѨϥΪ̤�ʵo�e�q�l�l��
 */
public class HAMC0601 extends DefaultAction
{ 
    public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception 
	{
        Hamb0601Form hamb0601Form = (Hamb0601Form) form;
        //���o�e�����~�׻P������
        String year = hamb0601Form.getSUP_YEAR();
        String month = hamb0601Form.getSUP_MONTH();
        String date = hamb0601Form.getSUP_DATE();
        String count = hamb0601Form.getSupCount();
	    MailContentRef mailContentRef = new MailContentRef();
	    //�Nhamb0601Form��ƫ�����mailContentRef����
	    BeanUtils.copyProperties(mailContentRef, hamb0601Form);
	    //�I�sMailContent����sendMail(year,month,kind) Method,�o�e�l��ܦU�����t���
//		MailContent.sendMail(year,month,"2",date,count);
//		setAlertMessage(request,"�o�e���\");
		try{
	    	MailContent.sendMail(year,month,"2",date,count);
			setAlertMessage(request,"�o�e���\");
	    }
		catch(Exception e){
			setAlertMessage(request,"�o�e����");
			e.printStackTrace();
		}
	}
}
