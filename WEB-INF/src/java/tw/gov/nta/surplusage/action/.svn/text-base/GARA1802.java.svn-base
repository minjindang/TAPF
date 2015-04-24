package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.surplusage.form.Gara1801Form;
import tw.gov.nta.system.common.CodeDetManage;
import gov.dnt.tame.util.DateUtil;
import java.util.Date;

public class GARA1802 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA18";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Gara1801Form myform = (Gara1801Form)form;
		String prtDate = DateUtil.date2ROCStr(new Date(),"yyy.MM.dd" );
		//map.put("Z1","TAPF");
		//map.put("Z2",myform.getAmountUnitLabel());
		String reportDate = request.getAttribute("reportDate").toString();
		if ( reportDate=="" || reportDate == null){
			map.put("A3","製表日期："+DateUtil.date2ROCStr(new Date(),"yyy.MM.dd" ));
			map.put("A10" , "註1：以上資料截至"+prtDate.substring(0,3)+"年"+prtDate.substring(4,6)+"月止。 ");
		}else{
			map.put("A3","製表日期："+reportDate.substring(1,3)+"年"+reportDate.substring(3,5)+"月"+reportDate.substring(5,7)+"日");
			map.put("A10" , "註1：以上資料截至"+reportDate.substring(1,3)+"年"+reportDate.substring(3,5)+"月"+reportDate.substring(5,7)+"日止。");
		}
		System.out.println(prtDate);

		//map.put("K3" , "單位：" + myform.getAmountUnitLabel());
		//map.put("K3","單位：" +CodeDetManage.getCodeName("BU",myform.getAmountUnitLabel().toString()));
		map.put("K3","單位：" +CodeDetManage.getCodeName("BU",myform.getAmountUnit().toString()));
		String memo = request.getAttribute("memo").toString();//取得GARA0401的memo值
		map.put("Z200",memo);
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
