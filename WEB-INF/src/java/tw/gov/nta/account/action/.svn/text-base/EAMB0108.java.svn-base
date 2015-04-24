package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.gov.nta.account.common.AccountException;
import tw.gov.nta.account.form.Eamb0102Form;
import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.DebitRef;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.account.dao.VoucherMainDAO;
import tw.gov.nta.sql.debt.account.AccountPhaseMain;
import tw.gov.nta.sql.debt.account.dao.AccountPhaseMainDAO;

public class EAMB0108 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
	// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.sql.Connection)
	 */
	@Override
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isSpecial = false;
		int voucherType = 0;
		int debtCode = 0;
		int budgetCode = 0;
		int phaseId = 0;
		AccountPhaseMain phase = null; 
		
		Eamb0102Form myForm = (Eamb0102Form)form;
		
		String issueKind = myForm.getIssueMain().getIssueKind();
		
		if ("0".equals(String.valueOf(request.getSession().getAttribute("voucherType"))))
			isSpecial = true;
		
		List voucherDateList = new ArrayList();
		
		
		String[] mark = request.getParameterValues("mark");
		String[] remark = request.getParameterValues("remark");
		String[] voucherROCDate = request.getParameterValues("date(voucherDate)");
		Object voucherDates[] = null;
		Transaction tx=null;
		try {
			if (voucherROCDate != null) {
				for(int i=0;i<voucherROCDate.length;i++) {
					Date voucherDate = DateUtil.str2Date(voucherROCDate[i]);
					if (voucherDate == null)
						throw new AccountException("日期格式錯誤(YYYMMDD)，請檢查!");
					else
						voucherDateList.add(voucherDate);
				}	
				voucherDates = voucherDateList.toArray();
			}
	
	
			DebtAccountManager manager = new DebtAccountManager();	
			VoucherMainDAO dao = new VoucherMainDAO();
			Session session = dao.getSession();
		
			if (isSpecial) {
				voucherType = Integer.parseInt(request.getParameter("voucherType"));
				debtCode = Integer.parseInt(request.getParameter("debtCode"));
				DebitRef debitCode = (DebitRef)session.get(DebitRef.class,debtCode);
				try {
					phaseId = Integer.parseInt(request.getParameter("phaseId"));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				phase = (AccountPhaseMain)session.get(AccountPhaseMain.class,phaseId);
				budgetCode = debitCode.getBudgetCode().getId();
				if(request.getParameter("issueKind") != null) {
					issueKind = request.getParameter("issueKind").trim();
				}
			}	
		
			List voucherList = (List)request.getSession().getAttribute("voucherList");
			List voucherIdList = new ArrayList();
			tx = session.beginTransaction();

			for(Iterator iterator = voucherList.iterator();iterator.hasNext();) {
				
				VoucherMain voucher = (VoucherMain)iterator.next();
				int i = ArrayUtils.indexOf(mark,voucher.getVoucherSer().toString());
				if (i > -1) {
					if (isSpecial) {		
						voucher.setVoucherType(voucherType);
						voucher.setBudgetCode(budgetCode);
						voucher.setDebtCode(debtCode);
						voucher.setPhase(phase);
						voucher.setIssueKind(issueKind);
						for(Iterator detIterator = voucher.getVoucherDets().iterator();detIterator.hasNext();) {
							if(((VoucherDet)detIterator.next()).getAccountAmount().longValue() == 0) {
								detIterator.remove();
							}
						}
					}

					voucher.setVoucherDate((Date)voucherDates[i]);
					voucher.setRemark(remark[i]);
					manager.makeVoucher(voucher,myForm.getIssueMain().getId(),session);
					voucherIdList.add(voucher.getId());

				}
			}	
			tx.commit();
			request.setAttribute("voucherIdList",voucherIdList);
		} catch (Exception e) {
			e.printStackTrace();
			if(tx != null) {
				tx.rollback();
			}
			// TODO Auto-generated catch block
			setAlertMessage(request,e.getMessage());
			request.setAttribute("date(voucherDate)",request.getParameter("date(voucherDate)"));
			request.setAttribute("remark",request.getParameter("remark"));	
			return new ActionForward("/EAM/EAMB0103M.jsp");
		}	

		
		return super.executeQuery(mapping, form, request, response, connection);
	}
	
	

}
