package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EARE1302 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "EARE13";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		AccountQueryForm myForm = (AccountQueryForm) form;
		String LastDate = myForm.getLastDate();
		if  (null != LastDate || !LastDate.equals("") ){
			if (Integer.parseInt(LastDate.substring(0,3))>= 100){
				map.put("A4","中華民國"+LastDate.substring(0,3)+"年"+LastDate.substring(3,5)+"月"+LastDate.substring(5,7)+"日");				

			 }else{
				map.put("A4","中華民國"+LastDate.substring(1,3)+"年"+LastDate.substring(3,5)+"月"+LastDate.substring(5,7)+"日");							
			} 
		}
		
		//map.put( position, value );
		//map.put("Z1","TAPF");
		return map;
	}
}