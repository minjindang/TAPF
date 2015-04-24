package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import tw.gov.nta.account.form.Eamb0102Form;
import tw.gov.nta.account.form.Eamb0103Form;
import tw.gov.nta.account.form.Eamb0105Form;
import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.account.dao.VoucherMainDAO;

public class EAMB0104 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
	// TODO Auto-generated method stub
//	        Eama0101Form eama0101Form =  form;
        //將查詢條件放入資料庫中對應之欄位
        //使用DebitCodeManage.query對輸入之資料(Dto)作查詢
		Session session = VoucherMainDAO.getInstance().getSession();
		int voucherId = Integer.valueOf(request.getParameter("voucher_id"));
		VoucherMain voucher = (VoucherMain)session.load(VoucherMain.class,voucherId);
		Eamb0103Form eamb0103Form = new Eamb0103Form();
		eamb0103Form.setVoucherMain(voucher);
		eamb0103Form.setIssueMain(((Eamb0102Form)form).getIssueMain());
	    for(Iterator iterator=voucher.getVoucherDets().iterator();iterator.hasNext();) {
	    	Eamb0105Form eamb0105Form = new Eamb0105Form();
	    	VoucherDet voucherDet = (VoucherDet)iterator.next();
	    	Hibernate.initialize(voucherDet);
	    	eamb0105Form.setVoucherDet(voucherDet);
	    }
	    
	    Set<VoucherDet> voucherDets = DebtAccountManager.sortVoucherDet(voucher.getVoucherDets());
	    eamb0103Form.setVoucherDets(voucherDets);
	    request.setAttribute("Eamb0103Form",eamb0103Form);
	    request.setAttribute("collection",voucher.getVoucherDets());
	    session.close();
	}

}
