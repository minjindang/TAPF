package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Apra3001Form;

public class APRA3002 extends JacobReportAction
{	
	private final static String PROGRAM_ID = "APRA30";

	protected String getProgramId(HttpServletRequest request)
	{	return PROGRAM_ID;	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Apra3001Form myForm = (Apra3001Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A1",myForm.getPayYear()+"年度國內借款還本付息估測表(年報)");
		if("1".equals(myForm.getBondType()))
			map.put("J6","公債(甲類)");
		else if("2".equals(myForm.getBondType()))
			map.put("J6","公債(乙類)");
		else
			map.put("J6","公      債");
		return map;
	}
}
