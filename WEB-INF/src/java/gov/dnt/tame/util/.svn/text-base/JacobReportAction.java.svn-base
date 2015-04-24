package gov.dnt.tame.util;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.pm.ProgramManagerDAO;

import java.io.File;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;

import com.jacob.com.ComThread;

public abstract class JacobReportAction extends DefaultAction {
	private Log log = LogFactory.getLog(this.getClass());

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {
		
		ReportManager reportManager = getReportManager(form,request);
		File file = null;
		try{
			file = reportManager.print();
			log.trace( file.getAbsolutePath() );
		}catch(Exception e){		
			ComThread.Release();
		}
		String programId = getProgramId(request);
		if( programId!=null && programId.length()>6 )
			programId = programId.substring(0,6);
		String progName = getProgramName(connection,programId);
		progName = new String(progName.getBytes("Big5"), "ISO-8859-1");
		byte[] bytes = FileUtils.readFileToByteArray(file);

		response.setContentType("application/excel");
		response.setHeader("Content-disposition", "attachment; filename=\"" + progName + ".xls\"");
		OutputStream os = response.getOutputStream();
		os.write(bytes);
		os.flush();
		os.close();
		response.flushBuffer();
		file.delete();
	}

	protected abstract String getProgramId(HttpServletRequest request);

	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request){
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request){
		return new LinkedHashMap<String,Object>();
	}

	protected Map<String,Object> getCrypticalParameter(ActionForm form, HttpServletRequest request){
		return new LinkedHashMap<String,Object>();
	}

	protected String getProgramName(Connection connection,String programId) throws SQLException
	{
		ProgramManagerDAO dao = new ProgramManagerDAO(connection);
		return dao.getProgramName(programId);
	}
	protected String getRealPath(){
		return this.getServlet().getServletContext().getRealPath("");
	}
}