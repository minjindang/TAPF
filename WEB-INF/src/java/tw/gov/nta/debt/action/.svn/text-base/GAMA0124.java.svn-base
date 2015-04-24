package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.sql.debt.DebtPlanDet;

public class GAMA0124 extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		String[] list = {"newcaplist","rCapList","caplist"};
		PlanManager manager = new PlanManager();
		for(int i=0; i<list.length ; i++)
		{
			doUpdataList( manager, request, list[i] );
		}
		setAlertMessage(request,"ฝTป{งนฆจ");
	}

	public void doUpdataList(PlanManager manager,HttpServletRequest request, String listName) throws Exception 
	{
		List list = (List) request.getSession().getAttribute(listName);
		if(null != list && !list.isEmpty() )
		{	
				manager.confirm(list);
		}
		request.getSession().removeAttribute(listName);
	}
}
