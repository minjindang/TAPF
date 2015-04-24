package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cira0301Form;

public class CIRA0302 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "CIRA03";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Cira0301Form myform = (Cira0301Form)form;
		map.put("N6","�s�x��" + myform.getBaseUnitValue());
		map.put("A1","�������ɴڶŰȷ��p��-"+myform.getStatus());
		if(null != myform.getStartYear() && !"".equals(myform.getStartYear()) && null != myform.getEndDate() && !"".equals(myform.getEndDate()))
		{	
			map.put("A2",myform.getStartYear() + " �~�װ_�� " + myform.getEndYear() +"�~��" );
		}	
		if(null != myform.getStartDate() && null!= myform.getEndDate())
		{	
			map.put("A3",DateUtil.date2ChineseROC2(myform.getStartDate()) + " �_�� " + DateUtil.date2ChineseROC2(myform.getEndDate()) + "��");
		}	
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
