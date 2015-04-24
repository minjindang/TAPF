package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara3001Form;

public class GARA3002 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA30";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Gara3001Form myform = (Gara3001Form)form;
				
		String AmountUnit = myform.getAmountUnit();
		String AmountUnitLabel = "";
		
		if (AmountUnit.equals("1"))
			AmountUnitLabel = "元" ;
		else if (AmountUnit.equals("1000"))
			AmountUnitLabel = "千元" ;
		else if (AmountUnit.equals("1000000"))
			AmountUnitLabel = "百萬元" ;
		else if (AmountUnit.equals("100000000"))
			AmountUnitLabel = "億元" ;
		else if (AmountUnit.equals("1000000000"))
			AmountUnitLabel = "十億元" ;		
		
		//map.put("Z2","單位："+AmountUnitLabel);	
		map.put("Z2","("+AmountUnitLabel+")");	
		
		//map.put("usrId","TAPF");
		//map.put("unit",myform.getAmountUnitLabel());
		map.put("A4","製表日期："+DateUtil.date2ROCStr(new Date(),"yyy.MM.dd" ));
		String remark = request.getAttribute("remark").toString();
		Integer remarkRow = 7 + (Integer)request.getAttribute("remarkRow") + 5;
		map.put("Z200",remark);
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
