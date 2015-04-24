/**
 * @author Andrew Sung
 * @create 2006/4/12
 */

package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara0601Form;
import tw.gov.nta.system.common.CodeDetManage;

public class GARA0602 extends JacobReportAction
{
	private final static String PROGRAM_ID = "GARA06";

	protected String getProgramId(HttpServletRequest request)
	{	return PROGRAM_ID;	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request)
	{	
		Gara0601Form myForm = (Gara0601Form)form;
		String memo = request.getAttribute("memo").toString();//取得GARA0602的memo值
		String remark = request.getAttribute("remark").toString();
		Integer remarkRow = 7 + (Integer)request.getAttribute("remarkRow") + 3;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A4","製表日期："+DateUtil.date2ChineseROC2(new Date()));
		map.put("U4","單位："+CodeDetManage.getCodeName("BU",myForm.getAmountUnit().toString()));
		map.put("Z200",memo);
		map.put("A"+remarkRow.toString(),remark);
		return map;
	}
}
