package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.StringUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class GARA3702 extends JacobReportAction
{
	private final static String PROGRAM_ID = "GARA37";

	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		AccountQueryForm myForm = (AccountQueryForm) form;
		BigDecimal amount = (BigDecimal)request.getAttribute("amount");
		StringUtil util = new StringUtil();
		map.put("L3",myForm.getAccountYear());
		map.put("M3",util.addThousandMark2(amount));
		System.out.println("amout:"+util.addThousandMark(amount));
		map.put("A1","中央政府"+Integer.parseInt(myForm.getAccountYear())+"年度可舉借債務執行概況表");
		map.put("A2","截至 "+Integer.parseInt(myForm.getAccountYear())+" 年 " + Integer.parseInt(myForm.getMonth()) + " 月底止");
		map.put("A3", "製表日期：" + DateUtil.date2ChineseROC2(new Date()));
		return map;
	}
}
