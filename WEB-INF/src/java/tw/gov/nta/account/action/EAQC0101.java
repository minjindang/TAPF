package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.account.common.AccountManager;
import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.account.dao.VoucherMainDAO;
import tw.gov.nta.sql.debt.DebtTypeRef;

public class EAQC0101 extends DefaultAction {

	@SuppressWarnings("static-access")

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		AccountQueryForm myForm = (AccountQueryForm)form;
		
		DebtTypeRef debtTypeRef = (DebtTypeRef)request.getSession().getAttribute("debtType");
			
		Session session = VoucherMainDAO.getInstance().createNewSession();
		
		StringBuffer queryString = new StringBuffer();
		queryString.append("select a from VoucherMain a , IssueMain i ");
		queryString.append(" where a.debtType = ? ");
		queryString.append("   and a.delete = ? ");
		queryString.append("   and a.issueId = i.id ");
		if(myForm.getAccountYear()!=null && myForm.getAccountYear().trim().length()>0){
			String voucherStartDate = null;
			String voucherEndDate = null;
			if(!"0".equals(myForm.getMonth())) {
				voucherStartDate = myForm.getSQLAccountYear()+"/"+myForm.getMonth()+"/"+"01";
				voucherEndDate = myForm.getSQLLastDate();
			}else {
				voucherStartDate = myForm.getSQLAccountYear()+"/01/01";
				voucherEndDate = myForm.getSQLYearLastDate();
			}

			queryString.append(" and a.voucherDate between '"+voucherStartDate+"' and '"+voucherEndDate+"'");
		}		

		
		if(myForm.getIssueYear()!=null && myForm.getIssueYear().trim().length()>0){
			
			queryString.append(" and exists(select 1 from IssueMain b where b.id = a.issueId and b.accountYear ='"+myForm.getIssueYear()+"')");
		}	
		
		if(myForm.getIssueId()!=0) {
			queryString.append(" and a.issueId="+myForm.getIssueId());
		}
		
		if(myForm.getVoucherType() != 0) {
			if(myForm.getVoucherType() == 3)
				queryString.append(" and a.voucherType in (3,4)");
			else
				queryString.append(" and a.voucherType="+myForm.getVoucherType());
		}
		
		if(myForm.getVoucherNo()!=null&&!"".equals(myForm.getVoucherNo())){
			queryString.append(" and a.voucherNo='"+myForm.getVoucherNo()+"'");
		}
		
		if(myForm.getIsPost() != null && myForm.getIsPost().trim().length()>0){
			if(myForm.getIsPost().equals("Y"))
				queryString.append(" and a.postDate is not null");
			else if(myForm.getIsPost().equals("N"))
				queryString.append(" and a.postDate is null");
		}		
		
		if("2".equals(myForm.getSortType())){
			queryString.append(" order by a.voucherDate,i.issueSerial,a.voucherType,a.phase.phaseSerial");
		}else {
			queryString.append(" order by i.issueSerial,a.voucherDate,a.voucherType,a.phase.phaseSerial");
		}
		Query query = session.createQuery(queryString.toString());
		
		query.setParameter(0,debtTypeRef);
		query.setParameter(1,false);

		List<VoucherMain> voucherList = query.list();
		
		for(Iterator iterator=voucherList.iterator();iterator.hasNext();) {
			VoucherMain voucher = (VoucherMain)iterator.next();
			voucher.setVoucherDets(AccountManager.sortVoucherDet(voucher.getVoucherDets()));
		}
		
		voucherList = DebtAccountManager.sortVoucher(voucherList);
		request.setAttribute("collection",voucherList);
		
		session.close();
	}

}
