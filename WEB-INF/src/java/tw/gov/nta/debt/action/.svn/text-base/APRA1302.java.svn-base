package tw.gov.nta.debt.action;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra1301Form;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;
import gov.dnt.tame.util.StringUtil;

public class APRA1302 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA13";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra1301Form myform = (Apra1301Form)form;
		//map.put("usrId","TAPF");
		StringUtil strUtil = new StringUtil();
		map.put("B2",strUtil.addMark("中華民國" + DateUtil.date2ChineseROC2(myform.getCloseSdate())+ "至"+ DateUtil.date2ChineseROC2(myform.getCloseEdate()) ,3," ",true));
		return map;
	} 
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
