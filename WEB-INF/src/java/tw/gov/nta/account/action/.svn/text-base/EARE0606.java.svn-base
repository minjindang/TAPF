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

public class EARE0606 extends JacobReportAction
{
	
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		String usrId = this.getUserId(request);
		String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		String debtName       = (String)request.getAttribute("debtName");
		String issueCount     = request.getAttribute("issueCount").toString();
		String issueAmount    = request.getAttribute("issueAmount").toString();
		String issueDate      = (String)request.getAttribute("issueDate");
		String diversityAmount= request.getAttribute("diversityAmount").toString();
		String realAmount     = request.getAttribute("realAmount").toString();
		String payableInterestAmount = request.getAttribute("payableInterestAmount").toString();
		map.put("Z1",createDate);
		map.put("Z2",usrId);
		map.put("Z3",issueDate);
		map.put("A2",debtName);
		map.put("B7",issueCount);
		map.put("C7",issueAmount);
		map.put("D7",realAmount);
		map.put("D8",diversityAmount);
		map.put("D10",payableInterestAmount);
		
		if ( issueDate == null || issueDate.equals("") || issueDate.substring(0,3).equals("")){
			map.put("C4","中華民國        年    月     日");
		}else if (Integer.parseInt(issueDate.substring(0,3))>= 100){
			map.put("C4","中華民國"+issueDate.substring(0,3)+"年"+issueDate.substring(4,6)+"月"+issueDate.substring(7,9)+"日");				
		}else{
			map.put("C4","中華民國"+issueDate.substring(1,3)+"年"+issueDate.substring(4,6)+"月"+issueDate.substring(7,9)+"日");							
		} 
		
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