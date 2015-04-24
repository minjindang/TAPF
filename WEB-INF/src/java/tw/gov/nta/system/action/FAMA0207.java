/* FAMA0207.java
�{���ت��GFAMA02
�{���N���GFAMA02
�{������G0950222
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.system.common.BudgetCodeManager;
import tw.gov.nta.system.form.Fama0201Form;

/**
 * @author EricChen
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class FAMA0207 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception
	 {
		// TODO �۰ʲ��ͤ�k Stub
		Fama0201Form myform = (Fama0201Form) form;
		
		myform.setCreateDate( new Date() );
		myform.setModDate( new Date() );
		myform.setUsrid(this.getUserId(request));

		BudgetRef myBudget = new BudgetRef();
		myBudget.setBudgetType(myform.getBudgetType());
		List list = BudgetCodeManager.isModify(myBudget);
		
		if(null == list || 0 == list.size())
		{	
			//�ϥ�Service:BudgetCodeManager
			//�ϥ� BudgetCodeManager.create �s�W
			BudgetCodeManager.create(myform.getMyDto());
			setAlertMessage(request,"�s�W���\");
			return mapping.findForward("success");
		}
		else
		{
			setAlertMessage(request,"�s�W����");
			myform.setBudgetName("");
			myform.setBudgetType("");
			myform.setRemark("");
			return mapping.findForward("failure");
		}	
	}
	public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	
    }
}
