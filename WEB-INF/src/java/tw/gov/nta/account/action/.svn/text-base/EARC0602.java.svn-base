package tw.gov.nta.account.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

public class EARC0602 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "EARC06";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		String createDate = "中華民國"+DateUtil.date2ChineseROC2(new Date());
		if (request.getAttribute("titelName") != null)
			map.put("A2",(String)request.getAttribute("titelName"));
		map.put("A4",createDate);
		return map;
	}
}