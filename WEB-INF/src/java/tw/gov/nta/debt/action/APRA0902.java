package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra0901Form;

public class APRA0902 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA09";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra0901Form myform = (Apra0901Form)form;
		//map.put("usrId","TAPF");
		
//		���o�w��O/�ŰȧO
		if (myform.getCloseDate()!=null){
			map.put("A2","���إ���"+ DateUtil.date2ROCStr(myform.getCloseDate()).substring(0,3)+"�~12��31���");
		}
		map.put("F4","�s�����G"+DateUtil.date2ROCStr(new Date(),"yyy/MM/dd" ));
		map.put("A6","���ŦW�١G"+myform.getPaidaName());
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
