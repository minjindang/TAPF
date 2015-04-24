package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.surplusage.form.Gara1901Form;
import tw.gov.nta.system.common.CodeDetManage;

public class GARA1902 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA19";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Gara1901Form myForm = (Gara1901Form)form;
		String accountYear = myForm.getAccountYear();
		String accountMonth = myForm.getAccountMonth();
		map.put("F3","單位：新台幣"+CodeDetManage.getCodeName("BU",myForm.getAmountUnit().toString()));
		map.put("A3","製表日期："+DateUtil.date2ChineseROC2(new Date()));
		map.put("A7",accountYear+"年"+accountMonth+"月底止未償餘債務餘額");
		map.put("A8",accountYear+"年"+accountMonth+"月份實際發行數");
		map.put("A9",accountYear+"年"+accountMonth+"月份還本數");
		map.put("A10",accountYear+"年"+accountMonth+"月份付息數");
		String memo = request.getAttribute("memo").toString();
		map.put("Z200",memo);
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
