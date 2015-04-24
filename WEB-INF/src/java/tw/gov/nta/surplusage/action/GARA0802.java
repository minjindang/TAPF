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

public class GARA0802 extends JacobReportAction
{
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		//Gara0801Form myForm = (Gara0801Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String memo = request.getAttribute("memo").toString();//取得GARA0401的memo值
		map.put("Z200",memo);
		String createDate = DateUtil.date2ChineseROC2(new Date());
		map.put("A4","製表日期："+createDate);
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
		return "GARA08";
	}
}
