/**
*
* @author Andrew Sung
* @createDate 2006/6/6
*/
package tw.gov.nta.account.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.account.Eaqc01Rpt;
import tw.gov.nta.sql.debt.account.dao.Eaqc01RptDAO;

public class EAQC0104 extends JacobReportAction {

	@Override
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "EAQC01";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		AccountQueryForm myForm = (AccountQueryForm)form;
		LinkedHashMap<String, Object> map = new LinkedHashMap<String,Object>();
		String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		DebtTypeRef debtTypeRef = (DebtTypeRef)request.getSession().getAttribute("debtType");
		map.put("A1",debtTypeRef.getTypeName()+"會計管理系統傳票清單");
		List voucherList = (List)request.getAttribute("collection");
		Eaqc01RptDAO dao = new Eaqc01RptDAO();
		Session session = dao.getSession();
		Transaction tx= session.beginTransaction();
		Query query = session.createQuery("delete Eaqc01Rpt");
		query.executeUpdate();
		tx.commit();
		session.close();
//		Query delQuery = dao.getSession().createQuery("delete from Eaqc01Rpt");
//		delQuery.executeUpdate();
		for(Iterator it = voucherList.iterator();it.hasNext();){
			VoucherMain voucherMain = (VoucherMain)it.next();
			Eaqc01Rpt dto = new Eaqc01Rpt();
			dto.setVoucherNo(voucherMain.getVoucherNo());
			dto.setVoucherDate(voucherMain.getVoucherDate());
			int i = 0;
			for(Iterator itDets = voucherMain.getVoucherDets().iterator();itDets.hasNext();){
				if(i != 0){
					dto.setVoucherNo(null);
					dto.setVoucherDate(null);
				}
				VoucherDet voucherDet = (VoucherDet)itDets.next();
				dto.setAccountName(voucherDet.getAccount().getAccountName());
				dto.setAccountAmountD((voucherDet.getAccountType().equals("D"))?voucherDet.getAccountAmount():null);
				dto.setAccountAmountC((voucherDet.getAccountType().equals("C"))?voucherDet.getAccountAmount():null);
				dao.save(dto);
				i++;
			}
			dao.save(new Eaqc01Rpt());
		}
		return map;
	}
}
