/* DIMA0303.java
�{���ت��GDIMA03
�{���N���GDIMA03
�{������G0950224
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtMainVectors;
import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.shortterm.form.Dima0301Form;
import tw.gov.nta.sql.debt.DebtMain;

/**
 * @author EricChen
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class DIMA0303 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO �۰ʲ��ͤ�k Stub
		Dima0301Form myform = (Dima0301Form) form;
	    DebtManager myManager = new DebtManager();
		//�ϥ� Service:DebtManager
		//�ϥ� DebtManager.confirm
	    
		for(Iterator it=myform.getDebtMains().iterator();it.hasNext();)
		{
			DebtMainVectors debtMainVectors = (DebtMainVectors) it.next();
			if(debtMainVectors!=null)
			{
				DebtMain debtMain = myManager.getBean(debtMainVectors.getId());
				debtMain.setGet(debtMainVectors.getGet());
//				if("Y".equals(debtMainVectors.getGet()))
//				{
//					debtMain.setGet("Y");
//				}
//				else
//				{
//					debtMain.setGet("N");
//				}
				debtMain.setAccrueDate( DateUtil.str2Date(debtMainVectors.getAccrueDate()) );
				myManager.confirm(debtMain);
			}
		}
		setAlertMessage(request,"���ڦ��\");
	}
}