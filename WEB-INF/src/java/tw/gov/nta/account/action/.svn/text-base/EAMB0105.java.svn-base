package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.common.AccountException;
import tw.gov.nta.account.common.AccountManager;
import tw.gov.nta.account.form.Eamb0102Form;
import tw.gov.nta.account.form.Eamb0103Form;

public class EAMB0105 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
	// TODO Auto-generated method stub
//	        Eama0101Form eama0101Form =  form;
        //將查詢條件放入資料庫中對應之欄位
        //使用DebitCodeManage.query對輸入之資料(Dto)作查詢
		AccountManager manager = new AccountManager();
	    Eamb0103Form myform = (Eamb0103Form)form;
		try {
			manager.cancelVoucher(myform.getId());
			
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setAlertMessage(request,e.getMessage());
		}
		Eamb0102Form eamb0102Form = new Eamb0102Form();
		

		Map parameters = request.getParameterMap();
	    parameters.put("id",myform.getIssueMain().getId());
	}
}
