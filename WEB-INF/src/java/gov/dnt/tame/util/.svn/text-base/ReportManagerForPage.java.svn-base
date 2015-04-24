package gov.dnt.tame.util;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jacob.com.Dispatch;

public class ReportManagerForPage extends ReportManager {
	private Log log = LogFactory.getLog(this.getClass());

	private Integer rowCountPerPage;
	private Integer rowsCount;
	private String pageColumn;
	
	public ReportManagerForPage(String id, Map<String,Object> parameters, String realPath,
			Integer rowCountPerPage,Integer rowsCount,String pageColumn){
		super(id, parameters, realPath);
		setRowsCount(rowsCount);
		setRowCountPerPage(rowCountPerPage);
		this.pageColumn = pageColumn;
	}

	@Override
	protected void queryData(Dispatch workbook_out) {
		int p = 0;
        Dispatch firstSheet = Dispatch.call(workbook_out,"ActiveSheet").toDispatch();
        Dispatch activeSheet = firstSheet;
        
		for(int i=0;i<rowsCount + rowCountPerPage;i = i+rowCountPerPage){
			Dispatch dp = Dispatch.invoke(activeSheet, "Range", Dispatch.Get, new Object[] {pageColumn}, new int[1]).toDispatch();
			Dispatch.put(dp, "Value", "²Ä "+String.valueOf(i)+" ­¶");
			
			Dispatch queryTable = Dispatch.call(activeSheet,"QueryTable",1).toDispatch();
			Dispatch.call(queryTable,"Refresh");
			p++;
			setPage(queryTable,i + 1,i + rowCountPerPage,p);
			Dispatch.call(queryTable,"Delete");
			activeSheet = Dispatch.call(workbook_out,"Copy",activeSheet).toDispatch();
		}
	}

	private void setPage(Dispatch queryTable,int startRow,int endRow,int pageNumber){
		Dispatch parameters = Dispatch.get(queryTable,"Parameters").toDispatch();
		Dispatch pageStartParameter = Dispatch.call(parameters,"Parameter",1).toDispatch();
		Dispatch pageEndParameter = Dispatch.call(parameters,"Parameter",2).toDispatch();		
		Dispatch.call(pageStartParameter,"SetParam","xlConstant",startRow);
		Dispatch.call(pageEndParameter,"SetParam","xlConstant",endRow);
	}

	/**
	 * @return Returns the rowCountPerPage.
	 */
	public Integer getRowCountPerPage() {
		return rowCountPerPage;
	}
	/**
	 * @param rowCountPerPage The rowCountPerPage to set.
	 */
	public void setRowCountPerPage(Integer rowCountPerPage) {
		this.rowCountPerPage = rowCountPerPage;
	}
	/**
	 * @return Returns the rowsCount.
	 */
	public Integer getRowsCount() {
		return rowsCount;
	}
	/**
	 * @param rowsCount The rowsCount to set.
	 */
	public void setRowsCount(Integer rowsCount) {
		this.rowsCount = rowsCount;
	}
}
