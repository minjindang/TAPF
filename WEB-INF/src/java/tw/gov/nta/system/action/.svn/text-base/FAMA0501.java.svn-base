package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.system.common.BankCodeManage;
import tw.gov.nta.system.form.Fama0501Form;

/**
 * @author AndrewSung
 *呼叫ExstockCodeManage物件之query(),傳入exstockRef
 */
public class FAMA0501 extends DefaultAction
{
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
       Fama0501Form fama0501Form = (Fama0501Form) form;
        //將查詢條件放入資料庫中對應之欄位
       fama0501Form.setBankCode(fama0501Form.getQryBankCode());
       fama0501Form.setBankName(fama0501Form.getQryBankName());
       fama0501Form.setShortBankName(fama0501Form.getQryShortBankName());
       fama0501Form.setBelongToBankId(fama0501Form.getQryBelongToBankId());
       fama0501Form.setCombinationBankId(fama0501Form.getQryCombinationBankId());
       List collection = BankCodeManage.query(fama0501Form.getBankRef());
       request.setAttribute("collection",collection);
    }
}
