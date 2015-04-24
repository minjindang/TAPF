/* CIMA0101.java
 �{���ت��GCIMA01
 �{���N���GCIMA01
 �{������G0950307
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.IssueMain;

public class CIMA0101 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		try
		{
				Cima0101Form myForm = (Cima0101Form)form;
				//�I�s Service �s�W���
				myForm.setUserid(this.getUserId(request));
				myForm.setModDate(new Date());
				IssueManager myManager = new IssueManager();
				myForm.setDebtType("C");		//�ŰȧO�g����
				if("on".equals(myForm.getBondType()))
				{
					myForm.setBondType("1");	//true
				}
				else
				{
					myForm.setBondType("2");	//false
				}
				myForm.setExpectAmount(myForm.getExpectAmount().setScale(4,5));
				
				myForm.getMyIss().setAverageRate(new BigDecimal(0));
				myForm.getMyIss().setCapitalAmount(new BigDecimal(0));
				myForm.getMyIss().setInterestAmount(new BigDecimal(0));
				myForm.getMyIss().setRateKind("0");
				
				myForm.getMyIss().setBudgetCode(0);
				myForm.getMyIss().setDebtCode(0);
				
				myManager.confirm(myForm.getMyIss());
				setAlertMessage(request,"�s�W���\");
				IssueMain myIssue = new IssueMain();
				myIssue = myManager.getBean(myForm.getId());
				if(null == myIssue.getIssueAmount())
				{
					myIssue.setIssueAmount(new BigDecimal(0));
				}
				if(null == myIssue.getCapitalAmount())
				{
					myIssue.setCapitalAmount(new BigDecimal(0));
				}
				myForm.setMyIss(myIssue);
				//��s�W�ᤣ�|��Detail request.setAttribute("collection",myDManager.getBeanByIssue(myForm.getId()));
		}
		catch(Exception e)
		{
			setAlertMessage(request,"�s�W����");
		}
	}

}
