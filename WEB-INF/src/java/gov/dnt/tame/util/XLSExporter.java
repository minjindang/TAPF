package gov.dnt.tame.util;

import gov.dnt.tame.common.PageSize;

import java.io.OutputStream;

import net.sf.jasperreports.engine.export.JRXlsExporter;

import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class XLSExporter extends JRXlsExporter {
	public short DEFAULT_PAPERSIZE;
	public boolean LANDSCAPE;

	public XLSExporter() {
		DEFAULT_PAPERSIZE = PageSize.A4_PAPERSIZE;
		LANDSCAPE = false;
	}

	public XLSExporter(short pagesize) {
		DEFAULT_PAPERSIZE = pagesize;
		LANDSCAPE = false;
	}

	public XLSExporter(short pagesize,boolean landscape) {
		DEFAULT_PAPERSIZE = pagesize;
		LANDSCAPE = landscape;
	}

	@Override
	protected void createSheet(String name) {
		sheet = workbook.createSheet(name);
		HSSFPrintSetup ps = sheet.getPrintSetup();  
		ps.setPaperSize(DEFAULT_PAPERSIZE);
		ps.setLandscape(LANDSCAPE);
	}

	@Override
	protected void openWorkbook(OutputStream arg0) {
		workbook = new HSSFWorkbook();
		emptyCellStyle = workbook.createCellStyle();
		emptyCellStyle.setFillForegroundColor((new HSSFColor.WHITE()).getIndex());
		emptyCellStyle.setFillPattern(backgroundMode);
		emptyCellStyle.setDataFormat((short)4);
	}
}
