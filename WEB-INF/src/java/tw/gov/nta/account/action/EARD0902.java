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

public class EARD0902 extends JacobReportAction
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
		return "EARD09";
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
		map.put("A3","中華民國"+DateUtil.date2ROCStr(myForm.getStartIssueDate(),"YYY/MM/DD")+"至"+DateUtil.date2ROCStr(myForm.getEndDueDate(),"YYY/MM/DD"));
		return map;
	}

}
