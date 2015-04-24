package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara3001Form;

public class GARA3002 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA30";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Gara3001Form myform = (Gara3001Form)form;
				
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
		
		//map.put("Z2","���G"+AmountUnitLabel);	
		map.put("Z2","("+AmountUnitLabel+")");	
		
		//map.put("usrId","TAPF");
		//map.put("unit",myform.getAmountUnitLabel());
		map.put("A4","�s�����G"+DateUtil.date2ROCStr(new Date(),"yyy.MM.dd" ));
		String remark = request.getAttribute("remark").toString();
		Integer remarkRow = 7 + (Integer)request.getAttribute("remarkRow") + 5;
		map.put("Z200",remark);
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
