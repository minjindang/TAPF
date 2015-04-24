package tw.gov.nta.debt.action;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Apra0801Form;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

public class APRA0802 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA08";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra0801Form myform = (Apra0801Form)form;
		//map.put("usrId","TAPF");
		//map.put("A2",DateUtil.date2ChineseROC2(myform.getCloseSdate()) + "至" + DateUtil.date2ChineseROC2(myform.getCloseEdate()));
		map.put("B2",(String)request.getAttribute("Type"));
		map.put("C5","製表日期："+DateUtil.date2ROCStr(new Date(),"yyy/MM/dd" ));
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
