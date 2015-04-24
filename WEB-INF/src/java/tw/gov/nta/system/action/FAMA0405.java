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

import tw.gov.nta.sql.ExstockRef;
import tw.gov.nta.system.common.ExstockCodeManage;
import tw.gov.nta.system.form.Fama0401Form;

/**
 * @author AndrewSung
 *�I�sExstockCodeManage����update(),�ǤJID��exstockRef��s���
 */
public class FAMA0405 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
        Fama0401Form fama0401Form = (Fama0401Form) form;
        fama0401Form.setUsrid(this.getUserId(request));
        fama0401Form.setModDate(new Date());
        ExstockRef exstockRef = new ExstockRef();
        BeanUtils.copyProperties(exstockRef,fama0401Form);
        //�I�sExstockCodeManage����update(),�ǤJID��exstockRef��s���
        ExstockCodeManage.update(exstockRef);
        setAlertMessage(request,"��s���\");
    }

}
