package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Aima0101MForm;

public class AIMA0101QAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0101MForm actionForm = (Aima0101MForm) form;
		String[] tCols = new String[7];
		String[] tConds = new String[7];
		Object[] tValue = new Object[7];
		if(actionForm.getQryIssueSerial() != null && !"".equals(actionForm.getQryIssueSerial())){
			tValue[0] = actionForm.getQryIssueSerial() + "%";
			tCols[0] = "issueSerial";
			tConds[0] = "like";
		}
		if(actionForm.getQryIssueDateStart() != null && actionForm.getQryIssueDateEnd() != null){
			tValue[1] = actionForm.getQryIssueDateStart();
			tCols[1] = "issueDate";
			tConds[1] = ">=";
			tValue[2] = actionForm.getQryIssueDateEnd();
			tCols[2] = "issueDate";
			tConds[2] = "<=";
		}
		if(actionForm.getQryDebtCode() != null && actionForm.getQryDebtCode().intValue() != 0){
			tValue[3] = actionForm.getQryDebtCode();
			tCols[3] = "debtCode";
			tConds[3] = "=";
		}
		if(actionForm.getQryBudgetCode() != null && actionForm.getQryBudgetCode().intValue() != 0){
			tValue[4] = actionForm.getQryBudgetCode();
			tCols[4] = "budgetCode";
			tConds[4] = "=";
		}
		//只查公債
		tValue[5] = "A";
		tCols[5] = "debtType";
		tConds[5] = "=";
		//只查增額
		tValue[6] = "1";
		tCols[6] = "bondKind";
		tConds[6] = "=";
		List list = new IssueManager().Search(tCols, tValue, tConds, new String[]{"accountYear","serialNo"});
		request.setAttribute("collection",list);
		
	}
}
