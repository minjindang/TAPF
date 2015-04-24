package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;


import tw.gov.nta.account.form.Eamb0102Form;
import tw.gov.nta.account.form.Eamb0104Form;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.debt.DebtTypeRef;

public class EAMB0111 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
	// TODO Auto-generated method stub
//	        Eama0101Form eama0101Form =  form;
        //將查詢條件放入資料庫中對應之欄位
        //使用DebitCodeManage.query對輸入之資料(Dto)作查詢
		Eamb0102Form myform = (Eamb0102Form)form;
		String account = request.getParameter("account");
		Integer accountId = null;
		if(account !=null) {
			accountId = Integer.valueOf(account.trim());
		}
		Eamb0104Form eamb0104Form = new Eamb0104Form();
		DebtTypeRef debtType= (DebtTypeRef)request.getSession().getAttribute("debtType");
		eamb0104Form.getAccount().setDebtType(debtType);
		String voucherType = request.getParameter("voucherType");
		if(voucherType != null) {
			eamb0104Form.setVoucherType(Integer.parseInt(voucherType.trim()));
		}
		eamb0104Form.getIssueMain().setId(myform.getIssueMain().getId());
		eamb0104Form.getIssueMain().setDebtType(myform.getIssueMain().getDebtType());
		List voucherList = (List)request.getSession().getAttribute("voucherList");
		if(voucherList != null && voucherList.size() > 0 && account !=null) {
			VoucherMain voucher = (VoucherMain)voucherList.get(0);
			for(Iterator iterator = voucher.getVoucherDets().iterator();iterator.hasNext();) {
				VoucherDet voucherDet = (VoucherDet)iterator.next();
				if (voucherDet.getAccount().getId().equals(accountId)){
					eamb0104Form.getAccount().setId(accountId);
					eamb0104Form.getAccount().setAccountName(voucherDet.getAccount().getAccountName());
					eamb0104Form.setAccountAmount(voucherDet.getAccountAmount());
					eamb0104Form.setAccountType(voucherDet.getAccountType());
				}
			}
		}

		String makeDate = request.getParameter("date(voucherDate)");
		request.setAttribute("date(voucherDate)",makeDate.trim());
		String issueId = request.getParameter("issueMain.id");
		request.setAttribute("issueMain.id",issueId);
		eamb0104Form.getIssueMain().setId(Integer.valueOf(issueId.trim()));
		String debtTypeCode = request.getParameter("issueMain.debtType");
		request.setAttribute("issueMain.debtType",debtTypeCode);
		request.setAttribute("voucherType",voucherType);
		String phaseId = request.getParameter("phaseId");
		request.setAttribute("phaseId",phaseId);
		String issueKind = request.getParameter("issueKind");
		request.setAttribute("issueKind",issueKind);
		String remark = request.getParameter("remark");
		request.setAttribute("Eamb0104Form",eamb0104Form);
		request.setAttribute("remark",remark);
	}

}
