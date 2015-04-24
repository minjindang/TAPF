package tw.gov.nta.account.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EBRC0403 extends JacobReportAction {

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		AccountQueryForm myform = (AccountQueryForm)form;
		String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		Calendar calendar = Calendar.getInstance();
		//map.put( position, value );
		
		calendar.setTime(myform.getStartIssueDate());
		StringBuffer buffer = new StringBuffer();
		buffer.append("發行日期：中華民國");
		buffer.append(calendar.get(Calendar.YEAR) - 1911);
		buffer.append("年");
		buffer.append(calendar.get(Calendar.MONTH)+1);
		buffer.append("月");
		buffer.append(calendar.get(Calendar.DATE));
		buffer.append("日至");
		calendar.setTime(myform.getEndIssueDate());
		buffer.append(calendar.get(Calendar.YEAR) - 1911);
		buffer.append("年");
		buffer.append(calendar.get(Calendar.MONTH)+1);
		buffer.append("月");
		buffer.append(calendar.get(Calendar.DATE));
		buffer.append("日");
		
		//發行日期：中華民國  年  月   日  至  中華民國   年   月   日
		map.put("A4",buffer.toString());
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "EBRC04";
	}
}
