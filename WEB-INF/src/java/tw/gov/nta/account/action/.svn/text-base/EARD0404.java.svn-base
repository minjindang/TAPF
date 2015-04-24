/**
 * @author Andrew Sung
 * @create 2006/4/12
 */

package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

public class EARD0404 extends JacobReportAction
{
	
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		//Ebre0701Form myForm = (Ebre0701Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		if ("EARD04B".equals((String)request.getAttribute("file"))){
			map.put("Z1",request.getAttribute("debt_short_name"));
			map.put("Z2",request.getAttribute("serial_no"));
			map.put("Z3",request.getAttribute("issue_date"));
		}
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form,request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return (String)request.getAttribute("file");
	}


	
}