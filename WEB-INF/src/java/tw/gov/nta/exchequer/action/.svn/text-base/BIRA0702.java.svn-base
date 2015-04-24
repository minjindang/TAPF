package tw.gov.nta.exchequer.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bira0701Form;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class BIRA0702 extends JacobReportAction{
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "BIRA07";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Bira0701Form myForm = (Bira0701Form) form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		//map.put( position, value );
		if ("".equals(myForm.getBudgetCode())){
			map.put("A2","國庫券未償餘額彙總表（總表）");
			map.put("H7","占當年度歲出總額％或占當年度及前一年度預算支出總額％");
		}
		else{
			map.put("A2","國庫券未償餘額彙總表（"+tw.gov.nta.system.common.BudgetCodeManager.get(Integer.parseInt(myForm.getBudgetCode())).getBudgetName()+"）");
			map.put("H7","占當年度歲出總額％");
		}
		if (myForm.getIssueSdate() != null && myForm.getIssueEdate() != null)
			map.put("A3",DateUtil.date2ChineseROC2(myForm.getIssueSdate()) + "至" + DateUtil.date2ChineseROC2(myForm.getIssueEdate()));
		else
			map.put("A3","");
		map.put("A5", "製表日期:" + DateUtil.date2ChineseROC2(new Date()));
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}
