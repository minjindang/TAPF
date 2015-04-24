/**
 * @author Andrew Sung
 * @create 2006/4/12
 */

package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EDRE0702 extends JacobReportAction
{
	protected Map<String,Object> getReportParameter(ActionForm form, 
			HttpServletRequest request) 
	{
		Map<String,Object> map = new LinkedHashMap<String,Object>();

		AccountQueryForm myForm = (AccountQueryForm) form;
		String LastDate = myForm.getLastDate();
		String debtName = (String)request.getAttribute("debtName");
		String budgetName = (String)request.getAttribute("budgetName");
		String debitName = (String)request.getAttribute("debitName");
		Integer dayCount = ((Integer)request.getAttribute("dayCount"));
		
		if (debtName == null)
			debtName = "";
		
		if (budgetName == null)
			budgetName = "";
		
		if (debitName == null)
			debitName = "";
		
		String dayCountStr = "";
		
		if (dayCount != null)
			dayCountStr = dayCount.toString();
		
		map.put("C2",debtName);
		map.put("A4","預算別:"+budgetName);
		map.put("A5","債務別:"+debitName);
		map.put("A6","天期:"+dayCountStr);
		
		if  (null != LastDate || !LastDate.equals("") ){
			if (Integer.parseInt(LastDate.substring(0,3))>= 100){
				map.put("C5","中華民國"+LastDate.substring(0,3)+"年"+LastDate.substring(3,5)+"月"+LastDate.substring(5,7)+"日");				

			 }else{
				map.put("C5","中華民國"+LastDate.substring(1,3)+"年"+LastDate.substring(3,5)+"月"+LastDate.substring(5,7)+"日");							
			} 
		}
        map.put("Z1","TAPF");
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form,request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "EDRE07";
	}
}
