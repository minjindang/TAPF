/* CPMA0105.java
 程式目的：CPMA01 查詢
 程式代號：CPMA01
 程式日期：0950303
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Cpma0101Form;


public class CPMA0105 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
		   Cpma0101Form myform= (Cpma0101Form) form;
		   IssueManager myManager = new IssueManager();
		   myform.setAccountYear(myform.getQryaccountYear());
		   myform.setDebtName(myform.getQrydebtName());
		   String pcols[] = {"accountYear","debtName","debtType"};
		   String pValues[] = {myform.getAccountYear()+"%",myform.getDebtName()+"%","C"};
		   String pConds[] = {"like","like","="};
		   List list = myManager.Search(pcols,pValues,pConds,pcols);		//做查詢
		   request.setAttribute("collection",list);
	}
}
