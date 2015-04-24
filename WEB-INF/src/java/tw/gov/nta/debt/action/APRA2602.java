package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra2601Form;

public class APRA2602 extends JacobReportAction
{
	private final static String PROGRAM_ID = "APRA26";

	@Override
	protected String getProgramId(HttpServletRequest request)
	{	return PROGRAM_ID;	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra2601Form myForm = (Apra2601Form)form;
		map.put("Z1","TAPF");
		map.put("A5","兌付期限：中華民國"+DateUtil.date2ChineseROC2(myForm.getDueSdate())+"至"+DateUtil.date2ChineseROC2(myForm.getDueEdate()));
		map.put("D3",DateUtil.date2ChineseROC2(new Date()));
		return map;
	}
}
