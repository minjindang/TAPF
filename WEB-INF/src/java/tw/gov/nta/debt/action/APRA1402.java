package tw.gov.nta.debt.action;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra1401Form;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

public class APRA1402 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA14";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra1401Form myform = (Apra1401Form)form;
		//map.put("K1","TAPF");
		map.put("A2","中華民國"+ DateUtil.date2ChineseROC2(myform.getCloseSdate()) + "至" + DateUtil.date2ChineseROC2(myform.getCloseEdate()));
		map.put("Z1",(String)request.getAttribute("bankCName"));
		
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
