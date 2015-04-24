package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cprb0301Form;

public class CPRB0302 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "CPRB03";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Cprb0301Form myform = (Cprb0301Form)form;
		String startDate = "";
		String endDate = "";
		if(null != myform.getStartDate() && !"".equals(myform.getStartDate()))
		{
			startDate = DateUtil.date2ChineseROC(myform.getStartDate());
		}	
		if(null != myform.getEndDate() && !"".equals(myform.getEndDate()))
		{
			endDate = DateUtil.date2ChineseROC(myform.getEndDate());
		}
		
		map.put("usrId","TAPF");
		map.put("dateRange","¦Û" + startDate + "¦Ü" + endDate );
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
