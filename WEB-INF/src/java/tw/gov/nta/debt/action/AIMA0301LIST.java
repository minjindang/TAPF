/*
 * 在 2006/2/17 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.debt.form.Aima0301AForm;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;


/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class AIMA0301LIST extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0301AForm aima0301AForm = (Aima0301AForm) form;
		request.setAttribute("oklist",0);
		if(0 != aima0301AForm.getBudgetCode())
			request.setAttribute("oklist",aima0301AForm.getBudgetCode());
		if(aima0301AForm.getAccountYear() == null || "".equals(aima0301AForm.getAccountYear())){
			aima0301AForm.setIssueSerial(null);
		}
		else{
			Session tSession = new PaymentMainDAO().getSession();
			Criteria criteria = tSession.createCriteria(IssueMain.class);
			criteria.add(Expression.eq("accountYear", aima0301AForm.getAccountYear()));
			criteria.add(Expression.eq("debtType", "A"));
			List tList = criteria.list();
			IssueMain tTemp = null;
			int tTempMax;
			int tMax = 0;
			for(Iterator tIterator = tList.iterator(); tIterator.hasNext();){
				tTemp = (IssueMain) tIterator.next();
				if(tTemp.getSerialNo() == null) continue;
				tTempMax = Integer.valueOf(tTemp.getSerialNo());
				if(tTempMax > tMax)
					tMax = tTempMax;
			}
			tMax++;
			if(tMax < 10){
				aima0301AForm.setIssueSerial("A"+aima0301AForm.getAccountYear()+"5"+ "0" + tMax);
				aima0301AForm.getIssueMain().setSerialNo("0" + String.valueOf(tMax));
			}
			else{
				aima0301AForm.setIssueSerial("A"+aima0301AForm.getAccountYear()+"5"+ tMax);
				aima0301AForm.getIssueMain().setSerialNo(String.valueOf(tMax));
			}
			aima0301AForm.setDebtName(aima0301AForm.getAccountYear()+"年交"+tMax+"期");
		}

	}
}
