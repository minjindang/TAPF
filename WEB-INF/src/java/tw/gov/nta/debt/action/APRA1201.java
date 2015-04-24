/* APRA1201.java 報表
 程式目的：APRA12
 程式代號：APRA12
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra1201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA1201 extends ExcelReportBaseAction {

	protected SQLJob SQL1(String bondId,int Year,int sMonth,int eMonth)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select distinct ");
		sqljob.appendSQL("P.P_FLAG,");
		sqljob.appendSQL("(case when P.P_FLAG='P' then 1 else 2 end ) t_flag,");
		sqljob.appendSQL("P.P_TIMES,"); 
		sqljob.appendSQL("(case when P.P_FLAG='P' then P.P_TIMES else 0 end) as t1,");
		sqljob.appendSQL("(case when P.P_FLAG='I'  then P.P_TIMES else 0 end) as t2,");
		sqljob.appendSQL("B.BANK_FNAME,"); 
		sqljob.appendSQL("P.I_AMT as t3,"); 
		sqljob.appendSQL("P.P_AMT as t4,"); 
		sqljob.appendSQL("P.T_AMT as t5,"); 
		sqljob.appendSQL("P.BAL as t6,"); 
		sqljob.appendSQL("P.E_FEE as t7,"); 
		sqljob.appendSQL("B.BANK_CODE,");
		sqljob.appendSQL("P.BOND_ID ");
		sqljob.appendSQL("from PAIDA P, BANKF B ");
		sqljob.appendSQL("where P.BANK_CODE = B.BANK_CODE ");
		sqljob.appendSQL("and P.BOND_ID='"+bondId+"' ");
		sqljob.appendSQL("and P.P_YEAR="+Year+" ");
		sqljob.appendSQL(getPeriod(sMonth,eMonth));
		sqljob.appendSQL("order by B.BANK_CODE,P.P_FLAG, P.P_TIMES ");
		System.out.println("APRA1201-SQL1:"+sqljob);
		return sqljob;
	}
	protected String getPeriod(int sMonth , int eMonth){
		String sql = "";
		if (sMonth < 7 && eMonth  < 7){
			sql = "and P.P_PERIOD=1 ";
		}else if (sMonth < 7 && eMonth >= 7){
			sql = "and P.P_PERIOD in (1,2) ";
		}else if (sMonth >= 7 && eMonth >= 7){
			sql = "and P.P_PERIOD=2 ";
		}
		return sql;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, 
			Connection connection) throws Exception 
	{
		Apra1201Form myForm = (Apra1201Form) form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("APRA12_RPT",usrId)); 
		//執行 insert
		//預設 sYear及eYear為今年度
		int sYear = Integer.parseInt(DateUtil.date2ROCStr(new Date()).substring(0,3));
		int eYear = Integer.parseInt(DateUtil.date2ROCStr(new Date()).substring(0,3));
		//預設sMonth及eMonth為本月份
		int sMonth = Integer.parseInt(DateUtil.date2ROCStr(new Date()).substring(3,5));
		int eMonth = Integer.parseInt(DateUtil.date2ROCStr(new Date()).substring(3,5));
		//取得開始年度
		if( null != myForm.getCloseSdate() && !"".equals(myForm.getCloseSdate())){
			sYear = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseSdate()).substring(0,3));
			sMonth = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseSdate()).substring(3,5));
		}
		//取得結束年度
		if( null != myForm.getCloseEdate() && !"".equals(myForm.getCloseEdate())){
			eYear = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseEdate()).substring(0,3));
			eMonth = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseEdate()).substring(3,5));
		}
		for (int i = sYear; i <= eYear; i++){
			int selectSMonth = 1;
			int selectEMonth = 12;
			if (i == sYear ){
				selectSMonth = sMonth;
			}
			if ( i == eYear ){
				selectEMonth = eMonth;
			}
			List queryList1 = (List) run.query(SQL1(myForm.getDebtName(),i,selectSMonth,selectEMonth), new MapListHandler());
			Map tMap = null;
			Map dMap = new HashMap();
			for (Iterator it1 = queryList1.iterator(); it1.hasNext();){
				tMap = (Map) it1.next();
				dMap.putAll(getCommonMap(usrId));
				dMap.put("bank_id",String.valueOf(tMap.get("BANK_CODE")));
				dMap.put("t_flag",String.valueOf(tMap.get("t_flag")));
				dMap.put("bank_name",(String)tMap.get("BANK_FNAME"));//--公債名稱
				dMap.put("t1",String.valueOf(tMap.get("t1")));//--本次別
				dMap.put("t2",String.valueOf(tMap.get("t2")));//--息次別
				dMap.put("t3",new BigDecimal((Double)tMap.get("t3")));//--撥入基金
				dMap.put("t4",new BigDecimal((Double)tMap.get("t4")));//--本期經付數
				dMap.put("t5",new BigDecimal((Double)tMap.get("t5")));//--累計經付數
				dMap.put("t6",new BigDecimal((Double)tMap.get("t6")));//--基金餘額
				dMap.put("t7",new BigDecimal((Double)tMap.get("t7")));//--應付手續費
				run.update(connection,insTemp("APRA12_RPT",dMap));
			}
		}
	}
	

}
