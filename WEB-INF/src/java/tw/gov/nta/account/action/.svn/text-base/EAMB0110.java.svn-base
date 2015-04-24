package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.account.common.AccountManager;
import tw.gov.nta.account.form.Eamb0103Form;
import tw.gov.nta.account.form.Eamb0104Form;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.debt.DebtTypeRef;

import com.kangdainfo.ast.common.GlobalForwardNames;

public class EAMB0110 extends DefaultAction {


	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.sql.Connection)
	 */
	@Override
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {

		// TODO Auto-generated method stub
//        Eama0101Form eama0101Form =  form;
	    //將查詢條件放入資料庫中對應之欄位
	    //使用DebitCodeManage.query對輸入之資料(Dto)作查詢
		Eamb0104Form myform = (Eamb0104Form)form;
		Eamb0103Form eamb0103Form = new Eamb0103Form();
		AccountManager manager = new AccountManager();
		String parameter = mapping.getParameter();
		
		if (!"Cancel".equals(parameter)) {
			VoucherDet voucherDet = myform.getVoucherDet();
			List voucherList = (List)request.getSession().getAttribute("voucherList");
			VoucherMain voucher = (VoucherMain)voucherList.get(0);
			voucherDet.setVoucher(voucher);
			manager.addVoucherDet(voucher,voucherDet,2);
		}
	//	request.getSession().setAttribute("voucherList",voucherList);
		eamb0103Form.getIssueMain().setId(myform.getIssueMain().getId());
		eamb0103Form.getIssueMain().setDebtType(myform.getIssueMain().getDebtType());
		String makeDate = request.getParameter("date(voucherDate)");
		request.setAttribute("date(voucherDate)",makeDate.trim());
		eamb0103Form.setVoucherDate(DateUtil.str2Date(makeDate.trim()));
		String remark = request.getParameter("remark");
		request.setAttribute("remark",remark);
		eamb0103Form.setRemark(remark);
		String voucherType = request.getParameter("voucherType");
		eamb0103Form.setVoucherType(Integer.valueOf(voucherType.trim()));
		String phaseId = request.getParameter("phaseId");
		try {
			eamb0103Form.setPhaseId(Integer.valueOf(phaseId.trim()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			eamb0103Form.setPhaseId(0);
			e.printStackTrace();
		}
		String issueKind = request.getParameter("issueKind");
		eamb0103Form.setIssueKind(issueKind);
		eamb0103Form.setDebtType(myform.getVoucher().getDebtType());
		request.setAttribute("Eamb0103Form",eamb0103Form);
		return mapping.findForward(GlobalForwardNames.SUCCESS);
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
