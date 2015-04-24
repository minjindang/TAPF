package tw.gov.nta.central.action;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
public class HAMA0405 extends JacobReportAction{
	@Override
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "HAMA04";
	}
	@SuppressWarnings({"static-access","unchecked"})
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("F3","製表日期:"+DateUtil.date2ROCStr(new Date(),"yyy/mm/dd"));
		return map;
	}
}
