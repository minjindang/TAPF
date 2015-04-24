/**
 * @author Andrew Sung
 * @create 2006/3/31
 */

package tw.gov.nta.mediumterm.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

public class CIRA0202 extends JacobReportAction
{

	protected String getProgramId(HttpServletRequest request) {
		return "GARA04";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		//map.put("usrId","TAPF");
		//map.put("aa","aa");
		//map.put("bb","bb");
		//map.put("cc","cc");
		//map.put("dd","dd");
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
