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

public class ECRF0402 extends JacobReportAction {

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		AccountQueryForm myForm = (AccountQueryForm)form;
		System.out.println(myForm.getStartIssueDate());
		System.out.println(myForm.getEndIssueDate());
		String prnDate = "中華民國"  + DateUtil.date2ROCStr(myForm.getStartIssueDate()).substring(0,3) + " 年 " +  
		DateUtil.date2ROCStr(myForm.getStartIssueDate()).substring(3,5) + " 月 " +
		DateUtil.date2ROCStr(myForm.getEndIssueDate()).substring(5,7) + " 日　至　" + 
							"中華民國 " + DateUtil.date2ROCStr(myForm.getEndIssueDate()).substring(0,3) + " 年 " +  
							DateUtil.date2ROCStr(myForm.getEndIssueDate()).substring(3,5) + " 月 " +
							DateUtil.date2ROCStr(myForm.getEndIssueDate()).substring(5,7) + " 日止 ";
		
		String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		
		//map.put( position, value );
		//map.put("Z1","TAPF");
		map.put("A3",prnDate);
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
		return "ECRF04";
	}

}
