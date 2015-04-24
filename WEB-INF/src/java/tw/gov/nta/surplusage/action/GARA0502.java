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
import tw.gov.nta.surplusage.form.Gara0401Form;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.CodeDetManage;

public class GARA0502 extends JacobReportAction
{
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Gara0401Form myForm = (Gara0401Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		//String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		
		//map.put( position, value );
		//map.put("Z1","TAPF");
		//map.put("N4",createDate);
		String memo = request.getAttribute("memo").toString();//取得GARA0402的memo值
		map.put("O6","新台幣"+CodeDetManage.getCodeName("BU",myForm.getAmountUnit().toString()));
		map.put("A6","製表日期："+DateUtil.date2ChineseROC2( new Date() ) );
		map.put("Z200",memo );
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
		return "GARA05";
	}
}
