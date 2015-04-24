package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class EBRE0303 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	private final static String PROGRAM_ID = "EBRE03";

	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		//map.put( position, value );
		AccountQueryForm myform = (AccountQueryForm)form;
		int year = Integer.parseInt(myform.getAccountYear())+1911;
		int month = Integer.parseInt(myform.getMonth());
		int day = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.set(year,month,1);
		calendar.add(Calendar.DATE,-1);
		year = calendar.get(Calendar.YEAR)-1911;
		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DATE);
		map.put("Z1","TAPF");
		map.put("A3","中華民國"+String.valueOf(year)+"年"+String.valueOf(month)+"月"+String.valueOf(day)+"日");
		return map;
	}
	@Override
	protected String getProgramName(Connection connection, String programId) throws SQLException {
		// TODO Auto-generated method stub
		return super.getProgramName(connection,"EBRE03");
	}	
}