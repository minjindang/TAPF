package tw.gov.nta.central.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.form.Harb1001Form;

public class HARB1002 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "HARB10";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Harb1001Form myform = (Harb1001Form)form;
		//map.put("usrId","TAPF");
		Date date = new Date();
		map.put("A3","中華民國"+ (date.getYear()-11)+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日");
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
