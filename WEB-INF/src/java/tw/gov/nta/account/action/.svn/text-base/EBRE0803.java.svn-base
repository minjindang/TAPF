package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EBRE0803 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return request.getSession().getAttribute("SYSID").toString();
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		//map.put( position, value );
		AccountQueryForm myform = (AccountQueryForm)form;
		String lastDate = myform.getYearLastDate();
		String year = lastDate.substring(0,3);
		String month = lastDate.substring(3,5);
		String day = lastDate.substring(5,7);
		map.put("A3","中華民國"+year+"年"+month+"月"+day+"日");
		return map;
	}
}