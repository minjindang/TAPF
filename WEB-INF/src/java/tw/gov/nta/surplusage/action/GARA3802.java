package tw.gov.nta.surplusage.action;


import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class GARA3802 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA38";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		AccountQueryForm myForm = (AccountQueryForm) form;
		String date2 = DateUtil.date2ROCStr(new Date()) ;  //0940228
		String selYear = myForm.getAccountYear();
		String selMonth = myForm.getMonth();
		String yyy = "";
		String mm = "";
		String dd = "";
		String yyy2 = "";
		if (Integer.parseInt(myForm.getAccountYear().substring(0,3)) >= 100){
			yyy2 = myForm.getAccountYear().substring(0,3);
		}else{
			yyy2 = myForm.getAccountYear().substring(1,3);
		}
		if (Integer.parseInt(date2.substring(0,3)) >= 100){
			yyy = date2.substring(0,3);
		}else{
			yyy = date2.substring(1,3);
		}
		if (Integer.parseInt(date2.substring(3,5)) >= 10){
			mm = date2.substring(3,5);
		}else{
			mm = date2.substring(4,5);
		}
		if (Integer.parseInt(date2.substring(5,7)) >= 10){
			dd = date2.substring(5,7);
		}else{
			dd = date2.substring(6,7);
		}
		map.put("A2",yyy2+"年度國庫舉借債務執行概況表");				
		
		map.put("A3","(截至"+Integer.parseInt(selYear)+"年"+Integer.parseInt(selMonth)+"月底止)");				
		map.put("A4","製表日期:"+yyy+"."+mm+"."+dd);							
		map.put("A4","製表日期:"+DateUtil.date2ROCStr(new Date(),"yyy.MM.dd" ));	
		//map.put( position, value );
		map.put("Z1",DateUtil.date2ROCStr(DateUtil.str2Date(DateUtil.getLastDateOfMonth(selYear, selMonth)),"yyy/MM/dd").replaceAll("/", "."));
		String memo = request.getAttribute("memo").toString();
		map.put("Z200",memo);
		System.out.println(map);
		return map;
	}
}