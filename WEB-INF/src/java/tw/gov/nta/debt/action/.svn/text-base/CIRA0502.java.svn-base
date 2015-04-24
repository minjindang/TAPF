/* CIRA0502.java 報表
 程式目的：CIRA05
 程式代號：CIRA05
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ExcelReportAction;
import gov.dnt.tame.util.XLSExporter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
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

import tw.gov.nta.debt.form.Cira0501Form;

public class CIRA0502 extends ExcelReportAction {
	private Log log = LogFactory.getLog(this.getClass());
	public final short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;
	public final boolean LANDSCAPE = false;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}

	@Override
	public String getJasperFileName() {
		return "CIRA05_RPT.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		// TODO Auto-generated method stub
		Cira0501Form myform = (Cira0501Form) form;
		Map<String,Object> parameters = new HashMap<String,Object>();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得製表日期
		String createDate = DateUtil.date2ChineseROC(DateUtil.date());
		parameters.put("usrId",usrId);
		parameters.put("createDate",createDate);
		parameters.put("baseUnit",myform.getBaseUnitValue());
		parameters.put("endDate",DateUtil.date2ChineseROC2(myform.getBaseDate()));
		parameters.put("status",myform.getStatus());
		if(null != myform.getBudgetLabel() && !"".equals(myform.getBudgetLabel()))
		{	
			parameters.put("budgetCode",myform.getBudgetLabel());
		}	
		if(null != myform.getDebtLabel() && !"".equals(myform.getDebtLabel()))
		{	
			parameters.put("debtCode",myform.getDebtLabel());
		}	
		return parameters;
	}
	//不繼承自己改寫其中的一個屬性
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
    	//exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE); 
    	exporterXLS.setParameter(JRXlsExporterParameter.IS_AUTO_DETECT_CELL_TYPE, Boolean.TRUE); 
    	exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE); 
    	exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE); 
    	exporterXLS.exportReport(); 
    	return null;
	}
	public String getProgramName(Connection connection,String programId) throws SQLException
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
