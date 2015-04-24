package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

public class GARA4302 extends JacobReportAction {
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA43";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		if (null != request.getAttribute("accountYear") && !request.getAttribute("accountYear").equals("")){
			map.put("A2","中央政府概括承受台灣省政府債務"+request.getAttribute("accountYear")+"年度還本付息表");
			map.put("B4",request.getAttribute("accountYear")+"年度初未償餘額(本金)");
			map.put("D4",request.getAttribute("accountYear")+"年度債務還本及債務付息數");
			map.put("G4",request.getAttribute("accountYear")+"年度底未償餘額(本金)");
		}
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
