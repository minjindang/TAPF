package tw.gov.nta.account.action;
 
import java.sql.Connection;
import java.sql.SQLException;

import java.util.LinkedHashMap;
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

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.ExcelReportAction;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import gov.dnt.tame.util.XLSExporter;

public class ECRF0102 extends JacobReportAction {

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		AccountQueryForm myForm = (AccountQueryForm)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		//map.put( position, value );
		//map.put("Z1","TAPF");
//		map.put("I3","單位：新台幣"+CodeDetManage.getCodeName("BU",myForm.getAmountUnit().toString()));
//		map.put("A3","製表日期："+DateUtil.date2ChineseROC2(new Date()));
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "ECRF01";
	}
}
//public class ECRF0102 extends ExcelReportAction {
//	private Log log = LogFactory.getLog(this.getClass());
//	public final short DEFAULT_PAPERSIZE = PageSize.A4_PAPERSIZE;
//	public final boolean LANDSCAPE = true;
//	protected boolean isLANDSCAPE() {return LANDSCAPE;}
//	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
//
//	
//	
//	@Override
//	public String getJasperFileName() {
//		// TODO Auto-generated method stub
//		return "ECRF01_RPT1.jasper";
//	}
//
//	@Override
//	public Map getReportParameter(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response,
//			Connection connection) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	//原ExcelReportAction改同一個Sheet需改寫但不改共用,所以自己寫
//	private String getProgramName(Connection connection,String programId) throws SQLException
//	{
//		String programName = "";
//		try {
//			SQLRunner run = new ConnectionSQLRunner(connection);
//			MapHandler mh = new MapHandler();
//			SQLJob job = new SQLJob("select NAME from PM0003_DB WHERE PATH=?");
//			job.addParameter( programId );
//			Map map = (Map) run.query(job,mh);
//			programName = (String) map.get("NAME");
//		} catch (SQLException e) {
//			log.error("Error printing report", e);
//			throw e;
//		}
//		return "".equals(programName)?"noname":programName;
//	}
//	public ActionForward executeQuery(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response,
//			Connection connection) throws Exception {
//
//		Map parameters = getReportParameter(mapping,form,request,response,connection);
//
//		StringBuffer jasperPath = new StringBuffer("");
//		jasperPath.append(this.getServlet().getServletContext().getRealPath(""));
//		jasperPath.append("\\");
//		jasperPath.append(getJasperFileName().substring(0,3));
//		jasperPath.append("\\reports\\");
//		jasperPath.append(getJasperFileName());
//		log.trace( jasperPath );
//		
//		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperPath.toString());
//    	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
//
//    	String fileName = getProgramName(connection,getJasperFileName().substring(0,6));
//    	fileName = new String(fileName.getBytes("MS950"), "ISO-8859-1");
//
//    	//for excel download
//		response.setLocale(Locale.TAIWAN);
//		response.setContentType("application/excel");
//		response.setHeader("Content-disposition","attachment; filename="+fileName+".xls");
//
//		XLSExporter exporterXLS = new XLSExporter(getDEFAULT_PAPERSIZE(),isLANDSCAPE()); 
//    	exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint); 
//    	exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, response.getOutputStream()); 
//    	exporterXLS.setParameter(JRXlsExporterParameter.CHARACTER_ENCODING, "BIG5");
//    	//設定是否為同一Sheet
//    	exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE); 
//    	exporterXLS.setParameter(JRXlsExporterParameter.IS_AUTO_DETECT_CELL_TYPE, Boolean.TRUE); 
//    	exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE); 
//    	exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE); 
//    	exporterXLS.exportReport(); 
//    	return null;
//	}
//
//}
