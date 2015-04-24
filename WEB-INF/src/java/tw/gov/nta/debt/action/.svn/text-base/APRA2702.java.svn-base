package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra2701Form;

public class APRA2702 extends JacobReportAction {

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA27";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra2701Form myForm = (Apra2701Form)form;
		//map.put("Z1","TAPF");
		map.put("A5","兌付期限：中華民國"+DateUtil.date2ChineseROC2(myForm.getDueSdate())+"至"+DateUtil.date2ChineseROC2(myForm.getDueEdate()));
		map.put("D3",DateUtil.date2ChineseROC2(new Date()));
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
