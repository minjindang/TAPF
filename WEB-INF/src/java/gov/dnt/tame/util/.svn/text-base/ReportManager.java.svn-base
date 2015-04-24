package gov.dnt.tame.util;

import gov.dnt.tame.sys.ExcelReportServlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ReportManager {
	private Log log = LogFactory.getLog(this.getClass());
	private final static String REPORT_PATH_PREFIX = "\\excel\\";
	private final static String REPORT_PATH_SUFFIX = ".xls";
	private String realPath;
	private String programId;
	private Map parameters;
	private Map crypticalParameters;

	public ReportManager(String id,Map parameters,String realPath) {
		this.programId = id;
		this.parameters = parameters;
		this.realPath = realPath;
	}

	public ReportManager(String id,Map parameters,Map crypticalParameters,String realPath) {
		this.programId = id;
		this.parameters = parameters;
		this.crypticalParameters = crypticalParameters;
		this.realPath = realPath;
	}

	protected File print() throws FileNotFoundException
	{
		String sOutputDoc = getOutputDoc(programId);
		File outFile = new File(sOutputDoc);
		if( outFile.exists() )
			return outFile;
		else
			return null;
	}

	protected String getOutputDoc(String id)
	{
		String sInputDoc = getInputDoc(id);
		int r = (new Random()).nextInt(1000);

		String sOutputDoc = sInputDoc.substring(0,sInputDoc.lastIndexOf("."))+r+".xls";
		ActiveXComponent axc = ExcelReportServlet.getActiveXComponent();
		
		Dispatch workbooks = null;
		Dispatch workbook = null;
		Dispatch sheet = null; 
		Dispatch queryTables = null;
		Dispatch queryTable = null;
		try {
			axc.setProperty("Visible", new Variant(false) );
			//Dispatch.put(axc, "Visible", new Variant(false) );
			workbooks = axc.getProperty("Workbooks").toDispatch();
			workbook = Dispatch.call(workbooks, "Open", sInputDoc).toDispatch();
			
			try{
				Dispatch.call(workbooks, "Open", sOutputDoc).toDispatch();
				r = (new Random()).nextInt(1000);
				sOutputDoc = sInputDoc.substring(0,sInputDoc.lastIndexOf("."))+r+".xls";
			}catch (Exception e) {
			}
//			System.out.println("============"+workbook);
//			System.out.println("============"+r);
			Thread.sleep(5000);
			
			//Dispatch workbook = Dispatch.call(workbooks, "Open", Dispatch.Method, new Object[]{sInputDoc, new Variant(false), new Variant(true)}, new int[1] ).toDispatch();
	        queryData(workbook);
	        sheet = Dispatch.get(workbook,"ActiveSheet").toDispatch();
	        setParameter(sheet);
			//將查詢移除
			queryTables = Dispatch.get(sheet,"QueryTables").toDispatch();
			queryTable = Dispatch.call(queryTables,"Item",1).toDispatch();
			Dispatch.call(queryTable,"Delete");
	        //另存新檔
			Dispatch.call(workbook, "SaveAs", sOutputDoc );
//			Dispatch workbook_out = Dispatch.call(workbook, "SaveAs", sOutputDoc ).toDispatch(); 

		} catch (Exception e) {
			log.trace(e);
			e.printStackTrace();
		} finally {
	        //將檔案關閉
			//Dispatch.call(workbook_out, "Close");
			if(workbook!=null) {
				Dispatch.call(workbook, "Close");
				workbook.safeRelease();
			}
			
			if(workbooks!=null)
				workbooks.safeRelease();
			
			if(sheet!=null)
				sheet.safeRelease();
			
			if(queryTables!=null)
				queryTables.safeRelease();
			
			if(queryTable!=null)
				queryTable.safeRelease();
			
			ComThread.Release();
		}
		
		return sOutputDoc;
	}

	protected void setParameter(Dispatch sheet) {
		Set set = parameters.keySet();
		for(Iterator it=set.iterator();it.hasNext();)
		{
			String parameterName = (String) it.next();
			String parameter = (String) parameters.get(parameterName);

			//System.out.println("ReportManager:"+parameterName);
			Dispatch dp = Dispatch.invoke(sheet, "Range", Dispatch.Get, new Object[] {parameterName}, new int[1]).toDispatch();
			Dispatch.put(dp, "Value", parameter);
		}		
	}

	protected void queryData(Dispatch workbook) {
        try {
    		//查詢資料
            Dispatch.call(workbook,"RefreshAll");
			Thread.sleep(60 * 60 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private String getInputDoc(String programId) {
		return realPath + REPORT_PATH_PREFIX + programId + REPORT_PATH_SUFFIX;
	}
	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public Map getParameters() {
		return parameters;
	}

	public void setParameters(Map parameters) {
		this.parameters = parameters;
	}

	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	public Map getCrypticalParameters() {
		return crypticalParameters;
	}

	public void setCrypticalParameters(Map crypticalParameters) {
		this.crypticalParameters = crypticalParameters;
	}
}