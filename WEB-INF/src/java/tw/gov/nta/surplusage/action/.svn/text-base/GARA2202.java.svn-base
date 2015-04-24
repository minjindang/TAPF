/**
 * @author Andrew Sung
 * @create 2006/4/12
 */

package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara2201Form;
import tw.gov.nta.system.common.CodeDetManage;

public class GARA2202 extends JacobReportAction
{
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Gara2201Form myForm = (Gara2201Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		//String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		if (!"".equals(myForm.getIssueYear()))
			map.put("Z2",DateUtil.date2Str(DateUtil.str2Date(DateUtil.getLastDateOfMonth(myForm.getIssueYear(),"01")),"yyyy/mm/dd"));
		else
			map.put("Z2","");
		map.put("Z3","新台幣"+CodeDetManage.getCodeName("BU",myForm.getAmountUnit().toString()));
		String memo = request.getAttribute("memo").toString();//取得GARA0401的memo值
		map.put("Z200",memo);
		map.put("A5","製表日期："+DateUtil.date2ROCStr(new Date(),"yyy.MM.dd" ));

		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form,request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "GARA22";
	}
}
