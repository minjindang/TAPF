/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Apra1601Form;
public class APRA1602 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA16";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra1601Form myform = (Apra1601Form)form;
		//map.put("K1","TAPF");
		map.put("A2","中華民國" + DateUtil.date2ChineseROC2(myform.getCloseSdate()) + "至" + DateUtil.date2ChineseROC2(myform.getCloseEdate()));
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
