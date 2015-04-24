package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara2401Form;
import tw.gov.nta.system.common.CodeDetManage;

public class GARA2402 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA24";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Gara2401Form myform = (Gara2401Form)form;
		String createDate = DateUtil.date2ChineseROC2(new Date());
		map.put("H3","單位：新台幣"+CodeDetManage.getCodeName("BU",myform.getAmountUnit().toString()));
		map.put("A3","製表日期："+createDate);
		String memo = request.getAttribute("memo").toString();//取得GARA0401的memo值
		map.put("Z200",memo);
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
