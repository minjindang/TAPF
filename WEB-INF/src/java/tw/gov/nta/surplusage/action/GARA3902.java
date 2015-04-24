package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara3901Form;

public class GARA3902 extends JacobReportAction
{
	private final static String PROGRAM_ID = "GARA39_1";

	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}

	@SuppressWarnings("unchecked")
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A3","製表日期:"+DateUtil.date2ChineseROC2(new Date()));
		Map tempA = (Map) request.getAttribute("debtMapA");
		Map tempC = (Map) request.getAttribute("debtMapC");
		if(tempA!=null){
			map.put("A1",DateUtil.date2ROCStr((Date)tempA.get("issue_date"),"yyy.mm.dd"));
			map.put("B1",(String)tempA.get("debt_name"));
		}
		if(tempC!=null){
			map.put("C1",DateUtil.date2ROCStr((Date)tempC.get("issue_date"),"yyy.mm.dd"));
			map.put("D1",(String)tempC.get("debt_name"));
		}
		Gara3901Form myForm = (Gara3901Form) form;
		String year = myForm.getYear();

		map.putAll( putYearCell(map,year) );

		List sheet1List = (List) request.getAttribute("GARA39_RPT1");
		if( sheet1List!=null && !sheet1List.isEmpty() )
		{
			for( Iterator it=sheet1List.iterator();it.hasNext();)
			{
				Map sheet1Map = (Map) it.next();
				String type = (String) sheet1Map.get("debt_type");
				int rownum = 0;
				//公債			C6~N6,O6,P6,Q6
				if( "公債".equals( type ) ) 	rownum = 6;
				//中長期借款	C7~N7,O7,P7,Q7
				if( "中長期借款".equals( type ) ) 	rownum = 7;
				//戰機借款		C8~N8,O8,P8,Q8
				if( "戰機借款".equals( type ) ) 	rownum = 8;
				//省債			C9~N9,O9,P9,Q9
				if( "省債".equals( type ) ) 	rownum = 9;
				map.putAll( putSheet1Cell(map,sheet1Map,rownum) );
			}
		}

		List sheet3List = (List) request.getAttribute("GARA39_RPT3");
		if( sheet3List!=null && !sheet3List.isEmpty() )
		{
			for( Iterator it=sheet3List.iterator();it.hasNext();)
			{
				Map sheet3Map = (Map) it.next();
				map.putAll( putSheet3Cell(map,sheet3Map) );
			}
		}		
		return map;
	}

	private Map<String,Object> putSheet1Cell(Map<String,Object> map,Map dataMap,int rownum)
	{
		String[] cell = {"C","D","E","F","G","H","I","J","K","L","M","O","P","Q"};
		String[] columnName = {"year1","year2","year3","year4","year5","year6","year7","year8","year9","year10","year11","year_5_1","year_5_2","year_5_3"};
		for(int i=0;i<cell.length;i++)
		{
			map.put( cell[i]+String.valueOf( rownum ), new BigDecimal(dataMap.get( columnName[i] ).toString()).divide(new BigDecimal(100000000),2,4).toString() );
		}
		return map;
	}

	private Map<String,Object> putSheet3Cell(Map<String,Object> map,Map dataMap)
	{
		Integer month = (Integer) dataMap.get("mon");
		String[] cell = {"C","D","E","F","G","H","I","J","K","L","M"};
		String[] columnName = {"year1","year2","year3","year4","year5","year6","year7","year8","year9","year10","year11"};
		for(int i=0;i<cell.length;i++)
		{
//			BigDecimal totalAmount = new BigDecimal(0);
//			if (month == i && map.get(cell[i])!=null){
//				BigDecimal amount = new BigDecimal (map.get(cell[i])+String.valueOf( month.intValue()+11 ));
//				totalAmount = ((BigDecimal)dataMap.get( columnName[i] )).add(amount);
//			}
//			else
//				totalAmount = ((BigDecimal)dataMap.get( columnName[i] ));
			map.put( cell[i]+String.valueOf( month.intValue()+11 ),  new BigDecimal(dataMap.get( columnName[i] ).toString()).divide(new BigDecimal(100000000),2,4).toString()  );
		}
		return map;
	}

	private Map<String,Object> putYearCell(Map<String,Object> map,String year)
	{
		String[] cell = {"C","D","E","F","G","H","I","J","K","L","M"};
		int lastYear = 0;
		for(int i=0;i<cell.length;i++)
		{
			lastYear = Integer.parseInt(year)+i;
			map.put( cell[i]+"5", String.valueOf( lastYear ) );
		}
		map.put( "O5", String.valueOf( lastYear+1 ) +"~"+String.valueOf( lastYear+5 ) );
		map.put( "P5", String.valueOf( lastYear+6 ) +"~"+String.valueOf( lastYear+10 ) );
		map.put( "Q5", String.valueOf( lastYear+11 ) +"~" );
		return map;
	}
}
