package tw.gov.nta.exchequer.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bira0601Form;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class BIRA0602 extends JacobReportAction{
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "BIRA06";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Bira0601Form bira0601Form = (Bira0601Form) form;
		if ("".equals(bira0601Form.getBudgetCode())){
			map.put("A2","歷年國庫券未償餘額資料彙總表（總表）");
			map.put("G6","未償餘額佔歲出總額％或占當年度及前一年度預算支出總額％");
		}
		else{
			map.put("A2","歷年國庫券未償餘額資料彙總表（"+tw.gov.nta.system.common.BudgetCodeManager.get(Integer.parseInt(bira0601Form.getBudgetCode())).getBudgetName()+"）");
			map.put("G6","未償餘額佔歲出總額％%");
		}
		map.put("A4", "製表日期:" + DateUtil.date2ChineseROC2(new Date()));
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}
