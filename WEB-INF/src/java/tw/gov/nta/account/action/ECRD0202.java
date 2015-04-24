package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

public class ECRD0202 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "ECRD02";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		//map.put( position, value );
		map.put("Z1","TAPF");
		return map;
	}
}