package tw.gov.nta.exchequer.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bira0801Form;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class BIRA0802 extends JacobReportAction{
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "BIRA08";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Bira0801Form bira0801Form = (Bira0801Form) form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		if ("".equals(bira0801Form.getBudgetCode()))
			map.put("A2","國　庫　券　發　行　提　前　買　回　 概　況　表　（總表）");
		else
			map.put("A2","國　庫　券　發　行　提　前　買　回　 概　況　表　（"+tw.gov.nta.system.common.BudgetCodeManager.get(Integer.parseInt(bira0801Form.getBudgetCode())).getBudgetName()+"）");
		if(bira0801Form.getIssueSdate() != null && bira0801Form.getIssueEdate() != null)
			map.put("A3","中華民國 " + DateUtil.date2ChineseROC2(bira0801Form.getIssueSdate())+" 至 "+DateUtil.date2ChineseROC2(bira0801Form.getIssueEdate()) + " 止");
		else
			map.put("A3","");
		map.put("A5", "製表日期 : " + DateUtil.date2ChineseROC2(new Date()));

		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}
