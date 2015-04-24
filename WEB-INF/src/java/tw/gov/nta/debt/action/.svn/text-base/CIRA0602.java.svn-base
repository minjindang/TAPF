package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cira0601Form;

public class CIRA0602 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "CIRA06";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Cira0601Form myform = (Cira0601Form)form;
		map.put("A2","(" + myform.getStatus()+ ")");
		map.put("G6","金額單位:新台幣"+myform.getBaseUnitValue());
		map.put("A3",DateUtil.date2Str(myform.getBaseDate(),"yyyy/mm/dd"));
		if(null != myform.getBudgetLabel() && !"".equals(myform.getBudgetLabel()))
		{	
			map.put("A4",myform.getBudgetLabel());
		}	
		if(null != myform.getDebtLabel() && !"".equals(myform.getDebtLabel()))
		{	
			map.put("A5",myform.getDebtLabel());
		}
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}
