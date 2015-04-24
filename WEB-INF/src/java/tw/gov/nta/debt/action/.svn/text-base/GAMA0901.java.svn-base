package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;

public class GAMA0901 extends DefaultAction  {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		//©I¥s Service ¬d¸ß¸ê®Æ
		IssueManager issueManager = new IssueManager();
		
		String[] cols = {"debtType","accountYear"};
		Object[] pValues = {"F","096"}; 
		String[] pConds = {"=","="};
		List list =  issueManager.Search(cols,pValues,pConds,cols);
		request.setAttribute("collection",list);
	}

}
