/*
 * �b 2006/2/23 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.central.action;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb0701Form;
import gov.dnt.tame.common.DefaultAction;

/**
 * @author Jack Du
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class HAMC0701 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//���o formBean
		//�d�ߦU���q�l�l�󱵦�����
		Hamb0701Form myform = (Hamb0701Form) form;
		//myform.setMonKind("1");  //loadpage�ɳ]�m �ثe�S�� Action ���δ���
		
		myform.setAllYear(myform.getQryallYear());
		myform.setAllMonth(myform.getQryallMonth());
		myform.setUnitId(myform.getQryunitId());
		myform.setUnitName(myform.getQryunitName());
		
		List list = UnitAllocate.getMailRecord(myform.getAllYear(),myform.getAllMonth(),myform.getMonKind());
		//return to jsp
	    request.setAttribute("collection",list);
	}
	
}
