package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara1201Form;
import tw.gov.nta.system.common.CodeDetManage;


public class GARA1202 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA12";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Gara1201Form myForm = (Gara1201Form)form;
		String createDate = DateUtil.date2ChineseROC2(new Date());
		if (myForm.getCreateDate() != null){
			createDate = DateUtil.date2ChineseROC2(myForm.getCreateDate());
		}
		map.put("A1","表17    "+Integer.parseInt(myForm.getIssueYear())+"年度各月份短期債務餘額統計表");
		//map.put("Z2",DateUtil.date2Str(DateUtil.str2Date(DateUtil.getLastDateOfMonth(myForm.getIssueYear(),"01")),"yyyy/mm/dd"));
		map.put("E3","單位：新台幣"+CodeDetManage.getCodeName("BU",myForm.getAmountUnit().toString()));
		map.put("A3","製表日期："+createDate);
		map.put("Z1",request.getAttribute("remark2"));
		String memo = request.getAttribute("memo").toString();
		map.put("Z200",memo);
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
