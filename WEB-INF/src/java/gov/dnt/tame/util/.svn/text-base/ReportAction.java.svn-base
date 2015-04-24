package gov.dnt.tame.util;

import gov.dnt.tame.common.DefaultAction;

import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public abstract class ReportAction extends DefaultAction{

	public abstract String getJasperPath(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection);
	public abstract Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection);

	public ActionForward executeQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) throws Exception {
		String jasperPath = getJasperPath(mapping,form,request,response,connection);

		Map parameters = getReportParameter(mapping,form,request,response,connection);
		
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperPath);
    	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
    	response.setContentType("application/octet-stream");
    	ServletOutputStream ouputStream = response.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
    	oos.writeObject(jasperPrint);
    	oos.flush();
    	oos.close();
    	ouputStream.flush();
    	ouputStream.close();
        response.flushBuffer();
    	return null;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		// not used
	}
}	
