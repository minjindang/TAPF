/* BIMA0106.java
 �{���ت��GBIMA01
 �{���N���GBIMA01
 �{������G0950303
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.exchequer.form.Bima0101Form;

public class BIMA0106 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
		//���o�e�����
		  Bima0101Form myForm = (Bima0101Form)form;
		// �� �o����id ���d�߰ʧ@ ���o�Ų����
		  TicketManager myManager = new TicketManager();
		  List list = (List)myManager.getBeanByIssue(myForm.getIssueMain().getId());
		// ���e��
		  request.setAttribute("collection",list);
		
	}

}
