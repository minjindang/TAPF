package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara2901Form;

public class GARA2902 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA29";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Gara2901Form myform = (Gara2901Form)form;
		
		String AmountUnit = myform.getAmountUnit();
		String AmountUnitLabel = "";
		
		if (AmountUnit.equals("1"))
			AmountUnitLabel = "��" ;
		else if (AmountUnit.equals("1000"))
			AmountUnitLabel = "�d��" ;
		else if (AmountUnit.equals("1000000"))
			AmountUnitLabel = "�ʸU��" ;
		else if (AmountUnit.equals("100000000"))
			AmountUnitLabel = "����" ;
		else if (AmountUnit.equals("1000000000"))
			AmountUnitLabel = "�Q����" ;	
		
		map.put("S4","���G"+AmountUnitLabel);	
		map.put("A4","�s�����G"+DateUtil.date2ChineseROC2(new Date()));
		//map.put("Z1",this.getUserId(request));
		//map.put("Z2",myform.getAmountUnitLabel());
		String remark = request.getAttribute("remark").toString();
		Integer remarkRow = 7 + (Integer)request.getAttribute("remarkRow") + 5;
		map.put("A"+remarkRow.toString(),remark);
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
