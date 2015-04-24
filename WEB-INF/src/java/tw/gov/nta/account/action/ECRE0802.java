package tw.gov.nta.account.action;

import gov.dnt.tame.common.CheckNullValue;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class ECRE0802 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "ECRE08";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		//map.put( position, value );
		AccountQueryForm myForm = (AccountQueryForm) form;
		String LastDate = myForm.getLastDate();
		if  (null != LastDate || !LastDate.equals("") ){
			if (Integer.parseInt(LastDate.substring(0,3))>= 100){
				map.put("A4","中華民國"+LastDate.substring(0,3)+"年"+LastDate.substring(3,5)+"月"+LastDate.substring(5,7)+"日");				

			 }else{
				map.put("A4","中華民國"+LastDate.substring(1,3)+"年"+LastDate.substring(3,5)+"月"+LastDate.substring(5,7)+"日");							
			} 
		}
		IssueMain issue = IssueMainDAO.getInstance().get(myForm.getIssueId());
		map.put("A2",issue.getDebtName());
        map.put("Z1","TAPF");
		return map;
	}
}