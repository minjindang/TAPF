/*
 * 在 2006/2/22 建立
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.ExstockRef;
import tw.gov.nta.system.common.ExstockCodeManage;
import tw.gov.nta.system.form.Fama0401Form;

/**
 * @author AndrewSung
 *呼叫ExstockCodeManage物件之query(),傳入exstockRef
 */
public class FAMA0401 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
        Fama0401Form fama0401Form = (Fama0401Form) form;
        //將查詢條件放入資料庫中對應之欄位
        fama0401Form.setStockId(fama0401Form.getQryStockId());
        fama0401Form.setStockName(fama0401Form.getQryStockName());
        ExstockRef exstockRef = new ExstockRef();
        BeanUtils.copyProperties(exstockRef, fama0401Form);
        //使用ExstockCodeManage.query對輸入之資料(Dto)作查詢
        List collection = ExstockCodeManage.query(exstockRef);
        request.setAttribute("collection",collection);
    }

}
