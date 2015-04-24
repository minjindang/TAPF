package tw.gov.nta.account.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EDQC0302 extends JacobReportAction
{
	private final static String PROGRAM_ID = "EDQC03";

	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		AccountQueryForm myForm = (AccountQueryForm) form;
		
		Date startIssueDate = myForm.getStartIssueDate();
		Date endIssueDate = myForm.getEndIssueDate();
		String prnDate = "";
		if (startIssueDate != null && endIssueDate != null ){
        	prnDate = "い地チ瓣" + DateUtil.date2ChineseROC2(startIssueDate) + "" + 
			"い地チ瓣 " + DateUtil.date2ChineseROC2(endIssueDate) + " ゎ ";
        }else{
        	prnDate = "い地チ瓣                   い地チ瓣                    ゎ ";
        }
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A3",prnDate);
		return map;
	}
}
