package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cira0401Form;

public class CIRA0402 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "CIRA04";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Cira0401Form myform = (Cira0401Form)form;
		map.put("L6","金額單位:新台幣" + myform.getBaseUnitValue());
		if(null != myform.getStatus() && !"".equals(myform.getStatus()))
		{	
			map.put("A2",myform.getStatus());
		}
		if(null != myform.getBudgetLabel() && !"".equals(myform.getBudgetLabel()))
		{	
			map.put("A3",myform.getBudgetLabel());
		}	
		if(null != myform.getDebtLabel() && !"".equals(myform.getDebtLabel()))
		{	
			map.put("A4",myform.getDebtLabel());
		}
		//map.put("A4",DateUtil.date2Str(myform.getBaseDate(),"yyyy/mm/dd"));
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
