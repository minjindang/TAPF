/* FAMA0201.java
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
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.system.common.BudgetCodeManager;
import tw.gov.nta.system.form.Fama0201Form;

/**
 * @author EricChen
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class FAMA0201 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO �۰ʲ��ͤ�k Stub
		
		// ���o formBean
		Fama0201Form myform = (Fama0201Form) form;
		BudgetRef budgetMain = new BudgetRef();
		BeanUtils.copyProperties(budgetMain,myform);
		budgetMain.setBudgetName(myform.getQrybudgetName());
		budgetMain.setBudgetType(myform.getQrybudgetType());
		//�ϥ�Service:BudgetCodeManager
		//�ϥ� BudgetCodeManager.query
	
		//TODO
		List list = (List)BudgetCodeManager.query(budgetMain);
		//return to jsp
	    request.setAttribute("collection",list);
		
	}

}
