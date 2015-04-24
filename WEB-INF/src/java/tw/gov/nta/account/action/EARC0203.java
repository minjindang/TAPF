package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EARC0203 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "EARC02";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		String DEBTTYPE = (String)request.getSession().getAttribute("debtTypeCode");
        if ("A".equals(DEBTTYPE)){
        	map.put("A2","公     債");
        }else if("B".equals(DEBTTYPE)){
        	map.put("A2","國  庫  券");
        }else if("C".equals(DEBTTYPE)){
        	map.put("A2","中  長  借");
        }else if("D".equals(DEBTTYPE)){
        	map.put("A2","短  期  借  款");
        } 		
        
        AccountQueryForm myform = (AccountQueryForm)form;
        
        if(myform.getIssueKind()!=null&&!"".equals(myform.getIssueKind())){
        	String issueKindName = "";
        	if(myform.getIssueKind().equals("0")){
        		issueKindName = "( 登錄形式 )";
        	}else if(myform.getIssueKind().equals("1")){
        		issueKindName = "( 債票形式 )";
        	}
        	map.put("A4",issueKindName);
        }
		map.put("B5",(String)request.getAttribute("account_code"));
		map.put("B6",(String)request.getAttribute("account_name"));
		map.put("E5",(String)request.getAttribute("issue_serial"));
		map.put("E6",(String)request.getAttribute("debt_name"));
		return map;
	}
}