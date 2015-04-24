package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara3201Form;
import tw.gov.nta.system.common.CodeDetManage;

public class GARA3202 extends JacobReportAction {

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Gara3201Form myForm = (Gara3201Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		//map.put( position, value );
		//map.put("Z1",this.getUserId(request));
		//map.put("I3",createDate);
		map.put("A4","製表日期："+DateUtil.date2ChineseROC2(new Date()));
		map.put("T4","金額單位：新台幣"+CodeDetManage.getCodeName("BU",myForm.getAmountUnit().toString()));
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
		return "GARA32";
	}
}
