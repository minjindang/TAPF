package tw.gov.nta.account.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EARE0702 extends JacobReportAction 
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
	@Override
	protected String getProgramId(HttpServletRequest request) 
	{
		// TODO Auto-generated method stub
		return "EARE0701";
	}
	
	

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, 
			HttpServletRequest request) 
	{
		AccountQueryForm myForm = (AccountQueryForm)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("Z1","Z1");
		map.put("A2",(String)request.getAttribute("debtName"));
		String yyymmdd = DateUtil.getLastDateOfMonth(myForm.getAccountYear(),myForm.getMonth());
		map.put("A4","中華民國"+yyymmdd.substring(0,3)+"年"+yyymmdd.substring(3,5)+"月"+yyymmdd.substring(5,7)+"日");
		return map;
	}
	
	@Override
	protected String getProgramName(Connection connection, String programId) throws SQLException {
		// TODO Auto-generated method stub
		return super.getProgramName(connection,"EARE07");
	}
}
