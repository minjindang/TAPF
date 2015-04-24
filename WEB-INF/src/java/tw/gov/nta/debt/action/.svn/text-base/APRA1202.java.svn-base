package tw.gov.nta.debt.action;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra1201Form;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

public class APRA1202 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA12";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra1201Form myform = (Apra1201Form)form;
		//map.put("usrId","TAPF");
		/*
		if(null != myform.getType())
		{	
			map.put("A2",myform.getType());
		}
		*/
		map.put("A2","中華民國"+DateUtil.date2ChineseROC2(myform.getCloseSdate())+"至"+DateUtil.date2ChineseROC2(myform.getCloseEdate()));
		map.put("I4",DateUtil.date2ChineseROC2(new Date()));
		map.put("C5",myform.getPaidaName());
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
