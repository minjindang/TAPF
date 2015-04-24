package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.account.form.Eamb0102Form;
import tw.gov.nta.account.form.Eamb0103Form;
import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class EAMB0103 extends DefaultAction
{
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
        //將查詢條件放入資料庫中對應之欄位
        //使用DebitCodeManage.query對輸入之資料(Dto)作查詢
		Eamb0102Form myform = (Eamb0102Form)form;
		
		Session session = IssueMainDAO.getInstance().getSession();
		
		Integer issueId = myform.getIssueMain().getId();
		
		IssueMain issue = (IssueMain)session.get(IssueMain.class,issueId);
		
		myform.setIssueMain(issue);
		StringBuffer queryString = new StringBuffer();
		queryString.append(" from VoucherMain v ");
		queryString.append(" where v.issueId = :issueId ");
		queryString.append("   and v.voucherType = :voucherType ");

		Query query = session.createQuery(queryString.toString());
		
		Integer voucherType = (Integer)request.getSession().getAttribute("voucherType");
		
		query.setInteger("issueId",issue.getId());
		query.setInteger("voucherType",voucherType);
		
		List queryList = query.list();
		
		if (queryList.size()!=0) {
			List<Eamb0103Form> voucherList = new ArrayList<Eamb0103Form>();
			VoucherMain voucher;
			
			for(Iterator iterator=queryList.iterator();iterator.hasNext();)
			{
				Eamb0103Form eamb0103Form = new Eamb0103Form();
				voucher = (VoucherMain)iterator.next();
				if (voucher.getVoucherType().equals(voucherType))
				{
					BeanUtils.copyProperties(eamb0103Form,voucher);
					voucherList.add(eamb0103Form);
				}
			}
	
			myform.setVoucherLists(voucherList);
			request.setAttribute("collection",myform.getVoucherLists());
		}else {
			request.setAttribute("collection",queryList);
		}
		String debtTypeCode = request.getSession().getAttribute("debtTypeCode").toString();
		if(debtTypeCode.equals("A")){
			List debtList = new DebtManager().getBeanByIssue(issueId);
			request.setAttribute("debtList", debtList);
		}
	}
}
