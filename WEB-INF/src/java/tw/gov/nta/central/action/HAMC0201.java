/* HAMB0201.java
 �{���ت��GHAMB02��r
 �{���N���GHAMB02
 �{������G0950222
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.form.Hamb0201Form;

/**
 * @author EricChen
 * 
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в��� ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class HAMC0201 extends DefaultAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// ���o formBean
		Hamb0201Form myform = (Hamb0201Form) form;
		myform.setUsrid(this.getUserId(request));	
		myform.setTaxKind("2");
//		myform.setMonKind("2");	//���Ȭ��U�Կ���(���ե�) 
		myform.setModDate(new Date());
		//�ϥ�Service:Taxactioin
		//�ϥ� Taxaction.updateforInfo��s
		if(myform.getId()== 0){
			Taxaction.create(myform.getTaxYear(),myform.getTaxMonth(),myform.getTaxKind(),myform.getMonNo(),myform
					.getBankno(),myform.getMonKind(),myform.getPname(),this.getUserId(request));
			setAlertMessage(request, "�s�W���\");
		}
		else{
			Taxaction.updateforInfo(myform.getId(), myform.getMonNo(), myform
					.getBankno(), myform.getMonKind(), myform.getPname());
			setAlertMessage(request, "��s���\");
		}
		
	}
}