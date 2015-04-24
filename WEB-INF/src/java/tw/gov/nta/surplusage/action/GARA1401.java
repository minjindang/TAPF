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

import tw.gov.nta.surplusage.form.Gara1401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA1401 extends ExcelReportBaseAction {

	protected SQLJob SQL1(String year, BigDecimal unit){
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
		sqljob.appendSQL("sum(case when (year(date1)-1911="+year+") and kind = '1' and A.debt_type='B' then A_total + B_total else 0 end)/"+unit+" as year1,");
		sqljob.appendSQL("sum(case when (year(date1)-1911="+year1+") and kind = '1' and A.debt_type='B' then A_total + B_total else 0 end)/"+unit+" as year2,");
		sqljob.appendSQL("sum(case when (year(date1)-1911="+year2+") and kind = '1' and A.debt_type='B' then A_total + B_total else 0 end)/"+unit+" as year3,");
		sqljob.appendSQL("(sum(case when (year(date1)-1911="+year+") and kind = '1' and A.debt_type='B' then A_total + B_total else 0 end)+");
		sqljob.appendSQL("sum(case when (year(date1)-1911="+year1+") and kind = '1' and A.debt_type='B' then A_total + B_total else 0 end)+");
		sqljob.appendSQL("sum(case when (year(date1)-1911="+year2+") and kind = '1' and A.debt_type='B' then A_total + B_total else 0 end))/"+unit+" as total ");
		sqljob.appendSQL("from issue_main A,v_debt_plan_det B ");
		sqljob.appendSQL("where A.issue_serial = B.issue_serial ");
		sqljob.appendSQL("and date2 > '"+new Timestamp(new Date().getTime())+"' ");
		sqljob.appendSQL("and year(B.date1)-1911 between "+year+" and "+year2+" ");
		sqljob.appendSQL("and debt_type = 'B' ");
		sqljob.appendSQL("group by  B.issue_serial,");
		sqljob.appendSQL("datediff(dd,B.date2,B.date3),");
		sqljob.appendSQL("B.date3,");
		sqljob.appendSQL("B.date2 ");
		System.out.println("GARA1401-SQL1"+sqljob.toString());	
		return sqljob;
	}
	

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		
		Gara1401Form myForm = (Gara1401Form)form;
		String year = myForm.getIssueSdate();
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		// 取得使用者帳號
		String usrId = this.getUserId(request);
		// 取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		// 執行 delete
		run.update(connection,delSQLJob("GARA14_RPT", usrId));
		List queryList1 = (List) run.query(SQL1(year,unit), new MapListHandler());
		Map tMap = null;
		for(Iterator it1=queryList1.iterator();it1.hasNext();){
			tMap = (Map)it1.next();
			tMap.putAll(getCommonMap(usrId));
			run.update(connection,insTemp("GARA14_RPT",tMap));
		}
	}

}
