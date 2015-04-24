package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Apra2901Form;

public class APRA2902 extends JacobReportAction
{	
	private final static String PROGRAM_ID = "APRA29";

	protected String getProgramId(HttpServletRequest request)
	{	return PROGRAM_ID;	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Apra2901Form myForm = (Apra2901Form)form;
		String startYear = myForm.getPaySmonth().substring(0,3);
		String startMonth = myForm.getPaySmonth().substring(3,5);
		String endMonth = myForm.getPayEmonth().substring(3,5);
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A1",startYear+"年"+startMonth+"月至"+endMonth+"月份國內借款還本付息季報概況表");
		if("1".equals(myForm.getBondType()))
			map.put("J6","公債(甲類)");
		else if("2".equals(myForm.getBondType()))
			map.put("J6","公債(乙類)");
		else
			map.put("J6","公      債");
		return map;
	}
}
