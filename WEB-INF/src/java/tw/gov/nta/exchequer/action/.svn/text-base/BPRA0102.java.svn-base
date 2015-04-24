/**
 * @author Andrew Sung
 * @create 2006/4/11
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

import tw.gov.nta.exchequer.form.Bpra0101Form;

public class BPRA0102 extends JacobReportAction
{

	@Override
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		// TODO Auto-generated method stub
		return "BPRA01";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Bpra0101Form myForm = (Bpra0101Form)form;
		String repayDateStart = DateUtil.date2ChineseROC2(myForm.getRepaySdate());
		String repayDateEnd = DateUtil.date2ChineseROC2(myForm.getRepayEdate());
		String createDate = DateUtil.date2ChineseROC2(new Date());
		map.put("A3","´Á¶¡¡G"+repayDateStart+"¦Ü"+repayDateEnd);
		map.put("H6",createDate);
		return map;
	}

}
