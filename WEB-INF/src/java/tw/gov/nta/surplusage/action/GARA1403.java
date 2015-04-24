package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara1401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA1403 extends ExcelReportBaseAction {

	protected SQLJob SQL1(String year, BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		//���ӤT�~year+2
		String year2 = String.valueOf(Integer.parseInt(year)+2);
		if (year2.length() < 3 ){
			for (int i = 0 ; i < 3-year2.length() ; i++){
				year2 = "0" + year2;
			}	
		}
		sqljob.appendSQL("select Right('000'+convert(varchar(3),");
		sqljob.appendSQL(" case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3) as year1,");
		sqljob.appendSQL("month(B.date1) as month1,");
		sqljob.appendSQL("sum(case when (kind = '1') and A.debt_type='B' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_B,");//��w?�٥���
		sqljob.appendSQL("sum(case when (kind = '1') and A.debt_type='B' then isnull(B_total,0) else 0 end)/"+unit+" as interest_total_B ");//��w?�Q����
		sqljob.appendSQL("from issue_main A,v_debt_plan_det B ");
		sqljob.appendSQL("where A.issue_serial = B.issue_serial ");
		sqljob.appendSQL("and date2 > '"+new Timestamp(new Date().getTime())+"' ");
		sqljob.appendSQL("and  Right('000'+convert(varchar(3),");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3) between '"+year+"' and '"+year2+"' ");
		sqljob.appendSQL("group by Right('000'+convert(varchar(3),");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3),month(B.date1) ");
		sqljob.appendSQL("order by Right('000'+convert(varchar(3),");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3),month(B.date1) ");
		System.out.println("GARA1403-SQL1"+sqljob.toString());	
		return sqljob;
	}
	
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
			
		Gara1401Form myForm = (Gara1401Form)form;
		String year = myForm.getIssueSdate();
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delSQLJob("GARA14_RPT2",usrId)); 
		//yearAmount[0][]=�@��,yearAmount[1][]=�G�� ....yearAmount[11][]=�T��
		BigDecimal yearAmount[][] = {{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
				{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
				{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
				{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
				{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
				{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
				{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
				{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
				{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
				{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
				{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
				{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
		};
		int yearStart = Integer.parseInt(year);
		List queryList1 = (List) run.query(SQL1(year,unit), new MapListHandler());
		Map tMap = null;
		int yearIndex = 0;
		int monthIndex= 0;
		for(Iterator it1=queryList1.iterator();it1.hasNext();){
			tMap = (Map) it1.next();
			/*
			 *�n��b���Ӧ�m,��:��J95�~
			 *yearIndex = 95 - 95 = 0 
			 *			  96 - 95 = 1
			 * 			  97 - 95 = 2	
			 * monthIndex = SQL.month1-1
			 */
			yearIndex = Integer.parseInt((String)tMap.get("year1"))-yearStart;
			monthIndex = ((Integer)tMap.get("month1")).intValue()-1;
			//��w?�٥����I��=�٥���+�Q����
			yearAmount[monthIndex][yearIndex]=((BigDecimal)tMap.get("capital_total_B")).add((BigDecimal)tMap.get("interest_total_B"));
		}
		String monthName[] = {"1�@�@�@�@�@��",
								"2�@�@�@�@�@��",
								"3�@�@�@�@�@��",
								"4�@�@�@�@�@��",
								"5�@�@�@�@�@��",
								"6�@�@�@�@�@��",
								"7�@�@�@�@�@��",
								"8�@�@�@�@�@��",
								"9�@�@�@�@�@��",
								"10�@�@ �@�@��",
								"11  �@ �@�@��",
								"12  �@ �@�@��"}; 
		Map dMap = new HashMap();
		for (int i = 0 ; i < monthName.length ; i++){
			dMap = new HashMap();
			dMap.putAll(getCommonMap(usrId));
			dMap.put("account_month",monthName[i]);
			dMap.put("year1",yearAmount[i][0]);
			dMap.put("year2",yearAmount[i][1]);
			dMap.put("year3",yearAmount[i][2]);
			dMap.put("total",yearAmount[i][0].add(yearAmount[i][1]).add(yearAmount[i][2]));
			run.update(connection,insTemp("GARA14_RPT2",dMap));
		}
	}

}
