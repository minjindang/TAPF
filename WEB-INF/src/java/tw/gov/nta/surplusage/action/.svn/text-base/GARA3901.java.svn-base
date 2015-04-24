package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.surplusage.common.Gara39Report;
import tw.gov.nta.surplusage.common.Gara39Report_1021021;
import tw.gov.nta.surplusage.form.Gara3901Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA3901 extends ExcelReportBaseAction
{
	
	

	
	@SuppressWarnings("unchecked")
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob("GARA39_RPT1",usrId) );
		run.update( connection, delSQLJob("GARA39_RPT2",usrId) );
		run.update( connection, delSQLJob("GARA39_RPT3",usrId) );
		run.update( connection, delSQLJob("GARA39_RPT4",usrId) );

		Gara3901Form myForm = (Gara3901Form) form;
		String year = myForm.getYear();
		String month = myForm.getMonth();
		request.setAttribute("reportYear",year);
		request.setAttribute("reportMonth",month);
		
		Gara39Report gara39Report = new Gara39Report();
		Gara39Report_1021021 gara39Report_1021021 = new Gara39Report_1021021();
		String reportType = myForm.getReportType();
		String debtType = myForm.getDebtType();

		if( "1".equals( reportType ) )
		{
			List<String> typesList = new LinkedList<String>();
			typesList.add("公債");
			typesList.add("中長期借款");
			typesList.add("債務基金(短借)");
			
			//102 10 21 改使用以下新的取得方式
			List sheet1List = new LinkedList();
			//加入公債
			sheet1List.addAll((List) run.query(gara39Report_1021021.selectSheet1ByDebtTypeA(myForm), new MapListHandler()));
			//中長借
			sheet1List.addAll((List) gara39Report_1021021.selectSheet1ByDebtTypeC(myForm,run));
			//短借
			sheet1List.addAll((List) run.query(gara39Report_1021021.selectSheet1ByDebtTypeD(myForm), new MapListHandler()));
			for(String str : typesList){
				boolean isEmpty = true;
				for(int i = 0 ; i < sheet1List.size() ; i ++){
					Map tempMap = (Map)sheet1List.get(i);
					if(tempMap != null && str.equals(tempMap.get("debt_type")))
						isEmpty = false;
				}
				if(isEmpty)
					sheet1List.add( getNullMap(str) );
			}
			if( sheet1List!=null && !sheet1List.isEmpty() )
			{
				gara39Report_1021021.insertSheet1(connection, run, sheet1List,usrId);
				request.setAttribute("GARA39_RPT1",sheet1List);
			}

			List sheet3List = new LinkedList();
			//加入公債
			List sheet3List_1 = (List) run.query(gara39Report_1021021.selectSheet3ByDebtTypeA(myForm), new MapListHandler());
			//中長借
			List sheet3List_2 = gara39Report_1021021.selectSheet3ByDebtTypeC(myForm,run);
			//短借
			List sheet3List_3 = (List) run.query(gara39Report_1021021.selectSheet3ByDebtTypeD(myForm), new MapListHandler());
			
			mergeMapList(sheet3List,sheet3List_1);
			mergeMapList(sheet3List,sheet3List_2);
			mergeMapList(sheet3List,sheet3List_3);
			
			if( sheet3List!=null && !sheet3List.isEmpty() )
			{
				gara39Report.insertSheet3(connection, run, sheet3List,usrId);
				request.setAttribute("GARA39_RPT3",sheet3List);
			}
			Map tempMapA = (Map)((List) run.query(gara39Report.getMaxDebtA(myForm), new MapListHandler())).get(0);
			request.setAttribute("debtMapA",tempMapA);
			Map tempMapC = (Map)((List) run.query(gara39Report.getMaxDebtC(myForm), new MapListHandler())).get(0);
			request.setAttribute("debtMapC",tempMapC);
			
			Map remarkMapLine1 = (Map)run.query(gara39Report_1021021.getRemarkMapLine1(myForm),new MapHandler());
			Map remarkMapLine2 = (Map)run.query(gara39Report_1021021.getRemarkMapLine2(myForm),new MapHandler());
			Map remarkMapLine3 = (Map)run.query(gara39Report_1021021.getRemarkMapLine3(myForm),new MapHandler());
			Map remarkMapLine4 = (Map)run.query(gara39Report_1021021.getRemarkMapLine4(myForm),new MapHandler());
			Map remarkMapLine5 = (Map)run.query(gara39Report_1021021.getRemarkMapLine5(myForm),new MapHandler());
			request.setAttribute("remarkMapLine1",remarkMapLine1);
			request.setAttribute("remarkMapLine2",remarkMapLine2);
			request.setAttribute("remarkMapLine3",remarkMapLine3);
			request.setAttribute("remarkMapLine4",remarkMapLine4);
			request.setAttribute("remarkMapLine5",remarkMapLine5);
		}
		else
		{
			List sheet2List = (List) run.query(gara39Report.selectSheet2(myForm,debtType), new MapListHandler());
			if( sheet2List!=null && !sheet2List.isEmpty() )
			{
				gara39Report.insertSheet2(connection, run, sheet2List,usrId);
				request.setAttribute("GARA39_RPT2",sheet2List);
			}

			List sheet4List = (List) run.query(gara39Report.selectSheet4(myForm,debtType), new MapListHandler());
			if( sheet4List!=null && !sheet4List.isEmpty() )
			{
				gara39Report.insertSheet3(connection, run, sheet4List,usrId);
				request.setAttribute("GARA39_RPT3",sheet4List);
			}
			request.setAttribute("debtType",debtType);
		}

		return mapping.findForward("type"+reportType);
	}
	private void mergeMapList(List dist , List from){
		if(from != null ){
			for(int i = 0 ; i < from.size() ; i ++){
				Map list1Map = (Map)from.get(i);
				boolean isExist = false;
				for(int j = 0 ; j < dist.size() ; j ++){
					Map mainMap = (Map)dist.get(j);
					if(list1Map.get("mon").equals(mainMap.get("mon"))){
						isExist = true;
						for(int count = 1 ; count < 11 ; count++)
							mainMap.put("year"+count, ((BigDecimal)mainMap.get("year"+count)).add((BigDecimal)list1Map.get("year"+count)));
						for(int count = 1 ; count < 4 ; count++)
							mainMap.put("year_5_"+count, ((BigDecimal)mainMap.get("year_5_"+count)).add((BigDecimal)list1Map.get("year_5_"+count)));
					}
				}
				if(!isExist){
					Map mainMap = new HashMap();
					mainMap.put("mon",list1Map.get("mon"));
					for(int count = 1 ; count < 11 ; count++)
						mainMap.put("year"+count, (BigDecimal)list1Map.get("year"+count));
					for(int count = 1 ; count < 4 ; count++)
						mainMap.put("year_5_"+count, (BigDecimal)list1Map.get("year_5_"+count));
					dist.add(mainMap);
				}
			}
		}
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// do nothing
	}

	private Map<String, Object> getNullMap(String type)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "debt_type", type);

		String[] columnName = {"year1","year2","year3","year4","year5","year6","year7","year8","year9","year10","year11","year_5_1","year_5_2","year_5_3"};
		for(int i=0;i<columnName.length;i++)
		{
			map.put( columnName[i], new BigDecimal(0.00) );
		}
		return map;
	}
	private Map<String, Object> subMap(Map map1,Map map2)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		if(map1.get("debt_type") != null)
			map.put( "debt_type", map1.get("debt_type"));
		else if(map1.get("mon") != null)
			map.put( "mon", map1.get("mon"));
		String[] columnName = {"year1","year2","year3","year4","year5","year6","year7","year8","year9","year10","year11","year_5_1","year_5_2","year_5_3"};
		for(int i=0;i<columnName.length;i++)
		{
			map.put( columnName[i],new BigDecimal(map1.get(columnName[i]).toString()).subtract(new BigDecimal(map2.get(columnName[i]).toString())));
		}
		return map;
	}
}