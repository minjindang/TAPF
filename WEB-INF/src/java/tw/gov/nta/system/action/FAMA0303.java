/*
 * 在 2006/2/22 建立
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.DebitRef;
import tw.gov.nta.system.common.DebitCodeManage;
import tw.gov.nta.system.form.Fama0301Form;

/**
 * @author AndrewSung
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class FAMA0303 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
        Fama0301Form fama0301Form = (Fama0301Form) form;
        DebitRef debitRef = DebitCodeManage.get(fama0301Form.getId());
        BeanUtils.copyProperties(fama0301Form,debitRef);
        fama0301Form.setBudgetId(debitRef.getBudgetCode().getId());
    }

}
