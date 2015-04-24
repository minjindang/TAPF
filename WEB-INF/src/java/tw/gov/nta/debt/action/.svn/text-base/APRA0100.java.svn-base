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
//			核撥公債本息基金明細表
			if("1".equals(myform.getDisplay()))
				findforward = "doPrt1";//是否顯示提前買回資訊(是)
			else
				findforward = "doPrt3";//是否顯示提前買回資訊(否)
		}	
		else
		{
			findforward = "doPrt2";//核撥公債本息基金彙總表
		}	
		return mapping.findForward(findforward);
		
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub

	}

}
