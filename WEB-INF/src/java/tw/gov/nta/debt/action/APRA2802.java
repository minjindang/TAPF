package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Apra2801Form;

public class APRA2802 extends JacobReportAction
{	
	private final static String PROGRAM_ID = "APRA28";

	protected String getProgramId(HttpServletRequest request)
	{	return PROGRAM_ID;	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Apra2801Form myForm = (Apra2801Form)form;
		String payDate = myForm.getPayYearMonth();

		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A1",payDate.substring(0,3)+"年"+payDate.substring(3,5)+"月份國內舉借還本付息月報概況表");
		if("1".equals(myForm.getBondType()))
			map.put("J6","公債(甲類)");
		else if("2".equals(myForm.getBondType()))
			map.put("J6","公債(乙類)");
		else
			map.put("J6","公      債");
		return map;
	}
}
