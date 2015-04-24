/*
 * 在 2006/2/17 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Aima0301AForm;
import tw.gov.nta.sql.debt.IssueExchangeDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueExchangeDetDAO;


/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class AIMA0301AAction extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0301AForm aima0301AForm = (Aima0301AForm) form;
		IssueMain tIssueMain = aima0301AForm.getIssueMain();
//		Calendar tCalendar = Calendar.getInstance();
//		tCalendar.setTime(tIssueMain.getIssueDate());
//		tCalendar.roll(Calendar.YEAR, tIssueMain.getIssueInterval().intValue());
//		tIssueMain.setDueDate(tCalendar.getTime());
		IssueExchangeDet tIssueExchangeDet = aima0301AForm.getIssueExchangeDet();
		Set tSet = new HashSet();
		tSet.add(tIssueExchangeDet);
		tIssueMain.setIssueExchangeDets(tSet);
		tIssueMain.setDebtType("A");
		tIssueMain.setBondKind("4");
		Calendar tCalendar2 = Calendar.getInstance();
		tIssueMain.setAccountYear(String.valueOf(tCalendar2.get(Calendar.YEAR) - 1911));
		tIssueExchangeDet.setIssue(tIssueMain);
		if(tIssueMain.getIssueAmount() != null && tIssueMain.getCapitalAmount() != null)
			tIssueExchangeDet.setTotalStockAmount(tIssueMain.getIssueAmount().subtract(tIssueMain.getCapitalAmount()));
		new IssueManager().confirm(tIssueMain);
		new IssueExchangeDetDAO().save(tIssueExchangeDet);
	}
}
