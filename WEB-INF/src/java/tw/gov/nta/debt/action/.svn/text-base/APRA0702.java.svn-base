package tw.gov.nta.debt.action;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra0701Form;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;
import gov.dnt.tame.util.StringUtil;

public class APRA0702 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA07";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra0701Form myform = (Apra0701Form)form;
		//map.put("usrId","TAPF");
		StringBuffer startDate = new StringBuffer(DateUtil.date2ChineseROC2(myform.getCloseSdate()));
		StringBuffer endDate= new StringBuffer(DateUtil.date2ChineseROC2(myform.getCloseEdate()));
		
		map.put("A2", new StringUtil().addMark(("中華民國 " + startDate + "至" + endDate),3," ",true));
		map.put("C4","製表日期："+DateUtil.date2ROCStr(new Date(),"yyy/MM/dd" ));
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}
