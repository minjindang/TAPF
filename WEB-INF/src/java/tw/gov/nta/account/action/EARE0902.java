package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EARE0902 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "EARE09";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		AccountQueryForm myForm = (AccountQueryForm) form;
		String LastDate = myForm.getLastDate();
		if  (null != LastDate || !LastDate.equals("") ){
			if (Integer.parseInt(LastDate.substring(0,3))>= 100){
				map.put("A3","中華民國"+LastDate.substring(0,3)+"年12月31日");				

			 }else{
				map.put("A3","中華民國"+LastDate.substring(1,3)+"年12月31日");							
			} 
		}
		return map;
	}
}