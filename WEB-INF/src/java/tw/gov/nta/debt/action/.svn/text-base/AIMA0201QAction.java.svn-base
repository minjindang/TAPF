package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Aima0201MForm;
import tw.gov.nta.sql.debt.IssueMain;

public class AIMA0201QAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
			Aima0201MForm aima0201MForm = (Aima0201MForm) form;
			String[] tCols = new String[7];
			String[] tConds = new String[7];
			Object[] tValue = new Object[7];
			if(aima0201MForm.getQryIssueSerial() != null && !"".equals(aima0201MForm.getQryIssueSerial())){
				tValue[0] = aima0201MForm.getQryIssueSerial()+"%";
				tCols[0] = "issueSerial";
				tConds[0] = "like";
			}
			if(aima0201MForm.getQryIssueDateStart() != null){
				tValue[1] = aima0201MForm.getQryIssueDateStart();
				tCols[1] = "issueDate";
				tConds[1] = ">=";
			}
			if(aima0201MForm.getQryIssueDateEnd() != null){
				tValue[2] = aima0201MForm.getQryIssueDateEnd();
				tCols[2] = "issueDate";
				tConds[2] = "<=";
			}
//			if(aima0201QForm.getQryDebtCode() != null && aima0201QForm.getQryDebtCode().intValue() != 0){
//				tValue[3] = aima0201QForm.getQryDebtCode();
//				tCols[3] = "debtCode";
//				tConds[3] = "=";
//			}
//			if(aima0201QForm.getQryBudgetCode() != null && aima0201QForm.getQryBudgetCode().intValue() != 0){
//				tValue[4] = aima0201QForm.getQryBudgetCode();
//				tCols[4] = "budgetCode";
//				tConds[4] = "=";
//			}
			//只查公債
			tValue[5] = "A";
			tCols[5] = "debtType";
			tConds[5] = "=";
			//只查增額
			tValue[6] = "3";
			tCols[6] = "bondKind";
			tConds[6] = "=";

			IssueManager manager = new IssueManager();
			List<Map> collection = new LinkedList<Map>();
			List addIssueMainList = manager.Search(tCols, tValue, tConds, new String[]{"accountYear","serialNo"});
			for(Iterator it=addIssueMainList.iterator();it.hasNext();)
			{
				IssueMain issueMain = (IssueMain) it.next();
				Map<String,Object> map = new HashMap<String,Object>();
				map.put( "id", issueMain.getId() );
				map.put( "sourceIssueId", (issueMain.getSourceIssueId()!= null)?issueMain.getSourceIssueId():issueMain.getId() );
				map.put( "issueSerial", issueMain.getIssueSerial() );
				map.put( "issueDate", issueMain.getIssueDate() );
//				map.put( "budgetName", BudgetCodeManager.findBudgetName(issueMain.getBudgetCode()) );
//				map.put( "debitName", DebitCodeManage.findDebitName(issueMain.getDebtCode()) );
				map.put( "debtName", issueMain.getDebtName() );
				collection.add(map);
			}
			request.setAttribute("collection", collection);
		}
}
