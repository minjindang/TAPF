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
        	prnDate = "中華民國" + DateUtil.date2ChineseROC2(startIssueDate) + "　至　" + 
			"中華民國 " + DateUtil.date2ChineseROC2(endIssueDate) + " 止 ";
        }else{
        	prnDate = "中華民國                   　至　中華民國                    　止 ";
        }
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A3",prnDate);
		return map;
	}
}
