package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara3301Form;
import tw.gov.nta.system.common.CodeDetManage;

public class GARA3302 extends JacobReportAction {

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Gara3301Form myform = (Gara3301Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		
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
		map.put("A4","製表日期："+DateUtil.date2ROCStr(new Date(),"yyy.MM.dd" ));
		map.put("W4","金額單位：新台幣("+CodeDetManage.getCodeName("BU",myform.getAmountUnit().toString())+")");
		//map.put( position, value );
		//map.put("Z1",this.getUserId(request));
		//map.put("I3",createDate);
		//map.put("I4","新台幣"+CodeDetManage.getCodeName("BU",myForm.getAmountUnit().toString()));
		String remark = request.getAttribute("remark").toString();
		map.put("Z300",remark);
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "GARA33";
	}
}
