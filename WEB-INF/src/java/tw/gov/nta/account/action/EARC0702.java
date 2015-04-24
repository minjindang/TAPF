package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

public class EARC0702 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "EARC07";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		
		if ("1".equals((String)request.getParameter("choose")))
			map.put("A2","���餽���ഫ�n������");
		else if ("2".equals((String)request.getParameter("choose")))
			map.put("A2","���餽���٥��I���g�I");
		return map;
	}
}