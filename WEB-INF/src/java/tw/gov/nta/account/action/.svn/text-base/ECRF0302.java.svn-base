package tw.gov.nta.account.action;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.ExcelReportAction;

public class ECRF0302 extends ExcelReportAction {
	public final short DEFAULT_PAPERSIZE = PageSize.A4_PAPERSIZE;
	public final boolean LANDSCAPE = false;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}

	@Override
	public String getJasperFileName() {
		// TODO Auto-generated method stub
		return "ECRF03_RPT.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		// TODO Auto-generated method stub
		Map<String,Object> parameters = new HashMap<String,Object>();
		
		return parameters;
	}

}
