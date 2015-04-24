package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara0401Form;
import tw.gov.nta.system.common.CodeDetManage;

public class GARA0402 extends JacobReportAction {

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Gara0401Form myForm = (Gara0401Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		//map.put( position, value );
		//map.put("Z1","TAPF");
		String memo = request.getAttribute("memo").toString();//取得GARA0401的memo值
		map.put("I3","單位：新台幣"+CodeDetManage.getCodeName("BU",myForm.getAmountUnit().toString()));
		map.put("A3","製表日期："+DateUtil.date2ChineseROC2(new Date()));
		map.put("Z200",memo);
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
		return "GARA04";
	}
}
