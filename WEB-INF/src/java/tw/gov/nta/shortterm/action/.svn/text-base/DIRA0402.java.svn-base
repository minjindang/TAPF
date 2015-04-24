/**
 * @author Andrew Sung
 * @create 2006/4/14
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.shortterm.form.Dira0401Form;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class DIRA0402 extends JacobReportAction
{

	@Override
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "DIRA04";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Map<String,String> map = new LinkedHashMap<String,String>();
		Dira0401Form myform = (Dira0401Form)form;
		String createDate = DateUtil.date2ROCStr(new Date(),"yyy/mm/dd");
		map.put("Z1","TAPF");
		IssueMain issue = new IssueMainDAO().get(myform.getIssueId());
		map.put("Z2",issue.getDebtName()+"比(議)價概況表");
		map.put("Z3",request.getAttribute("average_rate").toString());
		if(myform.getBaseDate() != null)
			map.put("Z4", new DateUtil().date2Str(myform.getBaseDate(), "yyyy/MM/dd"));
		else
			map.put("Z4", new DateUtil().date2Str(new Date(), "yyyy/MM/dd"));
		return map;
	}

}
