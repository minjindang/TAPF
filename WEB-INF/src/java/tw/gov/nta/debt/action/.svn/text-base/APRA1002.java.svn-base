package tw.gov.nta.debt.action;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra1001Form;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

public class APRA1002 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA10";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra1001Form myform = (Apra1001Form)form;
		if (myform.getCloseDate()!=null){
			map.put("A2","中華民國"+ DateUtil.date2ROCStr(myform.getCloseDate()).substring(0,3)+"年12月31日止");
		}
		map.put("F4",DateUtil.date2ROCStr(new Date(),"yyy/MM/dd" ));
		map.put("C3",myform.getBankName());
		map.put("C5",myform.getPaidaName());
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
