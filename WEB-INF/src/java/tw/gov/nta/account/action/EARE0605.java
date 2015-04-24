/**
 * @author Andrew Sung
 * @create 2006/4/12
 */

package tw.gov.nta.account.action;

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

public class EARE0605 extends JacobReportAction
{
	
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		String usrId = this.getUserId(request);
		String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		String debtName= (String)request.getAttribute("debtName");
		String issueDate= (String)request.getAttribute("issueDate");
		map.put("Z1",createDate);
		map.put("Z2",usrId);
		if ( issueDate == null || issueDate.equals("") || issueDate.substring(0,3).equals("")){
			map.put("C4","中華民國        年    月     日");
		}else if (Integer.parseInt(issueDate.substring(0,3))>= 100){
			map.put("C4","中華民國"+issueDate.substring(0,3)+"年"+issueDate.substring(4,6)+"月"+issueDate.substring(7,9)+"日");				
		}else{
			map.put("C4","中華民國"+issueDate.substring(1,3)+"年"+issueDate.substring(4,6)+"月"+issueDate.substring(7,9)+"日");							
		} 
		
//		map.put("Z3",issueDate);
		
		map.put("A2",debtName);
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
		return (String)request.getAttribute("file");
	}

	@Override
	protected String getProgramName(Connection connection, String programId) throws SQLException {
		// TODO Auto-generated method stub
		return super.getProgramName(connection,"EARE06");
	}
	
}