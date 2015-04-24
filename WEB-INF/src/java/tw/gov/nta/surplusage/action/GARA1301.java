package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara1301Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA1301 extends ExcelReportBaseAction {

//	protected SQLJob SQL1(String year, BigDecimal unit){
//		SQLJob sqljob = new SQLJob();
//		//未來三年year+2
//		String year2 = String.valueOf(Integer.parseInt(year)+2);
//		if (year2.length() < 3 ){
//			for (int i = 0 ; i < 3-year2.length() ; i++){
//				year2 = "0" + year2;
//			}	
//		}	
//
//		sqljob.appendSQL("select Right('000'+convert(varchar(3),"); 
//		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 "); 
//		sqljob.appendSQL("then  year(B.date1)+1"); 
//		sqljob.appendSQL("else  year(B.date1) "); 
//		sqljob.appendSQL("end-1911),3) as year1,"); 
//		sqljob.appendSQL("sum(case when (kind = '1') and A.debt_type='B' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_B,"); 	//國庫?還本數
//		sqljob.appendSQL("sum(case when (kind = '1') and A.debt_type='B' then isnull(B_total,0) else 0 end)/"+unit+" as interest_total_B,"); //國庫?利息數
//		sqljob.appendSQL("sum(case when (kind = '2') and A.debt_type='D' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_D,"); //短期借款還本數
//		sqljob.appendSQL("sum(case when (kind = '2') and A.debt_type='D' then isnull(B_total,0) else 0 end)/"+unit+" as interest_total_D ");  //短期借款利息數
//		sqljob.appendSQL("from issue_main A,v_debt_plan_det B "); 
//		sqljob.appendSQL("where A.issue_serial = B.issue_serial "); 
//		sqljob.appendSQL("and date2 > '"+new Timestamp(new Date().getTime())+"' ");
//		sqljob.appendSQL("and Right('000'+convert(varchar(3),");  
//		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 "); 
//		sqljob.appendSQL("then  year(B.date1)+1 "); 
//		sqljob.appendSQL("else  year(B.date1) "); 
//		sqljob.appendSQL("end-1911),3) between '"+year+"' and '"+year2+"' "); 
//		sqljob.appendSQL("group by Right('000'+convert(varchar(3),"); 
//		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 "); 
//		sqljob.appendSQL("then  year(B.date1)+1 "); 
//		sqljob.appendSQL("else  year(B.date1) "); 
//		sqljob.appendSQL("end-1911),3) "); 
//		sqljob.appendSQL("order by Right('000'+convert(varchar(3),"); 
//		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 "); 
//		sqljob.appendSQL("then  year(B.date1)+1 "); 
//		sqljob.appendSQL("else  year(B.date1) "); 
//		sqljob.appendSQL("end-1911),3) "); 
//		System.out.println("GARA1301-SQL1"+sqljob.toString());	
//		return sqljob;
//	}
	private SQLJob SQL1(String year1, BigDecimal unit) {
		
		String year3 = String.valueOf(Integer.parseInt(year1)+2);
		
		SQLJob insSQL = new SQLJob();
		
		if (year3.length() < 3 ){
			for (int i = 0 ; i < 3-year3.length() ; i++){
				year3 = "0" + year3;
			}	
		}

		String year2 = String.valueOf(Integer.parseInt(year1)+1);
		if (year2.length() < 3 ){
			for (int i = 0 ; i < 3-year2.length() ; i++){
				year2 = "0" + year2;
			}	
		}
		
		insSQL.appendSQL("insert into gara13_rpt(issue_serial,days,issue_date,due_date,year1,year2,year3,total)");
		insSQL.appendSQL("select B.issue_serial,");
		insSQL.appendSQL("datediff(dd,B.date3,B.date2) as days,");
		insSQL.appendSQL("B.date3 as issue_date,");
		insSQL.appendSQL("B.date2 as due_date,");
		insSQL.appendSQL("sum(case when (year(date1)-1911="+year1+") and kind = '1' and A.debt_type='B' then A_total + B_total else 0 end)/"+unit+" as year1,");
		insSQL.appendSQL("sum(case when (year(date1)-1911="+year2+") and kind = '1' and A.debt_type='B' then A_total + B_total else 0 end)/"+unit+" as year2,");
		insSQL.appendSQL("sum(case when (year(date1)-1911="+year3+") and kind = '1' and A.debt_type='B' then A_total + B_total else 0 end)/"+unit+" as year3,");
		insSQL.appendSQL("(sum(case when (year(date1)-1911="+year1+") and kind = '1' and A.debt_type='B' then A_total + B_total else 0 end)+");
		insSQL.appendSQL("sum(case when (year(date1)-1911="+year2+") and kind = '1' and A.debt_type='B' then A_total + B_total else 0 end)+");
		insSQL.appendSQL("sum(case when (year(date1)-1911="+year3+") and kind = '1' and A.debt_type='B' then A_total + B_total else 0 end))/"+unit+"as total ");
		insSQL.appendSQL("from issue_main A,v_debt_plan_det B ");
		insSQL.appendSQL("where A.issue_serial = B.issue_serial ");
		insSQL.appendSQL("and A.DEBT_CODE not in (25,61,31) ");
		insSQL.appendSQL("and date2 > '"+new Timestamp(new Date().getTime())+"' ");
		insSQL.appendSQL("and year(B.date1)-1911 between "+year1+" and "+year3+" ");
		insSQL.appendSQL("and debt_type = 'B' ");
		insSQL.appendSQL("group by  B.issue_serial,");
		insSQL.appendSQL("datediff(dd,B.date2,B.date3),");
		insSQL.appendSQL("B.date3,");
		insSQL.appendSQL("B.date2 ");
		insSQL.appendSQL("union all");
		insSQL.appendSQL("select B.issue_serial, ");
		insSQL.appendSQL("datediff(dd,B.date3,B.date2) as days, ");
		insSQL.appendSQL("B.date3 as issue_date, B.date2 as due_date, ");
		insSQL.appendSQL("(sum(case when (year(date1)-1911="+year1+") and kind = '2' and A.debt_type='D' then A_total else 0 end)-");
		insSQL.appendSQL("(select isNull(sum(capital_amount),0) as pay_amount from payment_main where 1=1");
		insSQL.appendSQL("and issue_id = (select id from issue_main where issue_serial = 'B.issue_serial' and debt_type = 'D') ");
		insSQL.appendSQL("and repay_date <= '"+new Timestamp(new Date().getTime())+"'))/"+unit+" as year1, ");
		insSQL.appendSQL("(sum(case when (year(date1)-1911="+year2+") and kind = '2' and A.debt_type='D' then A_total else 0 end)-");
		insSQL.appendSQL("(select isNull(sum(capital_amount),0) as pay_amount from payment_main where 1=1");
		insSQL.appendSQL("and issue_id = (select id from issue_main where issue_serial = 'B.issue_serial' and debt_type = 'D') ");
		insSQL.appendSQL("and repay_date <= '"+new Timestamp(new Date().getTime())+"'))/"+unit+" as year2, ");
		insSQL.appendSQL("(sum(case when (year(date1)-1911="+year3+") and kind = '2' and A.debt_type='D' then A_total else 0 end)-");
		insSQL.appendSQL("(select isNull(sum(capital_amount),0) as pay_amount from payment_main where 1=1");
		insSQL.appendSQL("and issue_id = (select id from issue_main where issue_serial = 'B.issue_serial' and debt_type = 'D') ");
		insSQL.appendSQL("and repay_date <= '"+new Timestamp(new Date().getTime())+"'))/"+unit+" as year3, ");
		insSQL.appendSQL("(sum(case when (year(date1)-1911="+year1+") and kind = '2' and A.debt_type='D' then A_total else 0 end)-");
		insSQL.appendSQL("(select isNull(sum(capital_amount),0) as pay_amount from payment_main where 1=1");
		insSQL.appendSQL("and issue_id = (select id from issue_main where issue_serial = 'B.issue_serial' and debt_type = 'D') ");
		insSQL.appendSQL("and repay_date <= '"+new Timestamp(new Date().getTime())+"')+ ");
		insSQL.appendSQL("sum(case when (year(date1)-1911="+year2+") and kind = '2' and A.debt_type='D' then A_total  else 0 end)-");
		insSQL.appendSQL("(select isNull(sum(capital_amount),0) as pay_amount from payment_main where 1=1");
		insSQL.appendSQL("and issue_id = (select id from issue_main where issue_serial = 'B.issue_serial' and debt_type = 'D') ");
		insSQL.appendSQL("and repay_date <= '"+new Timestamp(new Date().getTime())+"')+ ");
		insSQL.appendSQL("sum(case when (year(date1)-1911="+year3+") and kind = '2' and A.debt_type='D' then A_total  else 0 end)-");
		insSQL.appendSQL("(select isNull(sum(capital_amount),0) as pay_amount from payment_main where 1=1");
		insSQL.appendSQL("and issue_id = (select id from issue_main where issue_serial = 'B.issue_serial' and debt_type = 'D') ");
		insSQL.appendSQL("and repay_date <= '"+new Timestamp(new Date().getTime())+"'))/"+unit+" as total ");
		insSQL.appendSQL("from issue_main A,v_debt_plan_det B where ");
		insSQL.appendSQL("A.issue_serial = B.issue_serial ");
		insSQL.appendSQL("and A.DEBT_CODE not in (25,61,31) ");
		insSQL.appendSQL("and ( a.id not in (select issue_id from payment_main where issue_id = a.id ) or a.issue_amount > (select isNull(sum(capital_amount),0)"); 
		insSQL.appendSQL("from payment_main where issue_id = a.id and repay_date <= '"+new Timestamp(new Date().getTime())+"' ) ) ");
		insSQL.appendSQL("and date2 > '"+new Timestamp(new Date().getTime())+"'");
		insSQL.appendSQL("and year(B.date1)-1911 between "+year1+" and "+year3+" ");
		insSQL.appendSQL("and debt_type = 'D' ");
		insSQL.appendSQL("group by  B.issue_serial, ");
		insSQL.appendSQL("datediff(dd,B.date2,B.date3), ");
		insSQL.appendSQL("B.date3, B.date2");
		//System.out.println(insSQL.toString());
		return insSQL;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		
		Gara1301Form myForm = (Gara1301Form)form;
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		String year = myForm.getIssueSdate();
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA13_RPT",usrId));
		run.update(connection,SQL1(year, unit));
	}
		//yearAmount[0][]=國庫劵,yearAmount[1][]=短期借款
//		BigDecimal yearAmount[][] = {{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)},
//				{new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)}};
//		//起始年度int
//		int yearStart = Integer.parseInt(year);
//		List queryList1 = (List) run.query(SQL1(year,unit), new MapListHandler());
//		Map tMap = null;
//		int yearIndex = 0;
//		for(Iterator it1=queryList1.iterator();it1.hasNext();){
//			tMap = (Map) it1.next();
//			/*
//			 *要放在哪個位置,例:輸入95年
//			 *yearIndex = 95 - 95 = 0 
//			 *			  96 - 95 = 1
//			 * 			  97 - 95 = 2	
//			 */
//			yearIndex = Integer.parseInt((String)tMap.get("year1"))-yearStart;
//			//國庫劵還本落點數=還本數+利息數
//			yearAmount[0][yearIndex]=((BigDecimal)tMap.get("capital_total_B")).add((BigDecimal)tMap.get("interest_total_B"));
//			//短期借款還本落點數=還本數
//			yearAmount[1][yearIndex]=(BigDecimal)tMap.get("capital_total_D");
//		}
//		
//		String DebtName[] = {"國庫劵","短期借款"}; 
//		Map dMap = new HashMap();
//		for (int i = 0 ; i < DebtName.length ; i++){
//			dMap = new HashMap();
//			dMap.putAll(getCommonMap(usrId));
//			dMap.put("debt_type",DebtName[i]);
//			dMap.put("year1",yearAmount[i][0]);
//			dMap.put("year2",yearAmount[i][1]);
//			dMap.put("year3",yearAmount[i][2]);
//			dMap.put("total",yearAmount[i][0].add(yearAmount[i][1]).add(yearAmount[i][2]));
//			run.update(connection,insTemp("GARA13_RPT",dMap));
//		}
//	}

}
