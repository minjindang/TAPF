package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra2401Form;

public class APRA2402 extends JacobReportAction
{
	private final static String PROGRAM_ID = "APRA24";

	@Override
	protected String getProgramId(HttpServletRequest request)
	{	return PROGRAM_ID;	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra2401Form myform = (Apra2401Form)form;
		map.put("A2","截至中華民國"+ DateUtil.date2ChineseROC2(myform.getIssueDate()));
		return map;
	}
}