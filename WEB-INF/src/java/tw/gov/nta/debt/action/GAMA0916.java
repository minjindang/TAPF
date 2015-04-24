package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtPlanDet;

public class GAMA0916 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form;
		PlanManager planManager = new PlanManager();
		List caplist = (List)request.getSession().getAttribute("caplist");
		List rCapList = (List)request.getSession().getAttribute("rCapList");
		if(null == rCapList || 0 == rCapList.size())
		{
			rCapList = new LinkedList();
		}
		if( myform.getNowindex() <= caplist.size())
		{
			DebtPlanDet myDet = (DebtPlanDet)caplist.get(myform.getNowindex()-1);
			myDet.setDeleteMark("Y");
			rCapList.add(myDet);
			caplist.remove(myform.getNowindex()-1);
			request.getSession().setAttribute("caplist",caplist);
			//request.getSession().setAttribute("rCapList",rCapList);
			setAlertMessage(request,"刪除成功");
			
			planManager.confirm(rCapList);
		}	
		else
		{
			setAlertMessage(request,"無此資料");
		}	
	}

}
