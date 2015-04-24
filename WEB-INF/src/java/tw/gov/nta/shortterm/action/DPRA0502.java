package tw.gov.nta.shortterm.action;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.shortterm.form.DpraReportForm;
import tw.gov.nta.sql.debt.IssueMain;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

public class DPRA0502 extends JacobReportAction 
{

	@Override
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		DpraReportForm myForm = (DpraReportForm)form;
		return new ReportManager(myForm.getTitle(),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "DPRA05";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		DpraReportForm myForm = (DpraReportForm)form;
		Map<String,String> map = new LinkedHashMap<String,String>();
		String statrDate = (String)request.getAttribute("statrDate");
		String endDate = (String)request.getAttribute("endDate");
		map.put("A3","中華民國"+statrDate+"至"+endDate);
		return map;
	}

}
