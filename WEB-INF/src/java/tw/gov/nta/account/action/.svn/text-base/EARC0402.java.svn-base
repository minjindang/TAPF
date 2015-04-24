package tw.gov.nta.account.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EARC0402 extends JacobReportAction 
{

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		AccountQueryForm myForm = (AccountQueryForm)form;
		
		String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		String startIssueDate = DateUtil.date2ROCStr(myForm.getStartIssueDate());//[發行日期起]
		String endIssueDate   = DateUtil.date2ROCStr(myForm.getEndIssueDate());//[發行日期迄]

		map.put( "A3", "發行日期 中華民國"+startIssueDate.substring(0,3)+"年"+startIssueDate.substring(3,5)+"月"+startIssueDate.substring(5,7)+
				"日至"+endIssueDate.substring(0,3)+"年"+endIssueDate.substring(3,5)+"月"+endIssueDate.substring(5,7)+"日" );
		
		//map.put( position, value );
		//map.put("Z1","TAPF");
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "EARC04";
	}

}
