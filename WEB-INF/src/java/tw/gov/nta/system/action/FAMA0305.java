/*
 * �b 2006/2/22 �إ�
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.DebitRef;
import tw.gov.nta.system.common.DebitCodeManage;
import tw.gov.nta.system.form.Fama0301Form;

/**
 * @author AndrewSung
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class FAMA0305 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
        Fama0301Form fama0301Form = (Fama0301Form) form;
        fama0301Form.setUsrid(this.getUserId(request));
        fama0301Form.setModDate(new Date());
        DebitRef debitRef = new DebitRef();
        BeanUtils.copyProperties(debitRef,fama0301Form);
        DebitCodeManage.update(debitRef);
        setAlertMessage(request,"��s���\");
    }

}
