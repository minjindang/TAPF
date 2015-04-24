/**
*
* @author Andrew Sung
* @createDate 2006/7/19
*/
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Aima0101MForm;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class AIMA0101A extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Aima0101MForm actionForm = (Aima0101MForm)form;
		actionForm.setIssueMain(new IssueMain());
		if(null == actionForm.getAccountYear())
			actionForm.setAccountYear(DateUtil.date2ROCStr(new Date()).substring(0,3));
		if(actionForm.getAccountYear().length() < 3)
			actionForm.setAccountYear("00" + actionForm.getAccountYear());
		if(actionForm.getAccountYear().length() < 2)
			actionForm.setAccountYear("0" + actionForm.getAccountYear());
		String hqlStr = "select Max(serialNo) from IssueMain where 1=1";
		hqlStr += " and accountYear ='"+actionForm.getAccountYear()+"'";
		hqlStr += " and debtType ='A'";
		hqlStr += " and bondKind = '1'";
		Session tSession = new IssueMainDAO().getSession();
		Query query = tSession.createQuery(hqlStr);
		String serialNoStr = (String) query.list().get(0);
		if(serialNoStr == null)
			actionForm.setSerialNo("01");
		else{
			Integer serialNo = Integer.parseInt(query.list().get(0).toString());
			if(serialNo < 10)
				actionForm.setSerialNo("0"+(serialNo+1));
			else
				actionForm.setSerialNo(String.valueOf(serialNo+1));
		}
		actionForm.setRepayAlternate(1);
		actionForm.setIssueSerial(actionForm.getAccountYear()+"-"+actionForm.getSerialNo());
		actionForm.setDebtName(actionForm.getAccountYear()+"年度第"+actionForm.getSerialNo()+"期中央政府建設公債");
	}
}
