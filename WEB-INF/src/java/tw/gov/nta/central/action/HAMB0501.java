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
import tw.gov.nta.central.form.Hamb0501Form;
import tw.gov.nta.sql.MailContentRef;
import gov.dnt.tame.common.DefaultAction;


/**
 * @author AndrewSung
 * HAMB0501.java
 * ���ѨϥΪ̳]�w�q�l�l�󤺮e���
 */
public class HAMB0501 extends DefaultAction
{ 
    public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception 
	{
        Hamb0501Form hamb0501Form = (Hamb0501Form) form;
        //���o�Ĥ@���l����(ID=0)
        MailContentRef mailContent = MailContent.get(0);
        //�NmailContent���X��ƽƻs��hamb0501Form
        BeanUtils.copyProperties(hamb0501Form,mailContent);
        hamb0501Form.setMonKind("1");
	}
}
