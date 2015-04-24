/* AIRC1002.java ����
 �{���ت��GAIRC10
 �{���N���GAIRC10
 �{������G0950308
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
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
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.form.Airc1101Form;
import tw.gov.nta.system.common.CodeDetManage;

public class AIRC1102 extends JacobReportAction {

	private final static String PROGRAM_ID = "AIRC11";
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Airc1101Form airc1101Form = (Airc1101Form) form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String AmountUnit = airc1101Form.getAmountUnit();
		String AmountUnitLabel = "";
		String queryYear = new DateUtil().date2Str(airc1101Form.getLimitDate(), "yyyy/MM/dd");
		if (AmountUnit.equals("0"))
			AmountUnit ="1"; 
		map.put("A3",queryYear);
		map.put("R6","�s�x��"+CodeDetManage.getCodeName("BU",AmountUnit));
		return map;
	}
	
}