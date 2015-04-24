/*
 * 在 2006/2/22 建立
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
 */
public class FAMA0307 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
        Fama0301Form fama0301Form = (Fama0301Form) form; 
        
        DebitRef debitRef = new DebitRef();
        BeanUtils.copyProperties(debitRef, fama0301Form);
        debitRef.setCreateDate(new Date());
        debitRef.setModDate(new Date());
        debitRef.setUsrid(this.getUserId(request));
        DebitCodeManage.create(debitRef);
        BeanUtils.copyProperties(fama0301Form, debitRef);
        fama0301Form.setQry("N");
        setAlertMessage(request,"新增成功");
    }

}
