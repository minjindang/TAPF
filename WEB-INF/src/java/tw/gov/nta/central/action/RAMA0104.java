package tw.gov.nta.central.action;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
public class RAMA0104 extends JacobReportAction{
	@Override
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "RAMA01";
	}
	@SuppressWarnings({"static-access","unchecked"})
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("A2","製表日期:"+DateUtil.date2ROCStr(new Date(),"yyy/mm/dd"));
		return map;
	}
}
