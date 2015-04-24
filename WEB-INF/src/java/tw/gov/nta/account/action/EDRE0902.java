/**
 * @author Andrew Sung
 * @create 2006/4/12
 */

package tw.gov.nta.account.action;

import gov.dnt.tame.common.CheckNullValue;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;


public class EDRE0902 extends JacobReportAction
{
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		
		map.put("A2",CheckNullValue.checkNullPasueEmpty(request.getAttribute("debt_name")));
		map.put("Z2",CheckNullValue.checkNullPasueEmpty(request.getAttribute("budget_name")));
		map.put("Z3",String.valueOf(request.getAttribute("daycount")));
		AccountQueryForm myForm = (AccountQueryForm) form;
		String LastDate = myForm.getLastDate();
		if  (null != LastDate || !LastDate.equals("") ){
			if (Integer.parseInt(LastDate.substring(0,3))>= 100){
				map.put("A4","���إ���"+LastDate.substring(0,3)+"�~"+LastDate.substring(3,5)+"��"+LastDate.substring(5,7)+"��");				

			 }else{
				map.put("A4","���إ���"+LastDate.substring(1,3)+"�~"+LastDate.substring(3,5)+"��"+LastDate.substring(5,7)+"��");							
			} 
		}

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
		return "EDRE09";
	}
}