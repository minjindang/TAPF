package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara1501Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA1501 extends ExcelReportBaseAction {

	protected SQLJob SQL1(String year, BigDecimal unit, Date baseDate){
		//未來三年
		String year2 = String.valueOf(Integer.parseInt(year)+2);
		if (year2.length() < 3 ){
			for (int i = 0 ; i < 3-year2.length() ; i++){
				year2 = "0" + year2;
			}	
		}
		//未來二年
		String year1 = String.valueOf(Integer.parseInt(year)+1);
		if (year1.length() < 3 ){
			for (int i = 0 ; i < 3-year1.length() ; i++){
				year1 = "0" + year1;
			}	
		}
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select B.issue_serial,");
		sqljob.appendSQL("datediff(dd,B.date3,B.date2) as days,");
		sqljob.appendSQL("B.date3 as issue_date,");
		sqljob.appendSQL("B.date2 as due_date,");
		sqljob.appendSQL("sum(case when (year(date1)-1911="+year+") and kind = '2' and A.debt_type='D' then A_total else 0 end)/"+unit+" as year1,");
		sqljob.appendSQL("sum(case when (year(date1)-1911="+year1+") and kind = '2' and A.debt_type='D' then A_total else 0 end)/"+unit+" as year2,");
		sqljob.appendSQL("sum(case when (year(date1)-1911="+year2+") and kind = '2' and A.debt_type='D' then A_total else 0 end)/"+unit+" as year3,");
		sqljob.appendSQL("(sum(case when (year(date1)-1911="+year+") and kind = '2' and A.debt_type='D' then A_total else 0 end)+");
		sqljob.appendSQL("sum(case when (year(date1)-1911="+year1+") and kind = '2' and A.debt_type='D' then A_total  else 0 end)+");
		sqljob.appendSQL("sum(case when (year(date1)-1911="+year2+") and kind = '2' and A.debt_type='D' then A_total  else 0 end))/"+unit+" as total ");
		sqljob.appendSQL("from issue_main A,v_debt_plan_det B ");
		sqljob.appendSQL("where A.issue_serial = B.issue_serial ");
		sqljob.appendSQL("and A.DEBT_CODE not in (25,61,31) ");
		sqljob.appendSQL("and ");
		sqljob.appendSQL("(");
		sqljob.appendSQL("a.id not in (select issue_id from payment_main where issue_id = a.id )"); 
		sqljob.appendSQL("or a.issue_amount > (select isNull(sum(capital_amount),0) from payment_main where issue_id = a.id and repay_date <= '"+new Timestamp(baseDate.getTime())+"' )");
		sqljob.appendSQL(")");
		sqljob.appendSQL("and date2 > '"+new Timestamp(baseDate.getTime())+"' ");
		sqljob.appendSQL("and year(B.date1)-1911 between "+year+" and "+year2+" ");
		sqljob.appendSQL("and debt_type = 'D' ");
		sqljob.appendSQL("group by  B.issue_serial,");
		sqljob.appendSQL("datediff(dd,B.date2,B.date3),");
		sqljob.appendSQL("B.date3,");
		sqljob.appendSQL("B.date2 ");
		System.out.println("GARA1501-SQL1"+sqljob.toString());	
		return sqljob;
	}
	protected SQLJob SQL2(String year, BigDecimal unit, Date baseDate , String issueSerial){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select isNull(sum(capital_amount),0)/"+unit+" as pay_amount from payment_main where 1=1");
		sqljob.appendSQL("and issue_id = (select id from issue_main where issue_serial = '"+issueSerial+"' and debt_type = 'D') ");
		sqljob.appendSQL("and repay_date <= '"+new Timestamp(baseDate.getTime())+"'");
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		
		Gara1501Form myForm = (Gara1501Form)form;
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		String year = myForm.getIssueSdate();
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		// 取得使用者帳號
		String usrId = this.getUserId(request);
		// 取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		// 執行 delete
		run.update(connection,delSQLJob("GARA15_RPT", usrId));
		Date baseDate = new Date();
		if (myForm.getCreateDate() != null)
			baseDate = myForm.getCreateDate();
		List queryList1 = (List) run.query(SQL1(year,unit,baseDate), new MapListHandler());
		Map tMap = null;
		for(Iterator it1=queryList1.iterator();it1.hasNext();){
			tMap = (Map)it1.next();
			tMap.putAll(getCommonMap(usrId));
			BigDecimal payAmount = (BigDecimal)((Map)((List) run.query(SQL2(year,unit,baseDate,tMap.get("issue_serial").toString()), new MapListHandler())).get(0)).get("pay_amount");
			for(int i = 1 ; i <=3 ; i++){
				if(((BigDecimal)tMap.get("year"+i)).compareTo(new BigDecimal(0))!=0)
					tMap.put("year"+i, ((BigDecimal)tMap.get("year"+i)).subtract(payAmount));
			}
			tMap.put("total", ((BigDecimal)tMap.get("total")).subtract(payAmount));
			run.update(connection,insTemp("GARA15_RPT",tMap));
		}
	}
}
