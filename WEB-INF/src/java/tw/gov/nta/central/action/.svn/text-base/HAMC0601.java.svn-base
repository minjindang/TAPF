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
import tw.gov.nta.central.form.Hamb0601Form;
import tw.gov.nta.sql.MailContentRef;
import gov.dnt.tame.common.DefaultAction;

/**
 * @author AndrewSung
 * HAMB06.java
 * 提供使用者手動發送電子郵件
 */
public class HAMC0601 extends DefaultAction
{ 
    public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception 
	{
        Hamb0601Form hamb0601Form = (Hamb0601Form) form;
        //取得畫面的年度與月份資料
        String year = hamb0601Form.getSUP_YEAR();
        String month = hamb0601Form.getSUP_MONTH();
        String date = hamb0601Form.getSUP_DATE();
        String count = hamb0601Form.getSupCount();
	    MailContentRef mailContentRef = new MailContentRef();
	    //將hamb0601Form資料拷貝至mailContentRef物件
	    BeanUtils.copyProperties(mailContentRef, hamb0601Form);
	    //呼叫MailContent物件之sendMail(year,month,kind) Method,發送郵件至各受分配單位
//		MailContent.sendMail(year,month,"2",date,count);
//		setAlertMessage(request,"發送成功");
		try{
	    	MailContent.sendMail(year,month,"2",date,count);
			setAlertMessage(request,"發送成功");
	    }
		catch(Exception e){
			setAlertMessage(request,"發送失敗");
			e.printStackTrace();
		}
	}
}
