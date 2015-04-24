/*
 * �b 2006/2/20 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitPercent;
import tw.gov.nta.central.form.Hara0401Form;

/**
 * @author AndrewSung
 * �I�sUnitPercent��getByYear(),�H�p�b�~�׶i��d�ߨ����t�������t��Ҹ��
 */
public class HARA0401 extends DefaultAction
{ 
    public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception 
	{
        Hara0401Form hara0401Form = (Hara0401Form) form;  
		List list =(List)UnitPercent.getByYear(hara0401Form.getUnitPercentDet());	
		//return to jsp
		request.setAttribute("collection",list);
	}
}