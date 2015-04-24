/* BIMA0103.java
 �{���ت��GBIMA01
 �{���N���GBIMA01
 �{������G0950303
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.exchequer.action;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TreasuryIssueManager;
import tw.gov.nta.exchequer.form.Bima0101Form;

import gov.dnt.tame.common.DefaultAction;

public class BIMA0103 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		 // ���o�e�����
		 Bima0101Form myForm = (Bima0101Form)form;
		 if(myForm.getQryaccountYear()!=null ||myForm.getQrybudgetCode()!=null||myForm.getQrydebtCode()!=null||myForm.getQrydebtName()!=null)
		 {
			 Integer debtCode = myForm.getQrydebtCode();
			 Integer budgetCode = myForm.getQrybudgetCode();
			 if (debtCode ==0 )
				 debtCode = null;
			 if (budgetCode ==0 )
				 budgetCode = null;
			 
			 String[] clos = {"debtCode","budgetCode","accountYear","id","debtType"};
			 Object[] values={debtCode,budgetCode,myForm.getQryaccountYear(),(myForm.getQrydebtName().intValue() == 0)?null:myForm.getQrydebtName(),"B"};
			 String[] cond={"=","=","like","=","="};
			 String[] orderby={"issueSerial","accountYear"};
			 // ���d�� Service:TreasuryIssueManager
			 TreasuryIssueManager myManager = new TreasuryIssueManager();
			 List list = (List)myManager.search(clos,values,cond,orderby,true);
			 // ���e��
			 request.setAttribute("collection",list);
		 }
	}
}
