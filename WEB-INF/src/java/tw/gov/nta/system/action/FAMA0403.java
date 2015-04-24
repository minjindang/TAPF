/*
 * 在 2006/2/22 建立
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.ExstockCodeManage;
import tw.gov.nta.system.form.Fama0401Form;

/**
 * @author AndrewSung
 *呼叫ExstockCodeManage物件之get(),傳入ID
 */
public class FAMA0403 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
        Fama0401Form fama0401Form = (Fama0401Form) form;
        //使用ExstockCodeManage.get()取得輸入ID值
        fama0401Form.setExstockRef(ExstockCodeManage.get(fama0401Form.getId())) ;
       
    }
}
