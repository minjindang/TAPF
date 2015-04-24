package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class ECRE0402 extends JacobReportAction
{
	private final static String PROGRAM_ID = "ECRE04";

	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		AccountQueryForm myForm = (AccountQueryForm) form;
		String LastDate = myForm.getLastDate();
		if  (null != LastDate || !LastDate.equals("") ){
			if (Integer.parseInt(LastDate.substring(0,3))>= 100){
				map.put("A4","中華民國"+LastDate.substring(0,3)+"年"+LastDate.substring(3,5)+"月"+LastDate.substring(5,7)+"日");				

			 }else{
				map.put("A4","中華民國"+LastDate.substring(1,3)+"年"+LastDate.substring(3,5)+"月"+LastDate.substring(5,7)+"日");							
			} 
		}

		
		return map;
	}
}