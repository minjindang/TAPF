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

import tw.gov.nta.account.form.AccountQueryForm;

public class EBRE0705 extends JacobReportAction
{
	
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		//Ebre0701Form myForm = (Ebre0701Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		//String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		map.put("Z1",(String)request.getAttribute("debt_name"));
		map.put("Z2",(String)request.getAttribute("budget_name"));
		map.put("Z3",((AccountQueryForm)form).getSQLLastDate());
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