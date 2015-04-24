/*
 * 在 2006/2/22 建立
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.DebitRef;
import tw.gov.nta.system.common.DebitCodeManage;
import tw.gov.nta.system.form.Fama0301Form;

/**
 * @author AndrewSung
 */
public class FAMA0301 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
        Fama0301Form fama0301Form = (Fama0301Form) form;
        fama0301Form.setBudgetId(fama0301Form.getQryBudgetCode());
        //將查詢條件放入資料庫中對應之欄位
        DebitRef debitRef = new DebitRef();
        debitRef.setBudgetCode(fama0301Form.getBudgetCode());
        debitRef.setDebitName(fama0301Form.getQryDebitName());
        debitRef.setDebitType(fama0301Form.getQryDebitType());
        //使用DebitCodeManage.query對輸入之資料(Dto)作查詢
        List collection = DebitCodeManage.query(debitRef);
        request.setAttribute("collection",collection);
    }

}
