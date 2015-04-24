package tw.gov.nta.account.action;

import gov.dnt.tame.common.CheckNullValue;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

public class EDRE0602 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "EDRE06";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		String usrId = this.getUserId(request);
		String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		String debtName= (String)request.getAttribute("debtName");
		String budgetName= (String)request.getAttribute("budgetName");
		String debitName= (String)request.getAttribute("debitName");
		String dayCount = (String)request.getAttribute("dayCount");
		String issueDate      = (String)request.getAttribute("issueDate");
		
		map.put("Z1",createDate);
		map.put("Z2",usrId);
		
		if (debtName != null){
			if( debtName.indexOf("短期借款") != -1){
				map.put("A2",CheckNullValue.checkNullPasueEmpty(debtName));
			}else{
				map.put("A2",CheckNullValue.checkNullPasueEmpty(debtName+"短期借款"));
			} 
		}else{
			map.put("A2","短期借款");
		}
		map.put("A4","預算別:"+CheckNullValue.checkNullPasueEmpty(budgetName));
		map.put("A5","債務別:"+CheckNullValue.checkNullPasueEmpty(debitName));
		map.put("A6","天    期："+CheckNullValue.checkNullPasueEmpty(dayCount));
		if ( issueDate == null || issueDate.equals("") || issueDate.substring(0,3).equals("")){
			map.put("B4","中華民國        年    月     日");
		}else if (Integer.parseInt(issueDate.substring(0,3))>= 100){
			map.put("B4","中華民國"+issueDate.substring(0,3)+"年"+issueDate.substring(4,6)+"月"+issueDate.substring(7,9)+"日");				
		}else{
			map.put("B4","中華民國"+issueDate.substring(1,3)+"年"+issueDate.substring(4,6)+"月"+issueDate.substring(7,9)+"日");							
		} 
		
		return map;
	}
	@Override
	protected String getProgramName(Connection connection, String programId) throws SQLException {
		// TODO Auto-generated method stub
		return super.getProgramName(connection,"EDRE06");
	}		
}