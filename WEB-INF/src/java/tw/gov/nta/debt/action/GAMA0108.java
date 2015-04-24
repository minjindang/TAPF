/* GAMA0108.java
 �{���ت��GGAMA01
 �{���N���GGAMA01
 �{������G0950307
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */

package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.MiddleDebtManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtMain;

public class GAMA0108 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form;
		//�I�s Service �s�W���
		MiddleDebtManager myManager = new MiddleDebtManager();
		DebtManager myDManager = new DebtManager();
		DebtMain myDebt = new DebtMain();
		try
		{
			if(null !=  myform.getCountRow() && 0 != myform.getCountRow().length )  
			{
				for(int index=0;index<myform.getCountRow().length;index++)
				{	
						myDebt = myDManager.getBean(myform.getCountRow()[index]);
						if(null != myform.getIscheck()[index]  && myform.getCountRow()[index] == Integer.parseInt(myform.getIscheck()[index]))
						{	
							myDebt.setAccrue("Y");
						}
						else
						{
							myDebt.setAccrue("N");
						}
						myManager.confirm(myDebt);
				}	
				setAlertMessage(request,"�ק令�\");
			}
		}
		catch(Exception e)
		{
			setAlertMessage(request,"�ק異��");
		}
	
	}

}
