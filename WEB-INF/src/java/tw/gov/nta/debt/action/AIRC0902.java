/* AIRC0902.java 報表
 程式目的：AIRC09
 程式代號：AIRC09
 程式日期：0950309
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ExcelReportAction;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.form.Airc0901Form;
import tw.gov.nta.surplusage.form.Gara3901Form;

public class AIRC0902 extends JacobReportAction {

	private final static String PROGRAM_ID = "AIRC09";
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Airc0901Form airc0901Form = (Airc0901Form) form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A2",DateUtil.date2Str(airc0901Form.getLimitDate(), "yyyy/MM/dd"));
		map.put("G3","製表日期:"+DateUtil.date2ChineseROC2(new Date()));
		return map;

	}
}
