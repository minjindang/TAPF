package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.Eamb0103Form;
import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.debt.DebtTypeRef;

public class EAMB0106 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
	// TODO Auto-generated method stub
//	        Eama0101Form eama0101Form =  form;
        //將查詢條件放入資料庫中對應之欄位
        //使用DebitCodeManage.query對輸入之資料(Dto)作查詢
		List voucherList;
		boolean isSpecial = false;
		DebtAccountManager manager = new DebtAccountManager();
		Eamb0103Form myForm = (Eamb0103Form)form;
		
		int voucherType = (Integer)request.getSession().getAttribute("voucherType");
		DebtTypeRef debtType = (DebtTypeRef)request.getSession().getAttribute("debtType");
		
		if (voucherType == 0)
			isSpecial = true;
		
		voucherList = manager.generateVoucherByIssue(myForm.getIssueMain().getId(),voucherType,this.getUserId(request),isSpecial,debtType);
		
		request.getSession().setAttribute("voucherList",voucherList);
		String makeDate = (String)request.getAttribute("date(voucherDate)");
		String remark = (String)request.getAttribute("remark");
		
		if (makeDate == null) {
			makeDate =DateUtil.getSystemDate();
			request.setAttribute("date(voucherDate)",makeDate);
		}
		if (remark == null) {
			remark ="";
			request.setAttribute("remark",remark);
		}
	}
}
