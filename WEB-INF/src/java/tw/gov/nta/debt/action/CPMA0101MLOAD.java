/* CPMA0101MLOAD.java
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

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DayCount;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.form.Cpma0101Form;
import tw.gov.nta.sql.debt.IssueMain;


public class CPMA0101MLOAD extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
//		�s���ܵe��cpma0102a �ǤJ�ѼƵu���ɴڸ�Ƥ�id,�v�٤��repaydate�v�٤覡debttype
		Cpma0101Form myform= (Cpma0101Form)form;
		IssueManager myManager = new IssueManager();
		IssueMain myMain = new IssueMain();
		PayManager myPay = new PayManager();
		//List Debtlist = (List) myDManager.getBeanByIssue(myform.getIssueId());
		
		
		myMain = myManager.getBean(myform.getIssueId());
		request.setAttribute("DayCount","");
		if(null != myMain.getIssueDate() && null != myMain.getDueDate())		//�d�˪��B�O�_��null
		{
			request.setAttribute("DayCount",DayCount.dayCount(myMain.getIssueDate(),myMain.getDueDate(),myMain.getShowType()));
		}
		
		if(null == myMain.getExpectAmount())		//�d�˪��B�O�_��null
		{
			myMain.setExpectAmount(new BigDecimal(0));
		}
		if(null == myMain.getIssueAmount())
		{
			myMain.setIssueAmount(new BigDecimal(0));
		}
		if(null == myMain.getCapitalAmount())
		{
			myMain.setCapitalAmount(new BigDecimal(0));
		}		
		myform.setMyMain(myMain);
		//List list = (List) myPManager.byIssueIdPDate(myform.getIssueId(),myform.getPlanRepayDate());
		List list = (List) myPay.getDataByIssue(myform.getIssueId());
		request.setAttribute("collection",list);
		request.setAttribute("showType",myMain.getShowType());
		
	}
}
