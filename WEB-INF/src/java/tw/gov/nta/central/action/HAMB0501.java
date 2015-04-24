/*
 * 在 2006/2/20 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.central.action;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.MailContent;
import tw.gov.nta.central.form.Hamb0501Form;
import tw.gov.nta.sql.MailContentRef;
import gov.dnt.tame.common.DefaultAction;


/**
 * @author AndrewSung
 * HAMB0501.java
 * 提供使用者設定電子郵件內容資料
 */
public class HAMB0501 extends DefaultAction
{ 
    public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception 
	{
        Hamb0501Form hamb0501Form = (Hamb0501Form) form;
        //取得第一筆郵件資料(ID=0)
        MailContentRef mailContent = MailContent.get(0);
        //將mailContent取出資料複製到hamb0501Form
        BeanUtils.copyProperties(hamb0501Form,mailContent);
        hamb0501Form.setMonKind("1");
	}
}
