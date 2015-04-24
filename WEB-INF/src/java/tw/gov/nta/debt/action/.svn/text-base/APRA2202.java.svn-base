/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra2201Form;

public class APRA2202 extends JacobReportAction
{
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA22";
	}
	
	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra2201Form myform = (Apra2201Form)form;
		String createDate = DateUtil.date2ChineseROC2(DateUtil.date());
		map.put("A1","截至中華民國" + Integer.parseInt(myform.getKillYear())+ "年度待銷燬數量表");
		map.put("C4","       製表日期：中華民國"+createDate);
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
