package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara1601Form;
import tw.gov.nta.system.common.CodeDetManage;

public class GARA1602 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA16";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Gara1601Form myForm = (Gara1601Form)form;
		String createDate = DateUtil.date2ChineseROC2(new Date());
		map.put("A5","製表日期："+createDate);
		map.put("AH5","金錢單位："+CodeDetManage.getCodeName("BU",myForm.getAmountUnit().toString()));
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
