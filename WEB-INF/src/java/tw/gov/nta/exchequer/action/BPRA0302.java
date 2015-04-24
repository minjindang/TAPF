/**
 * @author Andrew Sung
 * @create 2006/4/19
 */

package tw.gov.nta.exchequer.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bpra0301Form;
import tw.gov.nta.system.common.CodeDetManage;

public class BPRA0302 extends JacobReportAction
{

	@Override
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		Bpra0301Form myForm = (Bpra0301Form)form;
		return new ReportManager(myForm.getCode(),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return (String) request.getAttribute("code");
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		@SuppressWarnings("unused") Bpra0301Form myForm = (Bpra0301Form)form;
		Map<String,String> map = new LinkedHashMap<String,String>();
		String createDate = DateUtil.date2ChineseROC2(new Date());
		String amountUtil = myForm.getAmountUnit();
		if(amountUtil ==null ||"".equals(amountUtil))
			amountUtil = "1";
		map.put("J5",createDate);
		map.put("J6","新台幣"+CodeDetManage.getCodeName("BU",amountUtil)+"元");
		if("BPRA04".equals(myForm.getCode()))
		{
			map.put("C5","中華民國"+DateUtil.date2ChineseROC2(myForm.getDestDate()));
			map.put("C6",myForm.getDestArea());
		}
		return map;
	}

}
