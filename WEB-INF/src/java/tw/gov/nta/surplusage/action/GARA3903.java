package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.JacobReportAction;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara3901Form;

public class GARA3903 extends JacobReportAction
{
	private final static String PROGRAM_ID = "GARA39_2";

	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request)
	{
		String debtType = (String) request.getAttribute("debtType");

		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put( "A1", getA1(debtType) );
		map.put( "C3", getC3(debtType) );
		map.put( "D3", getD3(debtType) );

		Gara3901Form myForm = (Gara3901Form) form;
		String year = myForm.getYear();

		map.putAll( putYearCell(map,year) );

		List sheet2List = (List) request.getAttribute("GARA39_RPT2");
		int sheet2ListSize = 0;
		if( sheet2List!=null && !sheet2List.isEmpty() )
		{
			sheet2ListSize = sheet2List.size();
		}

		
		List sheet3List = (List) request.getAttribute("GARA39_RPT3");
		if( sheet3List!=null && !sheet3List.isEmpty() )
		{
			for( Iterator it=sheet3List.iterator();it.hasNext();)
			{
				Map sheet3Map = (Map) it.next();
				map.putAll( putSheet3Cell(map,sheet3Map,sheet2ListSize) );
			}
		}		
		return map;
	}

	private String getA1(String debtType)
	{
		if( "A".equals( debtType ) )
			return "未來十年中央政府債務還本落點分析--公債";
		else if( "C".equals( debtType ) )
			return "未來十年中央政府債務還本落點分析--中長期款借";
		else if( "F".equals( debtType ) )
			return "未來十年中央政府債務還本落點分析--戰機借款";
		else if( "G".equals( debtType ) )
			return "未來十年中央政府債務還本落點分析--省債";
		else
			return "未來十年中央政府債務還本落點分析";
	}
	
	private String getC3(String debtType)
	{
		if( "F".equals( debtType ) )
			return "借款金額";
		else
			return "年期";
	}
	
	private String getD3(String debtType)
	{
		if( "A".equals( debtType ) )
			return "發行日期";
		else if( "C".equals( debtType ) )
			return "發行日期";
		else if( "F".equals( debtType ) )
			return "第一次動支日期";
		else if( "G".equals( debtType ) )
			return "舉借日期";
		else
			return "發行(舉借)日期";
	}

	private Map<String,Object> putSheet3Cell(Map<String,Object> map,Map dataMap,int sheet2ListSize)
	{
		Integer month = (Integer) dataMap.get("mon");
		String[] cell = {"E","F","G","H","I","J","K","L","M","N","O"};
		String[] columnName = {"year1","year2","year3","year4","year5","year6","year7","year8","year9","year10","year11"};
		for(int i=0;i<cell.length;i++)
		{
			map.put( cell[i]+String.valueOf( month.intValue()+8+sheet2ListSize ), String.valueOf( dataMap.get( columnName[i] ) ) );
		}
		return map;
	}

	private Map<String,Object> putYearCell(Map<String,Object> map,String year)
	{
		String[] cell = {"E","F","G","H","I","J","K","L","M","N","O"};
		int lastYear = 0;
		for(int i=0;i<cell.length;i++)
		{
			lastYear = Integer.parseInt(year)+i;
			map.put( cell[i]+"4", String.valueOf( lastYear ) );
		}
		map.put( "Q4", String.valueOf( lastYear+1 ) +"~"+String.valueOf( lastYear+5 ) );
		map.put( "R4", String.valueOf( lastYear+6 ) +"~"+String.valueOf( lastYear+10 ) );
		map.put( "S4", String.valueOf( lastYear+11 ) +"~" );
		return map;
	}
}
