/* CPMA0105.java
 �{���ت��GCPMA01 �d��
 �{���N���GCPMA01
 �{������G0950303
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
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
		   List list = myManager.Search(pcols,pValues,pConds,pcols);		//���d��
		   request.setAttribute("collection",list);
	}
}
