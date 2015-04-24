/**
 * @author Andrew Sung
 * @create 2006/4/21
 */

package tw.gov.nta.account.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.Eard0901Form;

public class EARD1202 extends JacobReportAction
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
		//return "EARD12_1";
		return "EARD12_"+(String)request.getAttribute("reportType");
	}

	@Override
	@SuppressWarnings("unused")
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Eard0901Form myForm = (Eard0901Form)form;
		Map<String,String> map = new LinkedHashMap<String,String>();
		 String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		//map.put( position, value );
		//map.put("Z1","TAPF");
		//map.put("G4",createDate);
		System.out.println(myForm.getReportType());
		if("1".equals(myForm.getReportType()))
		{
			map.put("G4",createDate);
		}
		else
		{
			map.put("H4",createDate);
			if(myForm.getEndDueDate()!= null)
				map.put("A2","(截至"+DateUtil.date2ROCStr(myForm.getEndDueDate())+"止)(未償／已償金額)");
		}
		System.out.println(map);
		return map;
	}

}
