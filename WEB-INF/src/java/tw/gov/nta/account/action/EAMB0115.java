package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.account.common.AccountManager;
import tw.gov.nta.account.form.Eamb0103Form;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.account.dao.AccountRefDAO;
import tw.gov.nta.sql.debt.account.AccountPhaseDet;

import com.kangdainfo.ast.common.GlobalForwardNames;

public class EAMB0115 extends DefaultAction {


	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.sql.Connection)
	 */
	@Override
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {

		// TODO Auto-generated method stub
//        Eama0101Form eama0101Form =  form;
	    //將查詢條件放入資料庫中對應之欄位
	    //使用DebitCodeManage.query對輸入之資料(Dto)作查詢

		AccountManager manager = new AccountManager();
		Eamb0103Form myform = (Eamb0103Form)form;
		Integer phaseId = myform.getPhaseId();
		if(phaseId != null && phaseId !=0) {
			List voucherList = (List)request.getSession().getAttribute("voucherList");
			VoucherMain voucher = (VoucherMain)voucherList.get(0);
			StringBuffer queryString = new StringBuffer();
			queryString.append("from AccountPhaseDet phaseDet where phaseDet.accountPhase.id = ?");
			Session session = AccountRefDAO.getInstance().getSession();
			Query query = session.createQuery(queryString.toString());
			query.setParameter(0,phaseId);
			
			List phaseDetList = query.list();
			
			voucher.setVoucherDets(null);
			for(Iterator iterator = phaseDetList.iterator();iterator.hasNext();) {
				AccountPhaseDet phaseDet = (AccountPhaseDet)iterator.next();
				VoucherDet voucherDet = new VoucherDet();
				voucherDet.setAccount(phaseDet.getAccountCode());
				voucherDet.setAccountAmount(new BigDecimal(0));
				voucherDet.setAccountType(phaseDet.getAccountType());
				voucherDet.setVoucher(voucher);
				manager.addVoucherDet(voucher,voucherDet,2);
			}
		}
	//	request.getSession().setAttribute("voucherList",voucherList);

		String makeDate = request.getParameter("date(voucherDate)");
		request.setAttribute("date(voucherDate)",makeDate);
		String remark = request.getParameter("remark");
		request.setAttribute("remark",remark);
		String issueKind = request.getParameter("issueKind");
		request.setAttribute("issueKind",issueKind);
		return mapping.findForward(GlobalForwardNames.SUCCESS);
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
