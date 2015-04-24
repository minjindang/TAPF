package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra0901Form;

public class APRA0902 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA09";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra0901Form myform = (Apra0901Form)form;
		//map.put("usrId","TAPF");
		
//		取得預算別/債務別
		if (myform.getCloseDate()!=null){
			map.put("A2","中華民國"+ DateUtil.date2ROCStr(myform.getCloseDate()).substring(0,3)+"年12月31日止");
		}
		map.put("F4","製表日期："+DateUtil.date2ROCStr(new Date(),"yyy/MM/dd" ));
		map.put("A6","公債名稱："+myform.getPaidaName());
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
