package tw.gov.nta.exchequer.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bira0901Form;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class BIRA0902 extends JacobReportAction{
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "BIRA09";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Bira0901Form myForm = (Bira0901Form) form;
		if (null != myForm.getPrintDate())
			map.put("A3", "製表日期:" + DateUtil.date2ChineseROC2(myForm.getPrintDate()));
		else
			map.put("A3", "製表日期:" + DateUtil.date2ChineseROC2(new Date()));
		if (myForm.getIssueSdate() != null && myForm.getIssueEdate() != null)
			map.put("A2",DateUtil.date2ChineseROC2(myForm.getIssueSdate()) + "至" + DateUtil.date2ChineseROC2(myForm.getIssueEdate()));
		else
			map.put("A2","");
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}
