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

public class EDRE0802 extends JacobReportAction
{
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		AccountQueryForm myform = (AccountQueryForm) form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		//Date lastDate = DateUtil.str2Date(DateUtil.getLastDateOfMonth(myform.getAccountYear(),myform.getMonth()));
		//map.put("A4",DateUtil.date2Str(lastDate,"yyyy/MM/dd"));
		AccountQueryForm myForm = (AccountQueryForm) form;
		String LastDate = myForm.getLastDate();
		if  (null != LastDate || !LastDate.equals("") ){
			if (Integer.parseInt(LastDate.substring(0,3))>= 100){
				map.put("A4","中華民國"+LastDate.substring(0,3)+"年"+LastDate.substring(3,5)+"月"+LastDate.substring(5,7)+"日");				

			 }else{
				map.put("A4","中華民國"+LastDate.substring(1,3)+"年"+LastDate.substring(3,5)+"月"+LastDate.substring(5,7)+"日");							
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
		return "EDRE08";
	}
}
