package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class ECRE1002 extends JacobReportAction
{
	private final static String PROGRAM_ID = "ECRE10";

	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		AccountQueryForm myForm = (AccountQueryForm) form;
		String LastDate = myForm.getLastDate();
		if  (null != LastDate || !LastDate.equals("") ){
			if (Integer.parseInt(LastDate.substring(0,3))>= 100){
				map.put("A3","中華民國"+LastDate.substring(0,3)+"年12月31日");				

			 }else{
				map.put("A3","中華民國"+LastDate.substring(1,3)+"年12月31日");							
			} 
		}

		return map;
	}
}