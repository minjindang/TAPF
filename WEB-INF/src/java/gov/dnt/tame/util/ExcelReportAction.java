/*
 * 在 2006/2/27 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package gov.dnt.tame.util;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public abstract class ExcelReportAction extends DefaultAction{
	private Log log = LogFactory.getLog(this.getClass());

	protected abstract boolean isLANDSCAPE();
	protected abstract short getDEFAULT_PAPERSIZE();

	/**
	 * 取得 *.jasper 之絕對路徑
	 * @return String
	 */
	public abstract String getJasperFileName();
	/**
	 * 取得欲傳入 report 之參數集合
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @param connection
	 * @return Map
	 */
	public abstract Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection);

	public ActionForward executeQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) throws Exception {

		Map parameters = getReportParameter(mapping,form,request,response,connection);

		StringBuffer jasperPath = new StringBuffer("");
		jasperPath.append(this.getServlet().getServletContext().getRealPath(""));
		jasperPath.append("\\");
		jasperPath.append(getJasperFileName().substring(0,3));
		jasperPath.append("\\reports\\");
		jasperPath.append(getJasperFileName());
		log.trace( jasperPath );
		
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperPath.toString());
    	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

    	String fileName = getProgramName(connection,getJasperFileName().substring(0,6));
    	fileName = new String(fileName.getBytes("MS950"), "ISO-8859-1");

    	//for excel download
		response.setLocale(Locale.TAIWAN);
		response.setContentType("application/excel");
		response.setHeader("Content-disposition","attachment; filename="+fileName+".xls");

		XLSExporter exporterXLS = new XLSExporter(getDEFAULT_PAPERSIZE(),isLANDSCAPE()); 
    	exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint); 
    	exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, response.getOutputStream()); 
    	exporterXLS.setParameter(JRXlsExporterParameter.CHARACTER_ENCODING, "BIG5");
    	exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE); 
    	exporterXLS.setParameter(JRXlsExporterParameter.IS_AUTO_DETECT_CELL_TYPE, Boolean.TRUE); 
    	exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE); 
    	exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE); 
    	exporterXLS.exportReport(); 
    	return null;
	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		// not used
	}

	private String getProgramName(Connection connection,String programId) throws SQLException
	{
		String programName = "";
		try {
			SQLRunner run = new ConnectionSQLRunner(connection);
			MapHandler mh = new MapHandler();
			SQLJob job = new SQLJob("select NAME from PM0003_DB WHERE PATH=?");
			job.addParameter( programId );
			Map map = (Map) run.query(job,mh);
			programName = (String) map.get("NAME");
		} catch (SQLException e) {
			log.error("Error printing report", e);
			throw e;
		}
		return "".equals(programName)?"noname":programName;
	}
}
