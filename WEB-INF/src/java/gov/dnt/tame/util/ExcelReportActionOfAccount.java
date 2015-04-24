/*
 * 在 2006/2/27 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package gov.dnt.tame.util;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public abstract class ExcelReportActionOfAccount extends DefaultAction{

	protected abstract boolean isLANDSCAPE();
	protected abstract short getDEFAULT_PAPERSIZE();

	/**
	 * 取得 *.jasper 之絕對路徑
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @param connection
	 * @return String
	 */
	public abstract String getJasperFileName(HttpServletRequest request);
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

		StringBuffer jasperPath = new StringBuffer("");
		jasperPath.append(this.getServlet().getServletContext().getRealPath(""));
		jasperPath.append("\\");
		jasperPath.append(getJasperFileName(request).substring(0,3));
		jasperPath.append("\\reports\\");
		jasperPath.append(getJasperFileName(request));
		System.out.println(jasperPath);
		String filename = getJasperFileName(request);
		filename = filename.substring(0,filename.lastIndexOf("."));

		Map parameters = getReportParameter(mapping,form,request,response,connection);
		
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperPath.toString());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
		if("A".equals((String)request.getSession().getAttribute("DEBTTYPE")))
		{
			
	    	@SuppressWarnings("unused") boolean trueprint = false;
	    	try{
	    		trueprint = JasperPrintManager.printReport(jasperPrint,false);
	    		setAlertMessage(request, "列印完成");
	    	}catch(Exception e){
	    		setAlertMessage(request, "列印失敗");
	    	}
		}
		else
		{
			//for excel download
			response.setHeader("Content-disposition","attachment; filename="+filename+".xls");

			XLSExporter exporterXLS = new XLSExporter(getDEFAULT_PAPERSIZE(),isLANDSCAPE()); 
	    	exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint); 
	    	exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, response.getOutputStream()); 
	    	exporterXLS.setParameter(JRXlsExporterParameter.CHARACTER_ENCODING, "BIG5");
	    	exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE); 
	    	exporterXLS.setParameter(JRXlsExporterParameter.IS_AUTO_DETECT_CELL_TYPE, Boolean.TRUE); 
	    	exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE); 
	    	exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE); 
	    	exporterXLS.exportReport(); 
		}
		return mapping.findForward("success");
	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		// not used
	}
}
