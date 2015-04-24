package tw.gov.nta.debt.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.form.Apra0101Form;

import gov.dnt.tame.common.DefaultAction;

public class APRA0100 extends DefaultAction {

	public ActionForward executeQuery(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception
	{
		String findforward = new String();
		Apra0101Form myform = (Apra0101Form)form;
		if("1".equals(myform.getReportType()))
		{
//			�ּ����ť���������Ӫ�
			if("1".equals(myform.getDisplay()))
				findforward = "doPrt1";//�O�_��ܴ��e�R�^��T(�O)
			else
				findforward = "doPrt3";//�O�_��ܴ��e�R�^��T(�_)
		}	
		else
		{
			findforward = "doPrt2";//�ּ����ť�������J�`��
		}	
		return mapping.findForward(findforward);
		
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub

	}

}
