package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EBRE0402 extends JacobReportAction
{
	private final static String PROGRAM_ID = "EBRE04";

	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		AccountQueryForm myForm = (AccountQueryForm)form;
		
		String date = myForm.getLastDate();
		if ( date == null || date.equals("") || date.substring(0,3).equals("")){
			map.put("A4","中華民國        年    月     日");
		}else if (Integer.parseInt(date.substring(0,3))>= 100){
			map.put("A4","中華民國 "+date.substring(0,3)+"年 "+date.substring(3,5)+"月 "+date.substring(5,7)+"日");				
		}else{
			map.put("A4","中華民國 "+date.substring(1,3)+"年 "+date.substring(3,5)+"月 "+date.substring(5,7)+"日");												
		} 
		
		return map;
	}
}