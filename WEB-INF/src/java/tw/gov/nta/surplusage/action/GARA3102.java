package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara3101Form;

public class GARA3102 extends JacobReportAction {

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Gara3101Form myform = (Gara3101Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
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
		
		map.put("AK4","���B���G�s�x��("+AmountUnitLabel+")");
		map.put("A4","�s�����G"+DateUtil.date2ChineseROC2(new Date()));
		String remark = request.getAttribute("remark").toString();
		Integer remarkRow = 7 + (Integer)request.getAttribute("remarkRow") + 7;
		map.put("AO300",remark);
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
		return "GARA31";
	}
}
