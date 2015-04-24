package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara2701Form;

public class GARA2702 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA27";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Gara2701Form myform = (Gara2701Form)form;
		
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
		
		String memo = request.getAttribute("memo").toString();//取得GARA0401的memo值
		map.put("Z200",memo);
		
		map.put("A4","製表日期："+DateUtil.date2ChineseROC2(new Date()));
		map.put("S4","單位："+AmountUnitLabel);	
		//map.put("usrId","TAPF");
		//map.put("unit",myform.getAmountUnitLabel());
		String remark = request.getAttribute("remark").toString();
		Integer remarkRow = 7 + (Integer)request.getAttribute("remarkRow") + 7;
		map.put("A"+remarkRow.toString(),remark);
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
