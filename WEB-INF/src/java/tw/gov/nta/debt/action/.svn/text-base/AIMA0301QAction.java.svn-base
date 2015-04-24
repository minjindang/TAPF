/*
 * 在 2006/2/17 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import tw.gov.nta.debt.form.Aima0301QForm;
import tw.gov.nta.sql.debt.IssueExchangeDet;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;


/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class AIMA0301QAction extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0301QForm aima0301QAForm = (Aima0301QForm) form;
//		String[] tCols = new String[8];
//		String[] tConds = new String[8];
//		Object[] tValue = new Object[8];
//		if(aima0301QAForm.getQryIssueSerial() != null && !"".equals(aima0301QAForm.getQryIssueSerial())){
//			tValue[0] = aima0301QAForm.getQryIssueSerial();
//			tCols[0] = "issueSerial";
//			tConds[0] = "=";
//		}
//		if(aima0301QAForm.getQryIssueDateStart() != null){
//			tValue[1] = aima0301QAForm.getQryIssueDateStart();
//			tCols[1] = "issueDateStart";
//			tConds[1] = ">=";
//		}
//		if(aima0301QAForm.getQryIssueDateEnd() != null){
//			tValue[2] = aima0301QAForm.getQryIssueDateEnd();
//			tCols[2] = "issueDateEnd";
//			tConds[2] = "<=";
//		}
//		if(aima0301QAForm.getQryBudgetCode() != null && aima0301QAForm.getQryBudgetCode().intValue() != 0){
//			tValue[3] = aima0301QAForm.getQryBudgetCode();
//			tCols[3] = "budgetCode";
//			tConds[3] = "=";
//		}
//		if(aima0301QAForm.getQryDebtCode() != null && aima0301QAForm.getQryDebtCode().intValue() != 0){
//			tValue[4] = aima0301QAForm.getQryDebtCode();
//			tCols[4] = "debtCode";
//			tConds[4] = "=";
//		}
//		if(aima0301QAForm.getQryExchangeStockCode() != null && aima0301QAForm.getQryExchangeStockCode().intValue() != 0){
//			tValue[5] = aima0301QAForm.getQryExchangeStockCode();
//			tCols[5] = "exchangeStockCode";
//			tConds[5] = "=";
//		}
//		//只查公債
//		tValue[6] = "A";
//		tCols[6] = "debtType";
//		tConds[6] = "=";
//		//只查增額
//		tValue[7] = "4";
//		tCols[7] = "bondKind";
//		tConds[7] = "=";
//		aima0301QAForm.setResultList(new TransBondManager().Search(tCols, tValue, tConds, null));
//		request.setAttribute("collection", aima0301QAForm.getResultList());
		
		
		Session tSession = new IssueMainDAO().getSession();
		Criteria tIssueExchangeDetCriteria = tSession.createCriteria(IssueExchangeDet.class);
		Criteria tIssueMainCriteria = tIssueExchangeDetCriteria.createCriteria("issue");
		IssueExchangeDet t = new IssueExchangeDet();
		if(aima0301QAForm.getQryIssueSerial() != null && !"".equals(aima0301QAForm.getQryIssueSerial()))
			tIssueMainCriteria.add(Restrictions.like("issueSerial", aima0301QAForm.getQryIssueSerial() + "%"));
		if(aima0301QAForm.getQryIssueDateStart() != null)
			tIssueMainCriteria.add(Restrictions.eq("issueDateStart", aima0301QAForm.getQryIssueDateStart()));
		if(aima0301QAForm.getQryIssueDateEnd() != null && !"".equals(aima0301QAForm.getQryIssueDateEnd()))
			tIssueMainCriteria.add(Restrictions.eq("issueDateEnd", aima0301QAForm.getQryIssueDateEnd()));
		if(aima0301QAForm.getQryBudgetCode() != null && aima0301QAForm.getQryBudgetCode().intValue() != 0)
			tIssueMainCriteria.add(Restrictions.eq("budgetCode", aima0301QAForm.getQryBudgetCode()));
		if(aima0301QAForm.getQryDebtCode() != null && aima0301QAForm.getQryDebtCode().intValue() != 0)
			tIssueMainCriteria.add(Restrictions.eq("debtCode", aima0301QAForm.getQryDebtCode()));
		if((aima0301QAForm.getQryExchangeStockCode() != null) && (aima0301QAForm.getQryExchangeStockCode().intValue() != 0))
			tIssueExchangeDetCriteria.add(Restrictions.eq("exchangeStockCode", aima0301QAForm.getQryExchangeStockCode()));
		tIssueMainCriteria.add(Restrictions.eq("debtType", "A"));		
		tIssueMainCriteria.add(Restrictions.eq("bondKind", "4"));
		aima0301QAForm.setResultList(tIssueExchangeDetCriteria.list());
		tSession.close();
		request.setAttribute("collection", aima0301QAForm.getResultList());
	}
}
