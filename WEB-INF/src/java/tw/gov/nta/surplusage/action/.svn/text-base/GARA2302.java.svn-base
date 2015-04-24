package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara2301Form;
import tw.gov.nta.system.common.BudgetCodeManager;
import tw.gov.nta.system.common.CodeDetManage;
import tw.gov.nta.system.common.DebitCodeManage;

public class GARA2302 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA23";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Gara2301Form myform = (Gara2301Form)form;
		String createDate = DateUtil.date2ChineseROC2(new Date());
		String BCodeName = "";
		String DCodeName = "";
		String AmountUnit = myform.getAmountUnit();
		if (AmountUnit.equals("0"))
			AmountUnit ="1"; 
		if (!"".equals(myform.getBudgetCode()))
			BCodeName = BudgetCodeManager.findBudgetName(Integer.parseInt(myform.getBudgetCode()));
		if (!"".equals(myform.getDebtCode()))
			DCodeName = DebitCodeManage.findDebitName(Integer.parseInt(myform.getDebtCode()));
		map.put("A2","製表日期："+createDate);
		map.put("A3","預算別："+BCodeName);
		map.put("A4","債務別："+DCodeName);
		map.put("D4","金額單位：新台幣"+CodeDetManage.getCodeName("BU",AmountUnit));
		//map.put("budgetCode",myform.getBudgetLabel());
		//map.put("debtCode",myform.getDebtLabel());
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}
