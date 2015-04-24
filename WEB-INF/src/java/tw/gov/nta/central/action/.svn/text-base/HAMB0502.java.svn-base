/*
 * 在 2006/2/20 建立
 */
package tw.gov.nta.central.action;

import java.sql.Connection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.MailContent;
import tw.gov.nta.central.form.Hamb0501Form;
import tw.gov.nta.sql.MailContentRef;
import gov.dnt.tame.common.DefaultAction;


/**
 * @author AndrewSung
 * HAMB0502.java
 * 提供使用者設定電子郵件內容資料
 */
public class HAMB0502 extends DefaultAction
{ 
    public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception 
	{
        Hamb0501Form hamb0501Form = (Hamb0501Form) form;
        hamb0501Form.setModDate(new Date());
        hamb0501Form.setUsrid((request.getSession().getAttribute("ID")).toString());
        //呼叫MailContent物件之update(id,畫面,欄位)Method,
        //將畫面的郵件內容資料儲存至資料庫檔案
		MailContent.update(hamb0501Form.getMailContentRef());
		setAlertMessage(request,"更新成功");
	}
}
