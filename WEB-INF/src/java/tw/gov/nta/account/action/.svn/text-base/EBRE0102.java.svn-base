package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EBRE0102 extends JacobReportAction
{
	protected String getProgramId(HttpServletRequest request) {
		String debtCode = (String) request.getSession().getAttribute("debtTypeCode");
		if ("A".equals(debtCode)){
			return "EARE01";
		}
		return "EBRE01";
	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		AccountQueryForm myForm = (AccountQueryForm)form;
		String debtCode = (String) request.getSession().getAttribute("debtTypeCode");
		String debtName = "";
		if ("A".equals(debtCode)){
			debtName = "公  債  ";
		}else if("B".equals(debtCode)){
			debtName = "國  庫  劵  ";
		}else if("C".equals(debtCode)){
			debtName = "中  長  期  借  款";
		}else if("D".equals(debtCode)){
			debtName = "短  期  借  款";
		}
		map.put("Z2",debtName);
		map.put("Z1","中華民國 "+String.valueOf(Integer.parseInt(myForm.getAccountYear()))+" 年 "+myForm.getMonth()+" 月份");	
		return map;
	}

	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}