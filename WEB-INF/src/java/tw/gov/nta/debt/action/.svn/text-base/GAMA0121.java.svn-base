package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cima0101Form;

public class GAMA0121 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form;
		List ratelist = (List)request.getSession().getAttribute("ratelist");
//		List rRateList = (List)request.getSession().getAttribute("rRateList");
//		if(null == rRateList || 0 == rRateList.size())
//		{
//			rRateList = new LinkedList();
//		}
		if( myform.getNowindex() <= ratelist.size())
		{
//			DebtRateDet myRate = (DebtRateDet)ratelist.get(myform.getNowindex());
//			rRateList.add(myRate);
			ratelist.remove(myform.getNowindex()-1);
			request.getSession().setAttribute("ratelist",ratelist);
//			request.getSession().setAttribute("rRateList",rRateList);
			setAlertMessage(request,"刪除成功");
		}	
		else
		{
			setAlertMessage(request,"無此資料");
		}	
	}

}
