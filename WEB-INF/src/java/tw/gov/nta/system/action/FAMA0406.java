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

import tw.gov.nta.sql.ExstockRef;
import tw.gov.nta.system.common.ExstockCodeManage;
import tw.gov.nta.system.form.Fama0401Form;

/**
 * @author AndrewSung
 *FAMA0406.java
 *呼叫ExstockCodeManage物件之delete(),傳入ID刪除所對應資料並Link to FAMA0401L.jsp
 */
public class FAMA0406 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
        Fama0401Form fama0401Form = (Fama0401Form) form;
        //取得登入使用者之ID
        fama0401Form.setUsrid(this.getUserId(request));
        fama0401Form.setModDate(new Date());
        ExstockRef exstockRef = new ExstockRef();
        BeanUtils.copyProperties(exstockRef, fama0401Form);
        //呼叫ExstockCodeManage物件之delete(),傳入ID刪除所對應資料
        ExstockCodeManage.delete(exstockRef.getId());
        setAlertMessage(request,"刪除成功");
    }
}
