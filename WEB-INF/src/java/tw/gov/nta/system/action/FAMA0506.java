package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.system.common.BankCodeManage;
import tw.gov.nta.system.form.Fama0501Form;

/**
 * @author AndrewSung
 *FAMA0406.java
 *呼叫ExstockCodeManage物件之delete(),傳入ID刪除所對應資料並Link to FAMA0401L.jsp
 */
public class FAMA0506 extends DefaultAction
{
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
        Fama0501Form fama0501Form = (Fama0501Form) form;
        //取得登入使用者之ID
        BankCodeManage.delete(fama0501Form.getId());
        setAlertMessage(request,"刪除成功");
    }
}
