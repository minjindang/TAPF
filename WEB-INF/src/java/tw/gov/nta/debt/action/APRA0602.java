package tw.gov.nta.debt.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import tw.gov.nta.debt.form.*;

public class APRA0602 extends JacobReportAction {

	@Override
	protected String getProgramId(HttpServletRequest request) 
	{
		// TODO Auto-generated method stub
		return "APRA06";
	}

	@Override
	protected Map<String, Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Apra0601Form myform = (Apra0601Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A2","中華民國" + Integer.parseInt(myform.getRepayDate().substring(0, 3))+"年"+Integer.parseInt(myform.getRepayDate().substring(3, 5)) + "月 日填發");
		if(myform.getShowType()!= null)
			map.put("D1","本 份 留 底 不 蓋 印 鑑");
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.getReportManager(form, request);
	}

	@Override
	protected String getProgramName(Connection connection, String programId) throws SQLException {
		// TODO Auto-generated method stub
		return super.getProgramName(connection, programId);
	}
	
	

}
